/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author yasmi
 */
public class TFTPidev extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("responsable/FXMLResponsable.fxml"));
        Parent rootAdmin = FXMLLoader.load(getClass().getResource("admin/FXMLAdmin.fxml"));
        Parent rootAuth = FXMLLoader.load(getClass().getResource("authentification/FXMLauthentificationv2.fxml"));
        Parent rootMedecin = FXMLLoader.load(getClass().getResource("medecin/FXMLMedecin.fxml"));
        Scene scene = new Scene(root);
        //Scene sceneMedecin = new Scene(rootMedecin);
        
        scene.setRoot(rootAdmin);
        
        //stage.setMaximized(true);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
     
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
