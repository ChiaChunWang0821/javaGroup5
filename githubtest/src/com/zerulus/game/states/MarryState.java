package com.zerulus.game.states;

import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MarryState extends GameState{
    private BufferedImage background;
    public MarryState(GameStateManager gsm) {
        super(gsm);
        try{
            background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/church.jpg"));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(background,0,0,1280,720,null);
    }

}
