package com.boardgame.menu;

import com.boardgame.Main;
import com.boardgame.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Collin's frame to hold menus or game.
public class MenuFrame extends JFrame {
    JLabel bg;
    JLabel title;
    Container con;
    Menu menu;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screen = tk.getScreenSize();

    private JDesktopPane desktop;


    public MenuFrame() {
        super("Chinese Checkers");
        desktop = new JDesktopPane();
        ImageIcon img = new ImageIcon("src\\images\\pexels-photo-326333.jpeg");
        menu = new Menu();
        bg = new JLabel(){
            public void paintComponent(Graphics g){
                g.drawImage(img.getImage(), 0, 0, null);
                super.paintComponent(g);
                menu.render(g);
            }
        };


        bg.setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight());
        desktop.add(bg);
        add(desktop);
        setVisible(true);
    }

}


