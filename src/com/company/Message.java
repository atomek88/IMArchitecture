package com.company;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tomaszmichalik on 5/29/17.
 */
public class Message {
    private String sender;
    private String timestamp;
    private static int  MSGNBR = 1000;
    private int seqNbr;
    private String timeReceived;
    private String messageText;

    public Message(String a, String b){
        this.sender = "User: "+a+" : ";
        this.messageText = b;
        this.seqNbr = MSGNBR;
        MSGNBR++;

    }
    public void setTimeStamp(){
        this.timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public int getSeqNbr() {
        return seqNbr;
    }

    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }

    public void setRecTime(){
        this.timeReceived = new SimpleDateFormat("yyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTimeReceived() {
        return timeReceived;
    }

    public String getSender() {
        return sender;
    }


    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
