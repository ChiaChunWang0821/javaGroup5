package com.zerulus.game.Behavior;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PersonInformation{

    int heart;
    String name;
    BufferedImage img;
    BufferedImage imgInform;
    BufferedImage[] person;
    private BufferedImage imgButton;
    private Button talkButton;
    private Button giveButton;
    private int iHeight=320;
    private int iWidth=320;


    public PersonInformation(int heart, BufferedImage[] spriteArray, String name){
        imgInform= GameStateManager.inform.getSprite(0,0,520,677);
        this.name = name;
        this.heart = heart;
        this.person = spriteArray;
        load_heart(heart);
        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);
        // talkButton = new com.zerulus.game.ui.Button("Talk", 24, 12, imgButton, 100, 32, new Vector2f(30, 200), false);
        giveButton = new com.zerulus.game.ui.Button("Give", 24, 12, imgButton, 100, 32, new Vector2f(30, 220), false);
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    private void load_heart(int heart){
    	try {
            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("entity/heart.png"));
        }catch (Exception e){
            System.out.println("ERROR: could not load file: " + "entity/heart.png");
        }
    }

    public void render(Graphics2D g){
    	g.drawImage(imgInform, (int) 0, (int) 10, iWidth, iHeight, null);
        g.drawImage(person[0], (int) 30, (int) 20, 128, 128, null);
        Sprite.drawArray(g, name, new Vector2f(30+128, 64), 32, 24);
        for(int i=0;i<heart;i++){
            g.drawImage(img,(int)30+i*48,(int)160,32,32,null);
        }
        giveButton.render(g);
        //talkButton.render(g);
    }
}