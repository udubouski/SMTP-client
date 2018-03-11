/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author vlad
 */

public class Model {
    
    private Socket smtp;
    private String HELO;
    private String MAIL_FROM;
    private String RCPT_TO;
    private String DATA;    
    private String FROM;
    private String SUBJECT;
    private String BODY;
    private String END;
    
    public Model()
    {
        smtp = null; 
        HELO = "HELO ";
        MAIL_FROM = "MAIL FROM: ";
        RCPT_TO = "RCPT TO: ";
        DATA = "DATA ";   
        FROM = "FROM: ";
        SUBJECT = "SUBJECT: ";
        BODY ="";
        END = ".";
    }

    public Socket getSmtp() {
        return smtp;
    }

    public void setSmtp(Socket smtp) {
        this.smtp = smtp;
    }

    public String getHELO() {
        return HELO;
    }

    public void setHELO(String HELO) {
        this.HELO = HELO;
    }

    public String getMAIL_FROM() {
        return MAIL_FROM;
    }

    public void setMAIL_FROM(String MAIL_FROM) {
        this.MAIL_FROM = MAIL_FROM;
    }

    public String getRCPT_TO() {
        return RCPT_TO;
    }

    public void setRCPT_TO(String RCPT_TO) {
        this.RCPT_TO = RCPT_TO;
    }

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    public String getFROM() {
        return FROM;
    }

    public void setFROM(String FROM) {
        this.FROM = FROM;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

    public String getBODY() {
        return BODY;
    }

    public void setBODY(String BODY) {
        this.BODY = BODY;
    }

    public String getEND() {
        return END;
    }

    public void setEND(String END) {
        this.END = END;
    } 
}


