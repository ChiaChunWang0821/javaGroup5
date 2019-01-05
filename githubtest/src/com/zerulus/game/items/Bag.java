package com.zerulus.game.items;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.GameStateManager;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bag {
    private BufferedImage bagSlot;
    private ArrayList<BufferedImage> bagItems = new ArrayList<BufferedImage>(9);
    private ArrayList<Sprite> itemSprites = new ArrayList<Sprite>(9);
    private String[] bagArray;
    private String[] test;
    private int iHeight=320;
    private int iWidth=320;
    private Inventory inventory;

    /*private Sprite s1 = new Sprite("item/beet.png",64 ,64);
    private BufferedImage beet = s1.getSprite(0,0,64,64);
    private Sprite s2 = new Sprite("item/carrot.png",64 ,64);
    private BufferedImage carrot = s2.getSprite(0,0,64,64);
    private Sprite s3 = new Sprite("item/cabbage.png",64 ,64);
    private BufferedImage cabbage = s3.getSprite(0,0,64,64);*/

    private int index = 0;
    private int index2 = 0;
    private int x = 200;
    private int y = 0;

    private boolean draw;

    public Bag(Inventory inventory)
    {
        this.inventory = inventory;
        bagSlot = GameStateManager.box.getSprite(0,0,130,130);
        bagArray = new String[inventory.getSize()];
        bagArray = inventory.getItems();
        for(int i = 0; i <inventory.getSize(); i++)
        {
            itemSprites.add(new Sprite("item/"+ bagArray[i] +".png",32 ,32)) ;
            bagItems.add(itemSprites.get(i).getSprite(0,0,64,64));
        }
    }

    public void loadItem(){
        for(int i = 0; i <inventory.getSize(); i++)
        {
            itemSprites.set(i,new Sprite("item/"+ bagArray[i] +".png",32 ,32)) ;
            bagItems.set(i,itemSprites.get(i).getSprite(0,0,64,64));
        }
    }

    public void AddItem(){
        int i = inventory.getSize()-1;
        {
            itemSprites.add(new Sprite("item/"+ bagArray[i] +".png",32 ,32)) ;
            bagItems.add(itemSprites.get(i).getSprite(0,0,64,64));
        }
    }

    public void update(double time) {

    }

    public void setInventory(Inventory inv){
        this.inventory = inv;
        loadItem();
    }

    public void setInventory(String item){
        inventory.add(item);
        bagArray=inventory.getItems();
        AddItem();
    }

    public void input(MouseHandler mouse, KeyHandler key) {

    }

    public int clickInside(int x, int y){
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
        int choose;
        choose = clickInside(x,y);
        if(choose!=9 && draw==true){
            inventory.remove(bagArray[choose]);
            bagArray=inventory.getItems();
            loadItem();
        }
        loadItem();
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void render(Graphics2D g){
        g.drawImage(bagSlot, (int) 800, (int) 100, iWidth, iHeight, null);
        int i=0;
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
                if(i==inventory.getSize()){break;}
                 g.drawImage(bagItems.get(i), (int) 845+b*90, (int) 140+a*90, 64, 64, null);
                Sprite.drawArray(g, String.valueOf(inventory.getQuantity(bagArray[i])),new Vector2f(890+b*90,180+a*90),32,24);
                i++;
            }
        }
    }

    public void setDraw(boolean b) {
        draw = b;
    }
}
