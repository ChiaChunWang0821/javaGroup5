package com.zerulus.game.Behavior;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimalsBehavior
{
    BufferedImage img;
    BufferedImage imgInform;
    BufferedImage[] animal;

    private int iHeight=200;
    private int iWidth=320;

    private BufferedImage imgButton;
    // private Button btnFeed;
    // private Button btnCollect;
    
    private String satisfaction;

    public AnimalsBehavior(BufferedImage[] spriteArray)
    {
        this.animal = spriteArray;
        
        satisfaction = new String();

        imgInform= GameStateManager.inform.getSprite(0,0,520,677);
    }
    
    public void render(Graphics2D g, String name, int feedCount) {
        g.drawImage(imgInform, 960, 460, iWidth, iHeight, null);
        g.drawImage(animal[0], 990, 460, 128, 128, null);
        Sprite.drawArray(g, name, new Vector2f(990+128, 504), 32, 24);
        
        Font myFont = new Font ("微軟正黑體", 1, 32);
        g.setFont (myFont);
        
        satisfaction = (feedCount*20 + "%");
        if(feedCount > 5) {
        	satisfaction = ("100%");
        }
        g.drawString("飽食度: " + satisfaction, 1000, 600);
    }
}
