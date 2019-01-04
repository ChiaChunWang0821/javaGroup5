package com.zerulus.game.Behavior;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class AnimalBehavior
{
    BufferedImage img;
    BufferedImage imgInform;
    BufferedImage[] animal;


    /*private BufferedImage imgButton;
    private Button btnFeed;
    private Button btnCollect;*/


    public AnimalBehavior(BufferedImage[] spriteArray)
    {
        this.animal = spriteArray;
    }

    public abstract void render(Graphics2D g);

    // public abstract void feed();
    // public abstract void collect();
}