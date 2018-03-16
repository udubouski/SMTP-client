/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp.client;

import javafx.scene.control.TextArea;

/**
 *
 * @author vlad
 */
public class Message {
    
    private String msgFromSmb;
    private String msgToSmb;
    private String subject;
    private String msgData;
    
    public Message()
    {
        msgFromSmb="";
        msgToSmb="";
        subject="";
        msgData = "";
    }
    
    public void setValueMsg(String strFromSmb, String strToSmb, 
            String strSubject, String strMsgData)
    {
        this.msgFromSmb = strFromSmb;
        this.msgToSmb = strToSmb;
        this.subject = strSubject;
        this.msgData = strMsgData;
    }

    public String getMsgFromSmb() {
        return msgFromSmb;
    }

    public String getMsgToSmb() {
        return msgToSmb;
    }

    public String getSubject() {
        return subject;
    }

    public String getMsgData() {
        return msgData;
    }
}
