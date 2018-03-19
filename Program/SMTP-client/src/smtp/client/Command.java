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
import smtp.client.Request;
import smtp.client.Message;
import smtp.client.InitSocket;

/**
 *
 * @author vlad
 */

public class Command {
    
    private Request request;
    private InitSocket socket;
    private PrintStream ps;          
    private DataInputStream dis; 
    private String text;
         
    public Command()
    {
        ps = null; 
        dis = null;
        text= "";
        request = new Request();
        socket = new InitSocket();
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
    
    public String getMsg()
    {
        return text;
    }
    
    public void initialiseSocket()
    {
       try {  
            socket.createSocket();
            OutputStream os = socket.getSmtp().getOutputStream();
            ps = new PrintStream(os);
            InputStream is = socket.getSmtp().getInputStream();
            dis = new DataInputStream(is);
        }
        catch (IOException e)
        {
            text+="Error connection: " + e + "\n";
        }
    }
    
    public void executeRequest()
    {
         try {  
            receive();          
            send(request.getHELO());
            receive();          
            send(request.getMAIL_FROM());    
            receive();          
            send(request.getRCPT_TO());      
            receive();
            send(request.getDATA());         
            receive();          
            send(request.getFROM());
            send(request.getSUBJECT());
            send(request.getBODY());         
            send(request.getEND());
            receive();
            socket.getSmtp().close();
        }
        catch (IOException e)
        {
            text+="Error sending: " + e + "\n";
        }
        text+="Mail sent!\n\n";
    }
    
    public void setRequest(Message message)
    {
        request.setHELO("HELO " + message.getMsgFromSmb().split("@")[1]);
        request.setMAIL_FROM("MAIL FROM: " + message.getMsgFromSmb());
        request.setRCPT_TO("RCPT TO: " + message.getMsgToSmb());
        request.setFROM("from: " + message.getMsgFromSmb());
        request.setSUBJECT("subject: " + message.getSubject() + "\n\n");
        request.setBODY(message.getMsgData());
    }

    public void sendMessage()
    {
        initialiseSocket();
        executeRequest();
    }
}
