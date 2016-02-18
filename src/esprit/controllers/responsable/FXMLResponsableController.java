/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.responsable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustapha
 */
public class FXMLResponsableController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private double initialX;
   private double initialY;
   private Button buttonAux;
   private Stage stage;
   private final String styleMenuPressed = 
                "-fx-text-alignment: left;\n" +
                "-fx-text-align: left;\n" +
                "-fx-background-color: #144d5e;"+
                "-fx-cursor : hand;"+
                "-fx-alignment : baseline-left;";
   private final String styleMenu = styleMenuPressed + "-fx-background-color: #29778e;";
    
    
    
    
    @FXML
    private Button menuCup;
    @FXML
    private Button menuStade;
    @FXML
    private Button menuMatch;
    @FXML
    private Button menuMessage;
    @FXML
    private Button menuFormation;
    @FXML
    private Button menuClub;
    @FXML
    private Button menuClub2;
    @FXML
    private AnchorPane backgroundPane;
    @FXML
    private ImageView optionTailleAgrandir;
    @FXML
    private ImageView optionTailleParDefaut;
    
    
     private void setMenuStyleNormal()
    {
        menuCup.setStyle(styleMenu);
        menuStade.setStyle(styleMenu);
        menuMatch.setStyle(styleMenu);
        menuMessage.setStyle(styleMenu); 
        menuFormation.setStyle(styleMenu);
        menuClub.setStyle(styleMenu);
    }
     
     private Stage getStage()
    {
            return (Stage) backgroundPane.getScene().getWindow();
        
    }
     
     
     
     // Evenements ----------------------
    
     
     @FXML
    private void handleMenuButtonPressed( MouseEvent event)
    {
        // Configuration d'affichage des boutons
        buttonAux = (Button)event.getSource();
        setMenuStyleNormal();
        buttonAux.setStyle(styleMenuPressed);
        
    }
    
     //------------------------------------------------ Configuration d'affichage genrerale -------------------------------------------------------------
     
    
    // Permet la fermeture de l'application
    @FXML
   private void handleCloseApplication(MouseEvent event)
   {
     stage = getStage();
    // do what you have to do
    stage.close();
    
     System.exit(0);
     
   }
   
    @FXML
    // Mettre la fenetre en plein ecran et Changer la source de l'icone Agrandir
    private void handleAgrandir(MouseEvent event)
    {
        //Reference vers le "Stage" de l'application crée dans "FronEnd.Java"
       stage = getStage();
       stage.setMaximized(true);
       optionTailleAgrandir.setVisible(false);
       optionTailleParDefaut.setVisible(true);    
    }
    @FXML
    //retourner la taille par defaut
    private void handleRetournerParDefaut(MouseEvent event)
    {
        //Reference vers le "Stage" de l'application crée dans "FronEnd.Java"
       stage = getStage();
       stage.setMaximized(false);
       optionTailleAgrandir.setVisible(true);
       optionTailleParDefaut.setVisible(false);
    }
     @FXML
    private void onMousePressed( MouseEvent event)
    {
        // Si l'hauteur de l'application est superieur à 800 ( Par defaut ) alors elle est en plein ecran , Cette fonctionnalité est désactivée
          stage = getStage();
          if (stage.getHeight() < 900){
         initialX = event.getX();
        initialY = event.getY();
        if(event.getButton()!=MouseButton.MIDDLE)
                {
                    initialX = event.getSceneX();
                    initialY = event.getSceneY();
                }
                else
                {
                    backgroundPane.getScene().getWindow().centerOnScreen();
                    initialX = backgroundPane.getScene().getWindow().getX();
                    initialY = backgroundPane.getScene().getWindow().getY();
                }
       // System.out.println(initialX);
          }
    }
    // Permet le deplacement de la fenetre suivant la souris
    @FXML
    private void handleonMouseDragged(MouseEvent event)
    {
        
      stage = getStage();
       
          if (stage.getHeight() < 900){
               backgroundPane.getScene().getWindow().setX(event.getScreenX() - initialX);
               backgroundPane.getScene().getWindow().setY(event.getScreenY() - initialY);
          }
                
    }
    
   //--------------------------------------------------------------------------------------------------------
     
     
     
     
     
     
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
