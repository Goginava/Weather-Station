package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class ControllerAboutScene {

	@FXML
    private Hyperlink homepageLink;

    @FXML
    private Hyperlink cloudIconLink;

    @FXML
    private Hyperlink licenseLink;

    @FXML
    void cloudIconLinkClicked(ActionEvent event) {
    	openLinkInBrowser("https://icons8.com/web-app/41144/Cloud-Lightning");
    }

    @FXML
    void homepageLinkClicked(ActionEvent event) {
    	openLinkInBrowser("http://david-goginava.de");
    }

    @FXML
    void licenseLinkClicked(ActionEvent event) {
    	openLinkInBrowser("http://david-goginava.de/license/GNUGPLv3.txt");
    }
    
    void openLinkInBrowser (String link)
    {
    	if(Desktop.isDesktopSupported())
    	{
	    	  try {
				Desktop.getDesktop().browse(new URI(link));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}
