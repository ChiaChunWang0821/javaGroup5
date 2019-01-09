package com.zerulus.game.entity;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.AABB;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class Enemy_man extends Entity {

    private AABB sense;
    private int r;

    private Camera cam;

    public Enemy_man(Camera cam, Sprite sprite, Vector2f orgin, int size_h, int size_w) {
        super(sprite, orgin, size_h, size_w);

        this.cam = cam;

        acc = 1f;
        maxSpeed = 2f;
        r = 350;

        bounds.setWidth(42);
        bounds.setHeight(20);
        bounds.setXOffset(12);
        bounds.setYOffset(40);

        sense = new AABB(new Vector2f(orgin.x + size_w / 2 - r / 2, orgin.y + size_h / 2 - r / 2), r);
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
    }
}