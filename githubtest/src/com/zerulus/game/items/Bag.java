package com.zerulus.game.items;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bag {
    private BufferedImage bagSlot;
    private ArrayList<BufferedImage> bagItems = new ArrayList<BufferedImage>();
    private ArrayList<Sprite> itemSprites = new ArrayList<Sprite>();
    private String[] bagArray;
    private String[] test;
    private int iHeight=320;
    private int iWidth=320;
    private Inventory inventory;

    private Sprite s1 = new Sprite("item/beet.png",64 ,64);
    private BufferedImage beet = s1.getSprite(0,0,64,64);
    private Sprite s2 = new Sprite("item/carrot.png",64 ,64);
    private BufferedImage carrot = s2.getSprite(0,0,64,64);
    private Sprite s3 = new Sprite("item/cabbage.png",64 ,64);
    private BufferedImage cabbage = s3.getSprite(0,0,64,64);

    private int index = 0;
    private int index2 = 0;
    private int x = 200;
    private int y = 150;
    public Bag(Inventory inventory)
    {
        this.inventory = inventory;
        bagSlot = GameStateManager.box.getSprite(0,0,130,130);
        bagArray = new String[inventory.getSize()];
        bagArray = inventory.getItems();
        System.out.println("IM A BAG!");
        for(int i = 0; i <inventory.getSize(); i++)
        {
            itemSprites.add(new Sprite("item/"+ bagArray[i] +".png",32 ,32)) ;
            bagItems.add(itemSprites.get(i).getSprite(0,0,64,64));
        }
    }

    public void update(double time) {

    }

    public void input(MouseHandler mouse, KeyHandler key) {

    }


    public void render(Graphics2D g){
        g.drawImage(bagSlot, (int) 200, (int) 150, iWidth, iHeight, null);
        for(int i = 0; i < inventory.getSize(); i++)
        {
            if(i % 3 == 0)
            {
                g.drawImage(bagItems.get(i), (int) 245+i*90, (int) 190+i*90, 64, 64, null);
            }
            else
            {
                g.drawImage(bagItems.get(i), (int) 245+i*90, (int) 190, 64, 64, null);
            }

        }
    }

}
