/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritorionutricion;

import clienteescritorionutricion.modelo.pojo.Paciente;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author lizet
 */
public class FXMLRegistroPacienteController implements Initializable {

    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPat;
    @FXML
    private TextField tfApellidoMat;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfPeso;
    @FXML
    private TextField tfTallaInicial;
    @FXML
    private TextField tfEstatura;
    @FXML
    private ToggleGroup rbSexo;
    
    public Paciente paciente;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

 public void asignarDatos(){
        tfNombre.setText(paciente.getNombre());
        tfApellidoPat.setText(paciente.getApellidoPat());
        tfApellidoMat.setText(paciente.getApellidoMat());
        //Formato de fecha de String a LocalDate para el DatePicker
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimiento = LocalDate.parse(paciente.getFechaNacimiento(),formato);
        dpFechaNacimiento.setValue(fechaNacimiento);
        
        //Grupo para la seleccion de Radiobuttons de acuerdo al sexo
        if (paciente.getSexo().equals("F")) {
            rbSexo.selectToggle(rbFemenino);
        } else if (paciente.getSexo().equals("M")) {
            rbSexo.selectToggle(rbMasculino);
        }
        
        tfCorreo.setText(paciente.getEmail());
        tfEstatura.setText("" + paciente.getEstatura());
        tfPeso.setText(paciente.getPeso() + "");
        tfTallaInicial.setText("" + paciente.getTallaInicial());
        tfTelefono.setText(paciente.getTelefono());
        
        
       
       
    }
    
    
    public void inicializarInformacion(Paciente paciente){
        this.paciente = paciente;
       asignarDatos();
        
    }    
    
}
