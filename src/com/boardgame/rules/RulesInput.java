package com.boardgame.rules;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import com.boardgame.Main;
import com.boardgame.board.GameBoard;
import com.boardgame.menu.MenuFrame;

//Collin's method to take in mouse clicks on Rules Page.
public class RulesInput implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        //public Rectangle menuBtn = new Rectangle(290, 675, 250, 50);
        int xloc = e.getX();
        int yloc = e.getY();
        System.out.println(xloc);
        System.out.println(yloc);
        if(xloc >= 290 && xloc <= 700){
            if(yloc >= 675 && yloc <= 725){
                // Menu
                GameBoard.myGame.getContentPane().removeAll();
                GameBoard.myGame.getContentPane().invalidate();
                GameBoard.myGame.getContentPane().add(GameBoard.menu);
                GameBoard.myGame.getContentPane().revalidate();
                GameBoard.myGame.getContentPane().repaint();
                System.out.println("Return to Menu");
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
