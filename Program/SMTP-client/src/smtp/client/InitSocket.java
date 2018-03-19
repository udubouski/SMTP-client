/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author vlad
 */
public class InitSocket {
    private String ipAddress;
    private Integer numberPort;
    private Socket smtp;
    
    public InitSocket()
    {
        ipAddress = "mx.yandex.ru";
        numberPort = 25;
        smtp=null;
    }
    
    public void createSocket() throws IOException
    {
        smtp = new Socket(ipAddress,numberPort);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getNumberPort() {
        return numberPort;
    }

    public void setNumberPort(Integer numberPort) {
        this.numberPort = numberPort;
    }

    public Socket getSmtp() {
        return smtp;
    }

    public void setSmtp(Socket smtp) {
        this.smtp = smtp;
    }
    
}
