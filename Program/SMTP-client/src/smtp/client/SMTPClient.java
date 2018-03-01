/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import java.awt.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author vlad
 */
public class SMTPClient extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label labelFrom = new Label("Mail from:");
        Label labelTo = new Label("Mail to:");
        Label labelSubject = new Label("Subject:");
        TextField fieldFrom = new TextField();
        TextField fieldTo = new TextField();
        TextField fieldSubject = new TextField();
        TextArea areaForInput = new TextArea();
        areaForInput.setPrefHeight(200);
        areaForInput.setPrefWidth(230);
        TextArea areaForTrace = new TextArea();
        areaForTrace.setEditable(false);
        Button btnSendMessage = new Button("Send");
        Button exit = new Button("Exit");
        GridPane mainPane = new GridPane();
        GridPane upPane = new GridPane();
        GridPane downPane = new GridPane();
        
        //Group of labels
        upPane.add(labelFrom, 0, 0);
        upPane.add(labelTo, 0, 1);
        upPane.add(labelSubject, 0, 2);
         
        //Group of fields
        upPane.add(fieldFrom, 1, 0);
        upPane.add(fieldTo, 1, 1);
        upPane.add(fieldSubject, 1, 2);
        downPane.add(btnSendMessage, 0, 0);
        downPane.add(exit,1,0);
        mainPane.add(upPane,0,0);
        mainPane.add(areaForInput, 0, 1);
        mainPane.add(downPane,0,2);
        
        
        
        Scene scene = new Scene(mainPane);
        
        primaryStage.setTitle("SMTP client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }



    /*private void receive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
}
