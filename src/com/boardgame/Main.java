package com.boardgame;

import com.boardgame.board.GameBoard;
import java.awt.*;

public class Main {
    public enum STATE {
        MENU,
        RULES,
        GAME,
        QUIT
    }
//    public static Toolkit tk = Toolkit.getDefaultToolkit();
//    public static Dimension screen = tk.getScreenSize();
    public static STATE State = STATE.MENU;

    public static void main(String[] args) {

/*
            State = STATE.MENU;
            if (State == STATE.MENU) {
                MenuFrame frame = new MenuFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);
                frame.setVisible(true);
                frame.addMouseListener(new MenuInput());
            }

        State = STATE.RULES;
        if (State == STATE.RULES) {
            RulesFrame rframe = new RulesFrame();
            rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rframe.setSize(800, 800);
            rframe.setVisible(true);
            rframe.addMouseListener(new RulesInput());
        }
        */
        State = STATE.GAME;
        if (State == STATE.GAME) {
            GameBoard game = new GameBoard();
            GameBoard.main();
        }


        }
    }

