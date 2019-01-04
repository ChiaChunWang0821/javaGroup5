package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.entity.Animals;
import com.zerulus.game.entity.Human;
import com.zerulus.game.entity.Player;
import com.zerulus.game.graphics.Font;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.Inventory;
import com.zerulus.game.items.Item;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.*;

import java.awt.*;

public class PlayState extends GameState {

	private Font font;
	private Player player;
	private Human enemy;
	private TileManager tm;
	private Camera cam;
	private Animals animal;
	private Animals llama;
	private Animals pig;
	private Human man2;

	private Inventory inventory;
	private Item apple;

	public static Vector2f map;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		
		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);
		
		cam = new Camera(new AABB(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));

		tm = new TileManager("tile/test.xml", cam);

		inventory = new Inventory(apple);

		enemy = new Human(cam, new Sprite("entity/littlegirl.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) - 32 + 150, 0 + (GamePanel.height / 2) - 32 + 150), 128);
		player = new Player(cam, new Sprite("entity//男1_2.png",48,48), new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 128);
		animal = new Animals(cam, new Sprite("entity/cow_walk.png",128, 128), new Vector2f(0+(GamePanel.width / 2)+200 , (GamePanel.height / 2)+200), 256, 0);
		llama = new Animals(cam, new Sprite("entity/llama_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 400, (GamePanel.height / 2) + 200), 128, 0);
		pig = new Animals(cam, new Sprite("entity/pig_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128, 0);
		man2 = new Human(cam, new Sprite("entity/男2_4.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1000, (GamePanel.height / 2) + 1200), 128);cam.target(player);

		cam.target(player);
	}

	public void update(double time) {
		Vector2f.setWorldVar(map.x, map.y);
		if(!gsm.getState(GameStateManager.PAUSE)) {
			player.update(enemy, time);
			enemy.update(player);
			animal.update(player);
			//man_1.update(player);
			llama.update(player);
			pig.update(player);
			man2.update(player);
			cam.update();
		}
		
	}

	public void input(MouseHandler mouse, KeyHandler key) {
		key.escape.tick();
		key.i.tick();

		if(!gsm.getState(GameStateManager.PAUSE)) {
			player.input(mouse, key);
			cam.input(mouse, key);
			enemy.input(mouse,key);
		}
		if (key.escape.clicked) {
			if(gsm.getState(GameStateManager.PAUSE)) {
				gsm.pop(GameStateManager.PAUSE);
			} else {
				gsm.add(GameStateManager.PAUSE);
			}
        }
		if(key.i.clicked) {
			if(gsm.getState(GameStateManager.INVENTORY)) {
				gsm.pop(GameStateManager.INVENTORY);
			} else {
				gsm.add(GameStateManager.INVENTORY);
			}
		}
	}

	@Override
	public void click(int x, int y) {
		if(!gsm.getState(GameStateManager.PAUSE)) {
			enemy.click(x,y);
			man2.click(x, y);
			pig.click(x, y);
			llama.click(x, y);
			animal.click(x, y);
		}
	}

	public void render(Graphics2D g) {
		tm.render(g);
		String fps = GamePanel.oldFrameCount + " FPS";
		Sprite.drawArray(g, fps, new Vector2f(GamePanel.width - fps.length() * 32, 32), 32, 24);

		String tps = GamePanel.oldTickCount + " TPS";
		Sprite.drawArray(g, tps, new Vector2f(GamePanel.width - tps.length() * 32, 64), 32, 24);
		
		player.render(g);
		enemy.render(g);
		animal.render(g);
		//man_1.render(g);
		llama.render(g);
		pig.render(g);
		man2.render(g);
		cam.render(g);
	}
}
