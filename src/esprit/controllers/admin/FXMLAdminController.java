/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.admin;

import esprit.dao.ArbitreDAO;
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
import esprit.entite.Niveau;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
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
       
    
        @FXML
    private Button boutonGlissantListe;
    @FXML
    private Button boutonGlissantImage;
    @FXML
    private Button menuMedecin;
     @FXML
    private Button menuJoueur;
     @FXML
     private Button menuArbitre;
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
    private ComboBox arbitreNiveau;
    @FXML
    private RadioButton femme;
    @FXML
    private RadioButton homme;
   @FXML
   TextField searchField;
   //*************************** Attrbut arbitre ; 
   @FXML
   TextField arbitreCin;
   @FXML
   TextField arbitreNom;
   @FXML
   TextField arbitrePrenom;
   @FXML
   PasswordField arbitrePassword;
   @FXML
   TextField arbitreEmail;
   @FXML
   TextField arbitreLogin;
   @FXML
   private TableColumn arbitreColumnNom;
   @FXML
   private TableColumn arbitreColumnPrenom;
   @FXML
   private TableColumn arbitreColumnCin;
   @FXML
   private TableColumn arbitreColumnAdresse;
   @FXML
   private TableColumn arbitreColumnLogin;
   @FXML
   private TableColumn arbitreColumnPassword;
    @FXML
   private TableColumn arbitreColumnEmail;
   @FXML
   private TableColumn arbitreColumnSexe;
   @FXML
   private TableColumn arbitreColumnNiveau;
      @FXML
    private TableColumn arbitreColumnButton;
    @FXML
    private TableView tableArbitre;
    @FXML
    private TableColumn arbitreColumnButtonModify;
    
         private ObservableList<Arbitre> mainArbitreData;
        private ObservableList<Arbitre> arbitreData_filtree;
        private ObservableList<Arbitre> arbitreData ;
    final ToggleGroup groupSexeArbitre = new ToggleGroup();
    

    
    
    
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
               setInvisibleAllConsult();
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
    
  
   
   
   
   
   
   /**************************************************
    * @Desc :  interface Arbitre.                                                           *
    * @author : Mustapha.                                                                   *
    *                                                                                                            *
    **************************************************/
   // Fonction de controle de saisie & autres supplementaires
    
    private boolean fonctionCCsaisie(Object objetFormulaire)
    {
       if (objetFormulaire == null)
       {      
        try {
           
           
             if (arbitreNiveau.getValue() == null)
            {
                arbitreNiveau.setStyle(styleInputError);
                throw new Exception("Niveau is null");
            }
             
            Integer.parseInt(arbitreCin.getText()) ;
            if ( arbitreNom.getText().isEmpty() || arbitrePrenom.getText().isEmpty() || arbitreLogin.getText().isEmpty() || arbitrePassword.getText().isEmpty() || arbitreEmail.getText().isEmpty() || arbitreCin.getText().length() != 8) 
            {
                throw new Exception();
            }
            
            else{
            return true;    
            }
            
        }catch (Exception e)
        {
            return false;
        } 
        
       }else
       {
           
           
           switch(objetFormulaire.getClass().getName())
                   {
                       case "javafx.scene.control.TextField" :
                       TextField auxObjet = (TextField)objetFormulaire;
                            try {
                                Integer.parseInt(arbitreCin.getText()) ;
                                if (arbitreCin.getText().length() == 8)
                                   return true;
            
                                    }catch (Exception e)
                                        {
                                              return false;
                                        } 
                     
                        default :
                                return false;
                   }
       }
    }
     
    @FXML
    private void isCinANumber(KeyEvent event)
    {
         
        if(fonctionCCsaisie(arbitreCin))
        {
            //cin.setStyle(styleInputNormal);
           arbitreCin.setStyle(".inputNormal");
        }else
        {
           
            arbitreCin.setStyle(styleInputError);
        }
       
        
    }
     @FXML
    private void isBoxVide(MouseEvent event)
    {
         
        if(arbitreNiveau.getValue() != null)
        {
            //cin.setStyle(styleInputNormal);
           arbitreNiveau.setStyle(".inputNormal");
        }else
        {
           
            arbitreNiveau.setStyle(styleInputError);
        }
     
    }
      @FXML
       private void setBoxToNormal(MouseEvent event)
       {
           if(fonctionCCsaisie(arbitreNiveau))
           arbitreNiveau.setStyle(".inputNormal");
       }
        
       
       // Evenements
       @FXML
    private void basculerVersImageOuListe( MouseEvent event)
    {
        Button auxButton = (Button)event.getSource();
        if (auxButton.getId().equals("boutonGlissantImage"))
        {
           // imageScrollPaneContainer.setVisible(true);
            boutonGlissantImage.setVisible(false);
            boutonGlissantListe.setVisible(true);
            //TFTTransition.fadeIn(imageScrollPaneContainer,400);
           // fillImages();
            listeContainer.setOpacity(0);
            listeContainer.setVisible(false);
        }else
        {
                listeContainer.setVisible(true);
                boutonGlissantImage.setVisible(true);
                boutonGlissantListe.setVisible(false);
              //  imageScrollPaneContainer.setOpacity(0);
              //  imageScrollPaneContainer.setVisible(false);
                TFTTransition.fadeIn(listeContainer,600);
                
              //  fillTable();
           
            
        }
        
    }  
   @FXML
    private void handleAjouterArbitre(MouseEvent event)
    {
        if (fonctionCCsaisie(null))
        {
        RadioButton auxRadio = (RadioButton)groupSexeArbitre.getSelectedToggle();
          //public Arbitre(int idpersonne, String cin, String nom, String prenom, String adresse, 
        //String email, String sexe, String login, String password, Date datenaissance, String role, String avatar,
        //Date datedestruction,float salaire, int experience, Niveau niveau) 
    
        Arbitre arbitre = new Arbitre(0,arbitreCin.getText(),arbitreNom.getText(),arbitrePrenom.getText(),"Sans adresse",arbitreEmail.getText(),
                   auxRadio.getId(),arbitreLogin.getText(),
                arbitrePassword.getText(),null,"Arbitre",
                "Sans avatar",null,0,0,Niveau.valueOf(arbitreNiveau.getValue().toString())
        );
         System.out.println(arbitreNom.getText());
         ArbitreDAO arbitreDAO = new ArbitreDAO();
         arbitreDAO.save(arbitre);
         //fillTable();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Federation Tunisienne de Tennis");
    
    alert.setHeaderText("");
    alert.setContentText("Veuillez remplir tout les champs et correctement, ta3mel mzeya");
    alert.showAndWait();
        }
         /*
             */
         
    }
        
    private void fillTableArbitre()
   {
       
       
                
         Arbitre a=new Arbitre();
           ArbitreDAO arbitreDao = new ArbitreDAO();
           arbitreColumnNom.setCellValueFactory(new PropertyValueFactory("Nom"));
           arbitreColumnPrenom.setCellValueFactory(new PropertyValueFactory("Prenom"));
           arbitreColumnCin.setCellValueFactory(new PropertyValueFactory("Cin"));
           arbitreColumnEmail.setCellValueFactory(new PropertyValueFactory("Email"));
           arbitreColumnLogin.setCellValueFactory(new PropertyValueFactory("Login"));
           arbitreColumnPassword.setCellValueFactory(new PropertyValueFactory("Password"));
           arbitreColumnSexe.setCellValueFactory(new PropertyValueFactory("Sexe"));
           arbitreColumnNiveau.setCellValueFactory(new PropertyValueFactory("Niveau"));
             
           
           Callback<TableColumn<Arbitre, String>, TableCell<Arbitre, String>> cellFactory = 
                new Callback<TableColumn<Arbitre, String>, TableCell<Arbitre, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Arbitre, String> param )
                    {
                        final TableCell<Arbitre, String> cell = new TableCell<Arbitre, String>()
                        {

                            final Button btn = new Button( "Supprimer" );
                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                             a.setCin(getTableView().getItems().get(getIndex()).getCin()); 
                                              arbitreDao.delete(a);
                                             fillTableArbitre();
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
           
           
            Callback<TableColumn<Arbitre, String>, TableCell<Arbitre, String>> cellFactoryModify = 
                new Callback<TableColumn<Arbitre, String>, TableCell<Arbitre, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Arbitre, String> param )
                    {
                        final TableCell<Arbitre, String> cell = new TableCell<Arbitre, String>()
                        {

                            final Button btnModify = new Button( "Modifier" );
                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btnModify.setOnAction( ( ActionEvent event ) ->
                                            {
                                              
                                             a.setCin(getTableView().getItems().get(getIndex()).getCin());
                                             a.setNom(getTableView().getItems().get(getIndex()).getNom());
                                             a.setPrenom(getTableView().getItems().get(getIndex()).getPrenom());
                                             a.setLogin(getTableView().getItems().get(getIndex()).getLogin());
                                             a.setPassword(getTableView().getItems().get(getIndex()).getPassword());
                                             a.setSexe(getTableView().getItems().get(getIndex()).getSexe());
                                             a.setAdresse(getTableView().getItems().get(getIndex()).getAdresse());
                                             a.setNiveau(getTableView().getItems().get(getIndex()).getNiveau());
                                              
                                             fillTableArbitre();
                                             FXMLModifyArbitreController.initData(a);
                                             
                                             
                                             try {
                                            Thread.sleep(1000);
                                       
                                             } catch (InterruptedException ex) {
                                              System.out.println(ex.getMessage());
                                             }
                                             //***********************************************
                                             
                                             Stage stageModify = new Stage();
                                            stageModify.setResizable(false);
                                             Parent root;
                                        try {
                                            root = FXMLLoader.load(getClass().getResource("FXMLModifyArbitre.fxml"));
                                            stageModify.setScene(new Scene(root));
                                        } catch (IOException ex) {
                                            Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                            
                                             stageModify.setTitle("Modifier un Arbitre");
                                                     stageModify.initModality(Modality.WINDOW_MODAL);
                                            stageModify.initOwner(
                                               ((Button)event.getSource()).getScene().getWindow() );
                                             stageModify.setOnHidden((WindowEvent e)->{
                                             fillTableArbitre() ;});
                                                     
                                                     
                                                     stageModify.show();
                                             
                                    } );
                                    setGraphic( btnModify );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                }; 
            
            arbitreColumnButtonModify.setCellFactory(cellFactoryModify);
            arbitreColumnButton.setCellFactory( cellFactory );
            mainArbitreData = FXCollections.observableArrayList();
               for (Arbitre aIterator : arbitreDao.getList())
               {
                   mainArbitreData.add(aIterator);
               }
            
            tableArbitre.setItems(mainArbitreData);
            tableArbitre.setEditable(true);
        
        
            
   }
   
    
    
    
    
    
    
    //***********************************************
    //***********************************************
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
       arbitreNiveau.getItems().addAll("Amateur","National","International");
       femme.setToggleGroup(groupSexeArbitre);
       homme.setSelected(true);
       homme.setToggleGroup(groupSexeArbitre);
       
       fillTableArbitre();
       
    }    
    
}
