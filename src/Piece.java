/*
Author: Wyatt Morris
 */
import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Piece {
    int xPos;
    int yPos;
    int center_x;
    int center_y;
    Color color;
    Ellipse2D piece;

    public Piece(int x, int y, int center_x, int center_y, Color color) {
        xPos = x;
        yPos = y;
        this.center_x = center_x;
        this.center_y = center_y;
        this.color = color;
        this.piece = new Ellipse2D.Double(x,y,32,32);
    }

    //Collin
    public void move(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.center_x = xPos + 25/2;
        this.center_y = yPos + 25/2;
//        x = xPos;
//        y = yPos;
    }
}


