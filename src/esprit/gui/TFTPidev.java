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

/**
 *
 * @author yasmi
 */
public class TFTPidev extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ChoixEspace.fxml"));
        //chams gitlab w doctour ya doctour;
        Scene scene = new Scene(root);
        System.out.println("bbbbb");
        stage.setScene(scene);
        stage.show();
    }
    //test wissem gitlab 16/02/2016 19:50 :)

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
