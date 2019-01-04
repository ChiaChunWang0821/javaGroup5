package com.zerulus.game.Behavior;

import com.zerulus.game.GamePanel;
import com.zerulus.game.entity.Animals;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PigBehavior extends AnimalBehavior
{
    private int iHeight=320;
    private int iWidth=320;

    private BufferedImage imgButton;
    private Button btnFeed;
    private Button btnCollect;

    private Animals pig;
    private Camera cam;

    // private BufferedImage img;
    // private boolean checkFeed = false;

    public PigBehavior(BufferedImage[] spriteArray)
    {
        super(spriteArray);

        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);

        btnFeed = new Button("FEED", 32, 24, imgButton, 200, 75, new Vector2f(480, 130), true);
        btnCollect = new Button("COLLECT", 32, 24, imgButton, 200, 75, new Vector2f(480, 220), true);

        btnFeed.addEvent(e -> {
			/*try {
	            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("entity/pig_eat.png"));
	        }catch (Exception e1){
	            System.out.println("ERROR: could not load file: " + "entity/pig_eat.png");
	        }*/

            pig = new Animals(cam, new Sprite("entity/pig_eat.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128);

            // checkFeed = true;

            // feed();
        });
        btnCollect.addEvent(e -> {
            pig = new Animals(cam, new Sprite("entity/pig_eat.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128);
			/*try {
	            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("entity/pig_eat.png"));
	        }catch (Exception e1){
	            System.out.println("ERROR: could not load file: " + "entity/pig_eat.png");
	        }*/

            // collect();
        });
    }

    @Override
    public void render(Graphics2D g) {
        // TODO Auto-generated method stub
        imgInform= GameStateManager.inform.getSprite(0,0,520,677);

        g.drawImage(imgInform, 960, 340, iWidth, iHeight, null);
        g.drawImage(animal[0], 990, 340, 128, 128, null);
        Sprite.drawArray(g, "Pig", new Vector2f(990+128, 384), 32, 24);

        btnFeed.render(g);
        btnCollect.render(g);


		/*if(checkFeed) {
			g.drawImage(img,(int)30,(int)160,32,32,null);

			checkFeed = false;
		}*/
    }

	/*@Override
	public void feed()
	{
		try {
            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("entity/pig_eat.png"));
        }catch (Exception e){
            System.out.println("ERROR: could not load file: " + "entity/pig_eat.png");
        }
	}

	@Override
	public void collect()
	{
		try {
            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("entity/pig_eat.png"));
        }catch (Exception e){
            System.out.println("ERROR: could not load file: " + "entity/pig_eat.png");
        }
	}*/
}
