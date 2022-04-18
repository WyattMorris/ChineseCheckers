package com.boardgame.board;

/*
Author: Wyatt Morris
 */
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

public class Piece {
    int xPos;
    int yPos;

    int xLast;
    int yLast;

    int x;
    int y;

    int center_x;
    int center_y;
    public Color color;
    Color lastColor;
    String c;
    LinkedList<Piece> myList;
    Ellipse2D piece;

    public Piece(int xp, int yp, int center_x, int center_y, Color color, String clr, LinkedList<Piece> myList) {
        xLast = xp;
        yLast = yp;
        xPos = xp;
        yPos = yp;
        x = xp;
        y = yp;
        this.center_x = center_x;
        this.center_y = center_y;
        this.color = color;
        this.c = clr;
        this.lastColor = color;
        myList.add(this);
        piece = new Ellipse2D.Double(xp,yp,32,32);
    }

    //Collin
    public void move(int xPos, int yPos){
        xLast = this.xPos;
        yLast = this.yPos;
        this.xPos = xPos;
        this.yPos = yPos;
        this.center_x = xPos + 25/2;
        this.center_y = yPos + 25/2;
        piece = new Ellipse2D.Double(xPos, yPos, 32, 32);
        x = xPos;
        y = yPos;
    }
}
