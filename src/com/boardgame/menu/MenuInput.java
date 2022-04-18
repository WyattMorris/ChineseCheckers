package com.boardgame.menu;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import com.boardgame.Main;
import com.boardgame.menu.MenuFrame;

//Collin's method to take in mouse clicks on Menu.
public class MenuInput implements MouseListener  {

    private Main.STATE state = Main.STATE.MENU;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int xloc = e.getX();
        int yloc = e.getY();
        if(xloc >= 330 && xloc <= 480){
            if(yloc >= 230 && yloc <= 280){
                System.out.println("Clicked Play");
                state = Main.STATE.GAME;
            }
        }
        if(xloc >= 330 && xloc <= 480){
            if(yloc >= 330 && yloc <= 380){
                // rules
                System.out.println("Clicked Rules");
            }
        }
        if(xloc >= 330 && xloc <= 480){
            if(yloc >= 430 && yloc <= 480){
                // exit
                System.out.println("Clicked Exit");
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
