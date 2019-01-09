package com.zerulus.game.entity;

import com.zerulus.game.Behavior.BackgroundWating;
import com.zerulus.game.Behavior.Fishing;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.Camera;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class Sea extends Entity {
    private Camera cam;

    private Player player;
    private Fishing fishing;
    private Sprite fishSprite;
    private BackgroundWating backgroundWating;
    private String fish;
    private int collect = 0;
    private Sprite farmBlockSprite;

    Thread thread = new Thread();

    public Sea(Camera cam,Sprite sprite, Vector2f orgin, int size, int number, Player player, int collect) {
        super(sprite, orgin, size);
        this.cam = cam;
        this.player = player;
        this.collect = collect;

        bounds.setWidth(size/2);
        bounds.setHeight(size/2);
        bounds.setXOffset(size/4);
        bounds.setYOffset(size/4);
    }

    @Override
    public void render(Graphics2D g)
    {
        if(cam.getBounds().collides(this.bounds)) {
            if(fishSprite!=null)
            {
                if(backgroundWating.test==1) {
                    g.drawImage(fishSprite.getSprite(0, 0, 64, 64), (int) pos.getWorldVar().x, (int) (pos.getWorldVar().y), (int) bounds.getWidth(), (int) bounds.getHeight(), null);
                    collect = 1;
                }
            }
            
            if(collect == 2) {
            	g.drawImage(farmBlockSprite.getSprite(0, 0, 64, 64), (int) pos.getWorldVar().x, (int) (pos.getWorldVar().y), (int) bounds.getWidth(), (int) bounds.getHeight(), null);
            	collect = 0;
            }
        }
    }

    public boolean clickInside(int posx, int posy){
        if(posx > (int)pos.getWorldVar().x  && posx < (int)pos.getWorldVar().x + (int)bounds.getWidth()  && posy > (int)pos.getWorldVar().y && posy < (int)pos.getWorldVar().y + (int)bounds.getHeight())
        {
        	fishing = new Fishing(player);
            return true;
        }
        return  false;
    }

    public void  click(int x, int y)
    {
        if(clickInside(x,y))
        {
        	farmBlockSprite = new Sprite("background/seaBlock.png" ,(int) bounds.getWidth(), (int) bounds.getHeight());
        	
        	if(collect == 0) {
        		fish = fishing.getItem();
        		fishSprite = new Sprite("item/" + fishing.getItem() + ".png" ,(int) bounds.getWidth(), (int) bounds.getHeight());
                backgroundWating = new BackgroundWating(5000, fish, player);
                backgroundWating.execute();
        	}
        	else if(collect == 1){
        		player.addItem(fish);
        		collect = 2;
        		backgroundWating.test = 0;
        	}
        }
    }
}
