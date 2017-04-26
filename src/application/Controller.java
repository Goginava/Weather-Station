package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private Button ShowMetar;
    
    @FXML
    private TextArea ActualMetar;

    @FXML
    void getMetarFromServer(ActionEvent event) {
    	ActualMetar.setText("Testfunktion getMetar erfolgreich!");
    	//System.out.println("Testfunktion getMetar erfolgreich");
    }

}
