/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritorionutricion;

import clienteescritorionutricion.modelo.dao.PacienteDAO;
import clienteescritorionutricion.modelo.pojo.Paciente;
import clienteescritorionutricion.modelo.pojo.RespuestaPaciente;
import clienteescritorionutricion.utils.Utilidades;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lizet
 */
public class FXMLAdminPacientesController implements Initializable {
    
    
    private Integer idMedico;
    
    private ObservableList<Paciente> pacientesMedico;

    @FXML
    private TextField tfBuscarPaciente;
    @FXML
    private TableView<Paciente> tvPacientes;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPat;
    @FXML
    private TableColumn colApellidoMat;
    @FXML
    private TableColumn colFechaNacimiento;
    @FXML
    private TableColumn colEmail;
    @FXML
    private TableColumn colTelefono;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pacientesMedico = FXCollections.observableArrayList();
       configurarColumnasTabla();
    }    
    
    
    public void inicializarInformacion(Integer idMedico){
        this.idMedico = idMedico;
        consultarInformacionPacientes();
    }

    @FXML
    private void btnRegistrarPaciente(ActionEvent event) {
    }

    @FXML
    private void btnEditarPaciente(ActionEvent event) {
       int posicionSeleccionada = tvPacientes.getSelectionModel().getSelectedIndex();
        if(posicionSeleccionada != -1){
            Paciente paciente = pacientesMedico.get(posicionSeleccionada);
            Utilidades.mostrarAlertaSimple("Paciente ", paciente.getNombre() + " " + paciente.getApellidoPat() + " " + paciente.getApellidoMat(), Alert.AlertType.INFORMATION);
        }else{
            Utilidades.mostrarAlertaSimple("Selección de paciente", "Para poder modificar debes seleccionar un paciente de la tabla.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarPaciente(ActionEvent event) {
    }
    
    private void consultarInformacionPacientes(){
        RespuestaPaciente respuesta = PacienteDAO.buscarPacienteIdMedico(idMedico);
        if(respuesta.getMensaje()!=null){
        pacientesMedico.addAll(respuesta.getPacientes());
        tvPacientes.setItems(pacientesMedico);
        }
      
    }
    
    
    private void configurarColumnasTabla(){
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidoPat.setCellValueFactory(new PropertyValueFactory("apellidoPat"));
        colApellidoMat.setCellValueFactory(new PropertyValueFactory("apellidoMat"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
    }
    
}
