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
    private PrintStream ps = null;          
    private DataInputStream dis = null; 
    private Socket smtp = null;;    
    private String text="";
     
    public void exitApp()
    {
        System.exit(0);
    }
    
    public String getMsg()
    {
        return text;
    }
    
    public void send(String str) 
    {
        ps.println(str);      
        ps.flush();           
        text+=str+"\n";
    }
 
    public  void receive() throws IOException
    {
        String readstr = dis.readLine();
        text+=readstr+"\n";
    }
     
    public void createSocket()
    {
       try {  
            smtp = new Socket("mx.yandex.ru", 25);
            OutputStream os = smtp.getOutputStream();
            ps = new PrintStream(os);
            InputStream is = smtp.getInputStream();
            dis = new DataInputStream(is);
        }
        catch (IOException e)
        {
            text+="Error connection: " + e + "\n";
        }
    }
    
    public void executeCommands()
    {
         try {  
            receive();          
            send(model.getHELO());
            receive();          
            send(model.getMAIL_FROM());    
            receive();          
            send(model.getRCPT_TO());      
            receive();
            send(model.getDATA());         
            receive();          
            send(model.getFROM());
            send(model.getSUBJECT());
            send(model.getBODY());         
            send(model.getEND());
            receive();
            smtp.close();
        }
        catch (IOException e)
        {
            text+="Error sending: " + e + "\n";
        }
        text+="Mail sent!\n\n";
    }
    
    public void setInputData(String mailFrom,String mailTo,String subject,String data)
    {
        model.setHELO("HELO " + mailFrom.split("@")[1]);
        //model.setHELO("HELO " + mailFrom);
        model.setMAIL_FROM("MAIL FROM: " + mailFrom);
        model.setRCPT_TO("RCPT TO: " + mailTo);
        model.setFROM("from: " + mailFrom);
        model.setSUBJECT("subject: " + subject + "\n\n");
        model.setBODY(data);
    }

    public void sendMessage()
    {
        createSocket();
        executeCommands();
    }
}
