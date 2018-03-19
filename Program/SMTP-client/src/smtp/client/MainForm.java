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

/**
 *
 * @author vlad
 */
public class MainForm extends Application{
    
    private Command controller;
    private Message message;
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
        
        controller = new Command();
        message = new Message();
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
        areaForInput.setPrefHeight(250);
        areaForInput.setPrefWidth(230);
        areaForOutput.setPrefHeight(328);
        areaForOutput.setPrefWidth(700);
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
        leftPane.add(labelInput,0,1);
        rightPane.add(labelOutput, 0, 0);
        
        //Group of fields
        lUpPane.add(fieldFrom, 1, 0);
        lUpPane.add(fieldTo, 1, 1);
        lUpPane.add(fieldSubject, 1, 2);
        lDownPane.add(btnSendMessage, 0, 0);
        lDownPane.add(btnExit,1,0);
        leftPane.add(lUpPane,0,0);
        leftPane.add(areaForInput, 0, 2);
        leftPane.add(lDownPane,0,3);
        rightPane.add(areaForOutput, 0, 1);
        mainPane.add(leftPane,0,0);
        mainPane.add(rightPane,1,0);
            
        scene = new Scene(mainPane);
        
        primaryStage.setTitle("SMTP client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Handling events
        btnSendMessage.setOnAction((ActionEvent e) ->{
            initiateMessage();
            execute();
            outputLog();
        });
        
        btnExit.setOnAction((ActionEvent e) ->{
            System.exit(0);
        });  
    }
    
    public void initiateMessage()
    {
        message.setValueMsg(fieldFrom.getText(), fieldTo.getText(),
                    fieldSubject.getText(), areaForInput.getText());
    }
    
    public void outputLog()
    {
        areaForOutput.setText(controller.getMsg());
    }
    
    public void execute()
    {
        controller.setRequest(message);
        controller.sendMessage();
    }
}
