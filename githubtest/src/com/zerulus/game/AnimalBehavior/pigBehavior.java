package com.zerulus.game.AnimalBehavior;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.Vector2f;

public class pigBehavior extends AnimalBehavior
{
	private int iHeight=320;
    private int iWidth=320;
    
	public pigBehavior(BufferedImage[] spriteArray)
	{
		super(spriteArray);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(imgInform, (int) 960, (int) 400, iWidth, iHeight, null);
		g.drawImage(animal[0], (int)990, (int)410, 128, 128, null);
		Sprite.drawArray(g, "Pig", new Vector2f(990+128, 454), 32, 24);
	}
	
}
