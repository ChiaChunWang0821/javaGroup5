package com.zerulus.game.entity;

import com.zerulus.game.Behavior.PersonInformation;
import com.zerulus.game.Behavior.Talk;
import com.zerulus.game.ReadFile.TxtReader;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.*;

import java.awt.*;
import java.util.ArrayList;

public class Human extends Entity {

    private AABB sense;
    private int r;
    private int heart=0;
    private PersonInformation pInform;
    private boolean draw=false;

    private Talk talkframe;
    private ArrayList<String> talk ;
    private final String name;
    private int talkTime=0;
    private boolean marry;


    private Camera cam;


    public Human(Camera cam, Sprite sprite, Vector2f orgin, int size, String name) {
        super(sprite, orgin, size);
        this.name = name;
        this.cam = cam;

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

    public void move(Player player) {
        if (sense.colCircleBox(player.getBounds())) {
            if (pos.y > player.pos.y + 1) {
                dy -= acc;
                up = true;
                down = false;
                if (dy < -maxSpeed) {
                    dy = -maxSpeed;
                }
            } else if (pos.y < player.pos.y - 1) {
                dy += acc;
                down = true;
                up = false;
                if (dy > maxSpeed) {
                    dy = maxSpeed;
                }
            } else {
                dy = 0;
                up = false;
                down = false;
            }

            if (pos.x > player.pos.x + 1) {
                dx -= acc;
                left = true;
                right = false;
                if (dx < -maxSpeed) {
                    dx = -maxSpeed;
                }
            } else if (pos.x < player.pos.x - 1) {
                dx += acc;
                right = true;
                left = false;
                if (dx > maxSpeed) {
                    dx = maxSpeed;
                }
            } else {
                dx = 0;
                right = false;
                left = false;
            }
        } else {
            up = false;
            down = false;
            left = false;
            right = false;
            dx = 0;
            dy = 0;
        }
    }

    private void destroy() {

    }
    
    public void setHeart(int heart){
        this.heart = heart;
    }

    public void update(Player player) {
        if(cam.getBounds().collides(this.bounds)) {
            super.update();
            move(player);
            if (!fallen) {
                if (!tc.collisionTile(dx, 0)) {
                    sense.getPos().x += dx;
                    pos.x += dx;
                }
                if (!tc.collisionTile(0, dy)) {
                    sense.getPos().y += dy;
                    pos.y += dy;
                }
            } else {
                destroy();
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(cam.getBounds().collides(this.bounds)) {
            g.setColor(Color.green);
            g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()),
                    (int) bounds.getWidth(), (int) bounds.getHeight());

            g.setColor(Color.blue);
            g.drawOval((int) (sense.getPos().getWorldVar().x), (int) (sense.getPos().getWorldVar().y), r, r);

            g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
        }
        if(draw==true){
            pInform.render(g);
            talkframe.render(g);
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
    	if(clickInside(x,y)){
            talkTime++;
            if(draw==true){
                if(talkTime==1 || talkTime==2){
                    talkframe.setContext(talk.get((heart)*4+(talkTime-1)));  // 更換對話
                }
                else{
                    draw=false;
                    talkTime=0;
                    heart++;
                    if(heart==5){
                        heart=4;
                        marry=true;
                    }
                    pInform.setHeart(heart);
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
    
    public int getHeart() {
        return heart;
    }

    public boolean getMarry(){
        return marry;
    }
}