package com.zerulus.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Vector2f;

public class AnimalBehavior
{
	BufferedImage img;
	BufferedImage imgInform;
	BufferedImage[] animal;
	private int iHeight=320;
    private int iWidth=320;
    
    private BufferedImage imgButton;
    private Button btnFeed;
    private Button btnCollect;
    
	
	public AnimalBehavior(BufferedImage[] spriteArray)
	{
		this.animal = spriteArray;
		
		imgInform= GameStateManager.inform.getSprite(0,0,520,677);
		
		imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);
		btnFeed = new Button("FEED", 32, 24, imgButton, 200, 75, new Vector2f(0, -50), true);
		btnCollect = new Button("COLLECT", 32, 24, imgButton, 200, 75, new Vector2f(0, 50), true);
	}
	
	public void render(Graphics2D g)
	{
		g.drawImage(imgInform, (int) 960, (int) 400, iWidth, iHeight, null);
		g.drawImage(animal[0], (int)990, (int)410, 128, 128, null);
		Sprite.drawArray(g, "Cow", new Vector2f(990+128, 454), 32, 24);
	}
	
}