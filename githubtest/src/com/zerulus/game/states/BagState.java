package com.zerulus.game.states;

import com.zerulus.game.items.Inventory;
import com.zerulus.game.items.Item;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BagState extends GameState {
    BufferedImage bagSlot;
    private int sHeight=320;
    private int sWidth=320;
    BufferedImage beet1;
    Inventory inventory;
    Item beet, broccoli, cabbage, carrot, cucumber, eggplant, cauliflower, onion, pineapple, potato, tomato, flour, bread, milk, cheese, rice;

    public BagState(GameStateManager gsm)
    {
        super(gsm);
        System.out.println("bag");
        bagSlot = GameStateManager.box.getSprite(0,0,130,130);

        beet = new Item("beet");
        broccoli = new Item("broccoli");
        cabbage = new Item("cabbage");
        carrot = new Item("carrot");
        cucumber = new Item("cucumber");
        eggplant = new Item("eggplant");
        cauliflower = new Item("cauliflower");
        onion = new Item("onion");
        pineapple = new Item("pineapple");
        potato = new Item("potato");
        tomato = new Item("tomato");
        flour = new Item("flour");
        bread = new Item("bread");
        milk = new Item("milk");
        cheese = new Item("cheese");
        rice = new Item("rice");
        inventory = new Inventory(beet, broccoli, cabbage, carrot, cucumber, eggplant, cauliflower, onion, pineapple, potato, tomato, flour, bread, milk, cheese, rice);
        String [] allItems = inventory.getItems();
        for(String s : allItems)
        {
            System.out.println(s);
        }

    }
    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {

        bagSlot= GameStateManager.box.getSprite(0,0,130,130);
        g.drawImage(bagSlot, (int) 200, (int)200, sWidth, sHeight, null);//位置

    }
	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub

	}
}
