package com.boardgame.input;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.boardgame.board.GameBoard;


import static com.boardgame.board.GameBoard.initializeCoordinates;
import static com.boardgame.board.GameBoard.initializePieces;
import static java.awt.Color.*;

//Collin's method to take in mouse clicks on Rules Page.
public class PlayersInput implements MouseListener  {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

        //g.drawRect(100, 250, 100, 100);
        //g.drawRect(250, 250, 100, 100);
        //g.drawRect(400, 250, 100, 100);
        //g.drawRect(175, 400, 100, 100);
        //g.drawRect(325, 400, 100, 100);
        //g.drawRect(475, 400, 100, 100);
        int xloc = e.getX();
        int yloc = e.getY();
        if(xloc >= 250 && xloc <= 350){
            if(yloc >= 250 && yloc <= 350){
                GameBoard.playerCount = 2;
                GameBoard.turnColor = RED;
                initialize();
            }
        }
        if(xloc >= 400 && xloc <= 500){
            if(yloc >= 250 && yloc <= 350){
                GameBoard.playerCount = 3;
                GameBoard.turnColor = GREEN; // this can probably be a random between the three
                initialize();
            }
        }
        if(xloc >= 250 && xloc <= 350){
            if(yloc >= 400 && yloc <= 500){
                GameBoard.playerCount = 4;
                GameBoard.turnColor = WHITE;
                initialize();
            }
        }
        if(xloc >= 400 && xloc <= 500){
            if(yloc >= 400 && yloc <= 500){
                GameBoard.playerCount = 6;
                GameBoard.turnColor = RED;
                initialize();
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

    public void initialize(){
        initializeCoordinates();
        initializePieces();
        GameBoard.myGame.getContentPane().removeAll();
        GameBoard.myGame.getContentPane().invalidate();
        GameBoard.myGame.getContentPane().add(GameBoard.board);
        GameBoard.myGame.getContentPane().revalidate();
        GameBoard.myGame.getContentPane().repaint();
    }
}
