package com.zerulus.game.Behavior;

import java.util.Random;

import com.zerulus.game.entity.Player;

public class Fishing {

	private Player player;
	private String item;
	private Random random = new Random();;
	private int fish;

    public Fishing(Player player)
    {
    	this.player = player;
    	generateFish();
    }

    public void generateFish() {
    	item = new String();
    	fish = random.nextInt(5);
    	
    	switch(fish) {
    	case 0:
    		// item = ("");
    		break;
    	case 1:
    		// item = ("");
    		break;
    	case 2:
    		// item = ("");
    		break;
    	case 3:
    		// item = ("");
    		break;
    	case 4:
    		// item = ("");
    		break;
    	case 5:
    		// item = ("");
    		break;
    	default:
    		break;
    	}
    }
    
    public void click() {
    	player.setInventory(item);
    }
}
