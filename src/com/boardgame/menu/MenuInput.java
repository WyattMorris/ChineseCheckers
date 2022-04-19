package com.boardgame.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import com.boardgame.Main;
import com.boardgame.board.GameBoard;
import com.boardgame.menu.MenuFrame;



//Collin's method to take in mouse clicks on Menu.
public class MenuInput implements MouseListener, ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int xloc = e.getX();
        int yloc = e.getY();
        if(xloc >= 330 && xloc <= 480){
            if(yloc >= 230 && yloc <= 280){
                System.out.println("Clicked Play");
                GameBoard.myGame.getContentPane().removeAll();
                GameBoard.myGame.getContentPane().invalidate();
                GameBoard.myGame.getContentPane().add(GameBoard.board);
                GameBoard.myGame.getContentPane().revalidate();
                GameBoard.myGame.getContentPane().repaint();
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
