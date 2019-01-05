package com.zerulus.game.entity;

import com.zerulus.game.Behavior.Fishing;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class Sea extends Entity{
    private Camera cam;
    private int number;

    private Player player;
    private Fishing fishing;
    private String item;
    
    public Sea(Camera cam,Sprite sprite, Vector2f orgin, int size,int number, Player player) {
        super(sprite, orgin, size);
        this.number = number;
        this.cam = cam;
        this.player = player;
        
        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(size/4);
        bounds.setYOffset(size/4);
        
        item = new String("cheese");
    }

    @Override
    public void render(Graphics2D g)
    {
        //g.setColor(Color.green);
        //g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
        if(cam.getBounds().collides(this.bounds)) {
            g.setColor(Color.green);
            g.drawRect((int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), (int) bounds.getWidth(), (int) bounds.getHeight());
            //g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), 50, 50, null);
        }

    }

    public boolean clickInside(int posx, int posy){
        //pos是視窗座標
        // System.out.println(posx);
        // System.out.println(posy);

        if(posx > (int)pos.getWorldVar().x + (int)bounds.getXOffset() && posx < (int)pos.getWorldVar().x + (int)bounds.getXOffset() + (int)bounds.getWidth()  && posy > (int)pos.getWorldVar().y + (int)bounds.getYOffset() && posy < (int)pos.getWorldVar().y + (int)bounds.getYOffset() + (int)bounds.getHeight())
        {
            fishing = new Fishing(item, player);
            return true;
        }
        return  false;
    }

    public void  click(int x, int y)
    {
        if(clickInside(x,y))
        {
            /*if(number == 1)
                System.out.println(number + "SEA YA");*/

            fishing.click();
        }
        /*else {
            if(number == 1)
                System.out.println(number + "SEA NO");
        }*/
    }
}