package com.boardgame.board;

/*
Author: Wyatt Morris
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import javax.swing.*;


import static java.awt.Color.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameBoard {
    private static final int BoardSize = 25;
    private static final int[] rowWidth = {1,2,3,4,13,12,11,10,9,10,11,12,13,4,3,2,1};
    private static final int[] rowSpaces = {6,5,5,4,0,0,1,1,2,1,1,0,0,4,5,5,6};
    private static final LinkedList<Coordinates> myCoordinates = new LinkedList<>();
    private static final LinkedList<Piece> myList = new LinkedList<>();

    public static Piece selectedPiece = null;
    public static int playerCount = 6;

    public static void main() {
        JFrame myGame = new JFrame("Chinese Checkers");
        initializeCoordinates();
        initializePieces();
        Board board = new Board();
        board.setBackground(lightGray);
        myGame.add(board);
        myGame.setSize(800, 800);
        myGame.setVisible(true);
        board.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(selectedPiece == null){
                    for(Piece p : myList){
                        if (p.piece.contains(e.getPoint()) && p.color != gray) {
                            selectedPiece = p;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedPiece != null) {
                    boolean moveSuccess = false;
                    for(Piece p: myList){
                        if(p.piece.contains(e.getPoint())){
                            if(p.color != selectedPiece.color){
                                moveSuccess = true;
                                p.color = selectedPiece.color;
                            }
                            board.repaint();

                        } else {
                            selectedPiece.x = selectedPiece.xLast;
                            selectedPiece.y = selectedPiece.yLast;
                            board.repaint();
                        }
                    }
                    if(moveSuccess){
                        selectedPiece.color = gray;
                    }

                    selectedPiece = null;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        board.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece != null){
                    selectedPiece.x = e.getX() - 16;
                    selectedPiece.y = e.getY() - 16;
                    board.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        myGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void initializeCoordinates(){
        int squareSide;
        squareSide = 32;
        int k = 1;
        int offset;
        for(int i = 0; i < rowSpaces.length; i++){
            for(int j = 0; j < rowWidth[i]; j++){
                //Calculate the offset
                if(rowWidth[i] % 2 == 0){
                    offset = squareSide / 2;
                } else {
                    offset = 0;
                }
                myCoordinates.add(new Coordinates((int) (rowSpaces[i] *squareSide + squareSide*j + offset + squareSide*BoardSize/4.5), (k * squareSide + squareSide*BoardSize/12)));
            }
            k++;
        }
    }

    public static void initializePieces(){
        int squareSide;
        squareSide = 32;
        int x;
        int y;
        Color p1Color = gray;
        Color p2Color = gray;
        Color p3Color = gray;
        Color p4Color = gray;
        Color p5Color = gray;
        Color p6Color = gray;

        switch(playerCount){
            case 6: {
                p1Color = red;
                p2Color = black;
                p3Color = blue;
                p4Color = green;
                p5Color = white;
                p6Color = yellow;
            }
                break;
            case 4: {
                p2Color = black;
                p3Color = blue;
                p5Color = white;
                p6Color = yellow;
            }
                break;
            case 3: {
                p2Color = black;
                p4Color = green;
                p6Color = yellow;
            }
                break;
            case 2: {
                p1Color = red;
                p4Color = green;
            }
                break;
        }

        for(int i = 0; i < myCoordinates.size(); i++) {
            x = myCoordinates.get(i).getX();
            y = myCoordinates.get(i).getY();

            if (i < 10) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p1Color, "red", myList));
            } else if (i < 14) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p6Color,"yellow", myList));
            }else if (i > 18 && i < 23) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p2Color,"black", myList));
            } else if (i > 22 && i < 26) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p6Color,"yellow", myList));
            } else if (i > 31 && i < 35) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p2Color,"black", myList));
            }else if (i > 34 && i < 37) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p6Color,"yellow", myList));
            }else if (i > 43 && i < 46) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p2Color,"black", myList));
            }else if (i == 46) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p6Color,"yellow", myList));
            } else if (i == 55) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p2Color,"black", myList));
            }else if (i == 65) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p5Color,"white", myList));
            } else if (i == 74){
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p3Color, "blue",myList));
            }else if (i > 74 && i < 77) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p5Color, "white",myList));
            }else if (i > 83 && i < 86) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p3Color, "blue",myList));
            } else if (i > 85 && i < 89) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p5Color,"white", myList));
            }else if (i > 94 && i < 98) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p3Color, "blue",myList));
            }else if (i > 97 && i < 102) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p5Color,"white", myList));
            }else if (i > 106 && i < 111) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p3Color, "blue",myList));
            }else if (i > 110) {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), p4Color,"green", myList));
            } else {
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), gray,"gray", myList));
            }
        }
    }

    static class Board extends JPanel{
        public Board(){
            super();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int squareSide = 32;
            for(Piece p : myList){
                if(p.color == gray){
                    g2d.setColor(p.color);
                    g2d.drawOval(p.x, p.y, squareSide, squareSide);
                    g2d.setColor(black);
                    g2d.draw(p.piece);
                } else {
                    g2d.setColor(p.color);
                    g2d.fillOval(p.x, p.y, squareSide, squareSide);
                }
            }
        }
    }
}








