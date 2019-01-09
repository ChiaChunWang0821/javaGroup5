package com.zerulus.game.entity;

import com.zerulus.game.Behavior.BackgroundWating;
import com.zerulus.game.Behavior.Planting;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.Inventory;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Farm extends Entity {
    private Camera cam;
    private Inventory inv;
    // private int number;

    private Player player;
    private Planting planting;
    private Sprite vegetableSprite;
    private BackgroundWating backgroundWating;
    private String plant;
    //private TimeUnit timeUnit;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    Thread thread = new Thread();

    public Farm(Camera cam,Sprite sprite, Vector2f orgin, int size, int number, Player player) {
        super(sprite, orgin, size);
        // this.number = number;
        this.cam = cam;
        this.player = player;

        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(size/4);
        bounds.setYOffset(size/4);
    }

    @Override
    public void render(Graphics2D g) //畫出菜!
    {
        //g.setColor(Color.green);
        //g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
        if(cam.getBounds().collides(this.bounds)) {
            g.setColor(Color.green);
            g.drawRect((int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), (int) bounds.getWidth(), (int) bounds.getHeight());

            if(vegetableSprite!=null)
            {
                //System.out.println(backgroundWating.test);
                if(backgroundWating.test==1) {
                    g.drawImage(vegetableSprite.getSprite(0, 0, 64, 64), (int) pos.getWorldVar().x, (int) (pos.getWorldVar().y), (int) bounds.getWidth(), (int) bounds.getHeight(), null);
                }
            }


        }

    }

    public boolean clickInside(int posx, int posy){
        // pos是視窗座標
        // System.out.println(posx);
        // System.out.println(posy);
        if(posx > (int)pos.getWorldVar().x  && posx < (int)pos.getWorldVar().x + (int)bounds.getWidth()  && posy > (int)pos.getWorldVar().y && posy < (int)pos.getWorldVar().y + (int)bounds.getHeight())
        {
            planting = new Planting(player);
            return true;
        }
        return  false;
    }

    public void  click(int x, int y)
    {
        if(clickInside(x,y))
        {
            System.out.println(planting.getItem());
            //wait.run();
            /*try {
                thread.sleep(1000);
                //thread.sleep(0);

            }catch (InterruptedException ie){
                ie.printStackTrace();
            }*/

            /*WaitingTime wait = new WaitingTime(5000);
            executorService.execute(wait);
            executorService.shutdown();*/
            plant = planting.getItem();
            vegetableSprite = new Sprite("item/" + planting.getItem() + ".png" ,(int) bounds.getWidth(), (int) bounds.getHeight());
            backgroundWating = new BackgroundWating(5000,plant,player);
            backgroundWating.execute();
            //vegetableSprite = new Sprite(backgroundWating.getVegetable(), (int) bounds.getWidth(), (int) bounds.getHeight());


            //player.addItem(plant);
        }
    }



}
