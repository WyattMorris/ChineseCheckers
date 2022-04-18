package com.boardgame.rules;

import com.boardgame.rules.Rules;

import javax.swing.*;
import java.awt.*;

//Collin's frame to hold menus or game.
public class RulesFrame extends JFrame {
    JLabel bg;
    JLabel title;
    Container con;
    Rules rules;


    private JDesktopPane desktop;


    public RulesFrame() {
        super("Rules");
        desktop = new JDesktopPane();
        ImageIcon img = new ImageIcon("src\\images\\pexels-photo-326333.jpeg");
        rules = new Rules();
        bg = new JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(img.getImage(), 0, 0, null);
                super.paintComponent(g);
                rules.render(g);
            }
        };


        bg.setBounds(0,0,800,800);
        desktop.add(bg);
        add(desktop);
        setVisible(true);
    }

}

