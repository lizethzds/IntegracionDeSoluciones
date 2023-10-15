
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelo.pojo.Paciente;
import modelo.pojo.RespuestaPaciente;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;




/**
 *
 * @author lizet
 */


public class PacienteDAO {
    
    
    public List<Paciente> obtenerPacientes(){
        List<Paciente> pacientes = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if(conexionBD!=null){
            try{
            pacientes = conexionBD.selectList("pacientes.obtenerPacientes");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
            conexionBD.close();
            }
            
        }
        return pacientes;
    }
  
    //Metodo para obtener pacientes por ID médico
    
    public static RespuestaPaciente buscarPacienteIdMedico(Integer idMedico){
    RespuestaPaciente respuesta = new RespuestaPaciente();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if (conexionBD != null) {
            try {
                List<Paciente> pacientes = conexionBD.selectList("pacientes.obtenerPacientesIdMedico", idMedico);

                if (!pacientes.isEmpty()) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Pacientes con el ID medico: " + idMedico + " :");
                    respuesta.setPacientes(pacientes);
                } else {
                    respuesta.setMensaje("No hay pacientes asignados al ID del médico consultado.");
                }
            } catch (Exception e) {
                respuesta.setMensaje("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }
        } else {
            respuesta.setMensaje("Por el momento no hay conexión a la base de datos.");
        }
        
        
        return respuesta;
    }
    
    
    
    
     public static RespuestaPaciente registrarPaciente(String nombre,String apellidoPat,String apellidoMat,
            String fechaNacimiento,
            String sexo,
            float peso,
            Integer estatura,
            Integer tallaInicial,
            String email,
            String telefono,
            String password,
            Integer idMedico) {
        RespuestaPaciente respuesta = new RespuestaPaciente();

        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellidoPat(apellidoPat);
        paciente.setApellidoMat(apellidoMat);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setSexo(sexo);
        paciente.setPeso(peso);
        paciente.setEstatura(estatura);
        paciente.setTallaInicial(tallaInicial);
        paciente.setEmail(email);
        paciente.setTelefono(telefono);
        paciente.setPassword(password);
        paciente.setIdMedico(idMedico);

        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                int numeroDeFilasAfectadas = conexionBD.insert("pacientes.registrarPaciente", paciente);
                conexionBD.commit();
                if (numeroDeFilasAfectadas > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Se ha registrado un paciente con éxito.");
                } else {
                    respuesta.setMensaje("Ocurrió un error al registrar al paciente.");
                }
            } catch (Exception e) {
                respuesta.setMensaje("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }
        } else {
            respuesta.setMensaje("Error: por el momento no hay conexion con la base de datos");
        }

        return respuesta;
    }
     
     public static RespuestaPaciente editarPacientePorId(Integer idPaciente,
            String nombre,
            String apellidoPat,
            String apellidoMat,
            String fechaNacimiento,
            String sexo,
            float peso,
            float estatura,
            Integer tallaInicial,
            String telefono,
            String password,
            Integer idMedico) {

        RespuestaPaciente respuesta = new RespuestaPaciente();

        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("idPaciente", idPaciente);
            parametros.put("nombre", nombre);
            parametros.put("apellidoPat", apellidoPat);
            parametros.put("apellidoMat", apellidoMat);
            parametros.put("fechaNacimiento", fechaNacimiento);
            parametros.put("sexo", sexo);
            parametros.put("peso", peso);
            parametros.put("estatura", estatura);
            parametros.put("tallaInicial", tallaInicial);
            parametros.put("telefono", telefono);
            parametros.put("password", password);
            parametros.put("idMedico", idMedico);

            Paciente paciente = conexionBD.selectOne("pacientes.obtenerPacientePorId", idPaciente);

            if (paciente != null) {
                try {
                    int numeroDeFilasAfectadas = conexionBD.update("pacientes.editarPaciente", parametros);
                    conexionBD.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        respuesta.setError(false);
                        respuesta.setMensaje("Paciente actualizado con éxito.");
                    } else {
                        respuesta.setMensaje("Ocurrió un error al intentar actualizar los datos del paciente.");
                    }
                } catch (Exception e) {
                    respuesta.setMensaje("Error: " + e.getMessage());
                } finally {
                    conexionBD.close();
                }
            } else {
                respuesta.setMensaje("El paciente no existe en el sistema.");
            }

        } else {
            respuesta.setMensaje("Por el momento no hay conexión a la base de datos.");
        }

        return respuesta;
    }
     
     
     public static RespuestaPaciente eliminarPacientePorId(Integer idUsuario) {

        RespuestaPaciente respuesta = new RespuestaPaciente();
        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                Paciente paciente = conexionBD.selectOne("pacientes.obtenerPacientePorId", idUsuario);

                if (paciente != null) {
                    int numeroDeFilasAfectadas = conexionBD.delete("pacientes.eliminarPaciente", idUsuario);
                    conexionBD.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        respuesta.setError(false);
                        respuesta.setMensaje("Paciente eliminado con éxito");
                    } else {
                        respuesta.setMensaje("No se pudo eliminar el Paciente");
                    }
                } else {
                    respuesta.setMensaje("Error: el usuario que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                respuesta.setMensaje("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }
        } else {
            respuesta.setMensaje("Error: no hay conexion con la base de datos");
        }
        return respuesta;
    }
     
    
    
    
}
