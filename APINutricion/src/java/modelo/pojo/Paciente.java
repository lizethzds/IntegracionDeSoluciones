
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Paciente {

  

   
    private Integer idPaciente;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String fechaNacimiento;
    private String sexo;
    private float peso;
    private Integer estatura;
    private Integer tallaInicial;
    private String email;
    private String telefono;
    private String password;
    private byte[] fotografia;
    private Integer idMedico;
    
      public Paciente() {
    }

    
    
     public Paciente(Integer idPaciente, String nombre, String apellidoPat, String apellidoMat, String fechaNacimiento, String sexo, float peso, Integer estatura, Integer tallaInicial, String email, String telefono, String password, byte[] fotografia) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.estatura = estatura;
        this.tallaInicial = tallaInicial;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.fotografia = fotografia;
        this.idMedico = idMedico;
    }
     
     
        public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public Integer getTallaInicial() {
        return tallaInicial;
    }

    public void setTallaInicial(Integer tallaInicial) {
        this.tallaInicial = tallaInicial;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
    
    
    
    //fotografia
   //Llaves foraneas domicilio y medico

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }
}
