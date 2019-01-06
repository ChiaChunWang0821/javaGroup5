package com.zerulus.game.Behavior;

import com.zerulus.game.entity.Player;

import java.util.Random;

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

	public String getItem(){
		return item;
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
    
    /*public void click() {
    	player.setInventory(item);
    }*/
}
