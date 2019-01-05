package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.entity.Animals;
import com.zerulus.game.entity.Human;
import com.zerulus.game.entity.Player;
import com.zerulus.game.entity.ShopNPC;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.Item;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.*;

import java.awt.*;
import java.util.ArrayList;

public class PlayState extends GameState {

	private Font font;
	private Player player;
	private Human enemy;
	private TileManager tm;
	private Camera cam;
	private Animals cow;
	private Animals llama;
	private Animals pig;
	// private Human man2;
	private ArrayList<Human> human  = new ArrayList<>(5);
	private ShopNPC george;
	private Item apple;

	public static Vector2f map;

	public PlayState(GameStateManager gsm) {
		super(gsm);

		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);

		cam = new Camera(new AABB(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));

		tm = new TileManager("tile/test.xml", cam);

		// enemy = new Human(cam, new Sprite("entity/littlegirl.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) - 32 + 150, 0 + (GamePanel.height / 2) - 32 + 150), 128);
		player = new Player(cam, new Sprite("entity//超商老闆.png",48,48), new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 128);
		cow = new Animals("Cow", new Item("milk"), cam, new Sprite("entity/cow_walk.png",128, 128), new Vector2f(0+(GamePanel.width / 2)+200 , (GamePanel.height / 2)+200), 256, 1);
		llama = new Animals("Llama", new Item("fur"), cam, new Sprite("entity/llama_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 400, (GamePanel.height / 2) + 200), 128, 1);
		pig = new Animals("Pig", new Item("pork"), cam, new Sprite("entity/pig_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128, 1);
		// man2 = new Human(cam, new Sprite("entity/男2_4.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1000, (GamePanel.height / 2) + 1200), 128);cam.target(player);
		george = new ShopNPC(cam, new Sprite("entity/george.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 300, (GamePanel.height / 2) + 800), 64);
		
		human.add(new Human(cam, new Sprite("entity/男1_2.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1300, (GamePanel.height / 2) + 1300), 128, "Gray"));
		human.add(new Human(cam, new Sprite("entity/男2_4.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1500, (GamePanel.height / 2) + 1500), 128, "Tashi"));
		human.add(new Human(cam, new Sprite("entity/男3.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 900, (GamePanel.height / 2) + 900), 128, "Abner"));
		human.add(new Human(cam, new Sprite("entity/男4.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1500, (GamePanel.height / 2) + 1000), 128, "Bill"));
		human.add(new Human(cam, new Sprite("entity/男5.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1300, (GamePanel.height / 2) + 900), 128, "Colin"));
		
		cam.target(player);
	}

	public void update(double time) {
		Vector2f.setWorldVar(map.x, map.y);
		if(!gsm.getState(GameStateManager.PAUSE)) {
			player.update(enemy, time);
			// enemy.update(player);
			cow.update(player);
			//man_1.update(player);
			llama.update(player);
			pig.update(player);
			// man2.update(player);
			george.update(player);
			
			for(int i=0;i<5;i++){
				human.get(i).update(player);
			}
			
			cam.update();
		}
		
		for(int i=0;i<5;i++){
			if(human.get(i).getMarry()){
				gsm.pop(GameStateManager.PLAY);
				gsm.add(GameStateManager.MARRY);
				break;
			}

		}

	}

	public void input(MouseHandler mouse, KeyHandler key) {
		key.escape.tick();
		key.i.tick();

		if(!gsm.getState(GameStateManager.PAUSE)) {
			player.input(mouse, key);
			cam.input(mouse, key);
			// enemy.input(mouse,key);
		}
		if (key.escape.clicked) {
			if(gsm.getState(GameStateManager.PAUSE)) {
				gsm.pop(GameStateManager.PAUSE);
			} else {
				gsm.add(GameStateManager.PAUSE);
			}
		}
	}

	@Override
	public void click(int x, int y) {
		if(!gsm.getState(GameStateManager.PAUSE)) {
			// enemy.click(x,y);
			// man2.click(x, y);
			pig.click(x, y);
			llama.click(x, y);
			cow.click(x, y);
			george.click(x,y);
			
			for(int i=0;i<5;i++){
				human.get(i).click(x,y);
			}
		}
	}

	public void render(Graphics2D g) {
		tm.render(g);
		String fps = GamePanel.oldFrameCount + " FPS";
		Sprite.drawArray(g, fps, new Vector2f(GamePanel.width - fps.length() * 32, 32), 32, 24);

		String tps = GamePanel.oldTickCount + " TPS";
		Sprite.drawArray(g, tps, new Vector2f(GamePanel.width - tps.length() * 32, 64), 32, 24);

		player.render(g);
		// enemy.render(g);
		cow.render(g);
		//man_1.render(g);
		llama.render(g);
		pig.render(g);
		// man2.render(g);
		george.render(g);
		
		for(int i=0;i<5;i++){
			human.get(i).render(g);
		}
		
		cam.render(g);
	}
}
