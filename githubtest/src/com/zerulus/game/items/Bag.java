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
    private ArrayList<BufferedImage> bagItems = new ArrayList<BufferedImage>();
    private ArrayList<Sprite> itemSprites = new ArrayList<Sprite>();
    private String[] bagArray;
    private int iHeight=320;
    private int iWidth=320;
    private Inventory inventory;

    private boolean draw;

    public Bag(Inventory inventory)
    {
        this.inventory = inventory;
        bagSlot = GameStateManager.box.getSprite(0,0,130,130);
        bagArray = inventory.getItems();
        for(int i = 0; i <inventory.getSize(); i++)
        {
            itemSprites.add(new Sprite("item/"+ bagArray[i] +".png",32 ,32)) ;
            bagItems.add(itemSprites.get(i).getSprite(0,0,64,64));
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

    public void input(MouseHandler mouse, KeyHandler key) {

    }

    public Inventory getInventory(){
        return inventory;
    }

    public synchronized void render(Graphics2D g){
        g.drawImage(bagSlot, (int) 800, (int) 100, iWidth, iHeight, null);
        int i=0;
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
                if(i==inventory.getSize()){break;}
                try{
                    g.drawImage(bagItems.get(i), (int) 845+b*90, (int) 140+a*90, 64, 64, null);
                    Sprite.drawArray(g, String.valueOf(inventory.getQuantity(bagArray[i])),new Vector2f(890+b*90,180+a*90),32,24);
                    i++;
                }catch (IndexOutOfBoundsException e){
                    System.out.println("OutofBound");
                    return;
                }
            }
        }
    }

    public void setDraw(boolean b) {
        draw = b;
    }
}
