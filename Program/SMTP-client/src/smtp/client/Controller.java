/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import java.io.IOException;
import smtp.client.Model;
/**
 *
 * @author vlad
 */
public class Controller {
    
    private Model model;
    
    public void send(String str) throws IOException
    {
        model.getPs().println(str);
        model.getPs().println(str);      // посылка строки на SMTP
        model.getPs().flush();           // очистка буфера
        System.out.println("Java sent: " + str);
    }
 
    public void receive() throws IOException
    {
        String readstr = model.getDis().readLine();  // получение ответа от SMTP
        System.out.println("SMTP respons: " + readstr);
    }
    
    public void exitApp()
    {
        System.exit(0);
    }
    
    public void sendMessage()
    {

    }
        
}
