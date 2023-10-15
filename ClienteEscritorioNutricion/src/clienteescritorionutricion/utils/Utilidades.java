
package clienteescritorionutricion.utils;

import javafx.scene.control.Alert;

/**
 *
 * @author lizet
 */
public class Utilidades {
    
    public static void mostrarAlertaSimple(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
        
    
    
    }
    
    
}
