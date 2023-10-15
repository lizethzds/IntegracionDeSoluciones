
package clienteescritorionutricion.modelo.pojo;

/**
 *
 * @author lizet
 */
public class RespuestaLogin {
    
    private Boolean error;
    private String contenido;
    private Medico medicoSesion;

    public RespuestaLogin() {
    }

    public RespuestaLogin(Boolean error, String contenido, Medico medicoSesion) {
        this.error = error;
        this.contenido = contenido;
        this.medicoSesion = medicoSesion;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Medico getMedicoSesion() {
        return medicoSesion;
    }

    public void setMedicoSesion(Medico medicoSesion) {
        this.medicoSesion = medicoSesion;
    }
    
    
}
