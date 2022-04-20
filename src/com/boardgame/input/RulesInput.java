package com.boardgame.input;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import com.boardgame.board.GameBoard;


//Collin's method to take in mouse clicks on Rules Page.
public class RulesInput implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int xloc = e.getX();
        int yloc = e.getY();
        if(xloc >= 290 && xloc <= 700){
            if(yloc >= 675 && yloc <= 725){
                GameBoard.myGame.getContentPane().removeAll();
                GameBoard.myGame.getContentPane().invalidate();
                GameBoard.myGame.getContentPane().add(GameBoard.menu);
                GameBoard.myGame.getContentPane().revalidate();
                GameBoard.myGame.getContentPane().repaint();

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
