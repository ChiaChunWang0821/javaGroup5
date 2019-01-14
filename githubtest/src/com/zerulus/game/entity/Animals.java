package com.zerulus.game.entity;

import com.zerulus.game.Behavior.AnimalsInformation;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.*;

import java.awt.*;

public class Animals extends Entity {

    private AABB sense;
    private int r;

    private boolean draw = false;
    private AnimalsInformation animalsBehavior = new AnimalsInformation(sprite.getSpriteArray(DOWN));

    private String name;
    private String item;
    private Camera cam;
    private Player player;
    private int feedCount;

    public Animals(String name, String item, Camera cam, Sprite sprite, Vector2f orgin, int size, int feedCount, Player player) {
        super(sprite, orgin, size);

        this.name = name;
        this.item = item;
        this.cam = cam;
        this.feedCount = feedCount;
        this.player = player;

        acc = 1f;
        maxSpeed = 2f;
        r = 350;

        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(size/4);
        bounds.setYOffset(size/4);

        sense = new AABB(new Vector2f(orgin.x + size / 2 - r / 2, orgin.y + size / 2 - r / 2), r);
    }

    public Animals(String name,  Camera cam, Sprite sprite, Vector2f orgin, int size, int feedCount, Player player) {
        super(sprite, orgin, size);

        this.name = name;
        this.cam = cam;
        this.feedCount = feedCount;
        this.player = player;

        acc = 1f;
        maxSpeed = 2f;
        r = 350;

        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(size/4);
        bounds.setYOffset(size/4);

        sense = new AABB(new Vector2f(orgin.x + size / 2 - r / 2, orgin.y + size / 2 - r / 2), r);
    }

    private void destroy() {

    }

    public void update(Player player) {
        if(cam.getBounds().collides(this.bounds)) {
            super.update();
            // move(player);
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
            g.setColor(Color.blue);

            g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
        }

        if(draw == true) {
            animalsBehavior.render(g, name, feedCount);
        }
        if(feedCount > 5) {
            player.setInventory(item);
            feedCount = 0;
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
            if(draw == true){
                draw = false;
                this.feedCount++;
                setAnimation(RIGHT,sprite.getSpriteArray(RIGHT),1000);
            }
            else{
                draw = true;
                setAnimation(DOWN,sprite.getSpriteArray(DOWN),1000);
            }
        }
    }

    public int getFeedCount() {
        return feedCount;
    }

    public void setFeedCount(String s) {
        feedCount = Integer.parseInt(s);
    }
}
