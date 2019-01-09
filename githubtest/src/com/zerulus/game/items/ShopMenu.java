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

    private int iHeight = 450;
    private int iWidth = 450;

    private Sprite vege;
    private Sprite vege1;
    private Sprite vege2;
    private Sprite vege3;
    private Sprite vege4;
    private Sprite vege5;

    private Sprite buyButton;
    private BufferedImage buyBtn;

    public ShopMenu(BufferedImage[] spriteArray)
    {
        board = GameStateManager.shopMenu.getSprite(0,0,550,450);
        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);
        this.person = spriteArray;

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

        buyButton = new Sprite("ui/green_button.png", 64,64);
        buyBtn = buyButton.getSprite(0,0,190,49);
    }
    
    public void update(double time) {
        
    }

    public void input(MouseHandler mouse, KeyHandler key) {
       
    }

    public int clickInside(int x, int y){
        System.out.println(x + "," + y);
        if(y >130 && y < 200){
            if(x >840 && x <910){
                return 0;
            }
            else if(x>930 && x<1000){
                return 1;
            }
            else if(x>1020 && x<1090){
                return 2;
            }
        }
        else if(y > 230 && y<300){
            if(x >840 && x <910){
                return 3;
            }
            else if(x>930 && x<1000){
                return 4;
            }
            else if(x>1020 && x<1090){
                return 5;
            }
        }
        else if(y>330 && y<400){
            if(x >840 && x <910){
                return 6;
            }
            else if(x>930 && x<1000){
                return 7;
            }
            else if(x>1020 && x<1090){
                return 8;
            }
        }
        return  9;
    }

    public void  click(int x, int y){
        System.out.println(x + "," + y);
        int choose;
        choose = clickInside(x,y);
    }

    public void render(Graphics2D g){
        g.drawImage(board, (int) 500, (int) 100, iWidth, iHeight, null);
        g.drawImage(person[0], (int) 530, (int) 150, 128, 128, null);
        Sprite.drawArray(g, "George's shop", new Vector2f(60+500, 130), 32, 24);
        Font myFont = new Font ("微軟正黑體", 1, 32);
        g.setFont (myFont);
        g.drawImage(beet, (int) 720, (int) 190, 50, 50, null);
        g.drawImage(broccoli, (int) 720, (int) 245, 50, 50, null);
        g.drawImage(cabbage, (int) 720, (int) 300, 50, 50, null);
        g.drawImage(carrot, (int) 720, (int) 355, 50, 50, null);
        g.drawImage(cucumber, (int) 720, (int) 410, 50, 50, null);
        g.drawImage(eggplant, (int) 720, (int) 465, 50, 50, null);

        int a = 0;
        for(int i = 0; i < 6; i ++)
        {
            g.drawImage(buyBtn, (int) 810, (int) 210+i*55, 100, 30, null);
        }
    }
}
