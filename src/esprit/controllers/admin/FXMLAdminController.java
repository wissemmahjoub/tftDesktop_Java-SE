/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.admin;

import esprit.controllers.authentification.FXMLauthentificationController;
import esprit.controllers.responsable.FXMLResponsableController;
import esprit.dao.ArbitreDAO;
import esprit.dao.JoueurDAO;
import esprit.dao.MedecinDAO;
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
import esprit.entite.Joueur;
import esprit.entite.Medecin;
import esprit.entite.Niveau;
import esprit.entite.TrancheAge;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
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
       
    /* --*/
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
    @FXML
    private ScrollPane imageScrollPaneContainer;
     private List<AnchorPane> anchorListe;
    @FXML
    private AnchorPane imageGlobalContainer;
    @FXML
    private TextArea note;
     @FXML
    WebView browser;
    @FXML
    PieChart pieChart;
    @FXML
    private Button menuDashboard;
    @FXML
    private AnchorPane consulterDashboardPane;
    @FXML
    private AnchorPane stat2;
    private BarChart barChart;
    
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
        menuDashboard.setStyle(styleMenu);
        
    }
    private void setInvisibleAllConsult()
    {
        consulterArbitrePane.setVisible(false);
        consulterMedecinPane.setVisible(false);
        consulterJoueurPane.setVisible(false);
       consulterDashboardPane.setVisible(false);
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
            case "menuDashboard" :
                setInvisibleAllConsult();
                consulterDashboardPane.setVisible(true);
                  titelLabel.setText("Tableau de board");
                  loadCharts();
                break;
            default:
                break;
                
        }
        
        
    }
    private void loadCharts()
    {
        //barChart
        CategoryAxis xBar = new CategoryAxis();
                  xBar.setLabel("Nombre des comptes");
                  NumberAxis yBar = new NumberAxis();
                  yBar.setLabel("Comptes");
                  barChart = new BarChart(xBar, yBar);
                  barChart.setPrefSize(stat2.getPrefWidth() - 20,stat2.getPrefHeight() - 20);
                  barChart.setLayoutY(30);
                  stat2.getChildren().add(barChart);
                      ObservableList<XYChart.Data> barData= FXCollections.observableArrayList(
                    new XYChart.Data("Medecin",200,"#FFF"),
                    new XYChart.Data("Joueur",100),
                    new XYChart.Data("Arbitre",300)
            );
                      XYChart.Series serie = new XYChart.Series("Serie",barData);
                    barChart.getData().add(serie);
                    
                    //PieChart
                    ObservableList<PieChart.Data> list = FXCollections.observableArrayList(       
        new PieChart.Data("Arbitre", 50),
        new PieChart.Data("Joueur", 60),
        new PieChart.Data("Medecin", 30),
        new PieChart.Data("Inactifs", 20)
        );
        pieChart.setData(list);
    }
      @FXML
     private void deconnexion(MouseEvent event)
     {
         Stage stage = getStage();
           Parent rootAuth;
       try {
           rootAuth = FXMLLoader.load(getClass().getResource("/esprit/gui/authentification/FXMLauthentificationv2.fxml"));
            Scene scene = new Scene(rootAuth);
            stage.setScene(scene);
       } catch (IOException ex) {
           Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
            imageScrollPaneContainer.setVisible(true);
            boutonGlissantImage.setVisible(false);
            boutonGlissantListe.setVisible(true);
            TFTTransition.fadeIn(imageScrollPaneContainer,400);
            fillImagesArbitre();
            listeContainer.setOpacity(0);
            listeContainer.setVisible(false);
        }else
        {
                listeContainer.setVisible(true);
                boutonGlissantImage.setVisible(true);
                boutonGlissantListe.setVisible(false);
                imageScrollPaneContainer.setOpacity(0);
                imageScrollPaneContainer.setVisible(false);
                TFTTransition.fadeIn(listeContainer,600);
                
                fillTableArbitre();
           
            
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
         System.out.println(Niveau.valueOf(arbitreNiveau.getValue().toString()));
         ArbitreDAO arbitreDAO = new ArbitreDAO();
         arbitreDAO.save(arbitre);
         fillTableArbitre();
         fillImagesArbitre();
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
                                            root = FXMLLoader.load(getClass().getResource("/esprit/gui/admin/FXMLModifyArbitre.fxml"));
                                            stageModify.setScene(new Scene(root));
                                        } catch (IOException ex) {
                                            Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
                                           // System.out.println(ex.getMessage());
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
   
    
   @FXML
   public void rechercher(KeyEvent event)
   {
       rechercherImages();
       Arbitre a=new Arbitre();
           ArbitreDAO arbitreDao = new ArbitreDAO();
           arbitreColumnNom.setCellValueFactory(new PropertyValueFactory("Nom"));
           arbitreColumnPrenom.setCellValueFactory(new PropertyValueFactory("Prenom"));
           arbitreColumnCin.setCellValueFactory(new PropertyValueFactory("Cin"));
           arbitreColumnEmail.setCellValueFactory(new PropertyValueFactory("Email"));
           arbitreColumnLogin.setCellValueFactory(new PropertyValueFactory("Login"));
           arbitreColumnPassword.setCellValueFactory(new PropertyValueFactory("pwd"));
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
                                              //arbitreDao.delete(a);
                                             fillTableArbitre();
                                             FXMLModifyArbitreController.initData(a);
                                             
                                             /**
                                              *  Attendre pour que les donneés soit envoyées
                                              */
                                             try {
                                            Thread.sleep(1000);
                                       
                                             } catch (InterruptedException ex) {
                                            Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
                                       
                                             }
                                             //***********************************************
                                             
                                             Stage stageModify = new Stage();
                                            stageModify.setResizable(false);
                                             Parent root;
                                        try {
                                            root = FXMLLoader.load(getClass().getResource("/esprit/gui/admin/FXMLModifyArbitre.fxml"));
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
           arbitreData_filtree = FXCollections.observableArrayList();
           arbitreDao.getList().stream().filter((aIterator) -> ( aIterator.getNom().contains(searchField.getText()) ||  aIterator.getPrenom().contains(searchField.getText()) )).forEach((aIterator) -> {
               arbitreData_filtree.add(aIterator);
       });
            
            tableArbitre.setItems(arbitreData_filtree);
            tableArbitre.setEditable(true);
        
        
            
   }
   
  
     private void rechercherImages()
   {
       ArbitreDAO arbitreDao = new ArbitreDAO();
       
       List imageData;
       imageData = arbitreDao.getList();
       ObservableList<Arbitre> imageData_filtree = FXCollections.observableArrayList();
       
        arbitreDao.getList().stream().filter((aIterator) -> ( aIterator.getNom().contains(searchField.getText()) ||  aIterator.getPrenom().contains(searchField.getText()) )).forEach((aIterator) -> {
               imageData_filtree.add(aIterator);
       });
       /**
        * Itération pour chaque Objet Arbitre dans la base;
        */
       double ligneX = 26;
       double ligneY = 25;
       double iteration = 1;
       int nombreLigne = 1;
       int maxHorizon = 600;
       
       if (imageScrollPaneContainer.getWidth() > 750) maxHorizon=900;
       
       // On vide le container à chaque fois qu'on entre dans la fonction.
       if(anchorListe.size() > 0)
       {
           anchorListe.stream().forEach((anchorIterator) -> {
               imageGlobalContainer.getChildren().remove(anchorIterator);
           });
       }
       
           for (Arbitre aIterator :     imageData_filtree)
               {
                   
                       /**
                        * on est arrivé à la limite de la ligne horizontale donc on retourne à la ligne.
                        */
                       if (ligneX >= maxHorizon)
                        {
                       ligneX = 26;
                       ligneY = (263 * nombreLigne) + 25;
                       nombreLigne++;
                        }
                   
                   
                   //--------------------------Creation des composants / Evenements ----------------------------
                   VBox vbLabels = new VBox();
                   vbLabels.setSpacing(10);
                    vbLabels.setPadding(new Insets(0, 20, 10, 20)); 
                    vbLabels.setAlignment(Pos.CENTER);
                            
                   Label nomAndprenom = new Label(aIterator.getNom()+" "+aIterator.getPrenom());
                   //nomAndprenom.setLayoutX(65);
                   //nomAndprenom.setLayoutY(142);
                   Label lblNiveau = new Label(aIterator.getNiveau().toString());
                  // lblNiveau.setLayoutX(81);
                   //lblNiveau.setLayoutY(174);
                   
                   vbLabels.getChildren().addAll(nomAndprenom,lblNiveau);
                   vbLabels.setLayoutY(142);
                   vbLabels.setLayoutX((218 / nomAndprenom.getText().length()) + 20 );
                   /**
                    * Creation des boutons.
                    */
                   Button imgContainerModiferButton = new Button();
                   imgContainerModiferButton.getStyleClass().add("imageContainerButton");
                   imgContainerModiferButton.setText("Modifier");
                   imgContainerModiferButton.setPrefSize(74, 25);
                   imgContainerModiferButton.setLayoutX(119);
                   imgContainerModiferButton.setLayoutY(218);
                   
                   Button imgContainerSuppButton = new Button();
                   imgContainerSuppButton.getStyleClass().add("imageContainerButton");
                   imgContainerSuppButton.setText("Supprimer");
                   imgContainerSuppButton.setPrefSize(74, 25);
                   imgContainerSuppButton.setLayoutX(23);
                   imgContainerSuppButton.setLayoutY(218);
                   
                   imgContainerModiferButton.setOnAction((ActionEvent eventModifer)->{
                                FXMLModifyArbitreController.initData(aIterator);
                                 Stage stageModify = new Stage();
                                     stageModify.setResizable(false);
                                    Parent root;
                                  try {
                                    root = FXMLLoader.load(getClass().getResource("/esprit/gui/admin/FXMLModifyArbitre.fxml"));
                                      stageModify.setScene(new Scene(root));
                                     } catch (IOException ex) {
                                      Logger.getLogger(FXMLModifyArbitreController.class.getName()).log(Level.SEVERE, null, ex);
                                              }
                                      stageModify.setTitle("Modifier un Arbitre");
                                      stageModify.initModality(Modality.WINDOW_MODAL);
                                        stageModify.initOwner(((Button)eventModifer.getSource()).getScene().getWindow() );
                                          stageModify.setOnHidden((WindowEvent e)->{
                               fillImagesArbitre() ;
                                     });
                                 stageModify.show();
                               });
                   
                   
                   /**
                    * Creation des Containers.
                    */
                   AnchorPane imageContainer = new AnchorPane();
                   imageContainer.setOpacity(0);
                   imageContainer.setId("imageContainer"+aIterator.getCin());
                   
                   imageContainer.setPrefSize(218, 263);
                   imageContainer.setStyle("-fx-background-color: #fff; -fx-border-color: #f1f1f1");
                   imageContainer.setLayoutX(ligneX);
                   imageContainer.setLayoutY(ligneY);
                   
                   imageGlobalContainer.getChildren().add(imageContainer);
                   imageContainer.getChildren().addAll(imgContainerModiferButton,imgContainerSuppButton, vbLabels);
                   anchorListe.add(imageContainer);
                   ligneX += 218; 
                   
                   /**
                    * Transition config.
                    */
                   TFTTransition.fadeIn(imageContainer,iteration*150);
                   iteration++;
                   
                   
                   imgContainerSuppButton.setOnAction((ActionEvent eventSupp)->{
                       arbitreDao.delete(aIterator);
                       imageGlobalContainer.getChildren().remove(imageContainer);
                       
                       fillImagesArbitre();
                   });
                   
                  // data.add(aIterator);
               }
           
       
        //----------------------------------------------------------------------------
                                        
       
   }
    
     private void fillImagesArbitre()
   {
       ArbitreDAO arbitreDao = new ArbitreDAO();
       List imageData;
       imageData = arbitreDao.getList();
       /**
        * Itération pour chaque Objet Arbitre dans la base;
        */
       double ligneX = 26;
       double ligneY = 25;
       double iteration = 1;
       int nombreLigne = 1;
       int maxHorizon = 600;
       
       if (imageScrollPaneContainer.getWidth() > 750) maxHorizon=900;
       
       // On vide le container à chaque fois qu'on entre dans la fonction.
       if(anchorListe.size() > 0)
       {
           anchorListe.stream().forEach((anchorIterator) -> {
               imageGlobalContainer.getChildren().remove(anchorIterator);
           });
       }
       
           for (Arbitre aIterator : arbitreDao.getList())
               {
                   
                       /**
                        * on est arrivé à la limite de la ligne horizontale donc on retourne à la ligne.
                        */
                       if (ligneX >= maxHorizon)
                        {
                       ligneX = 26;
                       ligneY = (263 * nombreLigne) + 25;
                       nombreLigne++;
                        }
                   
                   
                   //--------------------------Creation des composants / Evenements ----------------------------
                   VBox vbLabels = new VBox();
                   vbLabels.setSpacing(10);
                    vbLabels.setPadding(new Insets(0, 20, 10, 20)); 
                    vbLabels.setAlignment(Pos.CENTER);
                            
                   Label nomAndprenom = new Label(aIterator.getNom()+" "+aIterator.getPrenom());
                   Label lblNiveau = new Label(aIterator.getNiveau().toString());
                   
                   ImageView avatar = new ImageView("/esprit/ressources/images/avatar.png");
                 
                   avatar.setFitHeight(100);
                   avatar.setFitWidth(100);
                   avatar.setLayoutY(20);
                   avatar.setLayoutX(218/4);
                    vbLabels.getChildren().addAll(nomAndprenom,lblNiveau);
                   vbLabels.setLayoutY(142);
                   vbLabels.setLayoutX((218 / nomAndprenom.getText().length()) + 20 );
                   
                   /**
                    * Creation des boutons.
                    */
                   Button imgContainerModiferButton = new Button();
                   imgContainerModiferButton.getStyleClass().add("imageContainerButton");
                   imgContainerModiferButton.setText("Modifier");
                   imgContainerModiferButton.setPrefSize(74, 25);
                   imgContainerModiferButton.setLayoutX(119);
                   imgContainerModiferButton.setLayoutY(218);
                   
                   Button imgContainerSuppButton = new Button();
                   imgContainerSuppButton.getStyleClass().add("imageContainerButton");
                   imgContainerSuppButton.setText("Supprimer");
                   imgContainerSuppButton.setPrefSize(74, 25);
                   imgContainerSuppButton.setLayoutX(23);
                   imgContainerSuppButton.setLayoutY(218);
                   
                   imgContainerModiferButton.setOnAction((ActionEvent event)->{
                                FXMLModifyArbitreController.initData(aIterator);
                                 Stage stageModify = new Stage();
                                     stageModify.setResizable(false);
                                    Parent root;
                                  try {
                                    root = FXMLLoader.load(getClass().getResource("/esprit/gui/admin/FXMLModifyArbitre.fxml"));
                                      stageModify.setScene(new Scene(root));
                                     } catch (IOException ex) {
                                      Logger.getLogger(FXMLModifyArbitreController.class.getName()).log(Level.SEVERE, null, ex);
                                              }
                                      stageModify.setTitle("Modifier un Arbitre");
                                      stageModify.initModality(Modality.WINDOW_MODAL);
                                        stageModify.initOwner(((Button)event.getSource()).getScene().getWindow() );
                                          stageModify.setOnHidden((WindowEvent e)->{
                               fillImagesArbitre() ;
                                     });
                                 stageModify.show();
                               });
                   
                   
                   /**
                    * Creation des Containers.
                    */
                   AnchorPane imageContainer = new AnchorPane();
                   imageContainer.setOpacity(0);
                   imageContainer.setId("imageContainer"+aIterator.getCin());
                   
                   imageContainer.setPrefSize(218, 263);
                   imageContainer.setStyle("-fx-background-color: #fff; -fx-border-color: #f1f1f1");
                   imageContainer.setLayoutX(ligneX);
                   imageContainer.setLayoutY(ligneY);
                   
                   imageGlobalContainer.getChildren().add(imageContainer);
                   imageContainer.getChildren().addAll(avatar,imgContainerModiferButton,imgContainerSuppButton, vbLabels);
                   anchorListe.add(imageContainer);
                   ligneX += 218; 
                   
                   /**
                    * Transition config.
                    */
                   TFTTransition.fadeIn(imageContainer,iteration*150);
                   iteration++;
                   
                   
                   imgContainerSuppButton.setOnAction((ActionEvent event)->{
                       arbitreDao.delete(aIterator);
                       imageGlobalContainer.getChildren().remove(imageContainer);
                       
                       fillImagesArbitre();
                   });
                   
                  // data.add(aIterator);
               }
           
       
        //----------------------------------------------------------------------------
                                        
       
   }
    
     
     
  private void readNote()
  {
      String filePath = "src\\esprit\\ressources\\font\\noteFile";
      String text= "";
        try{
        // Création du flux bufférisé sur un FileReader, immédiatement suivi par un 
        // try/finally, ce qui permet de ne fermer le flux QUE s'il le reader
        // est correctement instancié (évite les NullPointerException)
        BufferedReader buff = new BufferedReader(new FileReader(filePath));

        try {
        String line;
        // Lecture du fichier ligne par ligne. Cette boucle se termine
        // quand la méthode retourne la valeur null.
        while ((line = buff.readLine()) != null) {
        text += line + "\n";
       
        //faites ici votre traitement
        }
        } finally {
             note.setText(text);
        // dans tous les cas, on ferme nos flux
        buff.close();
        }
        } catch (IOException ioe) {
        // erreur de fermeture des flux
        System.out.println("Erreur --" + ioe.toString());
        }
  }
  
  @FXML
  private void saveNote(KeyEvent event)
  {
                FileWriter writer = null;
          String texte = note.getText();
          try{
               writer = new FileWriter("src\\esprit\\ressources\\font\\noteFile",false);
               writer.write(texte,0,texte.length());
          }catch(IOException ex){
              ex.printStackTrace();
          }
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                     }
                
  }
  
  
    //***********************************************
    //***********************************************
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      anchorListe = new ArrayList<>();
       arbitreNiveau.getItems().addAll("Amateur","National","International");
       femme.setToggleGroup(groupSexeArbitre);
       homme.setSelected(true);
       homme.setToggleGroup(groupSexeArbitre);
       
       fillTableArbitre();
      
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://api.openweathermap.org/data/2.5/weather?q=tunisia&mode=html&appid=826ceb3f1368a4e375a339c8c6c3a598");
           
        
           
      anchorListe = new ArrayList<>();
       arbitreNiveau.getItems().addAll("Amateur","National","International");
        radio_f.setToggleGroup(sexe);
        radio_h.setToggleGroup(sexe);
       
        AfficherMedecin();
       zone_statisque_medecin.setVisible(false); 
          
        readNote();
        
        
       
       afficher();
       RemplirCombo();
    }    
    
    
    
    
     //Initialisations **********************************************************************************************
    
   
    @FXML
    private Button bnt_close_stat;
   
     
     
      @FXML
    private Button parcourir_image;
     
     
    
   
    
    @FXML
    private TextField rech;
    @FXML
    private Label Label;
    @FXML
    private Label labb;
 @FXML
private ImageView imagepr;
    @FXML
    private Label email;

    @FXML
    private Button Bnt_stat_btn;

    @FXML
    private AnchorPane zone_statisque_medecin;

    @FXML
    private PieChart graph_stat_medecin;
   @FXML
    private TableColumn imgch;


    @FXML
    private TableColumn  col_nom_med;

    @FXML
    private TableColumn  col_prenom_med;

    @FXML
    private TableColumn  col_cin_med;
@FXML
    private TableColumn col_path;
    @FXML
    private TableColumn col_login_med;

    @FXML
    private TableColumn   col_pwd_med;

    @FXML
    private TableColumn<?, ?> col_specialite_med;

    @FXML
    private TableColumn col_salaire_med;

    @FXML
    private TableColumn  col_datenaiss_med;

    @FXML
    private TableColumn  col_sexe_med;

    @FXML
    private TableColumn  col_mail_med;

    @FXML
    private TableColumn  col_adress_med;

    @FXML
    private TableColumn  col_supp_med;

    @FXML
    private Button boutonGlissantListe1;

    @FXML
    private Button boutonGlissantImage1;

    @FXML
    private TableView tab_medecin;
    @FXML
    private Label label_medecin;

    @FXML
    private TextField nom_medecin;

    @FXML
    private TextField prenom_medecin;

    @FXML
    private TextField cin_medecin;

    @FXML
    private Button Button_ajout_medecin;

    @FXML
    private PasswordField pwd_medecin;

    @FXML
    private TextField login_medecin;

    @FXML
    private TextField spec_medecin;

    @FXML
    private TextField salaire_medecin;

    @FXML
    private TextField mail_medecin;

    @FXML
    private TextField adrs_medecin;

    @FXML
    private RadioButton radio_h;

    @FXML
    private ToggleGroup sexe;

    @FXML
    private RadioButton radio_f;

    @FXML
    private Button Button_modifier_medecin;

    @FXML
    private DatePicker date_naiss_medecin;


    @FXML
    private Button menuArbitre121;
    

      

    
    
  
    
   @FXML
  AnchorPane zon_ajout_medecin;
   
    
    
   //--------------------------------------------------------------------------------------------------------
    
  
   
   
   
   
   
    
   
//---------------------------------------------------------------------- 
//######################################################################
//######################################################################
//#####################|                    |###########################
 //####################|  GESTION MEDECIN   |###########################
//#####################|                    |###########################
//######################################################################
//######################################################################
//#####################|     By Wissem      |###########################   
//----------------------------------------------------------------------     
     
     
     
//######################################################################
//################# AJOUT Medecin ######################################
//######################################################################
    Medecin m = new Medecin();
    MedecinDAO mdao=new MedecinDAO();
    
    public void viderChamp()
    {
    m.setNom(nom_medecin.getText());
        m.setPrenom("");
        m.setCin("");
        m.setLogin("");
        m.setPassword("");
        m.setSpecialite("");
        m.setSalaire(0);
        m.setEmail("");
        m.setAdresse("");
        m.setAvatar("");
    
    }
    
    //################### changement de couleur de bordure de text fild ##########
   
    @FXML
    public void testCin(KeyEvent event)
    {
     
        if ((cin_medecin.getText().length()!=8) || (cin_medecin.getText().matches("[0-9]*")==false))
       {
           cin_medecin.setStyle("-fx-border-color: red;");

       }
        else{   cin_medecin.setStyle("-fx-border-color: #0ad200;");}
    }
    
    @FXML
     public void testPwd(KeyEvent event)
    {
     
        if (pwd_medecin.getText().length()<8) 
       {
           pwd_medecin.setStyle("-fx-border-color: red;");
           
       }
        else{   pwd_medecin.setStyle("-fx-border-color: #0ad200;");}
    }
     

   
     //#######################################################
    
    
    @FXML
   public void AjouterMedecin(ActionEvent event)
   { int x =1;
       //########### LES CONTROLS DE SAISIE ################
       if (
           nom_medecin.getText().equals("")  || 
           prenom_medecin.getText().equals("")||
           cin_medecin.getText().equals("") ||
           login_medecin.getText().equals("")||
           pwd_medecin.getText().equals("") ||
           spec_medecin.getText().equals("")||
           mail_medecin.getText().equals("")||
           adrs_medecin.getText().equals("")
            ) 
        {
       x=0;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Federation Tunisienne de Tennis");
        alert.setHeaderText(" Vous devez remplir tous les champs ");
        alert.setContentText("TFT");
        alert.showAndWait();
        }
         
       
       else if (!(cin_medecin.getText().length()== 8) || (cin_medecin.getText().matches("[0-9]*")==false)) 
       {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Federation Tunisienne de Tennis");
        alert.setHeaderText(" CIN Non Valide  ");
        alert.setContentText("Condition CIN : taille =8 chiffres");
        alert.showAndWait(); 
        x=0;
       }
       
        
       else if ((pwd_medecin.getText().length()<8)) 
       {
     x=0;
        Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Federation Tunisienne de Tennis");
       alert.setHeaderText(" Mot de passe Non Valide  ");
       alert.setContentText("Condition Password : taille min = 8 caractéres");
       alert.showAndWait(); 
       }
       else if (x==1)
        {
           
         RadioButton rd= (RadioButton) sexe.getSelectedToggle();
        m.setNom(nom_medecin.getText());
        m.setPrenom(prenom_medecin.getText());
        m.setCin(cin_medecin.getText());
        m.setLogin(login_medecin.getText());
        m.setPassword(pwd_medecin.getText());
        m.setSpecialite(spec_medecin.getText());
        m.setSalaire(Integer.parseInt(salaire_medecin.getText()));
        m.setDatedestruction(java.sql.Date.valueOf(date_naiss_medecin.getValue()));
        m.setSexe(rd.getText());
        m.setEmail(mail_medecin.getText());
        m.setAdresse(adrs_medecin.getText());
       
        
        mdao.save(m);
      
        viderChamp();
        AfficherMedecin();
        System.out.println("--------- Medecin ajouté  ----------");
        
    String chaine =prenom_medecin.getText()+" "+nom_medecin.getText()+" est ajouté(e) a la base de données";  
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Federation Tunisienne de Tennis");
    alert.setHeaderText(chaine);
    alert.setContentText("TFT");
    alert.showAndWait();
        
          }

        
    
     
        

       
       
       
       
   }

   
   
   
   
   
   
   
//######################################################################
//################# Modifier Medecin ###################################
//######################################################################
   int position ;
 @FXML
    private void Modifier(MouseEvent event) 
    {
         if (tab_medecin != null) {
         List<Medecin> TAB = tab_medecin.getSelectionModel().getSelectedItems();
         if (TAB.size() == 1) {
         final Medecin medecinSelected = TAB.get(0);
         position = dataMedecin.indexOf(medecinSelected);
         if (medecinSelected != null)
         {
           
       nom_medecin.setText(medecinSelected.getNom());
        prenom_medecin.setText(medecinSelected.getPrenom());
        cin_medecin.setText(medecinSelected.getCin());
        login_medecin.setText(medecinSelected.getLogin());
        pwd_medecin.setText(medecinSelected.getPassword());
        spec_medecin.setText(medecinSelected.getSpecialite());
        salaire_medecin.setText(String.valueOf( medecinSelected.getSalaire()));
        
        Instant instant = Instant.ofEpochMilli(medecinSelected.getDatenaissance().getTime());
        LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        date_naiss_medecin.setValue(res);
        
        RadioButton rd= (RadioButton) sexe.getSelectedToggle();
        mail_medecin.setText(medecinSelected.getEmail());
        adrs_medecin.setText(medecinSelected.getAdresse());
       
              
          AfficherMedecin();
   
        }}}}

    
    @FXML
    private void update(ActionEvent event)  {
          
        m.setNom(nom_medecin.getText());
        m.setPrenom(prenom_medecin.getText());
        m.setCin(cin_medecin.getText());
        m.setLogin(login_medecin.getText());
        m.setPassword(pwd_medecin.getText());
        m.setSpecialite(spec_medecin.getText());
        m.setSalaire(Float.parseFloat(salaire_medecin.getText()));
        m.setDatenaissance(java.sql.Date.valueOf(date_naiss_medecin.getValue()));
        RadioButton rd= (RadioButton) sexe.getSelectedToggle();
        m.setSexe(rd.getText());
        m.setEmail(mail_medecin.getText());
        m.setAdresse(adrs_medecin.getText());
        try {
                mdao.update(m);
               System.out.println("-----modification effectuée --------- ");
        } catch (Exception e)
        {
            System.out.println("------- ERREUR DE MODIFICATION----- ");
        }
  
 
   
      AfficherMedecin();
        
      
    }
    
   
//######################################################################
//################# Afficher Medecin ###################################
//################| supprimer Medecin|##################################
//######################################################################
   private ObservableList<Medecin> dataMedecin;    
   public void AfficherMedecin(){
  
       try {

           col_salaire_med.setCellValueFactory(new PropertyValueFactory("salaire"));
           col_specialite_med.setCellValueFactory(new PropertyValueFactory("specialite"));
           col_cin_med.setCellValueFactory(new PropertyValueFactory("cin"));
           col_nom_med.setCellValueFactory(new PropertyValueFactory("nom"));
           col_prenom_med.setCellValueFactory(new PropertyValueFactory("prenom"));
           col_adress_med.setCellValueFactory(new PropertyValueFactory("adresse"));
           col_mail_med.setCellValueFactory(new PropertyValueFactory("email"));
           col_sexe_med.setCellValueFactory(new PropertyValueFactory("sexe"));
           col_login_med.setCellValueFactory(new PropertyValueFactory("login"));  
           col_pwd_med.setCellValueFactory(new PropertyValueFactory("password"));
           col_datenaiss_med.setCellValueFactory(new PropertyValueFactory("datenaissance"));
          col_path.setCellValueFactory(new PropertyValueFactory("avatar"));
           
 } catch (Exception e) 
        { System.out.println("--------- erreur affichage medecin !! ---------");
       }
//***************** lajout de boutton supprimer dans la table view *******************************
 Callback<TableColumn<Medecin, String>, TableCell<Medecin, String>> cellFactory = 
 new Callback<TableColumn<Medecin, String>, TableCell<Medecin, String>>()
{
 @Override
public TableCell call( final TableColumn<Medecin, String> param )
{
                        final TableCell<Medecin, String> cell = new TableCell<Medecin, String>()
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
                                             m.setCin(getTableView().getItems().get( getIndex()).getCin()); 
                                             mdao.delete(m);
                                             AfficherMedecin();
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             
            col_supp_med.setCellFactory( cellFactory );
            
           
            dataMedecin = FXCollections.observableArrayList();
               for (Medecin m : mdao.getList())
               {
                   dataMedecin.add(m);
               }
            tab_medecin.setItems(dataMedecin);

    }

   
   
   
   
   
   
//######################################################################
//################# Chercher Medecin ###################################
//################| supprimer Medecin|##################################
//######################################################################
   private ObservableList<Medecin> dataMedecin2;    
  
    @FXML
   public void FiltrerMedecin(){
  
       try {

           col_salaire_med.setCellValueFactory(new PropertyValueFactory("salaire"));
           col_specialite_med.setCellValueFactory(new PropertyValueFactory("specialite"));
           col_cin_med.setCellValueFactory(new PropertyValueFactory("cin"));
           col_nom_med.setCellValueFactory(new PropertyValueFactory("nom"));
           col_prenom_med.setCellValueFactory(new PropertyValueFactory("prenom"));
           col_adress_med.setCellValueFactory(new PropertyValueFactory("adresse"));
           col_mail_med.setCellValueFactory(new PropertyValueFactory("email"));
           col_sexe_med.setCellValueFactory(new PropertyValueFactory("sexe"));
           col_login_med.setCellValueFactory(new PropertyValueFactory("login"));  
           col_pwd_med.setCellValueFactory(new PropertyValueFactory("password"));
           col_datenaiss_med.setCellValueFactory(new PropertyValueFactory("datenaissance"));
         
           
 } catch (Exception e) 
        { System.out.println("--------- erreur affichage medecin !! ---------");
       }

 Callback<TableColumn<Medecin, String>, TableCell<Medecin, String>> cellFactory = 
 new Callback<TableColumn<Medecin, String>, TableCell<Medecin, String>>()
{
 @Override
public TableCell call( final TableColumn<Medecin, String> param )
{
                        final TableCell<Medecin, String> cell = new TableCell<Medecin, String>()
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
                                             m.setCin(getTableView().getItems().get( getIndex()).getCin()); 
                                             mdao.delete(m);
                                             AfficherMedecin();
                                             
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             
            col_supp_med.setCellFactory( cellFactory );
            dataMedecin2 = FXCollections.observableArrayList();
               for (Medecin m : mdao.getList())
               {
              if ((m.getNom().contains(rech.getText()))||  (m.getPrenom().contains(rech.getText()))||((m.getCin().contains(rech.getText())))  )
                   dataMedecin2.add(m);
               }
            tab_medecin.setItems(dataMedecin2);

    }
   //##################################################################################################
    //################################## Statistique Medecin ##########################################
   //#################################################################################################
       @FXML
    void afficherStatisque(ActionEvent event)
    {
          zone_statisque_medecin.setVisible(true);
      ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
        List<Medecin> list =mdao.getList();
        for(Medecin mm : list){
           
            PieChart.Data data = new PieChart.Data(mm.getPrenom()+" "+mm.getNom(), mm.getSalaire());
            pieChartData.add(data);
        }
    

        graph_stat_medecin.setTitle("Salaire des Medecins ");
       
        graph_stat_medecin.setData(pieChartData);  

    }
     @FXML
    void close_stat(ActionEvent event)
    {
           zone_statisque_medecin.setVisible(false);

    }
 
   
  
    
    
    /*
    ########################## CHEMS ###################################
    */
    
    
        @FXML
        private TextField rechJoueur;
  
    @FXML
    private TextField jnom;
    @FXML   
    private TextField jprenom;
    @FXML
    private TextField jcin;
    @FXML
    private TextField jadresse;
    @FXML
    private TextField jemail;
    
    @FXML
    private RadioButton jfemme;
    @FXML
    private RadioButton jhomme;
    @FXML
    private RadioButton jjunior;
    @FXML
    private RadioButton jsenior;
    @FXML
    private RadioButton jveteran;
    @FXML
    private RadioButton jamateur;
    @FXML
    private RadioButton jnational;
    @FXML
    private RadioButton jinternational;
    @FXML
    private DatePicker jdate;
    @FXML
    private ComboBox jclub;
    @FXML
    private Button jenvoyer;
    
    @FXML
    private Button jmodif;
    
    
    @FXML
         private ToggleGroup section;
        @FXML
         private ToggleGroup niveau;
     @FXML
    private TableView tablejo;
         
        
         @FXML
    private TableColumn colcin;
    @FXML
    private TableColumn colnom;
    @FXML
    private TableColumn colpren;
     @FXML
    private TableColumn coladr;
     @FXML
    private TableColumn colemail;
         @FXML
    private TableColumn colsexe;
    @FXML
    private TableColumn coldate;
    @FXML
    private TableColumn colsect;
     @FXML
    private TableColumn colclub;
     @FXML
    private TableColumn colniv;
         @FXML
    private TableColumn column41;
          @FXML
    private TableColumn libclub;
      @FXML
      private Hyperlink clear;

           
         private ObservableList<Joueur> data;
         private ObservableList<Joueur> data_filtre;
        
          Joueur j =new Joueur();
          JoueurDAO jdao=new JoueurDAO();
          
//////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////
          
          
          
          
    
        
    @FXML
    private AnchorPane ajouterArbitrePane;
    
    
    
   @FXML
   private ToggleGroup sexeJoueur;
    
    
    
    
    
   
    
    
       /**************************************************
    * @Desc :  Gestion joueur.                                                           *
    * @author : Chams.                                                                   *
    *                                                                                                            *
    **************************************************/
    
    
     public void RemplirCombo (){
        Set<String> clubj = new HashSet<String>();
          
        for (int i = 0; i < jdao.getClub().size(); i++) {
            clubj.add(jdao.getClub().get(i).getLibellecode());
        }
        jclub.getItems().clear();
        jclub.getItems().addAll(clubj);
    
    }
    
    @FXML
    private void ajouterJoueur(ActionEvent event) 
    {
                      RadioButton Se = (RadioButton) (sexe).getSelectedToggle();
                      RadioButton sect = (RadioButton) (section).getSelectedToggle();
                      RadioButton niv = (RadioButton) (niveau).getSelectedToggle();

        j.setNom(jnom.getText());
            j.setPrenom(jprenom.getText());
            j.setCin((jcin.getText()));
            j.setAdresse(jadresse.getText());
            j.setEmail(jemail.getText());
            j.setNiveau(Niveau.valueOf(niv.getText()));
            j.setSection(TrancheAge.valueOf(sect.getText()));
            j.setSexe(Se.getText());
            j.setDatenaissance(java.sql.Date.valueOf(jdate.getValue()));
            j.setLogin(jcin.getText());
            j.setPassword(jcin.getText()+jprenom.getText());
            j.setRole("Joueur");
           
           String b = jclub.getValue().toString();
          // String b = jnom.getText();
            int a =jdao.rechIdClubParNom(b);
            j.setIdclub(a);
            j.setAvatar("d");
            jdao.save(j);
            jdao.getList();
            afficher();
            
    }
    
    public void afficher()
    {
    
             colcin.setCellValueFactory(new PropertyValueFactory("cin"));
             colnom.setCellValueFactory(new PropertyValueFactory("nom"));
             colpren.setCellValueFactory(new PropertyValueFactory("prenom"));
             coladr.setCellValueFactory(new PropertyValueFactory("adresse"));
              colemail.setCellValueFactory(new PropertyValueFactory("email"));
             colsexe.setCellValueFactory(new PropertyValueFactory("sexe"));
             coldate.setCellValueFactory(new PropertyValueFactory("datenaissance"));
              colsect.setCellValueFactory(new PropertyValueFactory("section"));
             colclub.setCellValueFactory(new PropertyValueFactory("idclub"));
             colniv.setCellValueFactory(new PropertyValueFactory("niveau"));
             libclub.setCellValueFactory(new PropertyValueFactory("nomclub"));

// data = FXCollections.observableArrayList();
//               for (Joueur j : jdao.getList())
//               {
//                   data.add(j);
//               }
//         //   table.setItems(null);
//           
//
//       tablejo.setItems(data);
                   




           
             

             Callback<TableColumn<Joueur, String>, TableCell<Joueur, String>> cellFactory = 
                new Callback<TableColumn<Joueur, String>, TableCell<Joueur, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Joueur, String> param )
                    {
                        final TableCell<Joueur, String> cell = new TableCell<Joueur, String>()
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
                                             j.setCin(getTableView().getItems().get( getIndex()).getCin()); 
                                             jdao.delete(j);
                                             afficher();
                                             RemplirCombo();
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             column41.setCellFactory( cellFactory );
            
            
            
data = FXCollections.observableArrayList();
               for (Joueur j : jdao.getList())
               {
                   data.add(j);
               }
           

       tablejo.setItems(data);       
            
    }
    
     @FXML
    public void rechercheJoueurr(){
    
     colcin.setCellValueFactory(new PropertyValueFactory("cin"));
             colnom.setCellValueFactory(new PropertyValueFactory("nom"));
             colpren.setCellValueFactory(new PropertyValueFactory("prenom"));
             coladr.setCellValueFactory(new PropertyValueFactory("adresse"));
              colemail.setCellValueFactory(new PropertyValueFactory("email"));
             colsexe.setCellValueFactory(new PropertyValueFactory("sexe"));
             coldate.setCellValueFactory(new PropertyValueFactory("datenaissance"));
              colsect.setCellValueFactory(new PropertyValueFactory("section"));
             colclub.setCellValueFactory(new PropertyValueFactory("idclub"));
             colniv.setCellValueFactory(new PropertyValueFactory("niveau"));
             
    
    Callback<TableColumn<Joueur, String>, TableCell<Joueur, String>> cellFactory = 
                new Callback<TableColumn<Joueur, String>, TableCell<Joueur, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Joueur, String> param )
                    {
                        final TableCell<Joueur, String> cell = new TableCell<Joueur, String>()
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
                                             j.setCin(getTableView().getItems().get( getIndex()).getCin()); 
                                             jdao.delete(j);
                                             afficher();
                                             RemplirCombo();
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             column41.setCellFactory( cellFactory );
             
             data_filtre = FXCollections.observableArrayList();
               for (Joueur j : jdao.getList())
               {
                   if ((j.getNom().contains(rechJoueur.getText()))  ||
                 (j.getCin().contains( rechJoueur.getText()))
                   ||
                           
                (j.getCin().contains( rechJoueur.getText())))
                   {
                   data_filtre.add(j);
                   
               }}
           
            tablejo.setItems(data_filtre);
    
    }
    
   @FXML
    private void ModifierJoueur(MouseEvent event) 
    {
        if (tablejo != null) {
            List<Joueur> tables = tablejo.getSelectionModel().getSelectedItems();
            if (tables.size() == 1) {
                final Joueur joueurselected = tables.get(0);
                   position = data.indexOf(joueurselected);
                        if (joueurselected != null) {

            jnom.setText(joueurselected.getNom());
            jprenom.setText(joueurselected.getPrenom());
            
           if (joueurselected.getSexe().equals("Homme")){
                sexe.selectToggle(jhomme);
            } else  
           {sexe.selectToggle(jfemme);}
           
           if (joueurselected.getSection().toString().equals("Junior")){
                section.selectToggle(jjunior);
            } else if (joueurselected.getSection().toString().equals("Senior")) 
           {section.selectToggle(jsenior);}
            else {section.selectToggle(jveteran);}
           
            if (joueurselected.getNiveau().toString().equals("National")){
                niveau.selectToggle(jnational);
            } else if (joueurselected.getNiveau().toString().equals("Amateur")) 
           {niveau.selectToggle(jamateur);}
            else {niveau.selectToggle(jinternational);}
                   
          //  jclub.setCellFactory(joueurselected.get);
                
            jcin.setText(joueurselected.getCin());
            jemail.setText(joueurselected.getEmail());
            jadresse.setText(joueurselected.getAdresse());
            String nomclub= jdao.rechnomclubparid(joueurselected.getIdclub());
            jclub.setValue(nomclub);
            Instant instant = Instant.ofEpochMilli(joueurselected.getDatenaissance().getTime());
            LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            
            


            jdate.setValue(res);
        }        

    }
}
    }
    
    
     @FXML
    private void updateJoueur(ActionEvent event)  {
   
  RadioButton Se = (RadioButton) (sexe).getSelectedToggle();
                      RadioButton sect = (RadioButton) (section).getSelectedToggle();
                      RadioButton niv = (RadioButton) (niveau).getSelectedToggle();

        j.setNom(jnom.getText());
            j.setPrenom(jprenom.getText());
            j.setCin((jcin.getText()));
            j.setAdresse(jadresse.getText());
            j.setEmail(jemail.getText());
            j.setNiveau(Niveau.valueOf(niv.getText()));
            j.setSection(TrancheAge.valueOf(sect.getText()));
            j.setSexe(Se.getText());
            j.setDatenaissance(java.sql.Date.valueOf(jdate.getValue()));
            j.setLogin(jcin.getText());
            j.setPassword(jcin.getText()+jprenom.getText());
            j.setRole("Joueur");
           
           String b = jclub.getValue().toString();
          // String b = jnom.getText();
            int a =jdao.rechIdClubParNom(b);
            j.setIdclub(a);
            j.setAvatar("d");
            jdao.update(j);
            
            
           

            System.out.println("modification effectuée  ");
        
        afficher();
        jclub.setValue(null);
        jnom.setText("");
        jprenom.setText("");
        jcin.setText("");
        jadresse.setText("");
        jemail.setText("");
        sexe.selectToggle(null);
        jdate.setValue(null);
        section.selectToggle(null);
        niveau.selectToggle(null);


    }
    
             @FXML
             public void clear()
             {
             jclub.setValue(null);
        jnom.setText("");
        jprenom.setText("");
        jcin.setText("");
        jadresse.setText("");
        jemail.setText("");
        sexe.selectToggle(null);
        jdate.setValue(null);
        section.selectToggle(null);
        niveau.selectToggle(null);
             }
     
    
    /*
    ########################## FIN CHEMS ###################################
    */
    
    
    
    
}
