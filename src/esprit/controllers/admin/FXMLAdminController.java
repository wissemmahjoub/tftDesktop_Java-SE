/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.admin;

import esprit.ressources.TFTEffects.TFTTransition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import esprit.entite.Arbitre;
/**
 *
 * @author Mustapha
 */
public class FXMLAdminController implements Initializable {
    
    //Initialisations **********************************************************************************************
    
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
   
   
   private final String styleInputError =  "-fx-border-radius: 5px;"+
    "-fx-focus-color: -fx-control-inner-background ;"+
    "-fx-faint-focus-color: -fx-control-inner-background ;"+
           " -fx-border-color: #e01212;";
   
   private final String styleInputNormal="-fx-border-color :  rgba(0,0,0,0.3);\n" +
"    -fx-border-radius: 5px;\n" +
"    -fx-focus-color: -fx-control-inner-background ;\n" +
"    -fx-faint-focus-color: -fx-control-inner-background ;";
     //*************************************************************************************************************
      private ObservableList<Arbitre> data;
      private ObservableList<Arbitre> data_filtree;
        private ObservableList<Arbitre> arbitreData ;
    @FXML
    private Label label;
    @FXML
    private Button menuCup,menuMatch,menuStade,menuMessage,menuArbitre;
    @FXML
    private Button boutonGlissantListe;
    @FXML
    private Button boutonGlissantImage;
    @FXML
    private Button menuMedecin;
     @FXML
    private Button menuJoueur;
    @FXML
    private Button menuFormation;
    @FXML
    private Button menuClub;
    @FXML
    private AnchorPane backgroundPane,listeContainer;
    @FXML
    private AnchorPane consulterArbitrePane;
     @FXML
    private AnchorPane consulterMedecinPane;
      @FXML
    private AnchorPane consulterJoueurPane;
  
    @FXML
    private ImageView optionTailleAgrandir,optionTailleParDefaut ; 
    @FXML
    private Label titelLabel;
    @FXML
    private ComboBox niveau;
    @FXML
    private RadioButton femme;
    @FXML
    private RadioButton homme;
    
   @FXML
   TextField searchField;
 
    
 
    final ToggleGroup group = new ToggleGroup();

    
    /**
     * 
     * @param o : L'objet surlequel on va faire le controle de saisie, Si = null -> tous les objets de la formulaure seront testés.
     * @return : retourner True si c'est bon.
     */
    
    
    private Stage getStage()
    {
            return (Stage) backgroundPane.getScene().getWindow();
       
    }
  
    
   
   
    
    /**
     * fonctionnalité : Gerer les boutons du menu
     * @param event 
     */
      private void setMenuStyleNormal()
    {
        menuJoueur.setStyle(styleMenu);
        menuArbitre.setStyle(styleMenu);
        menuMedecin.setStyle(styleMenu);
        
    }
    private void setInvisibleAllConsult()
    {
        consulterArbitrePane.setVisible(false);
        consulterMedecinPane.setVisible(false);
        consulterJoueurPane.setVisible(false);
        //consulterDashboardPane.setVisible(false);
    }
    
    @FXML
    private void handleMenuButtonPressed( MouseEvent event)
    {
        // Configuration d'affichage des boutons
        buttonAux = (Button)event.getSource();
        setMenuStyleNormal();
        buttonAux.setStyle(styleMenuPressed);
        
        // Configuration d'affichage des Pane de gestion
        switch (buttonAux.getId())
        {
            case "menuArbitre" :
               //setInvisibleAllConsult();
               //consulterArbitrePane.setVisible(true);
                
              TFTTransition.fadeIn(consulterArbitrePane,300);
                   
                consulterArbitrePane.setVisible(true);
                titelLabel.setText("Gestion des Arbitres");
                break;
            case "menuMedecin":
                setInvisibleAllConsult();
                consulterMedecinPane.setVisible(true);
                titelLabel.setText("Gestion des Medecins");
                break;
            case "menuJoueur" :
                setInvisibleAllConsult();
                consulterJoueurPane.setVisible(true);
                titelLabel.setText("Gestion des Joueurs");
                break;
                
            default:
                break;
                
        }
        
        
    }
    
    
    //--------------------------------------------------

    
    
    
    
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
      
      
       niveau.getItems().addAll("Amateur","National","International");
       femme.setToggleGroup(group);
       homme.setSelected(true);
       homme.setToggleGroup(group);
       
       
       
    }    
    
}
