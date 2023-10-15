
package ws;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.PacienteDAO;
import modelo.pojo.RespuestaPaciente;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 * 
 */

@Path("pacientes")
public class PacientesWS {
    
    @Context
    private UriInfo context;
    
    
   
        
        

    @GET
    @Path("obtenerPacientePorIdMedico/{idMedico}")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaPaciente obtenerPacientePorIdMedicoEscritorio(@PathParam("idMedico") Integer idMedico) {
        RespuestaPaciente respuesta = null;
        if (idMedico != 0) {
            respuesta = PacienteDAO.buscarPacienteIdMedico(idMedico);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return respuesta;
    }
    
    
    
    
    @POST
    @Path("registrarPaciente")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaPaciente resgistrarPacienteEscritorio(@FormParam("nombre") String nombre,
            @FormParam("apellidoPat") String apellidoPat,
            @FormParam("apellidoMat") String apellidoMat,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo,
            @FormParam("peso") float peso,
            @FormParam("estatura") Integer estatura,
            @FormParam("tallaInicial") Integer tallaInicial,
            @FormParam("email") String email,
            @FormParam("telefono") String telefono,
            @FormParam("password") String password,
            @FormParam("idMedico") Integer idMedico) {
        RespuestaPaciente respuesta = null;

        if (!nombre.isEmpty() && !apellidoPat.isEmpty() && !apellidoMat.isEmpty() && !fechaNacimiento.isEmpty() && !sexo.isEmpty() && peso != 0 && estatura != 0 && tallaInicial != 0 && !email.isEmpty() && !telefono.isEmpty() && !password.isEmpty() && idMedico!=0) {
            respuesta = PacienteDAO.registrarPaciente(nombre, apellidoPat, apellidoMat, fechaNacimiento, sexo, peso, estatura, tallaInicial, email, telefono, password, idMedico);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return respuesta;
    }
    
    
    @PUT
    @Path("editarPaciente")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaPaciente editarPacientePorIdEscritorio(@FormParam("idPaciente") Integer idPaciente,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPat") String apellidoPat,
            @FormParam("apellidoMat") String apellidoMat,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo,
            @FormParam("peso") float peso,
            @FormParam("estatura") Integer estatura,
            @FormParam("tallaInicial") Integer tallaInicial,
            @FormParam("telefono") String telefono,
            @FormParam("password") String password,
            @FormParam("idMedico")Integer idMedico){
        RespuestaPaciente respuesta = null;
        
        
        
        if (idPaciente!=0 && !nombre.isEmpty() && !apellidoPat.isEmpty() && !apellidoMat.isEmpty() && !fechaNacimiento.isEmpty() && !sexo.isEmpty() && peso != 0 && estatura != 0 && tallaInicial != 0 && !telefono.isEmpty() && !password.isEmpty() && idMedico!=0) {
         respuesta = PacienteDAO.editarPacientePorId(idPaciente, nombre, apellidoPat, apellidoMat, fechaNacimiento, sexo, peso, estatura, tallaInicial, telefono, password,idMedico);
        
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        
        return respuesta;
    }
    
    
    @DELETE
    @Path("eliminarPaciente")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaPaciente eliminarPacientePorIdEscritorio(@FormParam("idPaciente") Integer idPaciente){
    
        RespuestaPaciente respuesta = null;
        
        if(idPaciente != 0){
            respuesta = PacienteDAO.eliminarPacientePorId(idPaciente);
        }else{
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        
        return respuesta;
    }
    
    
    
    
    
    
       
     
       
       
       
       
       
    
   
    
}
