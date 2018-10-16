package com.company;


/**
 * Created by tomaszmichalik on 5/28/17. Interface for userAction, part of observer(User) pattern to update state when messages are consumed/sent
 */
public abstract class UserAction {
    private String name;

    public UserAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //send message
    abstract void sendMessage(String s);
    //updates user observer object
    abstract void update(String s);

    //listen to queue for reply
}
