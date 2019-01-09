package com.zerulus.game.entity;


import com.zerulus.game.Behavior.AnimalsInformation;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.*;

import java.awt.*;
import java.util.Random;

public class Pet extends Entity {

    private AABB sense;
    private int r;

    private boolean draw = false;
    private AnimalsInformation animalsBehavior = new AnimalsInformation(sprite.getSpriteArray(DOWN));

    private String name;
    private String item;
    private Camera cam;
    private Player player;
    private int feedCount;

    public Pet(String name,  Camera cam, Sprite sprite, Vector2f orgin, int size, int feedCount, Player player) {
        super(sprite, orgin, size,1);

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

    public void playmyself(){
        Random ran = new Random();

    }
    private void destroy() {

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
        else{
            playmyself();
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(cam.getBounds().collides(this.bounds)) {
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

    public void input(MouseHandler mouse, KeyHandler key) {
    }

    public void  click(int x, int y){

    }
}
