package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tomaszmichalik on 5/28/17.
 */
public class UserFrame extends JFrame { //maybe a singleton too
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private int counter;
    private JPanel mainPanel;
    private JTextArea inputText;
    private JLabel title;
// userFRAME object is instantiated with border layout, size, creates components of frame and
    public UserFrame(){
        super("A simulation of IM sorts");
        this.counter = 0;
        setLayout(new BorderLayout());
        createComponents();
        this.getContentPane().setBackground(new Color(110,23,245));
        this.setSize(WIDTH,HEIGHT);
        pack();
        this.setDefaultCloseOperation(UserFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }
    //checks if frame is full to create no more objects
    public boolean fullFrame(){
        if (this.counter > 3){
            return true;
        }else{
            return false;
        }
    }

    public void createComponents(){

        title = new JLabel("Admin Panel");
        //this.mainPanel = new JPanel();
        add(title,BorderLayout.NORTH);
        //add(mainPanel);

    }
    // adds a user to every available panel on border layout
    public void addPanel(UserPanel up){
        this.counter++;
        switch (counter){
            case 1:
                System.out.println("Adding user"+counter);
                getContentPane().add(up,BorderLayout.WEST);
                up.repaint();
                pack();
                revalidate();
                repaint();
                break;
            case 2:
                System.out.println("Adding user"+counter);
                add(up,BorderLayout.CENTER);
                up.repaint();
                pack();
                revalidate();
                repaint();
                break;
            case 3:
                System.out.println("Adding user"+counter);
                add(up,BorderLayout.EAST);
                up.repaint();
                pack();
                revalidate();
                repaint();
                //this.mainPanel.revalidate();
                //this.mainPanel.validate();;
                //this.repaint();
                break;
            default:
                System.out.println("You cannot add any more user obj's to this border");
                break;
        }
    }

    // add user window to the user frame, max out at 3 = EAST, MID, WEST ON BORDERLAYOUT
}
