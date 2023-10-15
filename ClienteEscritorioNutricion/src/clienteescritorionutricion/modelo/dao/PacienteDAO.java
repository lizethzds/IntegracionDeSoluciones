
package clienteescritorionutricion.modelo.dao;

import clienteescritorionutricion.modelo.ConexionHTTP;
import clienteescritorionutricion.modelo.pojo.CodigoHTTP;
import clienteescritorionutricion.modelo.pojo.Paciente;
import clienteescritorionutricion.modelo.pojo.RespuestaPaciente;
import clienteescritorionutricion.utils.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author lizet
 */

public class PacienteDAO {
    
  /*  public static HashMap<String,Object> obtenerPacientesPorMedico(Integer idMedico){
        HashMap<String,Object> respuesta = new LinkedHashMap<>();
        String url = Constantes.URL_WS + "pacientes/obtenerPacientePorIdMedico/" + idMedico;
        CodigoHTTP codigoRespuesta = ConexionHTTP.peticionGET(url);
        if(codigoRespuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            respuesta.put("error", false);
            Type tipoListaPaciente = new TypeToken<List<Paciente>>(){}.getType();
            Gson gson = new Gson();
            
            List<Paciente> pacientes = gson.fromJson(codigoRespuesta.getContenido(), tipoListaPaciente);
            
            respuesta.put("pacientes", pacientes);
        }else{
            respuesta.put("error", true);
            respuesta.put("mensaje", "Hubo un error al obtener la información de los pacientes, por favor"
                    + "intentelo más tarde");
        }
        
        return respuesta;
        
    }
*/
    
    public static RespuestaPaciente buscarPacienteIdMedico(Integer idMedico){
        RespuestaPaciente respuesta = new RespuestaPaciente();
        String url = Constantes.URL_WS+"pacientes/obtenerPacientePorIdMedico/" + idMedico;
        CodigoHTTP codigoRespuesta = ConexionHTTP.peticionGET(url);
        if(codigoRespuesta.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            respuesta = gson.fromJson(codigoRespuesta.getContenido(), RespuestaPaciente.class);
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Hubo un error en la obtención de la información de los pacientes, intentelo más tarde.");
        
        }
        return respuesta;
        
        
    
    }
    
    
    
    
}
