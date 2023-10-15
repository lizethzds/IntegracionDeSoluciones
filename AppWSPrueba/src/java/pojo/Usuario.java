
package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lizet
 */
public class Usuario {
    
    
    //cambiar por integer dependiendo de la necesidad del servicio
    private int id;
    private String nombre;
    private String correo;
    private String apellidoPat;
    private String apellidoMat;
    private String password;

    
    
    
    
    public Usuario(){
        
    }
    public Usuario(int id, String nombre, String correo, String apellidoPat, String apellidoMat, String password){
        this.id = id;
        this.nombre = nombre;
        this.correo= correo;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.password = password;
        
        
    }
    
    
    
    //Getters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
   
    
    
    
    
   
    
    
}
