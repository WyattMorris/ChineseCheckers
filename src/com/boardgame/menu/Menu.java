package com.boardgame.menu;

import com.boardgame.menu.*;

//Collin's main menu class. allows main menu to be shown on the display.


import java.awt.*;


public class Menu {

    public Rectangle playBtn = new Rectangle(325, 200, 150, 50);
    public Rectangle rulesBtn = new Rectangle(325, 300, 150, 50);
    public Rectangle exitBtn = new Rectangle(325, 400, 150, 50);

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font titleFont = new Font("Arial", Font.BOLD, 45);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("Chinese Checkers", 200, 100);

        Font buttonFont = new Font("arial", Font.BOLD, 30);
        g.setFont(buttonFont);
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
