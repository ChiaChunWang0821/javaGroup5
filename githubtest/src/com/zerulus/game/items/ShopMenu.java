package com.zerulus.game.items;

import com.zerulus.game.entity.Enemy_man;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ShopMenu {

    private BufferedImage board;
    private BufferedImage imgButton;
    private BufferedImage[] person;
    private BufferedImage beet;
    private BufferedImage broccoli;
    private BufferedImage cabbage;
    private BufferedImage carrot;
    private BufferedImage cucumber;
    private BufferedImage eggplant;
    private BufferedImage flour;
    private BufferedImage milk;
    private Button buy1;
    private Button buy2;
    private Button buy3;
    private Button buy4;
    private Button buy5;
    private Button buy6;
    private Button buy7;
    private Button buy8;

    private int iHeight = 450;
    private int iWidth = 450;

    private Enemy_man boy;
    private Camera cam;

    private Sprite vege;
    private Sprite vege1;
    private Sprite vege2;
    private Sprite vege3;
    private Sprite vege4;
    private Sprite vege5;

    public ShopMenu(BufferedImage[] spriteArray)
    {
        board = GameStateManager.shopMenu.getSprite(0,0,550,450);
        //imgButton = GameStateManager.shopButton.getSprite(0, 0, 190, 48);
        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);
        this.person = spriteArray;

        buy1 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, -140), true);
        buy2 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, -85), true);
        buy3 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, -30), true);
        buy4 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, 25), true);
        buy5 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, 80), true);
        buy6 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, 135), true);
        /*buy7 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, 160), true);
        buy8 = new Button("BUY", 32, 24, imgButton, 100, 40, new Vector2f(230, 210), true);*/
        buy1.addEvent(e -> {
        });
        buy2.addEvent(e -> {
        });
        buy3.addEvent(e -> {
        });
        buy4.addEvent(e -> {
        });
        buy5.addEvent(e -> {
        });
        buy6.addEvent(e -> {
        });
       /* buy7.addEvent(e -> {
        });
        buy8.addEvent(e -> {
        });*/
        vege = new Sprite("item/beet.png", 64, 64);
        beet = vege.getSprite(0,0,64,64);
        vege1 = new Sprite("item/broccoli.png", 64, 64);
        broccoli = vege1.getSprite(0,0,64,64);
        vege2 = new Sprite("item/cabbage.png", 64, 64);
        cabbage = vege2.getSprite(0,0,64,64);
        vege3 = new Sprite("item/carrot.png", 64, 64);
        carrot = vege3.getSprite(0,0,64,64);
        vege4 = new Sprite("item/cucumber.png", 64, 64);
        cucumber = vege4.getSprite(0,0,64,64);
        vege5 = new Sprite("item/eggplant.png", 64, 64);
        eggplant = vege5.getSprite(0,0,64,64);

    }
    public void update(double time) {
        buy1.update();
        buy2.update();
        buy3.update();
        buy4.update();
        buy5.update();
        buy6.update();

    }

    public void input(MouseHandler mouse, KeyHandler key) {
        buy1.input(mouse, key);
        buy2.input(mouse, key);
        buy3.input(mouse, key);
        buy4.input(mouse, key);
        buy5.input(mouse, key);
        buy6.input(mouse, key);
    }

    public void render(Graphics2D g){
        g.drawImage(board, (int) 500, (int) 100, iWidth, iHeight, null);
        g.drawImage(person[0], (int) 530, (int) 150, 128, 128, null);
        Sprite.drawArray(g, "George's shop", new Vector2f(60+500, 130), 32, 24);
        Font myFont = new Font ("微軟正黑體", 1, 32);
        g.setFont (myFont);
        //g.drawString("Hello",0,200);
        buy1.render(g);
        buy2.render(g);
        buy3.render(g);
        buy4.render(g);
        buy5.render(g);
        buy6.render(g);
       /* buy7.render(g);
        buy8.render(g);*/
        g.drawImage(beet, (int) 720, (int) 190, 50, 50, null);
        g.drawImage(broccoli, (int) 720, (int) 245, 50, 50, null);
        g.drawImage(cabbage, (int) 720, (int) 300, 50, 50, null);
        g.drawImage(carrot, (int) 720, (int) 355, 50, 50, null);
        g.drawImage(cucumber, (int) 720, (int) 410, 50, 50, null);
        g.drawImage(eggplant, (int) 720, (int) 465, 50, 50, null);
    }

}
