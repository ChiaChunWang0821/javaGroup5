package com.zerulus.game.entity;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.ShopMenu;
import com.zerulus.game.util.*;

import java.awt.*;

public class ShopNPC extends Entity {

    private AABB sense;
    private int r;
    private ShopMenu pInform = new ShopMenu(sprite.getSpriteArray(DOWN));
    private boolean draw=false;
    private Camera cam;


    public ShopNPC(Camera cam, Sprite sprite, Vector2f orgin, int size) {
        super(sprite, orgin, size);
        this.cam = cam;

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
    }

    @Override
    public void render(Graphics2D g) {
        if(cam.getBounds().collides(this.bounds)) {
            g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
        }
        if(draw==true){
            pInform.render(g);
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
            if(draw==true){draw=false;setAnimation(RIGHT,sprite.getSpriteArray(RIGHT),1000);}
            else{draw=true;setAnimation(DOWN,sprite.getSpriteArray(DOWN),1000);}
        }
    }
}
