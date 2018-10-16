package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //instantiate an admin
        MessagingApp ms = new MessagingApp();

        //admin can create 2 + users, application shoudl open ui window showing user chat screens and extra pane for pics
        ms.getAdmin().addUI();
        //from CL - admin can send the topic queue to user, or user can request
        ms.addUser("Tom");
        ms.addUser("Mallory");
        ms.addUser("Eve");
        ms.addUser("Trudy");
        ms.addUser("Mellow");
        // user can send a message to queue... is it addressed to anyone? maybe, once a responder listens and pulls it they open their own queue
        System.out.println(ms.getAllUsers());

    }
}
