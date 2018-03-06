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
import smtp.client.Model;
/**
 *
 * @author vlad
 */
public class Controller {
    
    private Model model= new Model();
     
    public void exitApp()
    {
        System.exit(0);
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
     
    public void createSocket()
    {
       try {  // заметка: 25 - это стандартный номер порта SMTP
            Socket smtp = null;
            smtp = new Socket("mx.yandex.ru", 25);
            model.setSmtp(smtp);
            smtp = model.getSmtp();
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
        }
        catch (IOException e)
        {
            System.out.println("Error connection: " + e);
        }
    }
    
    public void executeCommands()
    {
         try {  // скажем SMTP helo
            receive();          // получение ответа SMTP
            send(model.getHELO());
            receive();          // получение ответа SMTP
            send(model.getMAIL_FROM());    // посылка на SMTP
            receive();          // получение ответа SMTP
            send(model.getRCPT_TO());      // посылка адресату SMTP
            receive();
            send(model.getDATA());         // начинается посылка на SMTP
            receive();          // получение ответа SMTP
            send(model.getFROM());
            send(model.getSUBJECT());
            send(model.getBODY());         // посылка тела сообщения
            send(model.getEND());
            receive();
            model.getSmtp().close();      
        }
        catch (IOException e)
        {
            System.out.println("Error sending: " + e);
        }
        System.out.println("Mail sent!");
    }
    
    public void setInputData(String mailFrom,String mailTo,String subject,String data)
    {
        model.setHELO("HELO " + mailFrom);
        model.setMAIL_FROM("MAIL FROM: " + mailFrom);
        model.setRCPT_TO("RCPT TO: " + mailTo);
        model.setFROM("from: " + mailFrom);
        model.setSUBJECT("subject: " + subject);
        model.setBODY(data);
    }
    
    public void sendMessage()
    {
        createSocket();
        executeCommands();
    }
        
}
