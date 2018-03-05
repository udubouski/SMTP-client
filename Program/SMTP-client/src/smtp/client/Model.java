/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

/**
 *
 * @author vlad
 */

public class Model {
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
        HELO = "HELO";
        MAIL_FROM = "MAIL FROM:";
        RCPT_TO = "RCPT TO:";
        DATA = "DATA";   
        FROM = "from:";
        SUBJECT = "subject:";
        BODY ="";
        END = ".";
    }
    
    public void setHELO(String str)
    {
        HELO=str;
    }
    
}


