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
    private static final LinkedList<Coordinates> myCoordinates = new LinkedList<Coordinates>();
    private static final LinkedList<Piece> myList = new LinkedList<Piece>();
    private static Piece selectedPiece;

    public static void main(String[] args) {
        JFrame myGame = new JFrame("Chinese Checkers");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        initializeCoordinates(800);
        initializePieces(800);
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
                for(Piece p : myList){
                    if(p.piece.contains(e.getPoint())){
                        selectedPiece = p;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedPiece!= null) {
                    for(Piece p : myList){
                        if(p.piece.contains(e.getX(), e.getY() - 15)){
                            selectedPiece.move(e.getX() - 25, e.getY() - 45);
                            myGame.repaint();
                        }
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
        myGame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece != null){
                    selectedPiece.xPos = e.getX();
                    selectedPiece.yPos = e.getY();
                    myGame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        myGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void initializeCoordinates(int squareSide){
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
                myCoordinates.add(new Coordinates((int) (rowSpaces[i] *squareSide + squareSide*j + offset + squareSide*BoardSize/4.5), (int) (k * squareSide + squareSide*BoardSize/12)));
            }
            k++;
        }
    }

    public static void initializePieces(int squareSide){
        squareSide = 32;
        int x;
        int y;
        Color pieceColor;
        for(int i = 0; i < myCoordinates.size(); i++) {
            x = myCoordinates.get(i).getX();
            y = myCoordinates.get(i).getY();
            if(i == 1){
                System.out.println(x + " " + y);
            }
            if (i < 10) {
                pieceColor = red;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            } else if (i < 14) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 18 && i < 23) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));;
            } else if (i > 22 && i < 26) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            } else if (i > 31 && i < 35) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 34 && i < 37) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 43 && i < 46) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i == 46) {
                pieceColor = yellow;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            } else if (i == 55) {
                pieceColor = black;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i == 65) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            } else if (i == 74) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 74 && i < 77) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 83 && i < 86) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            } else if (i > 85 && i < 89) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 94 && i < 98) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 97 && i < 102) {
                pieceColor = white;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 106 && i < 111) {
                pieceColor = blue;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            }else if (i > 110) {
                pieceColor = green;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
            } else {
                pieceColor = gray;
                myList.add(new Piece(x, y, x + (squareSide/2), y + (squareSide/2), pieceColor));
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
                g2d.setColor(p.color);
                g2d.fillOval(p.xPos, p.yPos, squareSide, squareSide);
                g2d.setColor(BLACK);
                g2d.draw(p.piece);
            }
        }
 }
}



