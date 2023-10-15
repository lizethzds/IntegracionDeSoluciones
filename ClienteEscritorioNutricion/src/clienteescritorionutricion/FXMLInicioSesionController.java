/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritorionutricion;

import clienteescritorionutricion.modelo.ConexionHTTP;
import clienteescritorionutricion.modelo.dao.InicioSesionDAO;
import clienteescritorionutricion.modelo.pojo.CodigoHTTP;
import clienteescritorionutricion.modelo.pojo.Medico;
import clienteescritorionutricion.modelo.pojo.RespuestaLogin;
import clienteescritorionutricion.utils.Constantes;
import clienteescritorionutricion.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author lizet
 */
public class FXMLInicioSesionController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfNumPersonal;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lblErrorPassword;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnIniciarSesion(ActionEvent event) {
        lbErrorUsuario.setText("");
        lblErrorPassword.setText("");
        String numeroDePersonal = tfNumPersonal.getText();
        String password = tfPassword.getText();
        boolean isValido = true;
        if(numeroDePersonal.isEmpty()){
            lbErrorUsuario.setText("Número de personal requerido");
            isValido = false;
        
        }
        if(password.isEmpty()){
        
            lblErrorPassword.setText("Contraseña requerida");
            isValido = false;
        }
        
        if(isValido){
            verificarSesion(numeroDePersonal,password);
        }
       
    }
    
    private void verificarSesion(String numeroDePersonal, String password){ 
        RespuestaLogin respuestaValidacionLogin = InicioSesionDAO.validarSesion(numeroDePersonal, password);
        if(!respuestaValidacionLogin.getError()){
            Utilidades.mostrarAlertaSimple("Credenciales correctas", respuestaValidacionLogin.getContenido(), 
                    Alert.AlertType.INFORMATION);
            irPantallaPrincipal(respuestaValidacionLogin.getMedicoSesion());
        }else{
            Utilidades.mostrarAlertaSimple("Error", respuestaValidacionLogin.getContenido(), 
                    Alert.AlertType.ERROR);
        
        }
    }
    
   
    
    private void irPantallaPrincipal(Medico medico){
       
        try {
             Stage stagePrincipal = (Stage)tfNumPersonal.getScene().getWindow();
            FXMLLoader loadVista = new FXMLLoader(getClass().getResource("FXMLHome.fxml"));
            Parent vista = loadVista.load();
            
           FXMLHomeController controladorHome = loadVista.getController();
           controladorHome.inicializarHome(medico);
            
            Scene scene = new Scene(vista);
            stagePrincipal.setScene(scene);
            stagePrincipal.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
