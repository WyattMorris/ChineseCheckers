package com.boardgame.rules;


import com.boardgame.menu.*;
import com.boardgame.rules.*;
//Collin's main menu class. allows main menu to be shown on the display.


import java.awt.*;


public class Rules {
    public Rectangle menuBtn = new Rectangle(290, 675, 250, 50);

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font titleFont = new Font("Arial", Font.ITALIC, 40);
        Font textFont = new Font("Arial", Font.ITALIC, 20);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("Rules:", 50, 75);
        Font btnFont = new Font("Arial", Font.ITALIC, 30);
        g.setFont(textFont);
        g.drawString("1.) Players take turns to move a single peg of their own colour.", 50, 110);
        g.drawString("2.) In one turn a peg may either be simply moved into an adjacent hole", 50, 140);
        g.drawString("OR it may make one or more hops over other pegs.", 50, 170);
        g.drawString("3.) Where a hopping move is made, each hop must be over an adjacent peg", 50, 200);
        g.drawString("and into a the vacant hole directly beyond it.", 50, 230);
        g.drawString("4.) Each hop may be over any coloured peg including the player's own", 50, 260);
        g.drawString("and can proceed in any one of the six directions. ", 50, 290);
        g.drawString("5.) After each hop, the player may either finish or, if possible and desired,", 50, 320);
        g.drawString("continue by hopping over another peg.", 50, 350);
        g.drawString("6.) Occasionally, a player will be able to move a peg all the way from the", 50, 380);
        g.drawString("starting triangle across the board and into the opposite triangle in one turn!\n", 50, 410);
        g.drawString("7.)Pegs are never removed from the board. Once a peg has reached the ", 50, 440);
        g.drawString("opposite triangle, it may not be moved out of the triangle - only within the triangle.", 50, 470);

        g.setFont(btnFont);
        g.drawString("Return to Menu", menuBtn.x + 25, menuBtn.y + 35);
        g2d.draw(menuBtn);

    }

}
