
package modelo;

import java.util.HashMap;
import modelo.pojo.Medico;
import modelo.pojo.RespuestaLoginEscritorio;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class AutenticacionDAO {
    
    public static RespuestaLoginEscritorio verificarSesionEscritorio(String numeroDePersonal,
            String password){
        
        RespuestaLoginEscritorio respuesta = new RespuestaLoginEscritorio();
        respuesta.setError(true);
        
        SqlSession  conexionBD = MyBatisUtil.getSession();
        if (conexionBD !=null){
            try{
                HashMap<String,String> parametros = new HashMap<>();
                parametros.put("numeroDePersonal", numeroDePersonal);
                 parametros.put("password", password);
                Medico medico = conexionBD.selectOne("autenticacion.loginEscritorio",parametros );
                
                if(medico !=null){
                    respuesta.setError(false);
                    respuesta.setContenido("Bienvenido(a), " + medico.getNombre() + " al sistema de control nutricional.");
                    respuesta.setMedicoSesion(medico);
                }
                else{
                    respuesta.setContenido("Numero de personal y/o contraseña incorrectos, verifique sus credenciales");
                    
                }
                
                
            }catch(Exception e){
                respuesta.setContenido("Error: " + e.getMessage());
            }
            finally{
            conexionBD.close();
            }
        }else{
        respuesta.setContenido("Error: Por el momento no hay conexión con la base de datos.");
        }
        
        
    
        
        return respuesta;
    
    }
    
}
