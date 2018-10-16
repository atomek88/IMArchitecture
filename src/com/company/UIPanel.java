package com.company;

/**
 * Created by tomaszmichalik on 5/29/17. UserPanel interface for attaching observer and updating users
 */
public interface UIPanel {
    void attach(User a);
    void detach(User a);
    //update User object with the state
    void updateUser();
}
