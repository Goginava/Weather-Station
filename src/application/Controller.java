package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button ShowMetar;
    
    @FXML
    private TextArea ActualMetar;
    
    @FXML
    private TextField AirportCodeIcao;

    @FXML
    void getMetarFromServer(ActionEvent event) {
    	Metar metar = new Metar();
    	System.out.println("" + AirportCodeIcao.getText());
    	String output = metar.getRawMetar("" + AirportCodeIcao.getText());
    	//String output = metar.getRawMetar("EDDL");
    	ActualMetar.setText(output);
    }

}
