/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import esprit.dao.ArbitreDAO;
import esprit.entite.Arbitre;

/**
 * FXML Controller class
 *
 * @author Mustapha
 */
public class FXMLModifyArbitreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    final ToggleGroup group = new ToggleGroup();
    @FXML
    RadioButton femme;
    @FXML
    RadioButton homme;
    @FXML
    Button boutonModifier;
    @FXML
    Button boutonAnnuler;
    @FXML
    Button butonTerminer;
    @FXML
    AnchorPane notification;
    @FXML
    TextField nom ;
    @FXML
    TextField prenom ;
    @FXML
    TextField adresse ;
    @FXML
    TextField login;
    @FXML
    TextField pwd;
    @FXML
    ComboBox niveau;
    @FXML
    AnchorPane body;
    @FXML
    Label label;
    static private Arbitre arbitre;
    private boolean fonctionCCsaisie()
    {
       
        
            if ( nom.getText().isEmpty() || prenom.getText().isEmpty() || login.getText().isEmpty() || pwd.getText().isEmpty() || adresse.getText().isEmpty() || niveau.getValue()==null) 
            {
                return false;
            }else
            {
                return true;
            }
            
        
    
    }
    
    
    
    @FXML
    public void modifier(MouseEvent event)
    {
//        Stage stage = (Stage) pwd.getScene().getWindow();
//        ArbitreDAO arbitreDao = new ArbitreDAO();
//        RadioButton auxButton = (RadioButton)group.getSelectedToggle();
//       
//        try
//        {
//            if (fonctionCCsaisie()){
//                 Arbitre arbitreNouveau = new Arbitre(nom.getText(),prenom.getText(),adresse.getText(),auxButton.getId(), arbitre.getCin(),pwd.getText(), login.getText(), niveau.getValue().toString());
//        
//                arbitreDao.update(arbitreNouveau);
//                notification.setStyle("-fx-background-color:#6df35f");
//                label.setText("Modification terminée !");
//                   notification.setVisible(true);
//                
//        }else{
//                 label.setText("Les champs sont invalides");
//                 notification.setStyle("-fx-background-color:#ff4c4c");
//                 notification.setVisible(true);
//                 
//            }
//            
//                notification.setVisible(true);
//                
//        }catch(Exception e)
//        {
//            notification.setStyle("-fx-background-color:#ff4c4c");
//        }
//    
//        
//        
//        //stage.hide();
    }
   static void initData(Arbitre a) {
    arbitre = a;
  }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        nom.setText(arbitre.getNom());
//        prenom.setText(arbitre.getPrenom());
//        adresse.setText(arbitre.getAdresse());
//        login.setText(arbitre.getLogin());
//        pwd.setText(arbitre.getPwd());
//       niveau.getItems().addAll("Amateur","National","International");
//       femme.setToggleGroup(group);
//       homme.setSelected(true);
//       homme.setToggleGroup(group);
        
    }    
    @FXML
    private  void terminer(MouseEvent event)
    {
        
        Stage stage = (Stage) pwd.getScene().getWindow();
        stage.hide();
    }
}
