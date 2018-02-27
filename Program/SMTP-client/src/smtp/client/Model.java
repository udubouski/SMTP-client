/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author vlad
 */
/*
public class Model {
        static PrintStream ps = null;          // посылка сообщений
        static DataInputStream dis = null;     // получение сообщений
        String HELO = "HELO bsuir.com";
        String MAIL_FROM = "MAIL FROM: user@bsuir.com";
        String RCPT_TO = "RCPT TO: dub4ik06@yandex.ru";
        String DATA = "DATA";    // начало сообщения
        String FROM = "user@bsuir.com";
        String SUBJECT = "subject: SMTP message";
        String BODY = "Hello my friend! Java sent this!";
        String END = ".";
 
        Socket smtp = null;     // сокет SMTP
 
       // try {  //  25 - это стандартный номер порта SMTP
            smtp = new Socket("mx.yandex.ru", 25);
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
      //  }
       /* catch (IOException e)
        {
            System.out.println("Error connection: " + e);
        }
      //  try {  // скажем SMTP helo
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
        //}
        catch (IOException e)
        {
            System.out.println("Error sending: " + e);
        }
        System.out.println("Mail sent!");
}
*/