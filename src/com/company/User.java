package com.company;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by tomaszmichalik on 5/28/17.
 */
public class User extends UserAction {
   // if time, add username and password
    public String input;
    private Stack<Message> chat;
    //  will need a producer/consumer module inside

    //connect to JMS broker at initiation, get info stored as variables

    public String getInput() {
        return input;
    }
// notes for later: create producer and consumer and test sending messages to queue and polling for results
    // then either add them within a user or create interface for users to send messages and link back to messageApp

    public User(String name){
        super(name);
        this.input = "";
        this.chat = new Stack<>();
    }
    public String userName() {
        return getName();
    }
    // if no message reciepient in header of message, then message always send to General Queue

    // observer update message, user observes changes in message chat
    public void update(String msg){
        this.input = msg;
        Message m = new Message(getName(),msg);
        System.out.println(getName() +" " + m.getMessageText());
        this.chat.push(m);

        sendMessage(getName()+" : "+msg); // can add who its from or get the header information
        System.out.println("Messags: " + this.chat);
    }
// getter for arraylist of conversation
    public Stack<Message> getChat() {
        return this.chat;
    }



    public void sendMessage(String msg){
        //send via producer
    }
    //every string in array should be "header info:: text here" +\n for each row of text
//create method extracts user message and adds to chatdialog - maybne in interface for user?
}
