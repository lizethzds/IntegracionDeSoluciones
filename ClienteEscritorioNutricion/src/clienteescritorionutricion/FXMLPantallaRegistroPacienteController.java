/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritorionutricion;

import clienteescritorionutricion.modelo.pojo.Paciente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lizet
 */
public class FXMLPantallaRegistroPacienteController implements Initializable {

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
    
    private Paciente paciente;

  
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    
    public void asignarDatos(){
       
    }
    
  
    
}
