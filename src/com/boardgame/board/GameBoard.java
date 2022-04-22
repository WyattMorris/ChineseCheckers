package com.boardgame.board;

/*
Author: Wyatt Morris
 */
import com.boardgame.input.*;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;


import static java.awt.Color.*;
import static java.awt.Color.red;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameBoard {
    private static final int BoardSize = 25;
    private static final int[] rowWidth = {1,2,3,4,13,12,11,10,9,10,11,12,13,4,3,2,1};
    private static final int[] rowSpaces = {6,5,5,4,0,0,1,1,2,1,1,0,0,4,5,5,6};
    private static final LinkedList<Coordinates> myCoordinates = new LinkedList<>();
    private static final LinkedList<Piece> myList = new LinkedList<>();
    public static Piece selectedPiece = null;
    public static int playerCount;
    public static JFrame myGame;
    public static Board board;
    public static Rules rules;
    public static Menu menu;
    public static Players players;
    public static Color turnColor = RED;
    public static String theWinner = null;
    public static Color winner = null;

    public static void main(String[] args) {
        myGame = new JFrame("Chinese Checkers");

        menu = new Menu();
        rules = new Rules();
        players = new Players();
        players.addMouseListener(new PlayersInput());
        board = new Board();
        myGame.add(menu);
        menu.addMouseListener(new MenuInput());
        rules.addMouseListener(new RulesInput());
        board.setBackground(lightGray);
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
                        if (p.piece.contains(e.getPoint()) && p.color != gray && p.color == turnColor) {
                            selectedPiece = p;
                            //System.out.println("Piece selected");
                        }
                    }
                }
                int xloc = e.getX();
                int yloc = e.getY();
                if(xloc >= 500 && xloc <= 745){
                    if(yloc >= 650 && yloc <= 700) {
                        if(turnColor == RED){
                            if(playerCount == 2){
                                turnColor = GREEN;
                            }
                            if(playerCount == 6){
                                turnColor = YELLOW;
                            }
                        }
                        else if(turnColor == YELLOW){
                            if(playerCount == 3){
                                turnColor = GREEN;
                            }
                            if(playerCount == 4){
                                turnColor = WHITE;
                            }
                            if(playerCount == 6){
                                turnColor = WHITE;
                            }
                        }
                        else if(turnColor == WHITE){
                            if(playerCount == 4){
                                turnColor = BLUE;
                            }
                            if(playerCount == 6){
                                turnColor = GREEN;
                            }
                        }
                        else if(turnColor == GREEN){
                            if(playerCount == 2){
                                turnColor = RED;
                            }
                            if(playerCount == 3){
                                turnColor = BLACK;
                            }
                            if(playerCount == 6){
                                turnColor = BLUE;
                            }
                        }
                        else if(turnColor == BLUE){
                            if(playerCount == 4){
                                turnColor = BLACK;
                            }
                            if(playerCount == 6){
                                turnColor = BLACK;
                            }
                        }
                        else if(turnColor == BLACK){
                            if(playerCount == 3){
                                turnColor = YELLOW;
                            }
                            if(playerCount == 4){
                                turnColor = YELLOW;
                            }
                            if(playerCount == 6){
                                turnColor = RED;
                            }
                        }
                        board.repaint();
                    }
                    }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedPiece != null) {
                    boolean moveSuccess = false;
                    for(Piece p: myList){
                        if(p.piece.contains(e.getPoint())){
                            if(p.color != selectedPiece.color && p.color == gray){
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
                        //Automatic end turn
                        /*if(turnColor == RED){
                            if(playerCount == 2){
                                turnColor = GREEN;
                            }
                            if(playerCount == 6){
                                turnColor = YELLOW;
                            }
                        }
                        else if(turnColor == YELLOW){
                            if(playerCount == 3){
                                turnColor = GREEN;
                            }
                            if(playerCount == 4){
                                turnColor = WHITE;
                            }
                            if(playerCount == 6){
                                turnColor = WHITE;
                            }
                        }
                        else if(turnColor == WHITE){
                            if(playerCount == 4){
                                turnColor = BLUE;
                            }
                            if(playerCount == 6){
                                turnColor = GREEN;
                            }
                        }
                        else if(turnColor == GREEN){
                            if(playerCount == 2){
                                turnColor = RED;
                            }
                            if(playerCount == 3){
                                turnColor = BLACK;
                            }
                            if(playerCount == 6){
                                turnColor = BLUE;
                            }
                        }
                        else if(turnColor == BLUE){
                            if(playerCount == 4){
                                turnColor = BLACK;
                            }
                            if(playerCount == 6){
                                turnColor = BLACK;
                            }
                        }
                        else if(turnColor == BLACK){
                            if(playerCount == 3){
                                turnColor = YELLOW;
                            }
                            if(playerCount == 4){
                                turnColor = YELLOW;
                            }
                            if(playerCount == 6){
                                turnColor = RED;
                            }
                        }*/

                        winner = checkWin();

                        if(winner != null){
                            theWinner = colorToString(winner.toString());
                        }
                        if(theWinner != null){
                            System.out.println("We have a winner! - " + theWinner);
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

    public static Color checkWin(){
        int redWin = 0;
        int blackWin = 0;
        int blueWin = 0;
        int greenWin = 0;
        int whiteWin = 0;
        int yellowWin = 0;

        Color red = null;
        Color black = null;
        Color blue = null;
        Color green = null;
        Color white = null;
        Color yellow = null;

        for(Piece p : myList){
            if(p.originalColor != gray){ // Only checking the outer triangles.
                //switch on every color, increasing the counter if the pieces are filled with non-gray pieces
                //and at least 1 non-original color. this will constitute a win by the non-original color.
                switch (p.c){
                    case "red": {
                        if(p.originalColor == p.color){
                            redWin++;
                        } else if(p.color != gray){
                            redWin++;
                            red = p.color;
                        }
                        if(redWin == 20 && red != null) {
                            return red;
                        }
                    }
                        break;

                    case "black": {
                        if(p.originalColor == p.color){
                            blackWin++;
                        } else if(p.color != gray){
                            blackWin++;
                            black = p.color;
                        }
                        if(blackWin == 20 && black != null) {
                            return black;
                        }
                    }
                        break;

                    case "blue": {
                        if(p.originalColor == p.color){
                            blueWin++;
                        } else if(p.color != gray){
                            blueWin++;
                            blue = p.color;
                        }
                        if(blueWin == 20 && blue != null) {
                            return blue;
                        }
                    }
                        break;

                    case "green": {
                        if(p.originalColor == p.color){
                            greenWin++;
                        } else if(p.color != gray){
                            greenWin++;
                            green = p.color;
                        }
                        if(greenWin == 20 && green != null) {
                            return green;
                        }
                    }
                        break;

                    case "white": {
                        if(p.originalColor == p.color){
                            whiteWin++;
                        } else if(p.color != gray){
                            whiteWin++;
                            white = p.color;
                        }
                        if(whiteWin == 20 && white != null) {
                            return white;
                        }
                    }
                        break;

                    case "yellow": {
                        if(p.originalColor == p.color){
                            yellowWin++;
                        } else if(p.color != gray){
                            yellowWin++;
                            yellow = p.color;
                        }
                        if(yellowWin == 20 && yellow != null) {
                            return yellow;
                        }
                    }
                        break;

                }
            }
        }
        return null;
    }


    static class Board extends JPanel{
        public Board(){
            super();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if(theWinner != null){
                Font titleFont = new Font("Arial", Font.BOLD, 45);
                g.setFont(titleFont);
                g.setColor(winner);
                g.drawString("We have a winner! - " + theWinner, 100, 75);
            } else {
                Font titleFont = new Font("Arial", Font.BOLD, 45);
                g.setFont(titleFont);
                g.setColor(turnColor);
                String colorTurn = colorToString(turnColor.toString());
                assert colorTurn != null;
                g.drawString(colorTurn, 200, 100);
                g.fillRect(500, 650, 245, 50);
                g.setColor(BLACK);
                g.drawRect(500, 650, 245, 50);
                g.drawString("Turn: ", 75, 100);
                if(colorTurn.equals("Black")){
                    g.setColor(WHITE);
                    g.drawString("End Turn", 525, 690);
                }
                else
                g.drawString("End Turn", 525, 690);
            }


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

    // MENU CLASS ***************************************************
    static class Menu extends JPanel {

        public Menu() {
            super();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            render(g);
        }

        public Rectangle playBtn = new Rectangle(325, 200, 150, 50);
        public Rectangle rulesBtn = new Rectangle(325, 300, 150, 50);
        public Rectangle exitBtn = new Rectangle(325, 400, 150, 50);

        public void render(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            decorate(g);
            Font titleFont = new Font("Arial", Font.BOLD, 45);
            g.setColor(WHITE);
            g.fillRect(190, 60, 410, 50);
            g.setFont(titleFont);
            g.setColor(Color.BLACK);
            g.drawRect(190, 60, 410, 50);
            g.drawString("Chinese Checkers", 200, 100);

            Font buttonFont = new Font("arial", Font.BOLD, 30);
            g.setFont(buttonFont);
            g.setColor(GREEN);
            g.fillRect(325, 200, 150, 50);
            g.setColor(YELLOW);
            g.fillRect(325, 300, 150, 50);
            g.setColor(RED);
            g.fillRect(325, 400, 150, 50);
            g.setColor(Color.BLACK);
            g.drawString("Play", playBtn.x + 45, playBtn.y + 35);
            g2d.draw(playBtn);
            g.drawString("Rules", rulesBtn.x + 35, rulesBtn.y + 35);
            g2d.draw(rulesBtn);
            g.drawString("Exit", exitBtn.x + 45, exitBtn.y + 35);
            g2d.draw(exitBtn);

            Font creditFont = new Font("arial", Font.ITALIC, 15);
            g.setFont(creditFont);
            g.drawString("A Wyatt and Collin production (2022)", 10, 740);
        }
    }

    // RULES CLASS ***************************************************

    static class Rules extends JPanel{

        public Rules(){
            super();
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            render(g);
        }
        public Rectangle menuBtn = new Rectangle(290, 675, 250, 50);

        public void render(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            //decorate(g);
            Font titleFont = new Font("Arial", Font.ITALIC, 40);
            Font textFont = new Font("Arial", Font.ITALIC, 20);
            g.setFont(titleFont);
            g.setColor(Color.BLACK);
            g.drawString("Rules:", 50, 75);
            Font btnFont = new Font("Arial", Font.PLAIN, 30);
            g.setFont(textFont);
            g.drawString("1.) Players take turns to move a single marble of their own color.", 50, 110);
            g.drawString("2.) In one turn a marble may either be simply moved into an adjacent hole", 50, 140);
            g.drawString("OR it may make one or more hops over other marbles.", 50, 170);
            g.drawString("3.) Where a hopping move is made, each hop must be over an adjacent marble", 50, 200);
            g.drawString("and into a the vacant hole directly beyond it.", 50, 230);
            g.drawString("4.) Each hop may be over any colored marble including the player's own", 50, 260);
            g.drawString("and can proceed in any one of the six directions. ", 50, 290);



            g.setFont(btnFont);
            g.setColor(RED);
            g.fillRect(290, 675, 250, 50);
            g.setColor(BLACK);
            g.drawString("Return to Menu", menuBtn.x + 25, menuBtn.y + 35);
            g2d.draw(menuBtn);

        }

    }


    // Playercount CLASS ***************************************************


    static class Players extends JPanel{

        public Players(){
            super();
        }
        public void paintComponent(Graphics g){
            ImageIcon img = new ImageIcon("src\\images\\pexels-photo-326333.jpeg");
            g.drawImage(img.getImage(), 0, 0, null);
            super.paintComponent(g);
            render(g);
        }

        public void render(Graphics g){
            Font titleFont = new Font("Arial", Font.BOLD, 40);
           // decorate(g);
            g.setFont(titleFont);
            g.setColor(Color.BLACK);
            g.drawString("Player Count:", 50, 100);



            g.drawRect(250, 250, 100, 100);
            g.drawRect(400, 250, 100, 100);
            g.drawRect(250, 400, 100, 100);
            g.drawRect(400, 400, 100, 100);


            g.setColor(BLUE);
            g.fillRect(250, 250, 100, 100);
            g.setColor(GREEN);
            g.fillRect(400, 250, 100, 100);
            g.setColor(YELLOW);
            g.fillRect(250, 400, 100, 100);
            g.setColor(RED);
            g.fillRect(400, 400, 100, 100);


            g.setColor(Color.BLACK);
            g.drawString("2", 290, 315);
            g.drawString("3", 440, 315);
            g.drawString("4", 290, 465);
            g.drawString("6", 440, 465);


        }

    }

    static String colorToString(String myColor){
        switch(myColor){
            case "java.awt.Color[r=255,g=0,b=0]":
                return "Red";
            case "java.awt.Color[r=0,g=255,b=0]":
                return "Green";
            case "java.awt.Color[r=0,g=0,b=255]":
                return "Blue";
            case "java.awt.Color[r=255,g=255,b=255]":
                return "White";
            case "java.awt.Color[r=0,g=0,b=0]":
                return "Black";
            case "java.awt.Color[r=255,g=255,b=0]":
                return "Yellow";
            default:
                return null;

        }
    }

    static void decorate(Graphics g){
        int px = 0;
        int py = 0;
        int color = 0;
        Color [] colors = {RED, BLUE, YELLOW, GREEN, WHITE};
        Random rand = new Random();
        for(int i = 0; i< 100; i++){
            color = rand.nextInt(5);
            g.setColor(colors[color]);
            py = rand.nextInt(700);
            px = rand.nextInt(700);
            g.fillOval(px, py, 32, 32);
            g.setColor(BLACK);
            g.drawOval(px, py, 32, 32);
        }

    }

}








