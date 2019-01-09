package com.zerulus.game.Behavior;

import com.zerulus.game.entity.Player;

public class Fishing {

	private Player player;
	private String item;
	public Fishing(Player player)
    {
    	this.player = player;
    	generateFish();
    }

	public String getItem(){
		return item;
	}

    public void generateFish() {
    	item = new String("fish");
    }
}
