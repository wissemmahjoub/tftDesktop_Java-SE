/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gui.responsable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLVideoController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
            WebView webvview = new WebView();
    webvview.getEngine().load(
     
           "http://www.dailymotion.com/embed/video/x2z17c0_le-coup-franc-monumental-de-casemiro_sport"
    );
    webvview.setPrefSize(640, 390);
Stage stage=new Stage();
    stage.setScene(new Scene(webvview));
   stage.show();

    }    
    
}
