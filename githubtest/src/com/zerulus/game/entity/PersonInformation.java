package com.zerulus.game.entity;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PersonInformation{

    int heart;
    BufferedImage img;
    BufferedImage imgInform;
    BufferedImage[] person;
    private BufferedImage imgButton;
    private Button talkButton;
    private Button giveButton;
    private int iHeight=320;
    private int iWidth=320;


    public PersonInformation(int heart, BufferedImage[] spriteArray){
        imgInform= GameStateManager.inform.getSprite(0,0,520,677);
        this.heart = heart;
        this.person = spriteArray;
        load_heart(heart);
        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);
        talkButton = new com.zerulus.game.ui.Button("Talk", 24, 12, imgButton, 100, 32, new Vector2f(30, 200), false);
        giveButton = new com.zerulus.game.ui.Button("Give", 24, 12, imgButton, 100, 32, new Vector2f(30, 240), false);
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
        Sprite.drawArray(g, "Lily", new Vector2f(30+128, 64), 32, 24);
        for(int i=0;i<5;i++){
            g.drawImage(img,(int)30+i*32,(int)160,32,32,null);
        }
        /*Font myFont = new Font ("微軟正黑體", 1, 32);
        g.setColor(Color.white);
        g.setFont (myFont);
        g.drawString("嗨",30,200);*/
        giveButton.render(g);
        talkButton.render(g);
    }
}