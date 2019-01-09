package com.zerulus.game.Behavior;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Talk {
    private String context;
    private String name;
    private BufferedImage frame;

    public Talk(String name){
        this.name = name;
        frame = GameStateManager.talk.getSprite(0,0,1800,476);
    }
    
    public void setContext(String s){
        this.context = s;
    }

    public void render(Graphics2D g){
        g.drawImage(frame,130,380,1080,300,null);
        Sprite.drawArray(g, name, new Vector2f(320, 410), 48, 24);
        Font myFont = new Font ("微軟正黑體", 1, 32);
        g.setColor(Color.BLACK);
        g.setFont (myFont);
        g.drawString(context,250,550);
    }
}
