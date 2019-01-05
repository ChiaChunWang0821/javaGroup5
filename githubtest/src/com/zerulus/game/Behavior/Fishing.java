package com.zerulus.game.Behavior;

import com.zerulus.game.entity.Player;

public class Fishing {

	private Player player;
	private String item;

    public Fishing(String item, Player player)
    {
    	this.player = player;
    	this.item = item;
    }

    public void click() {
    	player.setInventory(item);
    }
}
