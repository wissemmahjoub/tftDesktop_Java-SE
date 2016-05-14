/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gui.responsable;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLMediaController implements Initializable {

    
    
     @FXML
    private MediaView mediaView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // TODO
        
      
      //  WebEngine engine = test.getEngine();
   //     engine.load("http://www.dailymotion.com/video/x3sic8d_shake-shake-go-take-me-to-the-sea-paleo-festival-2015_music");
        
    //    engine.setJavaScriptEnabled(true);
     
        
           // Create and set the Scene.
    
   //  Media media = new Media("GOPR0211.MP4");

     // Create the player and set to play automatically.
  //   MediaPlayer mediaPlayer = new MediaPlayer(media);
   //  mediaPlayer.setAutoPlay(true);

     // Create the view and add it to the Scene.
   //  MediaView mediaView = new MediaView(mediaPlayer);
        
        MediaPlayer mediaPlayer;

Media media;

     

//Add your own path of the vidio that you want to play
String path = "C:\\tunis.mp4";

media = new Media(new File(path).toURI().toString());

mediaPlayer = new MediaPlayer(media);
//AutoPlay set to false
mediaPlayer.setAutoPlay(true);
mediaView.setMediaPlayer(mediaPlayer);






    }    
    
}
