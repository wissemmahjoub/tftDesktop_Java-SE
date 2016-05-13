/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import esprit.controllers.responsable.*;
import esprit.controllers.admin.FXMLAdminController;
import esprit.dao.MatchDAO;
import esprit.dao.StadeDAO;
import esprit.dao.StadeDAOInterface;
import esprit.dao.TicketDAO;
import esprit.entite.Arbitre;
import esprit.entite.Categorie;
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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
    private AnchorPane backgroundPane;
    @FXML
    private ImageView optionTailleAgrandir;
    @FXML
    private ImageView optionTailleParDefaut;
    @FXML
    private Label Gestion;
    @FXML
    private AnchorPane consulterMedecinPane;
     @FXML
    private AnchorPane AnchorMatchlist;
    @FXML
    private TableView  tab_match;
    @FXML
    private TableColumn  col10_id;
    @FXML
    private TableColumn  col1_type;
    
    
    @FXML
    private TableColumn col_12_idmatch;
    @FXML
    private TableColumn  col2_niveau;
    @FXML
    private TableColumn  col3_categorie;
    @FXML
    private TableColumn  col4_competition;
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
    private DatePicker date;
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
    @FXML
    private AnchorPane googleMapContainer;
    @FXML
    private AnchorPane sessionFormationPane;
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
    private ComboBox<String> txtnivsecsession;
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
    private TextField recherchesession;
    @FXML
    private TextField txtlibellesession;
    @FXML
    private TextField txtcapacitesession;
    @FXML
    private TextField txtlieusession;
    @FXML
    private DatePicker datedebutsession;
    @FXML
    private DatePicker datefinsession;
    @FXML
    private ComboBox<String> txtciblesession;
    @FXML
    private Button boutonGlissantMap;
    @FXML
    private Button boutonGlissantList;
    @FXML
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
    private Button SendEmail;
    
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
    
    
     private void setMenuStyleNormal()
    {
        menuCup.setStyle(styleMenu);
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
        consulterMatch.setVisible(false);
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
            case "menuMatch" :
                setInvisibleAllConsult();
                consulterMatch.setVisible(true);
                titelLabel.setText("Gestion des matchs");
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
    
            
            
    
    
    public void AjouterTicket() 
       {
         
           
        t.setNbrticket(Integer.parseInt(nb_ticket.getText()));
        t.setPrix(Integer.parseInt(prix_ticket.getText()));
        
 
        tdao.save(t);
        
        System.out.println(t.toString());
        System.out.println("--------- Ticket ajouté  ----------");
       
          }

    
    
   //####################################################################################### 
   //----------------------------------Afficher Match -------------------
   //#######################################################################################
     private ObservableList<Match> dataMatch; 
     public void Afficher_Match()
   {
     try {
    
       
           col1_type.setCellValueFactory(new PropertyValueFactory("type"));
           col2_niveau.setCellValueFactory(new PropertyValueFactory("niveau"));
           col3_categorie.setCellValueFactory(new PropertyValueFactory("categorie"));
           col4_competition.setCellValueFactory(new PropertyValueFactory("idcompetition"));
           col5_joueur1.setCellValueFactory(new PropertyValueFactory("idjoueur1"));
           col6_joueur2.setCellValueFactory(new PropertyValueFactory("idjoueur2"));
           col7_arbitre.setCellValueFactory(new PropertyValueFactory("idarbitre"));
           col8_evenement.setCellValueFactory(new PropertyValueFactory("idevenement"));
           col9_stade.setCellValueFactory(new PropertyValueFactory("idstade"));
           col10_date.setCellValueFactory(new PropertyValueFactory("datematch"));
           col_12_idmatch.setCellValueFactory(new PropertyValueFactory("idmatch"));
           
           
           
           System.out.println("-------- pas derreur lors de la methode affiche_liste_joueurs_invites  --------- ");
 } catch (Exception e) 
        { System.out.println("--------- erreur  affiche_liste_joueurs_invites  ---------");
       }
        
    dataMatch = FXCollections.observableArrayList();
    for (Match m : mdao.getList())
    {
     dataMatch.add(m);  
    }   
    
    tab_match.setItems(dataMatch); 
 
   }
    
    
   //####################################################################################### 
   //----------------------------------Ajouter Match a la base de donnée-------------------
   //#######################################################################################
   
    Match m = new Match();
    MatchDAO mdao=new MatchDAO();  
    public void AjouterMatch(ActionEvent event) 
       {
          AjouterTicket();
           Afficher_Match();
        m.setIdjoueur1(mdao.GetIdByName(ManipuleString((String)combo_joueur1.getSelectionModel().getSelectedItem())));
        m.setIdjoueur2(mdao.GetIdByName(ManipuleString((String)combo_joueur2.getSelectionModel().getSelectedItem()))); 
        m.setIdcompetition((ManipuleString((String)combo_competition.getSelectionModel().getSelectedItem())));
        m.setIdarbitre(mdao.GetIdByName(ManipuleString((String)combo_arbitre.getSelectionModel().getSelectedItem())));
        m.setIdevenement(ManipuleString((String)combo_evenement.getSelectionModel().getSelectedItem()));
        m.setIdstade(ManipuleString((String)combo_stade.getSelectionModel().getSelectedItem()));
        m.setDatematch(java.sql.Date.valueOf(date.getValue()));
        m.setNiveau(Niveau.valueOf(combo_niveau.getSelectionModel().getSelectedItem().toString()));
        m.setType(TrancheAge.valueOf(combo_type.getSelectionModel().getSelectedItem().toString()));
        m.setCategorie(Categorie.valueOf(combo_categorie.getSelectionModel().getSelectedItem().toString()));
        m.setIdticket(tdao.id_dernier_Ticket());
 
        mdao.save(m);
        
        System.out.println(m.toString());
        System.out.println("--------- Match ajouté  ----------");
     
    
          }

   //-------------------------------------------------------------------------------------- 
   //----------------------------------Remplissage de CompBo-------------------------------
    //******************************** author : wissem ************************************
    
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
            obs.add(St.getLibellestade()+" :"+St.getIdstade());
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
            obs.add(J.getNom()+" :"+J.getCin());
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
            obs.add(J.getNom()+" :"+J.getCin());
        }
        return obs;
    }
  //################################################################   
     
      public ObservableList<String> RemplireComboJoueurAll()
    {
        MatchDAO d =new MatchDAO();
        List<Joueur> listeM = new ArrayList();
        listeM = d.List_ALL_JoueurForComboBox();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(Joueur J : listeM)
        {
          
            obs.add(J.getNom()+" :"+J.getCin());
        }
        return obs;
    }
  //################################################################    
     
      public ObservableList<String> RemplireComboArbitre()
    {
        MatchDAO d =new MatchDAO();
        List<Arbitre> listeAr = new ArrayList();
        listeAr = d.List_ArbitresForComboBox();
        ObservableList<String> obsAr = FXCollections.observableArrayList();
        for(Arbitre Arr: listeAr)
        {
            obsAr.add(Arr.getNom()+" :"+Arr.getCin());
        }
        return obsAr;
    }
  //################################################################  
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Afficher_Match();
  //*************************************************************************
        ObservableList<String> obsNomJoueur = RemplireComboJoueurAll();
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
      
     ObservableList<String> obsNomarbitr= RemplireComboArbitre(); 
  //*************************************************************************
    ObservableList<String> obserEvenement= RemplireComboEven(); 
 //*************************************************************************
    ObservableList<String> obserStad = RemplireComboStade();
//*************************************************************************
        
        combo_type.setItems(obsType);
        combo_joueur1.setItems(obsNomJoueur);
        combo_joueur2.setItems(obsNomJoueur);
        combo_niveau.setItems(obsNiveau);
        combo_categorie.setItems(obsCategorie);
        combo_arbitre.setItems(obsNomarbitr);
        combo_evenement.setItems(obserEvenement);
        combo_stade.setItems(obserStad);
        combo_competition.setItems(obsCompeti);
       
       
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
    
    
    
    }    

    @FXML
    private void handleGlissantButtonListe(ActionEvent event) {
    }

    @FXML
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
    
    
    @FXML
    private void Rechercher(KeyEvent event) {
    }
    
}
 
     
     
     
     
     
     
      
    

