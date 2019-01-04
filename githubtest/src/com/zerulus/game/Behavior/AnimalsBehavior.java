package com.zerulus.game.Behavior;

import com.zerulus.game.entity.Animals;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimalsBehavior
{
    BufferedImage img;
    BufferedImage imgInform;
    BufferedImage[] animal;

    private int iHeight=320;
    private int iWidth=320;

    private BufferedImage imgButton;
    private Button btnFeed;
    // private Button btnCollect;

    public AnimalsBehavior(BufferedImage[] spriteArray)
    {
        this.animal = spriteArray;

        imgInform= GameStateManager.inform.getSprite(0,0,520,677);

        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);
        btnFeed = new Button("FEED", 32, 24, imgButton, 200, 75, new Vector2f(480, 210), true);
        // btnCollect = new Button("COLLECT", 32, 24, imgButton, 200, 75, new Vector2f(480, 220), true);

        btnFeed.addEvent(e -> {
            Animals.feedCount++;
        });
        /*btnCollect.addEvent(e -> {

        });*/
    }

    public void render(Graphics2D g) {
        g.drawImage(imgInform, 960, 340, iWidth, iHeight, null);
        g.drawImage(animal[0], 990, 340, 128, 128, null);
        Sprite.drawArray(g, "Pig", new Vector2f(990+128, 384), 32, 24);

        btnFeed.render(g);
        // btnCollect.render(g);

        Font myFont = new Font ("微軟正黑體", 1, 32);
        g.setFont (myFont);
        g.drawString("飽食度:", 1000, 500);
    }
}
