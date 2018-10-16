package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tomaszmichalik on 5/28/17. Decided to tightly couple the user and their userPanel
 */
public class UserPanel extends JPanel implements UIPanel {
    private JButton send;
    private User user;
    private JButton delete;
    private JTextArea chatArea;
    private JTextField sendText;
    private String input = "";
    private JLabel pic; // set to pic later
    private JLabel name;
    public ArrayList<String> chatDialog = new ArrayList<>();

    private JLabel other;// gets name of user that is chatting with
    //public Point location;

    public UserPanel(User a,String name){
        this.user = a;
        attach(this.user);
        setLayout(new BorderLayout());
        this.name = new JLabel(name+"'s panel");
        add(this.name, BorderLayout.NORTH);
        final int WIDTH1 = 20;
        final int HEIGHT1 = 20;
        chatArea = new JTextArea(WIDTH1,HEIGHT1);
        chatArea.setEditable(false);
        sendText = new JTextField(WIDTH1);
        sendText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendText.setText("");
                input = "";
            }
        });
        sendText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode==KeyEvent.VK_ENTER){
                    consumeTextUpdate();
                        // hit send
                    }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });


        sendText.setText("Write message here..");
        send = new JButton("Send");
        send.addActionListener(new SendButtonListener());
        //delete = new JButton("Delete"); -= add later
        //creates listener object here
        //jpanel set to x non image imageicon
        add(chatArea, BorderLayout.CENTER);
        JPanel p = new JPanel();
        //p.setLayout(new FlowLayout());
        p.add(sendText);
        p.add(send);
        add(p, BorderLayout.SOUTH);

    }
    //different implementation of send message, to get string message out of panel and send thru channels
    public void attach(User u){this.user = u;}
    public void detach(User u){this.user = null;}
    // update here or maybe a visitor to update the ui..
    class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            consumeTextUpdate();
        }
    }

    public void consumeTextUpdate(){
        input = sendText.getText();
        System.out.println(input);
        //update observer
        updateUser();
        getLastMessage();
        //chatDialog.add(user.getInput());
        updateDialog();
        revalidate();
        repaint();
    }
    //observe chagnes to this state - updates user from UIPANEL interface to send updated input to user object
    public void updateUser(){
        user.update(input);
    }
    // check how fast refreshes chat doing it this way. UpdateDialog takes arraylist from conversation and prints to textarea
    public void updateDialog(){
        this.chatArea.setText("");
        for (String s : chatDialog){
            chatArea.append(s+"\n");
        }
    }
    // grabs last message from the User objects to add it to its arraylist for chat dialog
    public void getLastMessage(){
        Message m = user.getChat().peek();
        String a = m.getSender();
        String b = m.getTimestamp();
        String c = m.getMessageText();
        int x = m.getSeqNbr();
        String abc = a + " ("+b+";"+x+") "+c;
        System.out.println(abc);
        chatDialog.add(abc);
    }
    // translateFromStack, gets Entire stack of messages from User object and parses for all
    public void translateFromStack(Stack<Message> convo){
        this.chatDialog.clear();
        ArrayList<String> temp = new ArrayList<>();
        while (!convo.isEmpty()){
            Message m = convo.pop();
            String a = m.getSender();
            String b = m.getTimestamp();
            String c = m.getMessageText();
            int x = m.getSeqNbr();
            String abc = a + " ("+b+";"+x+") "+c;
            System.out.println(abc);  // print test
            temp.add(abc);
        }
        this.chatDialog = temp;
        System.out.println(this.chatDialog); //print test
    }
}
