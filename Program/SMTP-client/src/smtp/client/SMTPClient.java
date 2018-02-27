/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
        TextArea areaForLogs = new TextArea();
        areaForLogs.setEditable(false);
        Button btnSendMessage = new Button("Send");
        Button exit = new Button("Exit");
        
        GridPane pane = new GridPane();
        
        
        
        

        
        btnSendMessage.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
                
        StackPane root = new StackPane();
        root.getChildren().add(btnSendMessage);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
