package com.zerulus.game.states;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MarryState extends GameState{
    private BufferedImage background;
    private int posX=10;

    public MarryState(GameStateManager gsm) {
        super(gsm);
        try{
            background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/marry1.png"));
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
        g.drawImage(background,posX,0,305,170,null);
        if(posX<500){
            posX +=10;
        }
        else {
            Sprite.drawArray(g, "Success !!", new Vector2f(158, 80), 64, 48);
        }
    }

}
