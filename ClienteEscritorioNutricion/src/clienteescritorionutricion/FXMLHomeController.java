/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritorionutricion;

import clienteescritorionutricion.modelo.pojo.Medico;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lizet
 */

public class FXMLHomeController implements Initializable {
    
    
    private Medico medicoSesion;
    
    

    @FXML
    private Label lbNombreMedico;
    @FXML
    private Label lbCedula;
    @FXML
    private Label lbNumPersonal;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void inicializarHome(Medico medicoSesion){
        this.medicoSesion = medicoSesion;
        lbNombreMedico.setText("Nombre: "+ medicoSesion.getNombre() +" " + medicoSesion.getApellidoPaterno() +" "+ medicoSesion.getApellidoMaterno());
        lbCedula.setText("Cédula Profesional: "+medicoSesion.getCedulaProfesional());
        lbNumPersonal.setText("Número de Personal: " + medicoSesion.getNumeroDePersonal());
    }

    @FXML
    private void btnGestionarPacientes(ActionEvent event) {
        try{
            FXMLLoader vistaLoad = new FXMLLoader(getClass().getResource("FXMLAdminPacientes.fxml"));
            Parent vista = vistaLoad.load();
            
           FXMLAdminPacientesController controlador =  vistaLoad.getController();
           controlador.inicializarInformacion(medicoSesion.getIdMedico());
           
           Stage stage = new Stage();
           Scene escenaAdmin = new Scene(vista);
           stage.setScene(escenaAdmin);
           stage.setTitle("Pacientes");
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.showAndWait();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}

