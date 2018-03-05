/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import smtp.client.Model;


/**
 *
 * @author vlad
 */
public class SMTPClient extends Application {
    
    private Model model;
    
    @Override
    public void start(Stage primaryStage) {
        
        Label labelFrom = new Label("Mail from:");
        Label labelTo = new Label("Mail to:");
        Label labelSubject = new Label("Subject:");
        Label labelInput = new Label("Input:");
        Label labelOutput = new Label("Output:");
        TextField fieldFrom = new TextField();
        TextField fieldTo = new TextField();
        TextField fieldSubject = new TextField();
        TextArea areaForInput = new TextArea();
        TextArea areaForOutput = new TextArea();
        areaForInput.setPrefHeight(200);
        areaForInput.setPrefWidth(230);
        areaForOutput.setPrefHeight(278);
        areaForOutput.setPrefWidth(230);
        areaForOutput.setEditable(false);
        Button btnSendMessage = new Button("Send");
        Button btnExit = new Button("Exit");
        GridPane mainPane = new GridPane();
        GridPane leftPane = new GridPane();
        GridPane rightPane = new GridPane();
        GridPane lUpPane = new GridPane();
        GridPane lDownPane = new GridPane();
        
        //Group of labels
        lUpPane.add(labelFrom, 0, 0);
        lUpPane.add(labelTo, 0, 1);
        lUpPane.add(labelSubject, 0, 2);
         
        //Group of fields
        lUpPane.add(fieldFrom, 1, 0);
        lUpPane.add(fieldTo, 1, 1);
        lUpPane.add(fieldSubject, 1, 2);
        lDownPane.add(btnSendMessage, 0, 0);
        lDownPane.add(btnExit,1,0);
        leftPane.add(lUpPane,0,0);
        leftPane.add(labelInput,0,1);
        leftPane.add(areaForInput, 0, 2);
        leftPane.add(lDownPane,0,3);
        rightPane.add(labelOutput, 0, 0);
        rightPane.add(areaForOutput, 0, 1);
        mainPane.add(leftPane,0,0);
        mainPane.add(rightPane,1,0);
        
        
        Scene scene = new Scene(mainPane);
        
        primaryStage.setTitle("SMTP client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //
                
        btnExit.setOnAction((ActionEvent e) ->{
            System.exit(0);
        });
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}
