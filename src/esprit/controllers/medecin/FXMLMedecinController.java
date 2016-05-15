package esprit.controllers.medecin;

import esprit.controllers.admin.FXMLAdminController;
import esprit.dao.TestDAO;
import esprit.dao.InvitationDAO;
import esprit.entite.Joueur;
import esprit.dao.InvitationDAO;
import esprit.entite.Invitation;
import esprit.entite.Test;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FXMLMedecinController implements Initializable{

   @FXML
    private AnchorPane backgroundPane;
   
   @FXML
    private PieChart zone_stat;
    @FXML
    private ImageView optionTailleAgrandir;

    @FXML
    private ImageView optionTailleParDefaut;

    @FXML
    private AnchorPane Creation_Test;

    @FXML
    private AnchorPane inviterJoueur;

    @FXML
    private Pane pane_new_test1;

    @FXML
    private Label label_inviter_Joueurs;

    @FXML
    private TableView  tab_invitation;

    @FXML
    private TableColumn  col_id;

    @FXML
    private TableColumn col_nom;

    @FXML
    private TableColumn  col_prenom;

    @FXML
    private TableColumn col_cin;

    @FXML
    private AnchorPane ajouter_test;

    @FXML
    private Pane pane_new_test;

    @FXML
    private Label label_new_test;

    @FXML
    private TextField libelle_test;

    @FXML
    private DatePicker date_test;

    @FXML
    private AnchorPane Liste_invités;

    @FXML
    private Pane pane_liste_invité;

    @FXML
    private Label label_Liste_invités;

    @FXML
    private TableView  tab_liste_invite;

    @FXML
    private TableColumn  col_id1;

    @FXML
    private TableColumn  col_nom_invite;

    @FXML
    private TableColumn  col_prenom_invite;

    @FXML
    private TableColumn  col_cin_invite;

    @FXML
    private Button btn_test_precedent;

    @FXML
    private Button btn_test_suivant;
    
     @FXML
    private Button btn_stat;



    @FXML
    private Label titelLabel;

    @FXML
    private Button menuAjouterTest;

    @FXML
    private Button menuAfficherInvite;

    @FXML
    private Button deconnexion_medecin;
   
    
private ObservableList<Joueur> data;  
private ObservableList<Joueur> data_all;  
       
private Stage stage;
InvitationDAO idao=new InvitationDAO();
Invitation invit = new Invitation();
Joueur j = new Joueur();


/*############ ACTION Menu AjouterTest ##############*/
     @FXML
    public void MenuAjouterTestMethode(ActionEvent event) {
     System.out.println("MenuAjouterTest  cliqué");
     Creation_Test.setVisible(true);
     inviterJoueur.setVisible(false);
     ajouter_test.setVisible(true);
     btn_test_suivant.setVisible(true);
      btn_test_suivant.setDisable(false);
     btn_test_precedent.setVisible(true);
     btn_test_precedent.setDisable(true);
     Liste_invités.setVisible(false);
    
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
    
    /*############ ACTION Menu afficher invités##############*/
     @FXML
    public void menuAfficherJoueurInvitee(ActionEvent event) {
     System.out.println("menuAfficherInvités  cliqué");
    
     btn_test_suivant.setVisible(false);
   
     btn_test_precedent.setVisible(false);

     inviterJoueur.setVisible(false);
     ajouter_test.setVisible(false);
     Liste_invités.setVisible(true);
     affiche_liste_joueurs_invites();
    }  
 /*############ ACTION BOUTTON SUIVANT ##############*/
     @FXML
    public void SuivantBoutton(ActionEvent event) {
    System.out.println("BOUTTON suivant cliqué");
  
    
      if (libelle_test.getText().length()== 0 || (java.sql.Date.valueOf(date_test.getValue())== null))
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Federation Tunisienne de Tennis");
        alert.setHeaderText("");
        alert.setContentText("Attention : champs  VIDE");
        alert.showAndWait();
        }
    
  
        else 
        {
    ajouter_test.setVisible(false);
    inviterJoueur.setVisible(true);
    btn_test_precedent.setVisible(true);
    btn_test_precedent.setDisable(false);
    btn_test_suivant.setDisable(true);

                ajouter_test();
                lister_joueur_a_inviter();
        }
    }
   
     /*############ ACTION BOUTTON Precedent ##############*/
     @FXML
    public void precedentBoutton(ActionEvent event) {
     System.out.println("BOUTTON precedent cliqué");
    ajouter_test.setVisible(true);
    inviterJoueur.setVisible(false);
    btn_test_precedent.setDisable(true);
    btn_test_suivant.setDisable(false);
    btn_test_suivant.setVisible(true);

    }
    
    
    
  /*############ ACTION BOUTTON inviter ##############*/
 @FXML
    void InviterButton(ActionEvent event) {
        btn_test_precedent.setDisable(true);
        btn_test_suivant.setVisible(false);


    }
    

/*--------------------------------------------------------*/
    
private Stage getStage()
{
 return (Stage) backgroundPane.getScene().getWindow();     
}
/*#######################{ auteur : wissem }################################################*/
/*########### 3 methodes de la manipulation de la fenetre [fermerfenetre + petitefenetre + Maxfenetre ]#############*/
/*--------------------- 1 ---------------------------------------*/ 
@FXML
   private void fermerfenetre(MouseEvent event)
   {
    stage = getStage();
    stage.close();
      
   }
 /*--------------------- 2 ---------------------------------------*/
   @FXML
   private void petitefenetre(MouseEvent event)
   {
    stage = getStage();
    stage.setMaximized(false);
   }
 /*--------------------- 3 ---------------------------------------*/
    @FXML
   private void Maxfenetre(MouseEvent event)
   {
    stage = getStage();
    stage.setMaximized(true);
   }
//*****************************************************************************//   



    Test t = new Test();
    TestDAO tdao=new TestDAO();
   
    
//#######################|  ajouter_test  |######################################//
    
    private void ajouter_test() {
      
        t.setLibelletest(libelle_test.getText());
        t.setDatetest(java.sql.Date.valueOf(date_test.getValue()));
        tdao.save(t);
        System.out.println("--------- Test ajouté  ----------");
        
    }

 //########################|   lister_joueur_a_inviter   |###################################"
   public void lister_joueur_a_inviter()
   {
       try {
           col_id.setCellValueFactory(new PropertyValueFactory("idpersonne"));
           col_nom.setCellValueFactory(new PropertyValueFactory("nom"));
           col_prenom.setCellValueFactory(new PropertyValueFactory("prenom"));
           col_cin.setCellValueFactory(new PropertyValueFactory("cin"));
           System.out.println("-------- pas derreur lors de la methode lister_joueur_a_inviter  --------- ");
 } catch (Exception e) 
        { System.out.println("--------- erreur  lister_joueur_a_inviter  ---------");
       }
        
    data = FXCollections.observableArrayList();
    for (Joueur j : idao.liste_joueur_hasard())
    {
     data.add(j);
     //Inviter les joueurs au fur et à mesure **************
     invit.setIdjoueur(j.getIdpersonne());
     invit.setIdtest(tDao.id_dernier_test());
     idao.save(invit);
     idao.update(invit);
    
    }   
    
    tab_invitation.setItems(data); 
     
   
   }
   
   
   InvitationDAO invDAO = new InvitationDAO();
   TestDAO tDao = new TestDAO();
   
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("OK");
        

    }
    
    
  //########################|   afficher les joueur invités|###################################"
   public void affiche_liste_joueurs_invites()
   {
       try {
           col_id1.setCellValueFactory(new PropertyValueFactory("idpersonne"));
           col_nom_invite.setCellValueFactory(new PropertyValueFactory("nom"));
           col_prenom_invite.setCellValueFactory(new PropertyValueFactory("prenom"));
           col_cin_invite.setCellValueFactory(new PropertyValueFactory("cin"));
           System.out.println("-------- pas derreur lors de la methode affiche_liste_joueurs_invites  --------- ");
 } catch (Exception e) 
        { System.out.println("--------- erreur  affiche_liste_joueurs_invites  ---------");
       }
        
    data_all = FXCollections.observableArrayList();
    for (Joueur j : idao.getListinviteee())
    {
     data_all.add(j);  
    }   
    
    tab_liste_invite.setItems(data_all); 
 
   }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
