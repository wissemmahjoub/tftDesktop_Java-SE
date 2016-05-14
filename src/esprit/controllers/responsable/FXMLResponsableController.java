/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.responsable;

import esprit.controllers.admin.FXMLAdminController;
import esprit.dao.ClubDAO;
import esprit.dao.CompetitionDAO;
import esprit.dao.EventDAO;
import esprit.dao.MatchDAO;
import esprit.dao.StadeDAO;
import esprit.dao.StadeDAOInterface;
import esprit.dao.TicketDAO;
import esprit.entite.Arbitre;
import esprit.entite.Categorie;
import esprit.entite.Club;
import esprit.entite.Competition;
import esprit.entite.Evenement;
import esprit.entite.Joueur;
import esprit.entite.Match;
import esprit.entite.Niveau;
import esprit.entite.SessionFormation;
import esprit.entite.Stade;
import esprit.entite.Surface;
import esprit.entite.Ticket;
import esprit.entite.TrancheAge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
   /*
     
    #######################################################################################
    #######################################################################################
     #######################################################################################
     WISSEM
     #######################################################################################
   #######################################################################################
     #######################################################################################
     
     
     */
   private LocalDate datedeb;
    private LocalDate datefin;
   
      
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
    private Button btnaddcompt;
    
    @FXML 
    private Button btnSuivantM1;
       @FXML 
    private Button btnAnnulerM1;
     @FXML 
    private Button btnAnnulerC1 ;
    @FXML 
    private Button  btnSuivantC1;
    @FXML
    private AnchorPane backgroundPane;
    @FXML
    private ImageView optionTailleAgrandir;
    @FXML
    private ImageView optionTailleParDefaut;
     @FXML
    private AnchorPane AnchorMatchlist;
    @FXML
    private TableView  tab_match;
    @FXML
    private TableColumn  col10_id;
    @FXML
    private TableColumn  col1_type;
    
    
    private TableColumn col_12_idmatch;
    @FXML
    private TableColumn  col2_niveau;
    @FXML
    private TableColumn  col3_categorie;
    @FXML
    private TableColumn  col5_joueur1;
    @FXML
    private TableColumn  col6_joueur2;
    @FXML
    private TableColumn  col7_arbitre;
    @FXML
    private TableColumn  col8_evenement;
    @FXML
    private TableColumn  col9_stade;
    @FXML
    private TableColumn  col10_date;
    @FXML
    private TableColumn  col11_supp;
    @FXML
    private TextField nb_ticket;
    @FXML
    private TextField prix_ticket;
    @FXML
    private Label label_medecin;
    @FXML
    private Label labelNbMatch;
    @FXML
    private Label LabelWarning;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_modifier;
    @FXML
    private ComboBox  combo_type;
    @FXML
    private ComboBox  combo_niveau;
    @FXML
    private ComboBox  combo_categorie;
    @FXML
    private ComboBox  combo_joueur2;
    @FXML
    private ComboBox    combo_joueur1;
    @FXML
    private ComboBox combo_arbitre;
    @FXML
    private ComboBox combo_evenement;
    @FXML
    private ComboBox combo_stade;
    @FXML
    private ComboBox comboNBmatch;
    @FXML
    private DatePicker date;
    @FXML
    private Label labelListematch;
    @FXML
    private ComboBox  combo_competition;
    @FXML
    private Button boutonGlissantListe1;
    @FXML
    private Button boutonGlissantImage1;
    @FXML
    private TextField rech;
    @FXML
    private Label error;
    
    
   
    
    //ATTRIBUTS STADE + SESSION
    @FXML
    private Label titelLabel;
    @FXML
    private AnchorPane consulterStadePane;
     @FXML
    private AnchorPane anchorMatch;
    private AnchorPane googleMapContainer;
    @FXML
    private DatePicker datecreationstade;
    @FXML
    private TextField txtlibellestade;
    @FXML
    private TextField txtcapacite;
    @FXML
    private TextField txtlatitude;
    @FXML
    private TextField txtlongitude;
    @FXML
    private ComboBox<String> txtsurface;
    @FXML
    private ComboBox<String> txtville;
    @FXML
    private TextField recherchestade;
    //tableview STADE
    @FXML
    private TableView tablestade;
    @FXML
    private TableColumn column1stade;
    @FXML
    private TableColumn column2stade;
    @FXML
    private TableColumn column3stade;
    @FXML
    private TableColumn column4stade;
    @FXML
    private TableColumn column5stade;
    @FXML
    private TableColumn column6stade;
    @FXML
    private TableColumn column7stade;
    @FXML
    private TableColumn column8stade;
    @FXML
    private Hyperlink clear;
    @FXML
    private Button boutonGlissantMap;
       @FXML
    private Button btnModifierCompe;
    @FXML
    private Button boutonGlissantList;
    private WebView googleMap;
    @FXML
    private AnchorPane consulterMatch;
       @FXML
    private AnchorPane SendMail;
  @FXML
    private AnchorPane mailAnchor;
     @FXML
    private WebView webgmail;
   @FXML
    private ImageView gmail;
    @FXML
    private TextField sendto;
         @FXML
    private TextField subject;
           @FXML
    private TextField textenvoie;
               
    @FXML
    private Button btexit;
    @FXML
    private AnchorPane EspaceCompetition;
    

    private StadeDAO stadedao;
   // private SessionFormationDAO sessiondao;
    private Dialog<Pair<String, String>> dialog;
    private Alert alert;
    private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
    
    private ObservableList<Stade> dataStade;
    private ObservableList<Stade> dataStadeRecherche;
    private ObservableList<String> listeVilles;
    private ObservableList<SessionFormation> dataSessionArbitre;
    private ObservableList<SessionFormation> dataSessionArbitreRecherche;
    private ObservableList<SessionFormation> dataSessionJoueur;
    private ObservableList<SessionFormation> dataSessionJoueurRecherche;
    private String villeStade, surfaceStade, villeChoix, libellestade, latitude, longitude, ville, surface, datecreat, capacite;
    private int position, idStade;;
    private LocalDate datestade;
    private Instant instant;
    private Date dteStade;
    @FXML
    private AnchorPane listeContainer;
    @FXML
    private Pane scrollbar;
    @FXML
    private ImageView btnAnnulesend;
    @FXML
    private TableColumn columnSupp;
    @FXML
    private AnchorPane AnchorCompetition;
    private TextField nomcompetition;
    private TextField nbrpointCompA;
    @FXML
    private RadioButton hommecompetition1;
    @FXML
    private RadioButton femmecompetition1;
    @FXML
    private RadioButton mixtecompetition1;
    @FXML
    private AnchorPane Anchormatchcompetition;
    @FXML
    private Label label_medecin1;
    @FXML
    private Button menuCompetition;
    @FXML
    private Separator separator;
    @FXML
    private AnchorPane AnchorCompetitionajout;
    @FXML
    private RadioButton amateurcompetition1;
    @FXML
    private ToggleGroup groupeniveau1;
    @FXML
    private RadioButton nationalcompetition1;
    @FXML
    private RadioButton INcompetition1;
    @FXML
    private ToggleGroup groupecategorie1;
    @FXML
    private DatePicker datedebutcompetition1;
    @FXML
    private DatePicker datefincompetition1;
    @FXML
    private TextField nbrpoint1;
    @FXML
    private ToggleGroup groupetype1;
    @FXML
    private TextField nomcompetition1;
    @FXML
    private ImageView etape1;
    @FXML
    private AnchorPane Anchornewmatchcompet;
    @FXML
    private Label label_medecin11;
    @FXML
    private DatePicker date11;
    @FXML
    private TextField nb_ticket11;
    @FXML
    private TextField prix_ticket11;
    @FXML
    private ImageView etape2;
    @FXML
    private Pane AnchorButtons;
    @FXML
    private Button btn_modifier2;
    @FXML
    private Button btn_modifier3;
    @FXML
    private ImageView etape3;
    @FXML
    private Label label_medecin2;
    @FXML
    private Pane AnchorListMatch;
    
  
    @FXML
    private RadioButton juniorcompetition1;
    @FXML
    private RadioButton seniorcompetition1;
    @FXML
    private RadioButton veterancompetition1;
    @FXML
    private ComboBox combojoueur2;
    @FXML
    private ComboBox combojoueur1;
    @FXML
    private ComboBox comboarbitre;
    @FXML
    private ComboBox combostade;
     Competition Comp = new Competition();
     CompetitionDAO CompDAO = new CompetitionDAO();
     MatchDAO d =new MatchDAO();
  
     
     List<Arbitre> listeAr = new ArrayList();
     List<Joueur> ListJoueur = new ArrayList();
     List<Stade> ListStade = new ArrayList();
    @FXML
    private AnchorPane AnchorEtape3;
    @FXML
    private AnchorPane AnchorEtape2;
    @FXML
    private AnchorPane AnchorEtape1;
    @FXML
    private AnchorPane AnchorEtape0;
     @FXML
    private TableView tab_match_compettion;
    @FXML
    private TableColumn  c0_id;
    @FXML
    private TableColumn  c1_competition;
    @FXML
    private TableColumn  c2_j1;
    @FXML
    private TableColumn  c3_j2;
    @FXML
    private TableColumn  c4_arbitre;
    @FXML
    private TableColumn  c5_stade;
    @FXML
    private TableColumn  c6_date;
    @FXML
    private TableColumn c7_delete;
    @FXML
    private TableView tablelistecompetition;
    @FXML
    private TableColumn c00_id_competition;
    @FXML
    private TableColumn c11_libelle_competition;
        @FXML
    private TableColumn c12_type_competition;
    @FXML
    private TableColumn  c22_date_deb_competition;
    @FXML
    private TableColumn  c33_date_fin_competition;
    @FXML
    private TableColumn  c44_niveau_competition;
    @FXML
    private TableColumn c55_categorie_competition;
    @FXML
    private TableColumn  c66_point_competition;
    @FXML
    private TableView tableListematchConfirm;
    @FXML
    private TableColumn  co0_id;
    @FXML
    private TableColumn  co1_comp;
    @FXML
    private TableColumn  co2_j1;
    @FXML
    private TableColumn  co2_j2;
    @FXML
    private TableColumn  co3_arbitre;
    @FXML
    private TableColumn  co4_stade;
    @FXML
    private TableColumn  co5_date;
    @FXML
    private TextField  nomcompetitionA;
    @FXML
    private RadioButton amateurcompetitionA;
    @FXML
    private ToggleGroup groupeniveauA;
    @FXML
    private RadioButton nationalcompetitionA;
    @FXML
    private RadioButton INcompetitionA;
    @FXML
    private RadioButton hommecompetitionA;
    @FXML
    private ToggleGroup groupecategorieA;
    @FXML
    private RadioButton femmecompetitionA;
    @FXML
    private RadioButton mixtecompetitionA;
    @FXML
    private DatePicker datedebutcompetitionA;
    @FXML
    private DatePicker datefincompetitionA;
    @FXML
    private RadioButton JuniorcompetitionA;
    @FXML
    private ToggleGroup groupetypeA;
    @FXML
    private RadioButton Seniorcompetition2;
    @FXML
    private RadioButton Veternoncompetition2;
    @FXML
    private TextField nbrpointA;
    @FXML
    private Button btn_modifierMatch;
    @FXML
    private ComboBox combo_modifjoueur2;
    @FXML
    private ComboBox  combo_modifjoueur1;
    @FXML
    private ComboBox  combo_modifarbitre;
    @FXML
    private ComboBox combo_modifstade;
    @FXML
    private DatePicker datemodif;
    @FXML
    private TextField nb_modifticket;
    @FXML
    private TextField prix_modifticket;
    @FXML
    private TableColumn cprix;
    @FXML
    private TableColumn  cnbrtick;
    @FXML
    private Label labelnotif;
    @FXML
    private TableColumn  c00_idticket;
    @FXML
    private Label labelnotifRed;
   @FXML
    private Label  labelnotifmatchRed;



     private void setMenuStyleNormal()
    {
        menuCup.setStyle(styleMenu);
        esp_even.setStyle(styleMenu);
        menuStade.setStyle(styleMenu);
        menuMatch.setStyle(styleMenu);
        menuMessage.setStyle(styleMenu); 
        menuFormation.setStyle(styleMenu);
        menuClub.setStyle(styleMenu);
    }
     
     private Stage getStage(){
            return (Stage) backgroundPane.getScene().getWindow();
                            }
    public void setInvisibleAllConsult() {
        consulterStadePane.setVisible(false);
//        sessionFormationPane.setVisible(false);
           clubPane.setVisible(false);
           esp_even.setVisible(false);
        consulterMatch.setVisible(false);
        EspaceCompetition.setVisible(false);
       
        
        
    }
     
     
     
     // Evenements ----------------------
    
     
    @FXML
    private void handleMenuButtonPressed( MouseEvent event){
        // Configuration d'affichage des boutons
        buttonAux = (Button) event.getSource();
        setMenuStyleNormal();
        buttonAux.setStyle(styleMenuPressed);

        // Configuration d'affichage des Pane de gestion
        switch (buttonAux.getId()) {
            case "menuClub" :
                setInvisibleAllConsult();
                
                clubPane.setVisible(true);
                titelLabel.setText("Gestion des Clubs");
                break;
            case "menuCup" :
                
                setInvisibleAllConsult();
                
                esp_even.setVisible(true);
                ajoutevent.setVisible(true);
                titelLabel.setText("Gestion des Events");
                break;
            case "menuStade":
                setInvisibleAllConsult();
                consulterStadePane.setVisible(true);
                titelLabel.setText("Gestion des Stades");
                

                break;
                
            case "menuFormation":
                setInvisibleAllConsult();
//                sessionFormationPane.setVisible(true);
                titelLabel.setText("Gestion des Sessions de formation");

                break;
                
            case  "menuCompetition" : 
                setInvisibleAllConsult();
                EspaceCompetition.setVisible(true);
                AnchorEtape0.setVisible(true);
                AnchorEtape1.setVisible(false);
                AnchorEtape2.setVisible(false);
                AnchorEtape3.setVisible(false);
                afficher_Competition();
                
                titelLabel.setText("Gestion des Compétitions");
                break;
            case "menuMatch" :
                setInvisibleAllConsult();
                consulterMatch.setVisible(true);
                titelLabel.setText("Gestion des matchs");
                Afficher_Match();
                break;
            default:
                break;

                                    } //fin switch
        
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
    
//------------------------------------------------------------------PARTIE STADE YASMINE-----------------------------------------------------------------------------------//
    
    @FXML
    private void handleButtonMap( MouseEvent event){
        boutonGlissantMap.setVisible(false);
        boutonGlissantList.setVisible(true);
        googleMapContainer.setVisible(false);
        consulterStadePane.setVisible(true);
                                                    }
    @FXML
    private void handleButtonListe( MouseEvent event){
        boutonGlissantMap.setVisible(true);
        boutonGlissantList.setVisible(false);
        
        googleMapContainer.setVisible(true);
        consulterStadePane.setVisible(false);
                                                     }



    //initialiser les fields
    public void initaliserFieldsStade() {
        //fields par défaut
        txtlibellestade.getStyleClass().remove("errorTextField");
        txtcapacite.getStyleClass().remove("errorTextField");
        txtsurface.getStyleClass().remove("errorTextField");
        datecreationstade.getStyleClass().remove("errorTextField");
        txtville.getStyleClass().remove("errorTextField");
        txtlatitude.getStyleClass().remove("errorTextField");
        txtlongitude.getStyleClass().remove("errorTextField");
                                          }

    //set columns values pour le tableview
    public void setColumnTableStade() {

        column1stade.setCellValueFactory(new PropertyValueFactory("libellestade"));
        column2stade.setCellValueFactory(new PropertyValueFactory("capacite"));
        column3stade.setCellValueFactory(new PropertyValueFactory("surface"));
        column4stade.setCellValueFactory(new PropertyValueFactory("datecreation"));
        column5stade.setCellValueFactory(new PropertyValueFactory("ville"));
        column6stade.setCellValueFactory(new PropertyValueFactory("latitude"));
        column8stade.setCellValueFactory(new PropertyValueFactory("longitude"));
                                        }
    
    
    //vider les champs d'ajout stade
    public void viderChampsStade() {
        initaliserFieldsStade();
        txtlibellestade.clear();
        txtcapacite.clear();
        txtsurface.valueProperty().set(null);
        datecreationstade.getEditor().clear();
        txtville.valueProperty().set(null);
        txtlatitude.clear();
        txtlongitude.clear();
        
        txtlibellestade.setPromptText("");
        txtcapacite.setPromptText("");
        txtsurface.setPromptText("");
        datecreationstade.setPromptText("");
        txtville.setPromptText("");
        txtlatitude.setPromptText("");
        txtlongitude.setPromptText("");
        
                                    }
    @FXML
    public void clear(){
        viderChampsStade();
    }


    //afficher les données des stades
    public void afficherDataStade() {
        //affichage par défaut
        //tablestade.setItems(null);

        final Stade stade = new Stade();
        try {
            setColumnTableStade();
            Callback<TableColumn<Stade, String>, TableCell<Stade, String>> cellFactory = //
                    new Callback<TableColumn<Stade, String>, TableCell<Stade, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Stade, String> param) {
                            final TableCell<Stade, String> cell = new TableCell<Stade, String>() {

                                final Button btnSuppStade = new Button("Supprimer");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btnSuppStade.setOnAction((ActionEvent event) -> {
                                            
                                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                            alert.setTitle("Confirmation Dialog");
                                            alert.setHeaderText("Look, a Confirmation Dialog");
                                            alert.setContentText("Are you ok with this?");
                                            Optional<ButtonType> result = alert.showAndWait();
                                            
                                            if (result.get() == ButtonType.OK) {
                                                
                                              stade.setIdstade(getTableView().getItems().get(getIndex()).getIdstade());
                                             // stadedao.delete(stade);
                                              if(!stadedao.delete(stade)){
                                                 
                                                  alert = new Alert(Alert.AlertType.INFORMATION);
                                                  alert.setTitle("Information Dialog");
                                                  alert.setHeaderText(null);
                                                  alert.setContentText("Stade supprimé");
                                                  alert.showAndWait();

                                              } else {
                                                  alert = new Alert(Alert.AlertType.INFORMATION);
                                                  alert.setTitle("Information Dialog");
                                                  alert.setHeaderText(null);
                                                  alert.setContentText("Erreur lors de la suppression");
                                                  alert.showAndWait();
                                                  clear();
                                                      }
         
                                            }
                                            afficherDataStade();
                                        });
                                        setGraphic(btnSuppStade);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    };

            column7stade.setCellFactory(cellFactory);

            stadedao = new StadeDAO();
            dataStade = FXCollections.observableArrayList();

            for (Stade aIterator : stadedao.getList()) {
                dataStade.add(aIterator);
            }
            tablestade.setItems(null);
            tablestade.setItems(dataStade);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }

    //lors de'une recherche d'un stade
    @FXML
    public void afficherDataStadeRechcherche(KeyEvent event) {

        final Stade stade = new Stade();
        try {

            setColumnTableStade();
            Callback<TableColumn<Stade, String>, TableCell<Stade, String>> cellFactory = //
                    new Callback<TableColumn<Stade, String>, TableCell<Stade, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Stade, String> param) {
                            final TableCell<Stade, String> cell = new TableCell<Stade, String>() {
                                final Button btnSuppStade = new Button("Supprimer");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btnSuppStade.setOnAction((ActionEvent event) -> {
                                          
                                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                            alert.setTitle("Confirmation Dialog");
                                            alert.setHeaderText("Look, a Confirmation Dialog");
                                            alert.setContentText("Are you ok with this?");
                                            Optional<ButtonType> result = alert.showAndWait();
                                            
                                            if (result.get() == ButtonType.OK) {
                                                
                                              stade.setIdstade(getTableView().getItems().get(getIndex()).getIdstade());

                                              if(!stadedao.delete(stade)){
                                                 
                                                  alert = new Alert(Alert.AlertType.INFORMATION);
                                                  alert.setTitle("Information Dialog");
                                                  alert.setHeaderText(null);
                                                  alert.setContentText("Stade supprimé");
                                                  alert.showAndWait();
                                                  clear();

                                              } else {
                                                  alert = new Alert(Alert.AlertType.INFORMATION);
                                                  alert.setTitle("Information Dialog");
                                                  alert.setHeaderText(null);
                                                  alert.setContentText("Erreur lors de la suppression");
                                                  alert.showAndWait();
                                                      }
         
                                            }
                                            afficherDataStade();
                                        });
                                            
                                        setGraphic(btnSuppStade);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    };

            column7stade.setCellFactory(cellFactory);

            stadedao = new StadeDAO();
            dataStadeRecherche = FXCollections.observableArrayList();

            for (Stade aIterator : stadedao.getList()) {
                String chaine = recherchestade.getText();
                if (aIterator.getLibellestade().contains(chaine) || (aIterator.getVille().contains(chaine))) {
                    dataStadeRecherche.add(aIterator);
                }
            }

            tablestade.setItems(null);
            tablestade.setItems(dataStadeRecherche);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    //combobox
    @FXML
    public void villeStade(ActionEvent event) {

        villeStade = (String) txtville.getValue();
                                              }

    //combobox
    @FXML
    public void surfaceStade(ActionEvent event) {

        surfaceStade = (String) txtsurface.getValue();

                                                }

    //validation des string
    public boolean isValidString(String s) {

        String chaine = "[A-Za-z\\s]*";
        return s.matches(chaine);//returns true if input and chaine matches otherwise false;
                                            }

    //validation des float
    public boolean isValidFloat(String s) {

        String chaine = "-?([0-9]+(\\.?[0-9]*)?)?";
        return s.matches(chaine);//returns true if input and regex matches otherwise false;
                                          }

    //validation des entiers
    public boolean isValidInt(String s) {

        String chaine = "[0-9]*";
        return s.matches(chaine);//returns true if input and regex matches otherwise false;
                                        }           

    //validation des entiers
    public boolean isValidCode(String s) {

        String chaine = "[a-zA-z0-9\\s]*";
        return s.matches(chaine);//returns true if input and regex matches otherwise false;

                                         }

    

    public void recuprerValeurStade() throws SQLException {
        libellestade = txtlibellestade.getText();
        ville = txtville.getValue();
        surface = txtsurface.getValue();
        latitude = txtlatitude.getText();
        longitude = txtlongitude.getText();
        capacite = txtcapacite.getText();
        datecreat = datecreationstade.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dteStade = java.sql.Date.valueOf(datestade);
        
        StadeDAO crudDAO = new StadeDAO();
        idStade = crudDAO.find(libellestade);
    }
    //ajouter un nouveau stade

    @FXML
    public void ajouterStade(ActionEvent event) {

        boolean controlesaisie = true;
        Stade stade = new Stade();

        try {
              recuprerValeurStade();

        } catch (Exception e) {
            System.out.println("ERREUR");
        }

        
        //controle libelle stade       
        if (libellestade.isEmpty()) {
            txtlibellestade.getStyleClass().add("errorTextField");
            txtlibellestade.setPromptText("Champ vide");
            controlesaisie = false;
        }
        if (!this.isValidString(libellestade)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText("Type libelle invalide");
            alert.setContentText("Verifiez le type svp");
            alert.showAndWait();
            txtlibellestade.getStyleClass().add("errorTextField");
            controlesaisie = false;
        }

        //controle capacite stade
        if (capacite.isEmpty()) {
            txtcapacite.getStyleClass().add("errorTextField");
            txtcapacite.setPromptText("Champ vide");
            controlesaisie = false;
        }
        if (!this.isValidInt(capacite)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText("Type capacité invalide");
            alert.setContentText("Verifiez le type svp");
            alert.showAndWait();
            txtcapacite.getStyleClass().add("errorTextField");
            controlesaisie = false;
                                        }
        
        //controle surface stade
        if(txtsurface.getValue()==null){
            txtsurface.getStyleClass().add("errorTextField");
            txtsurface.setPromptText("Champ vide");
            controlesaisie = false;
                                        }
        //controle sur la date de création stade
        if(datecreationstade.getValue()==null){
            datecreationstade.getStyleClass().add("errorTextField");
            datecreationstade.setPromptText("Champ vide");
            controlesaisie = false;
        }
        //controle sur les villes
        if (txtville.getValue() == null) {
            txtville.getStyleClass().add("errorTextField");
            txtville.setPromptText("Champ vide");
            controlesaisie = false;
                                        }
        
//             if  (!this.isValidString(ville) ) { 
//                  
//                  txtville.getStyleClass().add("errorTextField");
//                  controlesaisie = false;
//                                              }

        //controle sur les latitudes
        if (latitude.isEmpty()) {
            txtlatitude.getStyleClass().add("errorTextField");
            txtlatitude.setPromptText("Champ vide");
            controlesaisie = false;
        }
        if (!this.isValidFloat(latitude)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText("Type latitude invalide");
            alert.setContentText("Verifiez le type svp");
            alert.showAndWait();
            txtlatitude.getStyleClass().add("errorTextField");
            controlesaisie = false;
        }

        //controle sur les longitudes
        if (longitude.isEmpty()) {
            txtlongitude.getStyleClass().add("errorTextField");
            txtlongitude.setPromptText("Champ vide");
            controlesaisie = false;
        }
        if (!this.isValidFloat(longitude)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText("Type longitude invalide");
            alert.setContentText("Verifiez le type svp");
            alert.showAndWait();
            txtlongitude.getStyleClass().add("errorTextField");
            controlesaisie = false;
        }
        
        
        
        //cas d'ajout d'un stade
        if (controlesaisie == true) {
           // btnajouterstade.setDisable(false);
            stade.setLibellestade(libellestade);
            stade.setCapacite(Integer.parseInt(capacite));
            stade.setSurface(Surface.valueOf(surface));
            stade.setDatecreation(dteStade);
            stade.setLatitude(Float.parseFloat(latitude));
            stade.setLongidute(Float.parseFloat(longitude));
            stade.setVille(ville);


            stadedao.save(stade);
            afficherDataStade();
            //data.add(new Stade(libelle, capacite, surface,dte,ville,code));
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Stade ajouté");
            alert.showAndWait();
            initaliserFieldsStade();
            viderChampsStade();
        }

        //fin ajouter stade   
    }

    @FXML
    public void modifierStade(ActionEvent event) throws SQLException {

        Stade stade = new Stade();
        recuprerValeurStade();
        stade.setLibellestade(libellestade);
        stade.setCapacite(Integer.parseInt(capacite));
        stade.setSurface(Surface.valueOf(surface));
        stade.setDatecreation(dteStade);
        stade.setLatitude(Float.parseFloat(latitude));
        stade.setLongidute(Float.parseFloat(longitude));
        stade.setVille(ville);
        
        StadeDAOInterface icd = new StadeDAO();
        stade.setIdstade(icd.find(libellestade));

        if(!stadedao.update(stade)){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Modification éfféctuée");
            alert.showAndWait();
            afficherDataStade();
            viderChampsStade();
                                    }
        else{
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Modification non éfféctuée");
            alert.showAndWait();
                                    }
        
        
    }

    @FXML
    public void EditableTableViewStade(MouseEvent event) {
        if (tablestade != null) {
            List<Stade> tables = tablestade.getSelectionModel().getSelectedItems();
            if (tables.size() == 1) {
                final Stade stadeselected = tables.get(0);
                position = dataStade.indexOf(stadeselected);
                if (stadeselected != null) {

                    txtlibellestade.setText(stadeselected.getLibellestade());
                    txtcapacite.setText(String.valueOf(stadeselected.getCapacite()));
                    txtlatitude.setText(String.valueOf(stadeselected.getLatitude()));
                    txtlongitude.setText(String.valueOf(stadeselected.getLongidute()));

                    instant = Instant.ofEpochMilli(stadeselected.getDatecreation().getTime());
                    datestade = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
                    datecreationstade.setValue(datestade);

                    txtville.setValue(stadeselected.getVille());
                    txtsurface.setValue(stadeselected.getSurface().name());

                }

            }
        }
    }
    

    
    public void GoogleMap(){
      //google map
        final URL urlGoogleMaps = getClass().getResource("googleMap.html");
        WebEngine webEngine = googleMap.getEngine();
        webEngine.load(urlGoogleMaps.toExternalForm());
        webEngine.setJavaScriptEnabled(true);
                           }
    
    public void InitialisationTables(){
        tablestade.setPlaceholder(new Label("Aucun stade"));
        //tablearbitre.setPlaceholder(new Label("Aucune session pour les arbitres"));
        //tablejoueur.setPlaceholder(new Label("Aucune session pour les joueurs"));
                                      }     
     
    
    //#####################################################################################
    //#####################################################################################
    //#####################################################################################
    //--------------------------------- Gestion Matchs -------  author : Wissem  ----------
    //#####################################################################################
    //#####################################################################################
    //----------------------------------Ajouter Match a la base de donnée-------------------
            Ticket t = new Ticket();
            TicketDAO tdao=new TicketDAO();
    
            
            
    
    //################ AJOUT TICKET #############################
    public void AjouterTicket() 
       {
        t.setNbrticket(Integer.parseInt(nb_ticket.getText()));
        t.setPrix(Integer.parseInt(prix_ticket.getText()));
        tdao.save(t);
        System.out.println("Ticket ajouté avec succes");
       }

    
    
   //####################################################################################### 
   //----------------------------------Afficher Match -------------------
   //#######################################################################################
     private ObservableList<Match> dataMatch; 
     public void Afficher_Match()
   {
     try {

           col10_id.setCellValueFactory(new PropertyValueFactory("idmatch"));
           col1_type.setCellValueFactory(new PropertyValueFactory("type"));
           col2_niveau.setCellValueFactory(new PropertyValueFactory("niveau"));
           col3_categorie.setCellValueFactory(new PropertyValueFactory("categorie"));
           col5_joueur1.setCellValueFactory(new PropertyValueFactory("nomj1"));
           col6_joueur2.setCellValueFactory(new PropertyValueFactory("nomj2"));
           col7_arbitre.setCellValueFactory(new PropertyValueFactory("nomArb"));
           col8_evenement.setCellValueFactory(new PropertyValueFactory("libelleevennement"));
           col9_stade.setCellValueFactory(new PropertyValueFactory("libellestade"));
           col10_date.setCellValueFactory(new PropertyValueFactory("datematch"));
          

           
           System.out.println("-------- pas derreur lors de la methode affiche_liste_joueurs_invites  --------- ");
 } catch (Exception e) 
        { System.out.println("--------- erreur  affiche_liste_joueurs_invites  ---------");
       }
     
          //************************************************************************************************
          //***************** lajout de boutton supprimer dans la table view *******************************
          //************************************************************************************************
     
     
 Callback<TableColumn<Match, String>, TableCell<Match, String>> cellFactory = new Callback<TableColumn<Match, String>, TableCell<Match, String>>()
{
 @Override
public TableCell call( final TableColumn<Match, String> param )
{
                        final TableCell<Match, String> cell = new TableCell<Match, String>()
                        { final Button btn = new Button( "Supprimer" );
                     @Override
                            public void updateItem( String item, boolean empty )
                            {super.updateItem( item, empty );
                                if ( empty )
                                {
                                 setGraphic( null );
                                 setText( null );
                                }
                                else
                                { btn.setOnAction( ( ActionEvent event ) ->
                                    {        m.setIdmatch(getTableView().getItems().get( getIndex()).getIdmatch()); 
                                    // boite de dialog ( confirmation ) *************************
                                    
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation de suppression");
                                    alert.setHeaderText("Attention! Etes-vous sur de supprimer le Match ?");
                                    Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                                                  mdao.delete(m);
                                                  Afficher_Match();
                                                  labelnotifmatchRed.setVisible(true);
                                                  labelnotifmatchRed.setText("-Match supprimé-");
                                    } else {
                                                  labelnotifmatchRed.setVisible(true);
                                                  labelnotifmatchRed.setText("suppression annulée");
                                    }
                                    //************** fin de confirmation **************************     
                                    
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             
            col11_supp.setCellFactory( cellFactory );
            
            /////////////////////////////////////////////   
     
    dataMatch = FXCollections.observableArrayList();
    for (Match m : mdao.getList())
    {
     dataMatch.add(m); 
       
    }   
    
    tab_match.setItems(dataMatch); 
 
   }
    
    
   //####################################################################################### 
   //----------------------------------Ajouter Match amical a la base de données-------------------
   //#######################################################################################
  
    Match m = new Match();
    MatchDAO mdao=new MatchDAO();  
    @FXML
    public void AjouterMatch(ActionEvent event) 
       {
          AjouterTicket();
         
        m.setIdjoueur1( getIdFromListeJoueur((String)combo_joueur1.getSelectionModel().getSelectedItem()));
        m.setIdjoueur2( getIdFromListeJoueur((String)combo_joueur2.getSelectionModel().getSelectedItem()));
        m.setIdarbitre( getIdFromListeArbitre((String)combo_arbitre.getSelectionModel().getSelectedItem()));
        m.setIdcompetition(0);
        m.setIdevenement(ManipuleString((String)combo_evenement.getSelectionModel().getSelectedItem()));
        m.setIdstade(getIdFromListeStade((String)combo_stade.getSelectionModel().getSelectedItem()));
       
        m.setDatematch(java.sql.Date.valueOf(date.getValue()));
        m.setNiveau(Niveau.valueOf(combo_niveau.getSelectionModel().getSelectedItem().toString()));
        m.setType(TrancheAge.valueOf(combo_type.getSelectionModel().getSelectedItem().toString()));
        m.setCategorie(Categorie.valueOf(combo_categorie.getSelectionModel().getSelectedItem().toString()));
        m.setIdticket(tdao.id_dernier_Ticket());
 
        mdao.save(m);
        
        System.out.println(m.toString());
        System.out.println("--------- Match ajouté  ----------");
      Afficher_Match();
    
          }
    
 /*________________________________________________________________________   
 --------------------------------------------------------------------------
 - *Auteur        : Wissem                                                 -                  
 - *Methode       : SelectMatchAmicalForModif                              -     
 -                                                                         -   
 - *Description   : le but de cette methode est de remplire automatiquement-                                                       -     
                    le formulaire de modification d'un match amical        -
                    dés que le responsable TFT clique sur un match         -
                    a partir de la tableView                               -
 //------------------------------------------------------------------------
 //************************************************************************/  
    @FXML
    private void SelectMatchAmicalForModif(MouseEvent event) 
    {
         
         //--- MatchSelected est un (OBJET : Match) selectionné de la tableView
         List<Match> TAB = tab_match.getSelectionModel().getSelectedItems();
         final Match MatchSelected = TAB.get(0);
         
         if (MatchSelected != null)
         {
        Instant instant = Instant.ofEpochMilli(MatchSelected.getDatematch().getTime());
        LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        date.setValue(res);
        nb_ticket.setText(""+MatchSelected.getNombreTicket());
        prix_ticket.setText(""+MatchSelected.getPrixTicket());
        }}
    
    
    Ticket Tt1 = new Ticket();
    TicketDAO TDao1=new TicketDAO();
    Match amical = new Match();
    MatchDAO amicalDao = new MatchDAO();
 /*___________________________________________________________________________   
 -------------------------------------------------------------------------------                                                      -                  
 - *Methode     : ModifierMatchAmical                                   
 -                                                                                
 - *Description : cette methode permet tout simplement de Modifier un match
                    amical  selectionné       
 //-----------------------------------------------------------------------------
 //************************************************************************/ 
    @FXML
    public void ModifierMatchAmical( ActionEvent event) 
       {

         List<Match> TAB = tab_match.getSelectionModel().getSelectedItems();
         final Match MatchSelected = TAB.get(0);
    
        amical.setIdjoueur1( getIdFromListeJoueur((String)combo_joueur1.getSelectionModel().getSelectedItem()));
        amical.setIdjoueur2( getIdFromListeJoueur((String)combo_joueur2.getSelectionModel().getSelectedItem()));
        amical.setIdarbitre( getIdFromListeArbitre((String)combo_arbitre.getSelectionModel().getSelectedItem()));
        amical.setIdstade(getIdFromListeStade((String)combo_stade.getSelectionModel().getSelectedItem()));
        amical.setDatematch(java.sql.Date.valueOf(date.getValue()));
        amical.setIdmatch(MatchSelected.getIdmatch());
// modifier ticket -------
        Tt1.setNbrticket(Integer.parseInt( nb_ticket.getText()));
        Tt1.setPrix(Integer.parseInt( prix_ticket.getText()));
        Tt1.setIdticket(MatchSelected.getIdticket());
        TDao.update(Tt1);
 //-----------------------       
        amicalDao.update(amical);
        Afficher_Match();
        tab_match.refresh();
        labelnotifmatchRed.setVisible(true);
        labelnotifmatchRed.setText("Match Modifié avec succé");

        System.out.println("-Match amical  modifié -");

       }
    

    
    
    

   //-------------------------------------------------------------------------------------- 
   //----------------------------------Remplissage de CompBo-------------------------------
   //******************************** author : wissem ************************************
  
    //-------------------------------------------------------
    // Methode ManipuleString(String ch)
    // cette methode permet de recuperer le cin 
    // a partir dune chaine qui contient  "Nom : cin"
    // principe : parcour de chaine et "extract" cin a partir de separateur ':'
    //-------------------------------------------------------
    public int ManipuleString(String ch)
    {
    String chaine ="";
    char c = ':';
    int i=ch.length();
    boolean result =false; 
     do {     
         i=i-1;
            chaine=chaine+""+ch.charAt(i);
            if (ch.charAt(i) == ':')
            {result=true;}
           
        } while (result==false);
     
            String ch0="";
        for (int j = 0; j < chaine.length()-1; j++) 
        {
             ch0=chaine.charAt(j)+""+ch0;
        }
  
        
     return Integer.parseInt(ch0);
    
    }
      //################################################################  
      public ObservableList<String> RemplireComboCompetition()
    {
        MatchDAO d =new MatchDAO();
        List<Competition> listeCom = new ArrayList();
        listeCom = d.List_Competition_ForComboBox();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Competition co : listeCom)
        {
            obs.add(co.getLibelle()+" :"+co.getIdcompetition());
        }
        return obs;
    }
 
     //################################################################  
      public ObservableList<String> RemplireComboStade()
    {
        MatchDAO d =new MatchDAO();
        List<Stade> listeStad = new ArrayList();
        listeStad = d.List_stade_ForComboBox();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Stade St : listeStad)
        {
            obs.add(St.getLibellestade());
        }
        return obs;
    }
  //################################################################  
      public ObservableList<String> RemplireComboEven()
    {
        MatchDAO d =new MatchDAO();
        List<Evenement> listeEven = new ArrayList();
        listeEven = d.List_evenementForComboBox();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Evenement Ev : listeEven)
        {
            obs.add(Ev.getLibelle()+" :"+Ev.getIdevenement());
        }
        return obs;
    }
  //################################################################   
   
      public ObservableList<String> RemplireComboJoueurHomme()
    { 
        MatchDAO d =new MatchDAO();
        List<Joueur> listeM = new ArrayList();
        listeM = d.List_Joueur_HommesForComboBox();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Joueur J : listeM)
        {
          obs.add(J.getNom()+" "+J.getPrenom());
        }
        return obs;
    }
  //################################################################   
     
      public ObservableList<String> RemplireComboJoueurFemme()
    {
        MatchDAO d =new MatchDAO();
        List<Joueur> listeM = new ArrayList();
        listeM = d.List_Joueur_FemmesForComboBox();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Joueur J : listeM)
        {
             obs.add(J.getNom()+" "+J.getPrenom());
        }
        return obs;
    }
  //################################################################   
     
      public ObservableList<String> RemplireComboJoueurAll()
    {
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Joueur J : ListJoueur)
        {
          
            obs.add(J.getNom()+" "+J.getPrenom());
        }
        return obs;
    }
  //################################################################    
     
      public ObservableList<String> RemplireComboArbitre()
    {
       
       
        ObservableList<String> obsAr = FXCollections.observableArrayList();
        for(Arbitre Arr: listeAr)
        {
            obsAr.add(Arr.getNom()+" "+Arr.getPrenom());
        }
        return obsAr;
    }
  //################################################################  
     
     
     
  


    @FXML
    private void handleGlissantButtonListe(ActionEvent event) {
    }

    private void PressMatch(ActionEvent event) {
       // tab_match.setVisible(true);
        rech.setVisible(true);
        anchorMatch.setVisible(true);
        AnchorMatchlist.setVisible(true);
        
    }
    
     // Mail
      @FXML
    private void showmailbar(MouseEvent event)
    {
        
    mailAnchor.setVisible(true);
                
    }
     @FXML
    private void buttonAjouterCompetition(ActionEvent event)
    {
        nbmatch=1;
        AnchorEtape1.setVisible(true);
        AnchorEtape0.setVisible(false);
   
    }
    
   
   
  


    
    
    
    
    
    
    
    
    
     @FXML
    private void dontshowmailbar(MouseEvent event)
    {
        
    mailAnchor.setVisible(false);
                
    }
     
    
     @FXML
    private void ClickConsulterMail(ActionEvent event)
    {
        mailAnchor.setVisible(false);
        btexit.setVisible(true);
        webgmail.setVisible(true);
        webgmail.getEngine().load("http://mail.google.com/mail/#inbox");
    
    }
     
   @FXML
        private void ClickBtExit(ActionEvent event)
    {
        mailAnchor.setVisible(false);
        webgmail.setVisible(false);
    
    btexit.setVisible(false);
    }
     
      @FXML
        private void SendMail(ActionEvent event)
    {
         String host = "smtp.gmail.com";
       Properties prop = System.getProperties();
       prop.put("mail.smtp.starttls.enable", "true");
       prop.put("mail.smtp.host", "smtp.gmail.com");
       prop.put("mail.smtp.socketFactory.port", "587");
       prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       prop.put("mail.smtp.port", "587");
       prop.put("mail.smtp.auth", "true");
       Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication("federationdetennistunisie@gmail.com", "Yassine1994");
                   
                 }
             
             });
        MimeMessage mimeMessage2 = new MimeMessage(session);
        try {
          Message msg = new MimeMessage (session);
           msg.setFrom(new InternetAddress(sendto.getText()) );
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendto.getText()));
          msg.setSubject(subject.getText());
           msg.setText(textenvoie.getText());
           prop.put("mail.smtp.starttls.enable", "true");
           Transport.send(msg);
       
        } catch (MessagingException ex) {
            System.out.println(ex);  }
                
                
    }
     
         @FXML
        private void ClickEnvoieMsg(ActionEvent event)
    {
       SendMail.setVisible(true);
    }
           @FXML
        private void ClickAnnuleEnvoieMsg(MouseEvent event)
    {
       SendMail.setVisible(false);
    }
 
//############################################################################################################################################
//############################################################################################################################################
//#################|                Competition                   |###########################################################################
//############################################################################################################################################
//############################################################################################################################################
  
 /*____________________________________________________________________________   
 ------------------------------------------------------------------------------                                         -                  
 - *Methode     : AjouterCompetition                                          -     
 -                                                                            -   
 - *Description :  Cette methode permet tout simplement d'ajouter une compétition
 //-----------------------------------------------------------------------------
 //************************************************************************/  
      @FXML
    private void AjouterCompetition( ActionEvent event)
    {     
   try{
        Date dtedeb = java.sql.Date.valueOf(datedeb);
        Date dtefin = java.sql.Date.valueOf(datefin);
    
        RadioButton Niv = (RadioButton) (groupeniveau1).getSelectedToggle();
        RadioButton Cat = (RadioButton) (groupecategorie1).getSelectedToggle();
        RadioButton Typ = (RadioButton) (groupetype1).getSelectedToggle();
      
      Comp.setLibelle(nomcompetition1.getText());
      Comp.setDatedebut(dtedeb);
      Comp.setDatefin(dtefin);
      Comp.setNiveau(Niveau.valueOf(Niv.getText()));
      Comp.setCategorie(Categorie.valueOf(Cat.getText()));
      Comp.setType(TrancheAge.valueOf(Typ.getText())); 
      Comp.setNbrpoint(Integer.parseInt(nbrpoint1.getText()));

      CompDAO.save(Comp);
      LabelWarning.setVisible(false);
      AnchorEtape1.setVisible(false);
      AnchorEtape2.setVisible(true);
      labelNbMatch.setText("MATCH "+nbmatch+"/"+(String)comboNBmatch.getSelectionModel().getSelectedItem());
      
    }catch(Exception ex){
          
          LabelWarning.setVisible(true);
          LabelWarning.setText("ATTENTION : Vous devez vérifier tous les champs !");
          
    }
     
    
    }
    
    
    
 /*____________________________________________________________________________   
 ------------------------------------------------------------------------------                                                          -                  
 - *Methode     : ajoutermachCompet                                            -     
 -                                                                             -   
 - *Description : pour chaque compétition on doit ajouter un ensemble des matchs 
                  cette methode permet d'ajouter des matchs a la base données .
                  et le nombre des matchs depend au choix selectionné lors de la   
                  creation d'une compétition.
 //-----------------------------------------------------------------------------
 //************************************************************************/          
    int nbmatch ;
   
   @FXML
    public void ajoutermachCompet( ActionEvent event) 
       {
 try{
         List<Competition> ls = new ArrayList<Competition>();
         ls = CompDAO.getListCompetition(Comp.getLibelle().toString(), (java.sql.Date) Comp.getDatedebut());
         AjouterTicketMatchCompetition();
           
        m.setIdjoueur1( getIdFromListeJoueur((String)combojoueur1.getSelectionModel().getSelectedItem()));
        m.setIdjoueur2( getIdFromListeJoueur((String)combojoueur2.getSelectionModel().getSelectedItem()));
        m.setIdcompetition(ls.get(0).getIdcompetition());
        m.setIdarbitre( getIdFromListeArbitre((String)comboarbitre.getSelectionModel().getSelectedItem()));
        m.setIdevenement(0);
        m.setIdstade(getIdFromListeStade((String)combostade.getSelectionModel().getSelectedItem()));
        m.setDatematch(java.sql.Date.valueOf(date11.getValue()));
        m.setNiveau(Comp.getNiveau());
        m.setType(Comp.getType());
        m.setCategorie(Comp.getCategorie());
        m.setIdticket(tdao.id_dernier_Ticket());

         nbmatch=nbmatch+1;  
         Integer  NombreMatchCombo= Integer.parseInt((String)comboNBmatch.getSelectionModel().getSelectedItem());
          if (NombreMatchCombo >= (nbmatch))
        { 
          labelNbMatch.setText("MATCH "+(nbmatch)+"/"+NombreMatchCombo);
        }
        if (NombreMatchCombo >= (nbmatch-1))
        { 
        System.out.println("NombreMatchCombo = "+NombreMatchCombo+"  -  "+ "nbmatch   = "+nbmatch);
        mdao.save(m); 
        LabelWarning.setVisible(false);
        System.out.println("match -->"+m.toString());
        System.out.println(" Match ajouté ");
        }
        else 
        {
        AnchorEtape2.setVisible(false);
        AnchorEtape3.setVisible(true);
        afficher_MatchCompetitionConfirmation();
        label_medecin2.setText("Liste des Matchs de la compétition "+Comp.getLibelle());
        }
        }
      catch(Exception e)
        {  LabelWarning.setVisible(true);
          LabelWarning.setText("ATTENTION : Vous devez remplir tous les champs !");}
      
       }
    //********************************************************************************
    //************mettre invisible le label dans competition et match amical *********
    //********************************************************************************
    @FXML
    public void setlabelinvisible(MouseEvent event)
    {labelnotif.setVisible(false);
    labelnotifRed.setVisible(false);}
    //********************************************************************************
     @FXML
    public void setlabelMatchinvisible(MouseEvent event)
    {labelnotifmatchRed.setVisible(false);
    labelnotifmatchRed.setVisible(false);}
    //****************************************************************
    
 
    Ticket Tt = new Ticket();
    TicketDAO TDao=new TicketDAO();
 /*___________________________________________________________________________   
 -------------------------------------------------------------------------------                                                      -                  
 - *Methode     : ModifiermachCompet                                    
 -                                                                                
 - *Description : cette methode permet tout simplement de Modifier un match
                    d'une Competition  selectionnée       
 //-----------------------------------------------------------------------------
 //************************************************************************/ 
    @FXML
    public void ModifiermachCompet( ActionEvent event) 
       {
               
          
         List<Match> TAB = tab_match_compettion.getSelectionModel().getSelectedItems();
         final Match MatchSelected = TAB.get(0);
    
        m.setIdjoueur1( getIdFromListeJoueur((String)combo_modifjoueur1.getSelectionModel().getSelectedItem()));
        m.setIdjoueur2( getIdFromListeJoueur((String)combo_modifjoueur2.getSelectionModel().getSelectedItem()));
        m.setIdarbitre( getIdFromListeArbitre((String)combo_modifarbitre.getSelectionModel().getSelectedItem()));
        m.setIdstade(getIdFromListeStade((String)combo_modifstade.getSelectionModel().getSelectedItem()));
        m.setDatematch(java.sql.Date.valueOf(datemodif.getValue()));
        m.setIdmatch(MatchSelected.getIdmatch());
// modifier ticket -------
        Tt.setNbrticket(Integer.parseInt( nb_modifticket.getText()));
        Tt.setPrix(Integer.parseInt( prix_modifticket.getText()));
        Tt.setIdticket(MatchSelected.getIdticket());
        TDao.update(Tt);
 //-----------------------       
        mdao.update(m);
        afficher_MatchCompetition();
        tab_match_compettion.refresh();
        labelnotif.setVisible(true);
        labelnotif.setText("Match Modifié avec succé");

        System.out.println("-Match Modifié -");

       }
    

    
   /*___________________________________________________________________________   
 -------------------------------------------------------------------------------                                                      -                  
 - *Methode     : AjouterTicketMatchCompetition                                -     
 -                                                                             -   
 - *Description : cette methode permet tout simplement d'ajouter Ticket        -
 //-----------------------------------------------------------------------------
 //************************************************************************/        
      public void AjouterTicketMatchCompetition() 
       {
        t.setNbrticket(Integer.parseInt(nb_ticket11.getText()));
        t.setPrix(Integer.parseInt(prix_ticket11.getText()));
        tdao.save(t);
        System.out.println("-Ticket ajouté-");
       }       
 /*____________________________________________________________________________   
 ------------------------------------------------------------------------------                                                           -                  
 - *Methode     : afficher_Competition                                         -     
 -                                                                             -   
 - *Description : cette methode permet tout simplement d'afficher              -
                   la liste des compétition a partir de la base :)             -
 //----------------------------------------------------------------------------
 //************************************************************************/  
     private ObservableList<Competition> dataCompetition; 
     public void afficher_Competition()
   {
     try {
           c00_id_competition.setCellValueFactory(new PropertyValueFactory("idcompetition"));
           c11_libelle_competition.setCellValueFactory(new PropertyValueFactory("libelle"));
           c12_type_competition.setCellValueFactory(new PropertyValueFactory("type"));
           c22_date_deb_competition.setCellValueFactory(new PropertyValueFactory("datedebut"));
           c33_date_fin_competition.setCellValueFactory(new PropertyValueFactory("datefin"));
           c44_niveau_competition.setCellValueFactory(new PropertyValueFactory("niveau"));
           c55_categorie_competition.setCellValueFactory(new PropertyValueFactory("categorie"));
           c66_point_competition.setCellValueFactory(new PropertyValueFactory("nbrpoint"));

           System.out.println("-------- pas derreur lors de la methode afficher_Competition()  --------- ");
 } catch (Exception e) 
        { System.out.println("--------- erreur  afficher_Competition() ---------");
       }
     
     
          //************************************************************************************************
          //***************** lajout de boutton supprimer dans la table view *******************************
          //************************************************************************************************
     
     
 Callback<TableColumn<Competition, String>, TableCell<Competition, String>> cellFactory = new Callback<TableColumn<Competition, String>, TableCell<Competition, String>>()
{
 @Override
public TableCell call( final TableColumn<Competition, String> param )
{
                        final TableCell<Competition, String> cell = new TableCell<Competition, String>()
                        { final Button btn = new Button( "Supprimer" );
                     @Override
                            public void updateItem( String item, boolean empty )
                            {super.updateItem( item, empty );
                                if ( empty )
                                {
                                 setGraphic( null );
                                 setText( null );
                                }
                                else
                                { btn.setOnAction( ( ActionEvent event ) ->
                                    {  compet.setIdcompetition(getTableView().getItems().get( getIndex()).getIdcompetition()); 
                                    // boite de dialog ( confirmation ) *************************
                                    
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation de suppression");
                                    alert.setHeaderText("Attention! Etes-vous sur de supprimer la competition?");
                                    Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                                                 CompDAO.delete(compet);
                                            
                                             afficher_Competition();
                                             labelnotifRed.setVisible(true);
                                             labelnotifRed.setText("Competition supprimée");
                                    } else {
                                                  labelnotifmatchRed.setVisible(true);
                                                  labelnotifmatchRed.setText("suppression annulée");
                                    }
                                    //************** fin de confirmation **************************    
                                    
                                             
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             
            columnSupp.setCellFactory( cellFactory );
            
            /////////////////////////////////////////////

    dataCompetition = FXCollections.observableArrayList();
    for (Competition c : CompDAO.getList())
    {
     dataCompetition.add(c);
    }   
    
    tablelistecompetition.setItems(dataCompetition); 
    //c juste pour reflechir la page 
      tablelistecompetition.refresh();
   }
    
 /*____________________________________________________________________________   
 ------------------------------------------------------------------------------                                                   -                  
 - *Methode     : afficher_MatchCompetition                                   -     
 -                                                                            -   
 - *Description : le role de cette methode est d'afficher les Matchs d'une    -
                   Competition selectionné a partir de tableView on utilisant -
                    L'idcompetition                                           -  
 //----------------------------------------------------------------------------
 //************************************************************************/      
     
     private ObservableList<Match> dataMatchCompetition; 
     public void afficher_MatchCompetition()
   {
         List<Competition> TAB = tablelistecompetition.getSelectionModel().getSelectedItems();
         final Competition CompetitionSelected = TAB.get(0); 
     try {
           c0_id.setCellValueFactory(new PropertyValueFactory("idmatch"));
           c00_idticket.setCellValueFactory(new PropertyValueFactory("idticket"));
           c1_competition.setCellValueFactory(new PropertyValueFactory("libellecompetition"));
           c2_j1.setCellValueFactory(new PropertyValueFactory("nomj1"));
           c3_j2.setCellValueFactory(new PropertyValueFactory("nomj2"));
           c4_arbitre.setCellValueFactory(new PropertyValueFactory("nomArb"));
           c5_stade.setCellValueFactory(new PropertyValueFactory("libellestade"));
           c6_date.setCellValueFactory(new PropertyValueFactory("datematch"));
           cprix.setCellValueFactory(new PropertyValueFactory("prixTicket"));
           cnbrtick.setCellValueFactory(new PropertyValueFactory("nombreTicket"));
 } catch (Exception e) 
        { System.out.println("--------- erreur  afficher_MatchCompetition ---------");
       }
    
     //***************** lajout de boutton supprimer dans la table view *******************************
 Callback<TableColumn<Match, String>, TableCell<Match, String>> cellFactory = new Callback<TableColumn<Match, String>, TableCell<Match, String>>()
{
 @Override
public TableCell call( final TableColumn<Match, String> param )
{
         final TableCell<Match, String> cell = new TableCell<Match, String>()
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
                                             m.setIdmatch(getTableView().getItems().get( getIndex()).getIdmatch()); 
                                              // boite de dialog ( confirmation ) *************************
                                    
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation de suppression");
                                    alert.setHeaderText("Attention! Etes-vous sur de supprimer le Match ?");
                                    Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                                              mdao.delete(m);
                                             afficher_MatchCompetition();
                                             labelnotifRed.setVisible(true);
                                             labelnotifRed.setText("Match supprimé");
                                    } else {
                                                  labelnotifmatchRed.setVisible(true);
                                                  labelnotifmatchRed.setText("suppression annulée");
                                    }
                                    //************** fin de confirmation ************************** 
                                             
                                    } 
                                    );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             
            c7_delete.setCellFactory( cellFactory );
            
            /////////////////////////////////////////////
     

    dataMatchCompetition = FXCollections.observableArrayList();
    for (Match m : mdao.getListMatchCompetition(CompetitionSelected.getIdcompetition()))
    {
     dataMatchCompetition.add(m);
    }   
    tab_match_compettion.setItems(dataMatchCompetition); 
   }

 /*________________________________________________________________________   
 --------------------------------------------------------------------------
 - *Auteur        : Wissem                                                 -                  
 - *Methode       : SelectCompetitionForModif et  SelectMatchForModif                            -     
 -                                                                         -   
 - *Description   : le but de cette methode est de remplire automatiquement-                                                       -     
                    le formulaire de modification d'une competition/match  -
                    dés que le responsable TFT clique sur une competition  -
                    un match a partir de la tableView                               -
 //------------------------------------------------------------------------
 //************************************************************************/ 

 @FXML
    private void SelectCompetitionForModif(MouseEvent event) 
    {
         afficher_MatchCompetition();
         //--- CompetitionSelected est un (OBJET : competition) selectionné de la tableView
         List<Competition> TAB = tablelistecompetition.getSelectionModel().getSelectedItems();
         final Competition CompetitionSelected = TAB.get(0);
         //---- mettre ENABLE les elements de COMPETITION  ----        
         labelListematch.setText("Liste des matchs de la compétition : "+CompetitionSelected.getLibelle());
         tab_match_compettion.setDisable(false);
         labelListematch.setDisable(false);
         Anchormatchcompetition.setDisable(false);
         AnchorCompetition.setDisable(false);
         
         if (CompetitionSelected != null)
         {
           
        nomcompetitionA.setText(CompetitionSelected.getLibelle());
        // -- date debut
        Instant instant = Instant.ofEpochMilli(CompetitionSelected.getDatedebut().getTime());
        LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        datedebutcompetitionA.setValue(res);
        
        // -- date fin
        Instant instant2 = Instant.ofEpochMilli(CompetitionSelected.getDatefin().getTime());
        LocalDate res2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();
        datefincompetitionA.setValue(res2);
        
         RadioButton grpniv= (RadioButton) groupeniveauA.getSelectedToggle();
         RadioButton grpcat= (RadioButton) groupecategorieA.getSelectedToggle();
         RadioButton grptyp= (RadioButton) groupetypeA.getSelectedToggle();
        
         nbrpointA.setText(""+CompetitionSelected.getNbrpoint());
        }}
    
 //************************************************************************/ 

    @FXML
    private void SelectMatchForModif(MouseEvent event) 
    {
         
         //--- MatchSelected est un (OBJET : Match) selectionné de la tableView
         List<Match> TAB = tab_match_compettion.getSelectionModel().getSelectedItems();
         final Match MatchSelected = TAB.get(0);
         
         if (MatchSelected != null)
         {
        Instant instant = Instant.ofEpochMilli(MatchSelected.getDatematch().getTime());
        LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        datemodif.setValue(res);
        nb_modifticket.setText(""+MatchSelected.getNombreTicket());
       prix_modifticket.setText(""+MatchSelected.getPrixTicket());
        }}
    
    
    Competition compet = new Competition() ; 
    CompetitionDAO compDao  = new CompetitionDAO();
 /*___________________________________________________________________________________   
  ####################################################################################  
 -------------------------------------------------------------------------------------
 -     Auteur   : Wissem                                                                                     -                  
 -     Methode  : modifierCompetition                              -     
 -     Principe : modifier competition qui posséde l'id qui egale a celle selectionné-   
 //-----------------------------------------------------------------------------------
 //***********************************************************************************/
   
    @FXML
    private void modifierCompetition(ActionEvent event)  {
      
        
        List<Competition> TAB = tablelistecompetition.getSelectionModel().getSelectedItems();
        Competition CompetitionSelected = TAB.get(0);
        try {   
      Date dtedebu = java.sql.Date.valueOf(datedebutcompetitionA.getValue());
      Date dtefinn = java.sql.Date.valueOf(datefincompetitionA.getValue());
  
      RadioButton Niv = (RadioButton) (groupeniveauA).getSelectedToggle();
      RadioButton Cat = (RadioButton) (groupecategorieA).getSelectedToggle();
      RadioButton Typ = (RadioButton) (groupetypeA).getSelectedToggle();

      compet.setLibelle(nomcompetitionA.getText());
      compet.setDatedebut(dtedebu);
      compet.setDatefin(dtefinn);
      compet.setNiveau(Niveau.valueOf(Niv.getText()));
      compet.setCategorie(Categorie.valueOf(Cat.getText()));
      compet.setType(TrancheAge.valueOf(Typ.getText())); 
      compet.setNbrpoint(Integer.parseInt(nbrpointA.getText()));
      compet.setIdcompetition(CompetitionSelected.getIdcompetition());
   
      compDao.update(compet);
      afficher_Competition();
  //****** pour modifier Niveau+Categorie+Type *** de match qui appartient a cette competition ***
  m.setNiveau(Niveau.valueOf(Niv.getText()));
  m.setCategorie(Categorie.valueOf(Cat.getText()));
  m.setType(TrancheAge.valueOf(Typ.getText())); 
  mdao.ModifMatchDepuisCompetition(m, CompetitionSelected.getIdcompetition());
  //**********************************************************************************************
      labelnotif.setVisible(true);
      labelnotif.setText("Compétition Modifiée avec succé");
      
       /*-------------
        la variable CompetitionSelected :
      contient  la competition selectionné a partir de la tableView
        -------------------------------------------------------
       */
           System.out.println("modification Competition effectuée  ");
        } catch (Exception e){
           System.out.println("ERREUR DE MODIFICATION Competition !!! ");
           Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, e);
        }

      
    }
    
 
 /*___________________________________________________________________________________   
  ####################################################################################  
 -------------------------------------------------------------------------------------
 -     Auteur   : Wissem                                                                                     -                  
 -     Methode  : afficher_MatchCompetitionConfirmation                                 
 -     Principe : afficher la liste des match d'une competition qui est en cours de creation    
                  au but de verification avant la confirmation
 //-----------------------------------------------------------------------------------
 //***********************************************************************************/
     private ObservableList<Match> dataMatchCompetitionConfirmation; 
     public void afficher_MatchCompetitionConfirmation()
   {
       
     try {
           co0_id.setCellValueFactory(new PropertyValueFactory("idmatch"));
           co1_comp.setCellValueFactory(new PropertyValueFactory("libellecompetition"));
           co2_j1.setCellValueFactory(new PropertyValueFactory("nomj1"));
           co2_j2.setCellValueFactory(new PropertyValueFactory("nomj2"));
           co3_arbitre.setCellValueFactory(new PropertyValueFactory("nomArb"));
           co4_stade.setCellValueFactory(new PropertyValueFactory("libellestade"));
           co5_date.setCellValueFactory(new PropertyValueFactory("datematch"));
 } catch (Exception e) 
        { System.out.println("--------- erreur  afficher_MatchCompetitionConfirmation ---------");
       }
        
    dataMatchCompetitionConfirmation = FXCollections.observableArrayList();
    List<Competition> lss = new ArrayList<Competition>();
    lss = CompDAO.getListCompetition(Comp.getLibelle().toString(), (java.sql.Date) Comp.getDatedebut());
    
    for (Match mat : mdao.getListMatchCompetition(lss.get(0).getIdcompetition()))
    {
     dataMatchCompetitionConfirmation.add(mat);  
    }   
    
    tableListematchConfirm.setItems(dataMatchCompetitionConfirmation); 
 
   }
          
    
    /*------------------------------------------------------------------------------
    //******************************************************************************
    les 3 methodes  : - getIdFromListeArbitre(String chaine) 
                      - getIdFromListeJoueur(String chaine) 
                      - getIdFromListeStade(String chaine)
     
    * Roles: - puisqu'on a besoin de l'id de : joueur1+joueur2+arbitre , pour qu'on puisse les ajouter dans la base 
              ces 3 methodes sont utilisées dans la methode "ajouter match competition" 
    
            -  ces 3 methodes ont pour role de recuperer L'idpersonne on comparaison 
               la chaine de comboBox qui contient : "nom prenom" avec la concatination de nom et prenom de l'objet qui ce trouve dans une liste
   
    
    ------------------------------------------------------------------------------*/
    //###################### getIdFromListeArbitre #################################
    public int getIdFromListeArbitre(String chaine){
        int x = 0;
     for (Arbitre A : listeAr)
    {
     if ( (A.getNom() + " " + A.getPrenom()).equals(chaine))
     {
          x = A.getIdpersonne();
     }
    }  
       return x;
    }
    
     //###################### getIdFromListeJoueur #################################
    public int getIdFromListeJoueur(String chaine){
        int x = 0;
     for (Joueur J : ListJoueur)
    {
     if ( (J.getNom() + " " + J.getPrenom()).equals(chaine))
     {
          x = J.getIdpersonne();
     }
    }  
       return x;
    }
      //###################### getIdFromListeStade #################################
    public int getIdFromListeStade(String chaine){
        int x = 0;
     for (Stade S : ListStade)
    {
     if ( S.getLibellestade().equals(chaine))
     {
          x = S.getIdstade();
     }
    }  
       return x;
    }
 /*#############################################################################
 ###############################################################################
 ###############################################################################
 ###############################################################################   
    */
    @FXML
   public void RetourEtape0Competition(ActionEvent event)
   {
   tablelistecompetition.refresh();
   AnchorEtape0.setVisible(true);
   AnchorEtape1.setVisible(false);
   AnchorEtape2.setVisible(false);
   AnchorEtape3.setVisible(false);
   
   }
   
    @FXML
   public void SupprimerCompetitionNonCree(ActionEvent event)
   {
   AnchorEtape0.setVisible(true);
   AnchorEtape1.setVisible(false);
   AnchorEtape2.setVisible(false);
   AnchorEtape3.setVisible(false);
   CompDAO.DeleteCompetition(nomcompetition1.getText(), java.sql.Date.valueOf(datedebutcompetition1.getValue()));
   } 
    
   
   /*###########################################################
   -------------------------------------------------------------
   -------------------------------------------------------------
   
   methode : 
   listeOfJoueurNotDuplicated( ObservableList<String> obs, String ch ) 
   Role :
   Assurer de selectionner joueur1 != joueur2
   ***************************************************************
   methode : choice
   a letat initial , il faut afficher la liste de toutes les joueurs 
   en modifiant la variable 'etat' utilisé dans la methode : listeOfJoueurNotDuplicated
   --------------------------------------------------------------
   --------------------------------------------------------------
   ##############################################################
   */
   
   int etat= 0;
   //#####
   @FXML
   public void Choice(MouseEvent event)
   {etat=1;}
   
  public ObservableList<String> listeOfJoueurNotDuplicated( ObservableList<String> obs, String ch )
  {
    ObservableList<String> resulta = FXCollections.observableArrayList();

    int x=(obs.size());
      for (int i = 0; i <x; i++) 
      {
          if(!(obs.get(i).equals(ch)))
          {resulta.add(obs.get(i));}
      } 
      
      if( x==0)
      {
          resulta= obs;
      }
     return resulta;
  }
 
   
     
     
      
    
    
 //{{{{{{{{{{{{{{{{Remplire COMBO pour les joueurs de dajout match competitions }}}}}}}}}}}}}}
  @FXML
  public void remplireComboJ2(MouseEvent event)
          
  {
       RadioButton Cat = (RadioButton) (groupecategorie1).getSelectedToggle();
    ObservableList<String> obsNom = FXCollections.observableArrayList();
    
      if(Cat.getText().equals("Homme"))
  {
       obsNom = RemplireComboJoueurHomme();
  }
      else if(Cat.getText().equals("Femme"))
  {
    obsNom = RemplireComboJoueurFemme();
  } 
      else
  {
   obsNom = RemplireComboJoueurAll();
  } 
      ObservableList<String> obsNomJoueurNotDUPLICATE = listeOfJoueurNotDuplicated(obsNom,(String) combojoueur1.getSelectionModel().getSelectedItem());
      combojoueur2.setItems(obsNomJoueurNotDUPLICATE);
  
  }
   @FXML
  public void remplireComboJ1(MouseEvent event)
          
 {
      RadioButton Cat = (RadioButton) (groupecategorie1).getSelectedToggle();
    ObservableList<String> obsNom = FXCollections.observableArrayList();
      
 
      if(Cat.getText().equals("Homme"))
  {
       obsNom = RemplireComboJoueurHomme();
  }
      else if(Cat.getText().equals("Femme"))
  {
    obsNom = RemplireComboJoueurFemme();
  } 
      else
  {
   obsNom = RemplireComboJoueurAll();
  }  
      ObservableList<String> obsNomJoueurNotDUPLICATE = listeOfJoueurNotDuplicated(obsNom,(String) combojoueur2.getSelectionModel().getSelectedItem());
      combojoueur1.setItems(obsNomJoueurNotDUPLICATE);
  
  } 
  //{{{{{{{{{{{{{{{{Remplire COMBO pour les joueurs de modif match competitions }}}}}}}}}}}}}}
  @FXML
  public void remplireComboJ2_modif(MouseEvent event)
          
  {
   ObservableList<String> obsNom = FXCollections.observableArrayList();
   obsNom = RemplireComboJoueurAll();
   ObservableList<String> obsNomJoueurNotDUPLICATE = listeOfJoueurNotDuplicated(obsNom,(String) combo_modifjoueur1.getSelectionModel().getSelectedItem());
   combo_modifjoueur2.setItems(obsNomJoueurNotDUPLICATE);
  }
   @FXML
  public void remplireComboJ1_modif(MouseEvent event)      
 {  
   ObservableList<String> obsNom = FXCollections.observableArrayList();
   obsNom = RemplireComboJoueurAll();
   ObservableList<String> obsNomJoueurNotDUPLICATE = listeOfJoueurNotDuplicated(obsNom,(String) combo_modifjoueur2.getSelectionModel().getSelectedItem());
   combo_modifjoueur1.setItems(obsNomJoueurNotDUPLICATE);
  
  }  
  
  //{{{{{{{{{{{{{{{{Remplire COMBO pour les joueurs de modif match competitions }}}}}}}}}}}}}}
  @FXML
  public void remplireComboJMatchamicalJ1(MouseEvent event)
          
  {
   ObservableList<String> obsNom = FXCollections.observableArrayList();
   obsNom = RemplireComboJoueurAll();
   ObservableList<String> obsNomJoueurNotDUPLICATE = listeOfJoueurNotDuplicated(obsNom,(String) combo_joueur2.getSelectionModel().getSelectedItem());
   combo_joueur1.setItems(obsNomJoueurNotDUPLICATE);
  }
   @FXML
  public void remplireComboJMatchamicalJ2(MouseEvent event)      
 {  
   ObservableList<String> obsNom = FXCollections.observableArrayList();
   obsNom = RemplireComboJoueurAll();
   ObservableList<String> obsNomJoueurNotDUPLICATE = listeOfJoueurNotDuplicated(obsNom,(String) combo_joueur1.getSelectionModel().getSelectedItem());
   combo_joueur2.setItems(obsNomJoueurNotDUPLICATE);
  
  }  
  
  /*
     
    #######################################################################################
    #######################################################################################
     #######################################################################################
     FIN WISSEM
     #######################################################################################
   #######################################################################################
     #######################################################################################
     
     
     */
          
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
          @Override
    public void initialize(URL url, ResourceBundle rb) {
    
         /*
     
    #######################################################################################
    #######################################################################################
     #######################################################################################
      WISSEM
     #######################################################################################
   #######################################################################################
     #######################################################################################
     
     
     */
        tab_match_compettion.setDisable(true);
    Anchormatchcompetition.setDisable(true);
    AnchorCompetition.setDisable(true);
    labelListematch.setDisable(true);
    
             listeAr = d.List_ArbitresForComboBox();
             ListJoueur = d.List_ALL_JoueurForComboBox();
             ListStade=d.List_stade_ForComboBox();
             
             datedebutcompetition1.setOnAction(event -> {
             datedeb = datedebutcompetition1.getValue();
           });
             datefincompetition1.setOnAction(event -> {
        datefin = datefincompetition1.getValue();
        });
             
             
        amateurcompetition1.setToggleGroup(groupeniveau1);
        nationalcompetition1.setToggleGroup(groupeniveau1);
        INcompetition1.setToggleGroup(groupeniveau1);
     
        
          hommecompetition1.setToggleGroup(groupecategorie1);
          femmecompetition1.setToggleGroup(groupecategorie1);
          mixtecompetition1.setToggleGroup(groupecategorie1);
          
          
        juniorcompetition1.setToggleGroup(groupetype1);
        seniorcompetition1.setToggleGroup(groupetype1);
        veterancompetition1.setToggleGroup(groupetype1);
  
        Afficher_Match();
  //*************************************************************************
        ObservableList<String> obsNomJoueur = RemplireComboJoueurAll();
              System.out.println("obsNomJoueur ----> :" + obsNomJoueur);
 //**************************************************************************
       ObservableList<String> obsCompeti = RemplireComboCompetition();
 //**************************************************************************
        ObservableList<String> obsType = FXCollections.observableArrayList();
        obsType.add("Veteran");
        obsType.add("Senior");
        obsType.add("Junior");
 //************************************************************************** 
        ObservableList<String> obsNiveau = FXCollections.observableArrayList();
        obsNiveau.add("Amateur");
        obsNiveau.add("National");
        obsNiveau.add("International");
        
 //************************************************************************** 
        ObservableList<String> obsCategorie = FXCollections.observableArrayList();
        obsCategorie.add("Homme");
        obsCategorie.add("Femme");
        obsCategorie.add("Mixte");
//************************************************************************** 

        ObservableList<String> obsNbMatch = FXCollections.observableArrayList();
        obsNbMatch.add("5");
        obsNbMatch.add("10");
        obsNbMatch.add("15");
   
 //************************************************************************** 
      
     ObservableList<String> obsNomarbitr= RemplireComboArbitre(); 
  //*************************************************************************
    ObservableList<String> obserEvenement= RemplireComboEven(); 
 //*************************************************************************
    ObservableList<String> obserStad = RemplireComboStade();
//*************************************************************************
        comboNBmatch.setItems(obsNbMatch);
        combo_type.setItems(obsType);
        combo_joueur1.setItems(obsNomJoueur);
     
        combo_joueur2.setItems(obsNomJoueur);
        combo_niveau.setItems(obsNiveau);
        combo_categorie.setItems(obsCategorie);
        combo_arbitre.setItems(obsNomarbitr);
        combo_evenement.setItems(obserEvenement);
        combo_stade.setItems(obserStad);
        combo_competition.setItems(obsCompeti);

        combojoueur1.setItems(obsNomJoueur);
        combojoueur2.setItems(obsNomJoueur);
        comboarbitre.setItems(obsNomarbitr);
        combostade.setItems(obserStad);
     
        combo_modifjoueur1.setItems(obsNomJoueur);
        combo_modifjoueur2.setItems(obsNomJoueur);
        combo_modifarbitre.setItems(obsNomarbitr);
        combo_modifstade.setItems(obserStad);
        
        


   
       
        //PARTIE STADE
        afficherDataStade();
        initaliserFieldsStade();
        //InitilisationRadioButtons();
        InitialisationTables();
        //GoogleMap();
        
       // afficherDataSessionArbitre();
       // initaliserFieldsSession();
        
        new AutoCompleteComboBoxListener<>(txtville);



        recherchestade.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                afficherDataStadeRechcherche(ke);
                System.out.println("Key Pressed: " + ke.getText());
            }
        });

        //recuperer la date de creation du stade 
        datecreationstade.setOnAction(event -> {
            datestade = datecreationstade.getValue();
            System.out.println(datestade);
        });

        //recuperer la valeur de la ville
        txtville.setOnAction((ActionEvent evnt) -> {
            villeChoix = txtville.getValue();
            System.out.println("selected: " + villeChoix);
        });

        txtville.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                String chaine = ke.getText();
                System.out.println("Key Pressed: " + chaine);
            }
        });
    
     afficher_Competition();
     
               afficher();
        afficherEvent();
      /*
     
    #######################################################################################
    #######################################################################################
     #######################################################################################
      FIN WISSEM
     #######################################################################################
   #######################################################################################
     #######################################################################################
     
     
     */
    
    }
    
       
    /*
    ######################################### Chems ###########################
    */
    
   
    
    
    @FXML
    private Button menuClub2;
    
    @FXML
    private AnchorPane clubPane;
    @FXML
    private AnchorPane eventPane;
    //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////// ATTRIBUTS DU CLUB /////////////////////////////////////  
           @FXML
    private TextField cnom;
           
           
          @FXML
    private AnchorPane  esp_even;
          
          @FXML
    private AnchorPane gererclub;
         
           @FXML
    private AnchorPane ajoutevent;
                  
        @FXML
    private AnchorPane   esp_club;
          
    @FXML   
    private TextField csiege;
     @FXML   
    private TextField daily;
    @FXML
    private TextField ctel;
    @FXML
    private TextField cpresident;
    @FXML
    private ImageView imagepr;
    
        @FXML
        private DatePicker cdate;
          
          @FXML
    private Button cenvoyer;
    
    @FXML
    private Button cmodif;
          
          @FXML
    private TableView tablecl;
         
         @FXML
    private TableColumn clnom;
    @FXML
    private TableColumn clsiege;
    @FXML
    private TableColumn cldate;
     @FXML
    private TableColumn clpres;
     @FXML
    private TableColumn cltel;
        @FXML
    private TableColumn clidclub;
       @FXML
    private TableColumn column41;
        @FXML
    private TableColumn colimage;
       @FXML
    private TableColumn imgch;
        @FXML
    private TableColumn video;
        @FXML   
    private TextField idcl;
      @FXML   
    private Label labb;
       @FXML
    private TableColumn column411;
       
      @FXML
    private TableColumn lieuevv;
       
       @FXML
    private Button btnFile;
       
       ////////////////////////////////////////////////////////////////////////////
       
       /////////// Attributs evenement ////////////////////////
       
        @FXML
    private TableView tableev;
        @FXML
    private Label labeven;
         
         @FXML
    private TableColumn evlib;
    @FXML
    private TableColumn evlieu;
    @FXML
    private TableColumn evdatedeb;
     @FXML
    private TableColumn evdatefin;
       @FXML
    private TableColumn colsup;
       @FXML
    private TableColumn idevent;
      @FXML
    private TableColumn lienvid;
     @FXML
    private TextField tlib;
    @FXML   
    private TextField tlieu;
    @FXML
    private DatePicker tdatedeb;
    @FXML
    private DatePicker tdatefin;
    @FXML
    private Button cenvoyer1;
    @FXML
    private Button cmodif1;
    
       
       ///////////////////////////////////////////////////
        
         private ObservableList<Club> data;
         private ObservableList<Club> data_filtre;
               
         private ObservableList<Evenement> dataevent;
         private ObservableList<Evenement> data_filtreevent;

          Club c =new Club();
         ClubDAO cdao=new ClubDAO();
         
         Evenement e = new Evenement();
         EventDAO edao=new EventDAO();
       
/////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
   
     
    
     
     
     
    
   
     
     
     
     
     
     
     
         
    
    
    
    
    /////////// Espace Club (made by chams)      ////////////////////////////
    @FXML
    private void passerMenuClub(ActionEvent event)
    {
        tablecl.setVisible(true);
    }
    
     @FXML
    private void ajouterClub(ActionEvent event) 
    {
                 

             c.setLibellecode(cnom.getText());
            c.setDatecreation(java.sql.Date.valueOf(cdate.getValue()));
            c.setSiege((csiege.getText()));
            c.setPresident((cpresident.getText()));
            c.setTel((ctel.getText()));
            c.setAvatar(labb.getText());
            c.setVideo(daily.getText());
            cdao.save(c);
            
           afficher();
            
    }
    
     @FXML
    private void Modifier(MouseEvent event) 
    {
        if (tablecl != null) {
            List<Club> tables = tablecl.getSelectionModel().getSelectedItems();
            if (tables.size() == 1) {
                final Club clubselected = tables.get(0);
                   position = data.indexOf(clubselected);
                        if (clubselected != null) {

            cnom.setText(clubselected.getLibellecode());
            cpresident.setText(clubselected.getPresident());
            ctel.setText(clubselected.getTel());
            csiege.setText(clubselected.getSiege());
            Instant instant = Instant.ofEpochMilli(clubselected.getDatecreation().getTime());
            LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            cdate.setValue(res);
            idcl.setText(String.valueOf(clubselected.getIdclub()));
            daily.setText(clubselected.getVideo());
        }        

    }
}
    }
    
    
     @FXML
    private void update(ActionEvent event)  {
   
  

       c.setLibellecode(cnom.getText());
            c.setDatecreation(java.sql.Date.valueOf(cdate.getValue()));
            c.setSiege((csiege.getText()));
            c.setPresident((cpresident.getText()));
            c.setTel((ctel.getText()));
            c.setAvatar("a");
            c.setIdclub(Integer.valueOf(idcl.getText()));
           c.setVideo(daily.getText());
         
            cdao.update(c);
            
            
           

            System.out.println("modification effectuée  ");
        
        afficher();
        cnom.setText("");
            cpresident.setText("");
            ctel.setText("");
            csiege.setText("");
         cdate.setValue(null);
        


    }
    
            
    
     public void afficher()
    {
    
             clnom.setCellValueFactory(new PropertyValueFactory("libellecode"));
             clsiege.setCellValueFactory(new PropertyValueFactory("siege"));
             cldate.setCellValueFactory(new PropertyValueFactory("datecreation"));
             clpres.setCellValueFactory(new PropertyValueFactory("president"));
              cltel.setCellValueFactory(new PropertyValueFactory("tel"));
            colimage.setCellValueFactory(new PropertyValueFactory("avatar"));
             lienvid.setCellValueFactory(new PropertyValueFactory("video"));

             Callback<TableColumn<Club, String>, TableCell<Club, String>> cellFactory = 
                new Callback<TableColumn<Club, String>, TableCell<Club, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Club, String> param )
                    {
                        final TableCell<Club, String> cell = new TableCell<Club, String>()
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
                                             c.setIdclub(getTableView().getItems().get( getIndex()).getIdclub()); 
                                             cdao.delete(c);
                                             afficher();
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
            
            ////////////////////////////////////////
             Callback<TableColumn<Club, String>, TableCell<Club, String>> cellFactoryModifyy = 
                new Callback<TableColumn<Club, String>, TableCell<Club, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Club, String> param )
                    {
                        final TableCell<Club, String> cell = new TableCell<Club, String>()
                        {

                            final Button btnModify = new Button( "video" );
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
                                              
                                             
                                             
//                                             Stage stageModify = new Stage();
//                                            stageModify.setResizable(false);
//                                             Parent root;
//                                        try {
//                    root = FXMLLoader.load(getClass().getResource("/esprit/gui/responsable/FXMLVideo.fxml"));
//                                            
//                                            stageModify.setScene(new Scene(root));
//                                        } catch (IOException ex) {
//                                            Logger.getLogger(FXMLResponsableController.class.getName()).log(Level.SEVERE, null, ex);
//                                        }
//                                            
                                                
                                                Stage stageModify = new Stage();
                                            stageModify.setResizable(false);
                                                WebView web=new WebView();
                                             //  MediaPlayer mediaPlayer;
                                             //   Media media;
                                           //String path = "C:\\tunis.mp4";
                                            WebView webvview = new WebView();
                                     String pathh = (getTableView().getItems().get( getIndex()).getVideo()); 

                                            webvview.getEngine().load(pathh);
                                                  webvview.setPrefSize(640, 390);

                                        
               
                                                    Scene scene = new Scene(new Group());
                                                     VBox root = new VBox();    
                                   root.getChildren().addAll(webvview);
                                                      scene.setRoot(root);
                                            stageModify.setScene(scene);
                                          
                                             stageModify.setResizable(false);
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
            
            column411.setCellFactory(cellFactoryModifyy);
            ////////////////////////////////////
            
             
            
            /////////////////////////////////////////////////////////////////
            Callback<TableColumn<Club, String>, TableCell<Club, String>> cellFactoryModifyyy = 
                new Callback<TableColumn<Club, String>, TableCell<Club, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Club, String> param )
                    {
                        final TableCell<Club, String> cell = new TableCell<Club, String>()
                        {

                            final Button btnModify = new Button( "image" );
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
                                    
                                             Stage stageModify = new Stage();
                                            stageModify.setResizable(false);
                                            ImageView img=new ImageView();
                               String f = (getTableView().getItems().get( getIndex()).getAvatar()); 
                                                System.out.println("le path est : " + f);
                               InputStream inputStream = null;
                                        try {
                                            inputStream = new FileInputStream(f);
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(FXMLResponsableController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                 Image imgg = new Image(inputStream);
               
                                 img.setImage(imgg);
                                                    Scene scene = new Scene(new Group());
                                                     VBox root = new VBox();    
                                   root.getChildren().addAll(img);
                                                      scene.setRoot(root);
                                            stageModify.setScene(scene);
                                  
                     
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
            
            imgch.setCellFactory(cellFactoryModifyyy);
            
data = FXCollections.observableArrayList();
               for (Club c : cdao.getList())
               {
                   data.add(c);
               }
           

       tablecl.setItems(data);       
            
    }
    
    
    @FXML
    private void imageAction(ActionEvent event) throws IOException 
    
    {
         Stage pstage=null;
         FileChooser fileChooser = new FileChooser();
//         fileChooser.setTitle("Open Resource File");
//         File file = fileChooser.showOpenDialog(new Stage());
//         if(file != null) {
//        String imagepath = file.getPath();
//        System.out.println("file:"+file.getCanonicalPath());

 FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
File file = fileChooser.showOpenDialog(null);
            String path = file.getAbsolutePath();
             
            try {
                InputStream inputStream = new FileInputStream(path);
                Image img = new Image(inputStream);
               
                imagepr.setImage(img);
                labb.setText(path);
           } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLResponsableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            


       //String imgp= "C:\\mm.jpg";
        //Image image = new Image(file.getCanonicalPath());
      
       //Image image = new Image("/tn/esprit/crowdrise/utils/Project.png");
       // imgProfil.setImage(image);
        
    }

/////////////////// espace EVENEMENT ///////////////////////////
    @FXML
    private void ajouterEvent(ActionEvent event) 
    {
             e.setLibelle(tlib.getText());
             e.setLieu(tlieu.getText());
            e.setDatedebut(java.sql.Date.valueOf(tdatedeb.getValue()));
           e.setDatefin(java.sql.Date.valueOf(tdatefin.getValue()));
           e.setVideo(labeven.getText());
        edao.save(e);
        afficherEvent();
        
    }
    
       public void afficherEvent ()
       {
       
             evlib.setCellValueFactory(new PropertyValueFactory("libelle"));
             evlieu.setCellValueFactory(new PropertyValueFactory("lieu"));
             evdatedeb.setCellValueFactory(new PropertyValueFactory("datedebut"));
             evdatefin.setCellValueFactory(new PropertyValueFactory("datefin"));
             lieuevv.setCellValueFactory(new PropertyValueFactory("video"));
             //idevent.setCellValueFactory(new PropertyValueFactory("idevenement"));
             
             Callback<TableColumn<Evenement, String>, TableCell<Evenement, String>> cellFactory = 
                new Callback<TableColumn<Evenement, String>, TableCell<Evenement, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Evenement, String> param )
                    {
                        final TableCell<Evenement, String> cell = new TableCell<Evenement, String>()
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
                                             e.setIdevenement(getTableView().getItems().get( getIndex()).getIdevenement()); 
                                              edao.delete(e);
                                             afficherEvent();
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
            
             colsup.setCellFactory( cellFactory );
             
             //////////////////////////////////////////////////////////
             Callback<TableColumn<Evenement, String>, TableCell<Evenement, String>> cellFactoryMod= 
                new Callback<TableColumn<Evenement, String>, TableCell<Evenement, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Evenement, String> param )
                    {
                        final TableCell<Evenement, String> cell = new TableCell<Evenement, String>()
                        {

                            final Button btnModify = new Button( "video" );
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
                                              
                                             Stage stageModify = new Stage();
                                            stageModify.setResizable(false);
                                                MediaView mediaview=new MediaView();
                                               MediaPlayer mediaPlayer;
                                                Media media;
                                           //String path = "C:\\tunis.mp4";
                                 String path = (getTableView().getItems().get( getIndex()).getVideo()); 

                                            media = new Media(new File(path).toURI().toString());
                                            mediaPlayer = new MediaPlayer(media);
                                              mediaPlayer.setAutoPlay(true);
                                          mediaview.setMediaPlayer(mediaPlayer);
               
                                                    Scene scene = new Scene(new Group());
                                                     VBox root = new VBox();    
                                   root.getChildren().addAll(mediaview);
                                                      scene.setRoot(root);
                                            stageModify.setScene(scene);
                                             stageModify.setHeight(600);
                                             stageModify.setWidth(600);
                                             stageModify.setResizable(false);
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
            
            video.setCellFactory(cellFactoryMod);

              dataevent = FXCollections.observableArrayList();
               for (Evenement e : edao.getList())
               {
                   dataevent.add(e);
               }
           

       tableev.setItems(dataevent);   
       
       }
              
       @FXML
    private void ModifierEvent(MouseEvent event) 
    {
          if (tableev != null) {
            List<Evenement> tables = tableev.getSelectionModel().getSelectedItems();
            if (tables.size() == 1) {
                final Evenement eventselected = tables.get(0);
                   position = dataevent.indexOf(eventselected);
                        if (eventselected != null) {

            tlib.setText(eventselected.getLibelle());
            tlieu.setText(eventselected.getLieu());
            Instant instant = Instant.ofEpochMilli(eventselected.getDatedebut().getTime());
            LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            tdatedeb.setValue(res);
           Instant instantt = Instant.ofEpochMilli(eventselected.getDatefin().getTime());
            LocalDate ress = LocalDateTime.ofInstant(instantt, ZoneId.systemDefault()).toLocalDate();
            tdatefin.setValue(ress);
            
        }        

    }
          }
    }
    
      @FXML
    private void EspaceClub(ActionEvent event) {
    esp_club.setVisible(true);
    esp_even.setVisible(false);
    gererclub.setVisible(true);
    ajoutevent.setVisible(false);
    
    }
    
  @FXML
    private void EspaceEven(ActionEvent event) {
    esp_club.setVisible(false);
    esp_even.setVisible(true);
        gererclub.setVisible(false);
    ajoutevent.setVisible(true);

    
    }
    
   @FXML
    private void videoAction (ActionEvent event)
    {
         Stage pstage=null;
         FileChooser fileChooser = new FileChooser();


 //FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
          //  FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
          //  fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File file = fileChooser.showOpenDialog(null);
            String path = file.getAbsolutePath();
             
            try {
                InputStream inputStream = new FileInputStream(path);
                
               
                labeven.setText(path);
           } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLResponsableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            

    }
    
}
 
     
     
     
     
     
     
      
    

