/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author vlad
 */
public class SMTPClient extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!:");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
     static PrintStream ps = null;          // посылка сообщений
    static DataInputStream dis = null;     // получение сообщений
 
    public static void send(String str) throws IOException
    {
        ps.println(str);      // посылка строки на SMTP
        ps.flush();           // очистка буфера
        System.out.println("Java sent: " + str);
    }
 
    public static void receive() throws IOException
    {
        String readstr = dis.readLine();  // получение ответа от SMTP
        System.out.println("SMTP respons: " + readstr);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
 String HELO = "HELO gazprom.ru ";
        String MAIL_FROM = "MAIL FROM: user@gazprom.ru";
        String RCPT_TO = "RCPT TO: dub4ik06@yandex.ru";
        String DATA = "DATA";    // начало сообщения
        String FROM = "from: user@gazprom.ru";
        String SUBJECT = "subject: tema ebat kopat";
        String BODY = "Hello my friend! Java sent this!";
        String END = ".";
 
        Socket smtp = null;     // сокет SMTP
 
        try {  // заметка: 25 - это стандартный номер порта SMTP
            smtp = new Socket("mx.yandex.ru", 25);
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
        }
        catch (IOException e)
        {
            System.out.println("Error connection: " + e);
        }
        try {  // скажем SMTP helo
            receive();          // получение ответа SMTP
            send(HELO);
            receive();          // получение ответа SMTP
            send(MAIL_FROM);    // посылка на SMTP
            receive();          // получение ответа SMTP
            send(RCPT_TO);      // посылка адресату SMTP
            receive();
            send(DATA);         // начинается посылка на SMTP
            receive();          // получение ответа SMTP
            send(FROM);
            send(SUBJECT);
            send(BODY);         // посылка тела сообщения
            send(END);
            receive();
            smtp.close();      
        }
        catch (IOException e)
        {
            System.out.println("Error sending: " + e);
        }
        System.out.println("Mail sent!");
    }



    /*private void receive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
}
