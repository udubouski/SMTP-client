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
import smtp.client.Controller;

/**
 *
 * @author vlad
 */
public class View extends Application{
    
    private Controller controller;
    private Scene scene;
    private Label labelFrom;
    private Label labelTo;
    private Label labelSubject;
    private Label labelInput;
    private Label labelOutput;
    private TextField fieldFrom;
    private TextField fieldTo;
    private TextField fieldSubject;
    private TextArea areaForInput;
    private TextArea areaForOutput;
    private Button btnSendMessage;
    private Button btnExit;
    private GridPane mainPane;
    private GridPane leftPane;
    private GridPane rightPane;
    private GridPane lUpPane;
    private GridPane lDownPane;
    
    @Override
    public void start(Stage primaryStage){
        
        controller = new Controller();
        labelFrom = new Label("Mail from:");
        labelTo = new Label("Mail to:");
        labelSubject = new Label("Subject:");
        labelInput = new Label("Input:");
        labelOutput = new Label("Output:");
        fieldFrom = new TextField();
        fieldTo = new TextField();
        fieldSubject = new TextField();
        areaForInput = new TextArea();
        areaForOutput = new TextArea();
        areaForInput.setPrefHeight(200);
        areaForInput.setPrefWidth(230);
        areaForOutput.setPrefHeight(278);
        areaForOutput.setPrefWidth(230);
        areaForOutput.setEditable(false);
        btnSendMessage = new Button("Send");
        btnExit = new Button("Exit");
        mainPane = new GridPane();
        leftPane = new GridPane();
        rightPane = new GridPane();
        lUpPane = new GridPane();
        lDownPane = new GridPane();
        
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
            
        scene = new Scene(mainPane);
        
        primaryStage.setTitle("SMTP client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Handling events
        btnSendMessage.setOnAction((ActionEvent e) ->{
            controller.setInputData(fieldFrom.getText(), fieldTo.getText(),
                    fieldSubject.getText(), areaForInput.getText());
            controller.sendMessage();
        });

        btnExit.setOnAction((ActionEvent e) ->{
            controller.exitApp();
        });  
    }
}
