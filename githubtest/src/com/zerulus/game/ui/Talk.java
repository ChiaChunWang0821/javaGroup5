package com.zerulus.game.ui;

import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Talk {
    private BufferedImage image;
    private int iWidth;
    private int iHeight;
    private Vector2f offset;

    public Talk(BufferedImage image, int iWidth, int iHeight,Vector2f offset){
        this.image = image;
        this.iWidth = iWidth;
        this.iHeight = iHeight;
        this.offset = offset;


    }

    public void input(MouseHandler mouse, KeyHandler key){}

    public void render(Graphics2D g) {
        g.drawImage(image, (int) 0, (int) 10, iWidth, iHeight, null);
    }
}
