package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem delete;

    @FXML
    private MenuItem about;
	
	@FXML
    private Button ShowMetar;

    @FXML
    private TextField AirportCodeIcao;

    @FXML
    private TextArea ActualMetar;

    @FXML
    private TextArea DecodedMetar;

    @FXML
    private Button DecodeMetar;

    @FXML
    void getDecodedFromServer(ActionEvent event) {
    	rectifyAirportCodeIcao();
    	Metar metar = new Metar();
    	String output = metar.getDecodedMetar("" + AirportCodeIcao.getText());
    	//String output = metar.getRawMetar("EDDL");
    	DecodedMetar.setText(output);
    }

    @FXML
    void getMetarFromServer(ActionEvent event) {
    	rectifyAirportCodeIcao();
    	Metar metar = new Metar();
    	String output = metar.getRawMetar("" + AirportCodeIcao.getText());
    	//String output = metar.getRawMetar("EDDL");
    	ActualMetar.setText(output);
    }
    
    @FXML
    void rectifyAirportCodeIcao() {
    	String temp;
    	temp = AirportCodeIcao.getText();
    	temp = temp.trim();
    	temp = temp.toUpperCase();
    	AirportCodeIcao.setText(temp);
    	//System.out.println(temp);
    	
    }
    
    //Menü Handler
    @FXML
    void closeApp(ActionEvent event) {
    	System.exit(0);
    }
    

    @FXML
    void deleteContent(ActionEvent event) {
    	System.out.println("Delete Content");
    	AirportCodeIcao.clear();
    	ActualMetar.clear();
    	DecodedMetar.clear();
    }

    @FXML
    void openAboutSection(ActionEvent event) {
    	System.out.println("About...");
		try {
			Stage aboutStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
			Scene aboutScene = new Scene(root,300,200);
			//aboutScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			aboutStage.setScene(aboutScene);
			aboutStage.setTitle("About");
			aboutStage.getIcons().add(new Image(Main.class.getResourceAsStream("files/icon.png")));
			aboutStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
