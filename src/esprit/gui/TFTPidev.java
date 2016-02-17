/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gui;

import javafx.application.Application;
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
        
        Scene scene = new Scene(root);
        
        // Activer cette ligne pour afficher l'interface d'espace Administrateur
        //scene.setRoot(rootAdmin);
        
        stage.setMaximized(true);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
