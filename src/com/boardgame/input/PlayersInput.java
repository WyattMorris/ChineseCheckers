package com.boardgame.input;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import com.boardgame.board.GameBoard;


import static com.boardgame.board.GameBoard.initializeCoordinates;
import static com.boardgame.board.GameBoard.initializePieces;
import static java.awt.Color.*;


public class PlayersInput implements MouseListener  {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int xloc = e.getX();
        int yloc = e.getY();
        if(xloc >= 250 && xloc <= 350){
            if(yloc >= 250 && yloc <= 350){
                GameBoard.playerCount = 2;
                int num = diceRoll(2);
                if(num == 0) {
                    GameBoard.turnColor = RED;
                } else GameBoard.turnColor = GREEN;
                initialize();
            }
        }
        if(xloc >= 400 && xloc <= 500){
            if(yloc >= 250 && yloc <= 350){
                GameBoard.playerCount = 3;
                int num = diceRoll(3);
                if(num ==0) {
                    GameBoard.turnColor = GREEN;
                }
                else if(num == 1){
                    GameBoard.turnColor = BLACK;
                }else
                GameBoard.turnColor = YELLOW;
                initialize();
            }
        }
        if(xloc >= 250 && xloc <= 350){
            if(yloc >= 400 && yloc <= 500){
                GameBoard.playerCount = 4;
                int num = diceRoll(4);
                if(num ==0) {
                    GameBoard.turnColor = WHITE;
                }
                else if(num ==1) {
                    GameBoard.turnColor = BLUE;
                }
                else if(num == 2){
                    GameBoard.turnColor = BLACK;
                }else
                    GameBoard.turnColor = YELLOW;
                initialize();
            }
        }
        if(xloc >= 400 && xloc <= 500){
            if(yloc >= 400 && yloc <= 500){
                GameBoard.playerCount = 6;
                int num = diceRoll(4);
                if(num ==0) {
                    GameBoard.turnColor = RED;
                }
                else if(num ==1) {
                    GameBoard.turnColor = YELLOW;
                }
                else if(num == 2){
                    GameBoard.turnColor = WHITE;
                }
                else if(num == 3){
                    GameBoard.turnColor = GREEN;
                }
                else if(num == 4){
                    GameBoard.turnColor = BLUE;
                }else
                    GameBoard.turnColor = BLACK;
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

    public int diceRoll(int i){
        Random rand = new Random();
        return rand.nextInt(i);
    }
}
