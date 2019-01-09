package com.zerulus.game.entity;


import com.zerulus.game.GamePanel;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.Bag;
import com.zerulus.game.items.Inventory;
import com.zerulus.game.states.PlayState;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {

    private Camera cam;
    
    private Bag bag;
    private boolean drawBag=false ;
    private Inventory inventory;


    public Player(Camera cam, Sprite sprite, Vector2f orgin, int size) {
        super(sprite, orgin, size);
        this.cam = cam;
        acc = 2f;
        maxSpeed = 4f;
        bounds.setWidth(size/2);
        bounds.setHeight(size);
        bounds.setXOffset(size/4);
        bounds.setYOffset(0);
        
        inventory = new Inventory("beet","cabbage", "carrot", "carrot", "flour");
        bag = new Bag(inventory);
    }

    private void move() {
        if(up) {
            dy -= acc;
            if(dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if(dy < 0) {
                dy += deacc;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }
        if(down) {
            dy += acc;
            if(dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if(dy > 0) {
                dy -= deacc;
                if(dy < 0) {
                    dy = 0;
                }
            }
        }
        if(left) {
            dx -= acc;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if(dx < 0) {
                dx += deacc;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }
        if(right) {
            dx += acc;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if(dx > 0) {
                dx -= deacc;
                if(dx < 0) {
                    dx = 0;
                }
            }
        }
    }

    private void resetPosition() {
        System.out.println("Reseting Player... ");
        pos.x = GamePanel.width / 2 - 32;
        PlayState.map.x = 0;
        cam.getBounds().getPos().x = 0;

        pos.y = GamePanel.height /2 - 32;
        PlayState.map.y = 0;
        cam.getBounds().getPos().y = 0;

        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);

    }

    public void update(Human enemy, double time) {
        super.update();

        attacking = isAttacking(time);

        if(attacking && hitBounds.collides(enemy.getBounds())) {
            System.out.println("I've been hit!");
        }

        if(!fallen) {
            move();
            if(!tc.collisionTile(dx, 0)) {
                //PlayState.map.x += dx;
                pos.x += dx;
                xCol = false;
            } else {
                xCol = true;
            }
            if(!tc.collisionTile(0, dy)) {
                //PlayState.map.y += dy;
                pos.y += dy;
                yCol = false;
            } else {
                yCol = true;
            }
        } else {
            xCol = true;
            yCol = true;
            if(ani.hasPlayedOnce()) {
                resetPosition();
                dx = 0;
                dy = 0;
                fallen = false;
            }
        }
    }
    
    public Inventory getInventory()
    {
        return inventory;
    }

    
    public void setInventory(Inventory inventory)
    {
        //bag.setInventory(inventory);
        this.inventory = inventory;
    }

    public void setInventory(String item)
    {
        //bag.setInventory(item);
        inventory.add(item);
        bag=new Bag(inventory);
        //bag.setInventory(inventory);

        //this.inventory = inventory;
    }
    
    public void addItem(String item)
    {
        inventory.add(item);
        bag = new Bag(inventory);
        //bag.setInventory(item);
    }
    
    public void removeItem(String item)
    {
        inventory.remove(item);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.green);
        g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());

        if(attack) {
            g.setColor(Color.red);
            g.drawRect((int) (hitBounds.getPos().getWorldVar().x + hitBounds.getXOffset()), (int) (hitBounds.getPos().getWorldVar().y + hitBounds.getYOffset()), (int) hitBounds.getWidth(), (int) hitBounds.getHeight());
        }
        //System.out.println(size_w);
        //System.out.println(size_h);
        g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size_w, size_h, null);
        
        if(drawBag){
            bag.render(g);
        }
        
        /*g.setColor(Color.green);
        g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
        if(pos.getWorldVar().x < 0) {
        	
        }*/
    }

    public void input(MouseHandler mouse, KeyHandler key) {

        if(!fallen) {
            if(key.up.down) {
                up = true;
            } else {
                up = false;
            }
            if(key.down.down) {
                down = true;
            } else {
                down = false;
            }
            if(key.left.down) {
                left = true;
            } else {
                left = false;
            }
            if(key.right.down) {
                right = true;
            } else {
                right = false;
            }
            
            if(key.i.clicked)
            {
                if(drawBag == false)
                {
                    bag=new Bag(inventory);
                    bag.setDraw(true);
                    drawBag = true;
                } else {
                    bag.setDraw(false);
                    drawBag = false;
                }
            }

            if(key.attack.down && canAttack) {
                attack = true;
                attacktime = System.nanoTime();
            } else {
                if(!attacking) {
                    attack = false;
                }
            }

            if(up && down) {
                up = false;
                down = false;
            }

            if(right && left) {
                right = false;
                left = false;
            }
        } else {
            up = false;
            down = false;
            right = false;
            left = false;
        }
    }

    public void click(int x, int y) {
        //bag.click(x,y);
    }
}
