/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.authentification;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import esprit.dao.ArbitreDAO;
import esprit.entite.Arbitre;
import esprit.ressources.TFTEffects.TFTTransition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Mustapha
 */
public class FXMLauthentificationController implements Initializable {

     private double initialX;
   private double initialY;
    @FXML
    AnchorPane arbitreContainer;
    @FXML
    AnchorPane medecinContainer;
    @FXML
    AnchorPane responsableContainer;
    @FXML
    AnchorPane adminContainer;
    @FXML
    AnchorPane formContainer;
    @FXML
    AnchorPane choixContainer;
    @FXML
    TextField formLogin;
    @FXML
    TextField formPwd;
    @FXML
    Button retour;
    @FXML
    AnchorPane noteContainer;
    @FXML
     Label note;
    @FXML
    Button valider;
    private String etatTransition = "choix";
    private String compteSelected = "null";
    private boolean alreadyClicked = false;
    
    private Stage getStage()
    {
         return (Stage) note.getScene().getWindow();
    }
      @FXML
   private void handleCloseApplication(MouseEvent event)
   {
       
     Stage stage = getStage();
    // do what you have to do
    stage.close();
    
     System.exit(0);
     
   }
    
      @FXML
    private void onMousePressed( MouseEvent event)
    {
        // Si l'hauteur de l'application est superieur à 800 ( Par defaut ) alors elle est en plein ecran , Cette fonctionnalité est désactivée
        Stage  stage = getStage();
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
                    arbitreContainer.getScene().getWindow().centerOnScreen();
                    initialX = arbitreContainer.getScene().getWindow().getX();
                    initialY = arbitreContainer.getScene().getWindow().getY();
                }
       // System.out.println(initialX);
          }
    }
    // Permet le deplacement de la fenetre suivant la souris
    @FXML
    private void handleonMouseDragged(MouseEvent event)
    {
        
      Stage stage = getStage();
       
          if (stage.getHeight() < 900){
              arbitreContainer.getScene().getWindow().setX(event.getScreenX() - initialX);
              arbitreContainer.getScene().getWindow().setY(event.getScreenY() - initialY);
          }
                
    }
    
    
    @FXML
    private void clickAdmin(MouseEvent event)
    {
        
            if (etatTransition.equals("choix"))
            {
                
            compteSelected = "admin";
           TFTTransition.fadeOutAndGoY(arbitreContainer,400);
           TFTTransition.fadeOutAndGoX(responsableContainer,400);
           TFTTransition.fadeOutAndGoY(medecinContainer,400);
           Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(300),
				new KeyValue(adminContainer.layoutXProperty(),177 ),
                                                                                new KeyValue(adminContainer.layoutYProperty(),145 )
					)
                    );
                    timeLine.play(); 
                    /**
                     *  Transition de la formulaire
                     */
                    upForm();
                   // choixContainer.setVisible(false);
                    etatTransition = "form";
                    }
            
            else
            {
                
            }
    }
    @FXML
    private void clickMedecin(MouseEvent event)
    {
        if (etatTransition.equals("choix"))
            {
                
            compteSelected = "medecin";
           TFTTransition.fadeOutAndGoY(arbitreContainer,400);
           TFTTransition.fadeOutAndGoX(responsableContainer,400);
           TFTTransition.fadeOutAndGoY(adminContainer,400);
           Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(400),
				new KeyValue(medecinContainer.layoutXProperty(),210 ),
                                                                                new KeyValue(medecinContainer.layoutYProperty(),170 )
					)
                    );
                    timeLine.play(); 
                    /**
                     *  Transition de la formulaire
                     */
                     upForm();
                    // choixContainer.setVisible(false);
                     etatTransition = "form";
                    }
            
            else
            {
                
            }
    }
    
     @FXML
    private void clickArbitre(MouseEvent event)
    {
        if (etatTransition.equals("choix"))
            {
                
            compteSelected = "arbitre";
           TFTTransition.fadeOutAndGoY(medecinContainer,400);
           TFTTransition.fadeOutAndGoX(responsableContainer,400);
           TFTTransition.fadeOutAndGoY(adminContainer,400);
           Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(500),
				new KeyValue(arbitreContainer.layoutXProperty(),220),
                                                                                new KeyValue(arbitreContainer.layoutYProperty(),170 )
					)
                    );
                    timeLine.play(); 
                    /**
                     *  Transition de la formulaire
                     */
                     upForm();
                    // choixContainer.setVisible(false);
                     etatTransition = "form";
                    }
            
            else
            {
                
            }
    }
    
    
    @FXML
    private void clickResponsable(MouseEvent event)
    {
        if (etatTransition.equals("choix"))
            {
                
            compteSelected = "responsable";
           TFTTransition.fadeOutAndGoY(medecinContainer,400);
           TFTTransition.fadeOutAndGoX(arbitreContainer,400);
           TFTTransition.fadeOutAndGoY(adminContainer,400);
           Timeline timeLine = new Timeline();
                    timeLine.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(400),
				new KeyValue(responsableContainer.layoutXProperty(),210),
                                                                                new KeyValue(responsableContainer.layoutYProperty(),170 )
					)
                    );
                    timeLine.play(); 
                    /**
                     *  Transition de la formulaire
                     */
                     upForm();
                    // choixContainer.setVisible(false);
                     etatTransition = "form";
                    }
            
            else
            {
                
            }
    }
    @FXML
    private void retourPressed(MouseEvent event)
    {
        /*switch(compteSelected)
        {
            case "arbitre" :
                
        }*/
        Timeline timeLineResp = new Timeline();
                    timeLineResp.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(200),
				new KeyValue(responsableContainer.layoutXProperty(),39),
                                                                                 new KeyValue(responsableContainer.opacityProperty(),1),
                                                                                new KeyValue(responsableContainer.layoutYProperty(),411)
					)
                    );
                    timeLineResp.play();
                    
                    
          Timeline timeLineArbitre = new Timeline();
                    timeLineArbitre.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(550),
				new KeyValue(arbitreContainer.layoutXProperty(),361),
                            new KeyValue(arbitreContainer.opacityProperty(),1),                                                    
                            new KeyValue(arbitreContainer.layoutYProperty(),164)
					)
                    );
                    timeLineArbitre.play(); 
                   
                    Timeline timeLineAdmin = new Timeline();
                    timeLineAdmin.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(600),
				new KeyValue(adminContainer.layoutXProperty(),38),
                            new KeyValue(adminContainer.opacityProperty(),1),
                                                                                new KeyValue(adminContainer.layoutYProperty(),158)
					)
                    );
                    timeLineAdmin.play(); 
                    
                    Timeline timeLineMed = new Timeline();
                    timeLineMed.getKeyFrames().addAll(

                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(200),
				new KeyValue(medecinContainer.layoutXProperty(),339),
                            new KeyValue(medecinContainer.opacityProperty(),1),
                                                                                new KeyValue(medecinContainer.layoutYProperty(),404)
					)
                    );
                    timeLineMed.play(); 
                    
        etatTransition = "choix";
        downForm();
        
    }
    private void upForm()
    {
                    formContainer.setVisible(true);
                    Timeline timeLineForm = new Timeline();
                    timeLineForm.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(formContainer.layoutYProperty(),378 ) 
					),
                    new KeyFrame(Duration.millis(500),
                                                                                new KeyValue(formContainer.opacityProperty(),1),
				new KeyValue(formContainer.layoutYProperty(),128 )                                                                               
					)
                    );
                    timeLineForm.play(); 
                    retour.setDisable(false);
                    Timeline timeLineRetour = new Timeline();
                    timeLineRetour.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                                                                                new KeyValue(retour.opacityProperty(),0 )
					),
                    new KeyFrame(Duration.millis(500),
                                                                                new KeyValue(retour.opacityProperty(),1)                                                                             
					)
                    );
                    timeLineRetour.play();     
    }
    
    private void downForm()
    {
         note.setVisible(false);
          valider.setDisable(true);
         formLogin.setText("");
         formPwd.setText("");
                retour.setDisable(true);
                    Timeline timeLineForm = new Timeline();
                    timeLineForm.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.millis(500),
                                                                                new KeyValue(formContainer.opacityProperty(),0),
				new KeyValue(formContainer.layoutYProperty(),378 )                                                                               
					)
                    );
                    timeLineForm.play();     
                    
                    Timeline timeLineRetour = new Timeline();
                    timeLineRetour.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                                                                                new KeyValue(retour.opacityProperty(),1)
					),
                    new KeyFrame(Duration.millis(500),
                                                                                new KeyValue(retour.opacityProperty(),0)                                                                             
					)
                    );
                    timeLineRetour.play(); 
    }
    
    private void fadeNote(boolean ch)
    {
        if (ch)
        {
            Timeline timeLineNote = new Timeline();
                                          timeLineNote.getKeyFrames().addAll(
                                          new KeyFrame(Duration.ZERO,
                                                                                                      new KeyValue(note.opacityProperty(),0)
                                                              ),
                                          new KeyFrame(Duration.millis(300),
                                                                                                      new KeyValue(note.opacityProperty(),1)                                                                             
                                                              )
                                          );
                                                    timeLineNote.play(); 
        }else
        {
            Timeline timeLineNote = new Timeline();
                                          timeLineNote.getKeyFrames().addAll(
                                          new KeyFrame(Duration.ZERO,
                                                                                                      new KeyValue(note.opacityProperty(),1)
                                                              ),
                                          new KeyFrame(Duration.millis(500),
                                                                                                      new KeyValue(note.opacityProperty(),0)                                                                             
                                                              )
                                          );
                                                    timeLineNote.play(); 
        }
    }
    
    
    
    @FXML
    private void clickValider(MouseEvent event)
    {
        signIn(compteSelected);
    }
    private void signIn(String selection)
    {
        // Prendre les valeurs de la base de données d'aprés les formulaires .
        // Appeler la fenetre
        switch(selection)
        {
            case "arbitre" :
                    ArbitreDAO arbitreDao = new ArbitreDAO();
                    Arbitre formArbitre = new Arbitre();
                    if(!(formLogin.getText().isEmpty()) && !(formPwd.getText().isEmpty()))
                    {
                      
                              formArbitre.setLogin(formLogin.getText());
                              formArbitre.setPassword(formPwd.getText());
                               Arbitre sessionArbitre = arbitreDao.find(formArbitre);
                               if (sessionArbitre == null)
                               {
                                   System.out.println("Arbitre non retrouvé");
                                   
                                   note.setText("Compte inexistant !"); 
                                  note.setVisible(true);
                                  note.setStyle("-fx-background-color:#ff4c4c");
                                  fadeNote(true);
                                                    alreadyClicked = true;
                                                    valider.setDisable(true);
                                   
                               }else
                               {
                                   System.out.println(sessionArbitre.getCin()); 
                                   note.setVisible(true);
                                   note.setText("Connexion à votre espace en cours..");
                                    note.setStyle("-fx-background-color:#6df35f");
                                    fadeNote(true);
                               }
                    }else
                    {
                                 note.setText("Champs Invalides !"); 
                                  note.setVisible(true);
                                  note.setStyle("-fx-background-color:#ff4c4c");
                                  fadeNote(true);
                                  alreadyClicked = true;
                                  valider.setDisable(true);
                    }
                    break;
            case "medecin":
                    System.out.println("Not supported yet !");
                    break;
            case "responsable":
                   if((formLogin.getText().equals("responsable")) && !(formPwd.getText().isEmpty()))
                    {
                                                Stage stage = getStage();
                                                Parent root;
                           try {
                               root = FXMLLoader.load(getClass().getResource("/esprit/gui/responsable/FXMLResponsable.fxml"));
                               Scene scene = new Scene(root);
                               stage.setScene(scene);
                           } catch (IOException ex) {
                               Logger.getLogger(FXMLauthentificationController.class.getName()).log(Level.SEVERE, null, ex);
                           }

                                   
                                
                    }else
                    {
                                 note.setText("Champs Invalides !"); 
                                  note.setVisible(true);
                                  note.setStyle("-fx-background-color:#ff4c4c");
                                  fadeNote(true);
                                  alreadyClicked = true;
                                  valider.setDisable(true);
                    }
                    break;
            case "admin":
                      if((formLogin.getText().equals("admin")) && !(formPwd.getText().isEmpty()))
                    {
                                                Stage stage = getStage();
                                                Parent root;
                           try {
                               root = FXMLLoader.load(getClass().getResource("/esprit/gui/admin/FXMLAdmin.fxml"));
                               Scene scene = new Scene(root);
                               stage.setScene(scene);
                           } catch (IOException ex) {
                               Logger.getLogger(FXMLauthentificationController.class.getName()).log(Level.SEVERE, null, ex);
                           }

                                   
                                
                    }else
                    {
                                 note.setText("Champs Invalides !"); 
                                  note.setVisible(true);
                                  note.setStyle("-fx-background-color:#ff4c4c");
                                  fadeNote(true);
                                  alreadyClicked = true;
                                  valider.setDisable(true);
                    }
                    break;
            default :
                System.out.println("selection error");
        }
      
    }
  
    @FXML
    private void onChangeFields(KeyEvent event)
    {
        if (note.getOpacity() == 1)
         fadeNote(false);
        alreadyClicked = false;
         if(!(formLogin.getText().isEmpty()) && !(formPwd.getText().isEmpty()))
         {
        valider.setDisable(false);
         }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
