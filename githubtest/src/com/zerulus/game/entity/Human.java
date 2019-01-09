package com.zerulus.game.entity;

import com.zerulus.game.Behavior.PersonInformation;
import com.zerulus.game.Behavior.Talk;
import com.zerulus.game.ReadFile.TxtReader;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.Bag;
import com.zerulus.game.items.Inventory;
import com.zerulus.game.util.*;

import java.awt.*;
import java.util.ArrayList;

public class Human extends Entity {

    private AABB sense;
    private int r;
    private int heart=0;
    private PersonInformation pInform;
    private boolean draw=false;

    private Player player;
    private Talk talkframe;
    private ArrayList<String> talk ;
    private final String name;
    private int talkTime=0;
    private boolean marry;
    private boolean drawBag;
    private Inventory inv;
    private Bag bag;
    private Camera cam;

    public Human(Camera cam, Sprite sprite, Vector2f orgin, int size, String name,Player player) {
        super(sprite, orgin, size);
        this.name = name;
        this.cam = cam;
        this.player = player;

        pInform = new PersonInformation(heart,sprite.getSpriteArray(DOWN),name);
        talkframe= new Talk(name);
        
        acc = 1f;
        maxSpeed = 2f;
        r = 350;

        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(size/4);
        bounds.setYOffset(size/4);

        sense = new AABB(new Vector2f(orgin.x + size / 2 - r / 2, orgin.y + size / 2 - r / 2), r);
        
        TxtReader tmp = new TxtReader();
        talk = tmp.InputTalk(name+".txt");
    }


    @Override
    public void render(Graphics2D g) {
        if(cam.getBounds().collides(this.bounds)) {        	
            g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
        }
        if(draw==true){
            pInform.render(g);
            talkframe.render(g);
        }

        if(drawBag){
            bag.render(g);
        }
    }

    public boolean clickInside(int posx, int posy){
        if(posx > (int)pos.getWorldVar().x + (int)bounds.getXOffset() && posx < (int)pos.getWorldVar().x + (int)bounds.getXOffset() + (int)bounds.getWidth()  && posy > (int)pos.getWorldVar().y + (int)bounds.getYOffset() && posy < (int)pos.getWorldVar().y + (int)bounds.getYOffset() + (int)bounds.getHeight()){
            return true;
        }
        return  false;
    }

    public void input(MouseHandler mouse, KeyHandler key) {
    }

    public void  click(int x, int y){
        int i;
        if(clickInside(x,y)){
            if(talkTime==-1){
                draw=false;
                talkTime=0;
            }
            else{
                talkTime++;
                if(draw==true){
                    if(talkTime==1 || talkTime==2){
                        talkframe.setContext(talk.get((heart)*4+(talkTime-1)));  // 更換對話
                    }
                    else{
                        draw=false;
                        talkTime=0;
                        setAnimation(RIGHT,sprite.getSpriteArray(RIGHT),1000);
                    }
                }
                else{
                    draw=true;
                    talkframe.setContext(talk.get((heart)*4+0));
                    setAnimation(DOWN,sprite.getSpriteArray(DOWN),1000);
                }
            }
        }
        if(draw==true && clickButton(x,y)){
            if(drawBag==false){
                this.inv = player.getInventory();
                this.bag = new Bag(inv);
                bag.setDraw(true);
                drawBag=true;
            }
            else{
                drawBag=false;
            }
        }
        if(draw==true && drawBag==true && (i=clickBag(x,y))!=9){
            String s = inv.getItems()[i];
            checkLike(s);
            player.removeItem(s);
        }
    }

    private void checkLike(String s){
        drawBag=false;
        if(s.equals(talk.get(20)) || s.equals(talk.get(21)) || s.equals(talk.get(22))){
            talkframe.setContext(talk.get((heart)*4+2));
            heart++;
            pInform.setHeart(heart);
            if(heart==5){
                heart=4;
                marry=true;
            }
        }
        else if(s.equals(talk.get(23)) || s.equals(talk.get(24)) || s.equals(talk.get(25))){
            talkframe.setContext(talk.get((heart)*4+3));
            if(heart!=0){
                heart--;
            }
            pInform.setHeart(heart);
        }
        else{
            talkframe.setContext("好 謝謝");
        }
        talkTime=-1;
        this.inv = player.getInventory();
        this.bag=new Bag(inv);
    }

    private int clickBag(int x, int y) {
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

    private boolean clickButton(int x, int y) {
        if(x > 83 && x <176 && y > 238 && y < 264 ){
            return true;
        }
        return false;
    }

    public int getHeart() {
        return heart;
    }

    public boolean getMarry(){
        return marry;
    }

    public void setHeart(String s) {
        heart = Integer.parseInt(s);
        pInform.setHeart(heart);
    }
}
