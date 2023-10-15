
package clienteescritorionutricion.modelo.pojo;

/**
 *
 * @author lizet
 */
public class CodigoHTTP {
    
    private Integer codigoRespuesta;
    private String contenido;

    public CodigoHTTP() {
    }

    public CodigoHTTP(Integer codigoRespuesta, String contenido) {
        this.codigoRespuesta = codigoRespuesta;
        this.contenido = contenido;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
