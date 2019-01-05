package com.zerulus.game.Behavior;

import java.util.Random;

import com.zerulus.game.entity.Player;

public class Planting {

	private Player player;
	private String item;
	private Random random = new Random();;
	private int plant;

    public Planting(Player player)
    {
    	this.player = player;
    	generatePlant();
    }
    
    public void generatePlant() {
    	item = new String();
    	plant = random.nextInt(5);
    	
    	switch(plant) {
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
