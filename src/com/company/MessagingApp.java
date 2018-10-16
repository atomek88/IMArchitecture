package com.company;
import java.util.ArrayList;

/**
 * Created by tomaszmichalik on 5/29/17.
 */
public class MessagingApp {

    private Administrator admin;
    private ArrayList<User> allUsers;

    public MessagingApp(){
        this.admin = new Administrator();
        this.allUsers = new ArrayList<>();

    }
    public Administrator getAdmin() {
        return admin;
    }
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    // adds users to the messaging app service
    public void addUser(String a){
        User b = new User(a);
        allUsers.add(b);
        admin.addUser(b);
    }
}
