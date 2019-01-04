package com.zerulus.game.items;

public class Item {
    public String name;

    public Item(String name)
    { 
    	this.name = name; 
    }
    
    public Item(Item i)
    { 
    	this.name = i.name;
    }
    
    public String getItem() 
    { 
    	return this.name;
    }
}
