package com.zerulus.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.game.graphics.Sprite;

public class AnimalBehavior
{
	BufferedImage img;
	BufferedImage[] animal;
	private int iHeight=320;
    private int iWidth=320;
	
	public AnimalBehavior(BufferedImage[] spriteArray)
	{
		this.animal = spriteArray;
	}
	
	public void render(Graphics2D g)
	{
		g.drawImage(img, (int)0, (int)0, iWidth, iHeight, null);
		g.drawImage(animal[0], (int)30, (int)20, 128, 128, null);
		//Sprite.drawArray(g, "Cow", new Vector2f(30+128, 64);
	}
	
}