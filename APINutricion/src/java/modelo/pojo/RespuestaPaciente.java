/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

import java.util.List;

/**
 *
 * @author lizet
 */
public class RespuestaPaciente {
    
    private boolean error;
    private String mensaje;
    private List<Paciente> pacientes;
    
    public RespuestaPaciente() {
    }

    public RespuestaPaciente(boolean error, String mensaje, List<Paciente> pacientes) {
        this.error = error;
        this.mensaje = mensaje;
        this.pacientes = pacientes;
    }
    
    
    
    

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
     public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    
    
   
    
}
