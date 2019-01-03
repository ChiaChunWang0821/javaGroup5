package com.zerulus.game.AnimalBehavior;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Vector2f;

public abstract class AnimalBehavior
{
	BufferedImage img;
	BufferedImage imgInform;
	BufferedImage[] animal;
	
    
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
	
	public abstract void render(Graphics2D g);
	
}