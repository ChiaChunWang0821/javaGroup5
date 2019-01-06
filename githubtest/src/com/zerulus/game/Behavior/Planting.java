package com.zerulus.game.Behavior;

import com.zerulus.game.entity.Player;

import java.util.Random;

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

    public String getItem(){
        return item;
    }

    public void generatePlant() {
    	item = new String();
    	plant = random.nextInt(5);
    	
    	switch(plant) {
    	case 0:
    		item = ("cabbage");
    		break;
    	case 1:
    	    item = ("broccoli");
    		break;
    	case 2:
    		item = ("fig");
    		break;
    	case 3:
    		item = ("beet");
    		break;
    	case 4:
    		item = ("carrot");
    		break;
    	case 5:
    		item = ("potato");
    		break;
    	default:
    		break;
    	}
    }
    
    /*public void click() {
    	player.setInventory(item);
    }*/
}
