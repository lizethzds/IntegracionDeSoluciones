
package ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Mensaje;
import pojo.Usuario;

/**
 * REST Web Service
 *
 * @author lizet
 */
@Path("usuarios")
public class UsuarioWS {

    @Context
    private UriInfo context;


    public UsuarioWS() {
    }

    @GET
    @Path("listaUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD!= null){
            try{
                usuarios = conexionBD.selectList("usuarios.obtenerUsuarios");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        return usuarios;
    }
    
    @GET
    @Path("obtenerId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario obtenerDatosUsuarios(@PathParam("id") Integer id )
           {
        Usuario usuario = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD!=null){
            
            try{
               usuario = conexionBD.selectOne("usuarios.obtenerId", id);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
    
        
        return usuario;
    }
    
    @GET
    @Path("obtenerCorreo/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario obtenerCorreoUsuarios(@PathParam("correo")String correo){
        Usuario usuario = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD !=null){
        try{
            //No puede haber dos usuarios con el mismo correo
           usuario = conexionBD.selectOne("usuarios.obtenerCorreo", correo);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
            conexionBD.close();
            }
        }
    
        
        return usuario;
    }
    
    
    @GET 
    @Path("obtenerNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario obtenerNombreUsuarios(@PathParam("nombre") String nombre){
         Usuario usuario = null;
        SqlSession  conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null){
            try{
                usuario = conexionBD.selectOne("usuarios.obtenerNombre", nombre);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
    return usuario;
    
    }
    
    
    
    @POST
    @Path("registrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarUsuario(
             @FormParam("nombre") String nombre, 
             @FormParam("correo") String correo, 
             @FormParam("apellidoPat") String apellidoPat, 
             @FormParam("apellidoMat") String apellidoMat,
             @FormParam("password") String password){
        
    
    Usuario usuario = new Usuario();
    usuario.setNombre(nombre);
    usuario.setCorreo(correo);
    usuario.setApellidoPat(apellidoPat);
    usuario.setApellidoMat(apellidoMat);
    usuario.setPassword(password);
    Mensaje mensaje = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.getSession();
    if(conexionBD !=null){
        try{
            int numeroFilasAfectadas = conexionBD.insert("usuarios.registrar", usuario);
            conexionBD.commit();
            if(numeroFilasAfectadas>0){
                mensaje.setError(false);
                mensaje.setMensaje("La información del usuario registrada con éxito.");
            }else{
                mensaje.setError(true);
                mensaje.setMensaje("No se pudo registrar la información del usuario.");
            }
        }catch(Exception e){
            mensaje.setError(true);
            mensaje.setMensaje("Error: " + e.getMessage());
        }finally{
           conexionBD.close(); 
        }
    }else{
        mensaje.setError(true);
        mensaje.setMensaje("Por el momento no hay conexión en la base de datos.");
    }
        return mensaje;
    }
    
    
    
    @PUT
    @Path("editar")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editarUsuario(@FormParam("id") Integer id, 
                                @FormParam("nombre") String nombre,
                                @FormParam("apellidoPat") String apellidoPat,
                                @FormParam("apellidoMat") String apellidoMat,
                                @FormParam("password") String password){
        Mensaje mensaje = new Mensaje();
        HashMap<String,Object> parametros = new HashMap<>();
        parametros.put("id",id);
        parametros.put("nombre", nombre);
        parametros.put("apellidoPat", apellidoPat);
        parametros.put("apellidoMat", apellidoMat);
        parametros.put("password",password);
        
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD !=null){
            try{
                Usuario usuarioExistente = conexionBD.selectOne("usuarios.obtenerId",id);
                if(usuarioExistente !=null){
                    int filasAfectadas = conexionBD.update("usuarios.editar", parametros);
                    conexionBD.commit();
                    if (filasAfectadas >0){
                        mensaje.setError(false);
                        mensaje.setMensaje("Usuario actualizado con exito");

                    }
                    else{
                        mensaje.setError(true);
                        mensaje.setMensaje("No se pudo actualizar la información del usuario");
                    }
                }
                else{
                    mensaje.setError(true);
                    mensaje.setMensaje("El identificador del usuario a editar no existe.");
                }
                
            }catch(Exception e){
                mensaje.setError(true);
                mensaje.setMensaje("Error: " + e.getMessage());
                
            }finally{
                conexionBD.close();
            }
        
        
        
        }
        else{
            mensaje.setError(true);
            mensaje.setMensaje("Por el momento no hay conexión en la base de datos.");
        }
       
       
        return mensaje;
    }
    
    

@DELETE
    @Path("eliminar")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUsuario(@FormParam("id") Integer id) {
        Mensaje msj = new Mensaje();

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Usuario usuarioExiste = conexionBD.selectOne("usuarios.obtenerId", id);
                if (usuarioExiste != null) {
                    int numFilasAfectadas = conexionBD.delete("usuarios.eliminar", id);
                    conexionBD.commit();
                    if (numFilasAfectadas > 0) {
                        msj.setError(false);
                        msj.setMensaje("Usuario eliminado correctamente.");
                    } else {
                        msj.setError(true);
                        msj.setMensaje("Hubo un error al eliminar el usuario.");
                    }
                } else {
                    msj.setError(true);
                    msj.setMensaje("El usuario que desea eliminar con el identificador no existe.");
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }

        } else {
            msj.setError(true);
            msj.setMensaje("Sin conexion a la base de datos...");
        }

        return msj;
    }
}
    
    
  
