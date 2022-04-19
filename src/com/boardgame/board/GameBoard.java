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
    public static int playerCount = 2;

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
        Color pieceColor;

        for(int i = 0; i < myCoordinates.size(); i++) {
            x = myCoordinates.get(i).getX();
            y = myCoordinates.get(i).getY();

            if (i < 10) {
                pieceColor = red;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor, "red", myList));
            } else if (i < 14) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"yellow", myList));
            }else if (i > 18 && i < 23) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"black", myList));
            } else if (i > 22 && i < 26) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"yellow", myList));
            } else if (i > 31 && i < 35) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"black", myList));
            }else if (i > 34 && i < 37) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"yellow", myList));
            }else if (i > 43 && i < 46) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"black", myList));
            }else if (i == 46) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"yellow", myList));
            } else if (i == 55) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"black", myList));
            }else if (i == 65) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"white", myList));
            } else if (i == 74) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor, "blue",myList));
            }else if (i > 74 && i < 77) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor, "white",myList));
            }else if (i > 83 && i < 86) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor, "blue",myList));
            } else if (i > 85 && i < 89) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"white", myList));
            }else if (i > 94 && i < 98) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor, "blue",myList));
            }else if (i > 97 && i < 102) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"white", myList));
            }else if (i > 106 && i < 111) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor, "blue",myList));
            }else if (i > 110) {
                pieceColor = green;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"green", myList));
            } else {
                pieceColor = gray;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor,"gray", myList));
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








