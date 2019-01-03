package com.zerulus.game;

import javax.swing.*;

public class Window extends JFrame {
    public static final long serialVersionUID = 1L;

    public Window() {
        setTitle("Java-Group5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280, 720,this));
        setIgnoreRepaint(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
