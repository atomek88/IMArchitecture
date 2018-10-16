package com.company;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by tomaszmichalik on 5/28/17.
 */
public class Administrator {
    private UserFrame mainFrame;
    private static Administrator admin = null;
    private ArrayList<User> userpool = new ArrayList<>();
    //connect to JMS broker at initiation, get info stored as variables

    //admnistrator is like controller class in MVC, maybe singleton
    // should admin have facade to interact with User Frame?

    //default constructor
    public Administrator(){}
    //adds UI frame to application view and admin object
    public void addUI(){
        this.mainFrame = new UserFrame();
    }
    //singleton implementation of the Administrator class
    public static Administrator getInstance(){
        if (admin == null){
            admin = new Administrator();
        }
        return admin;
    }

    public void update(){} // method updates the user frame

    // method addUser takes string and create a user, adds to mainFrame if open of 3 slots
    public void addUser(User user){
        userpool.add(user);
        if (!mainFrame.fullFrame()) {UserPanel up = new UserPanel(user,user.getName());
            mainFrame.addPanel(up);
        }
    }
    //admin function for setting a user to the last part of border to test and see functionality
    public void SetUser(String s){
        for (User a : userpool){
            if (a.getName() == s){UserPanel up = new UserPanel(a,s);
                mainFrame.addPanel(up);
            }
        }

    }
    //delete user operation, destroys chat, user info and queue links?
    //may include an inputStream with commands - admin can send messages with user etc.

}
