package com.boardgame.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.boardgame.board.GameBoard;




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
        System.out.println("xloc " + xloc);
        System.out.println("yloc "+ yloc);
        if(xloc >= 325 && xloc <= 475){
            if(yloc >= 200 && yloc <= 250){

                System.out.println("Clicked Play");
                GameBoard.myGame.getContentPane().removeAll();
                GameBoard.myGame.getContentPane().invalidate();
                GameBoard.myGame.getContentPane().add(GameBoard.players);
                GameBoard.myGame.getContentPane().revalidate();
                GameBoard.myGame.getContentPane().repaint();
            }
        }
        if(xloc >= 325 && xloc <= 475){
            if(yloc >= 300 && yloc <= 350){
                GameBoard.myGame.getContentPane().removeAll();
                GameBoard.myGame.getContentPane().invalidate();
                GameBoard.myGame.getContentPane().add(GameBoard.rules);
                GameBoard.myGame.getContentPane().revalidate();
                GameBoard.myGame.getContentPane().repaint();
                System.out.println("Clicked Rules");
            }
        }
        if(xloc >= 325 && xloc <= 475){
            if(yloc >= 400 && yloc <= 450){
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
