/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.responsable;

import esprit.dao.StadeDAO;
import esprit.dao.StadeDAOInterface;
import esprit.entite.SessionFormation;
import esprit.entite.Stade;
import esprit.entite.Surface;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    //ATTRIBUTS STADE + SESSION
    @FXML
    private Label titelLabel;
    @FXML
    private AnchorPane consulterStadePane;
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
        sessionFormationPane.setVisible(false);
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
                sessionFormationPane.setVisible(true);
                titelLabel.setText("Gestion des Sessions de formation");

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
     
     
     
     
     
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
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
    
}
