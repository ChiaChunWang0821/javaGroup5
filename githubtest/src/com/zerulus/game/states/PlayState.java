package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.entity.Enemy;
// import com.zerulus.game.entity.Enemy_man;
import com.zerulus.game.entity.Player;
import com.zerulus.game.graphics.Font;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.*;

import java.awt.*;

public class PlayState extends GameState {

	private Font font;
	private Player player;
	private Enemy enemy;
	private TileManager tm;
	private Camera cam;
	private Enemy animal;
	// private Enemy_man man_1;
	private Enemy llama;
	private Enemy pig;

	public static Vector2f map;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		
		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);
		
		cam = new Camera(new AABB(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));

		tm = new TileManager("tile/test.xml", cam);

		enemy = new Enemy(cam, new Sprite("entity/littlegirl.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) - 32 + 150, 0 + (GamePanel.height / 2) - 32 + 150), 64);
		player = new Player(cam, new Sprite("entity//男1_2.png",48,48), new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 64);
		animal = new Enemy(cam, new Sprite("entity/cow_walk.png",128, 128), new Vector2f(0+(GamePanel.width / 2)+200 , (GamePanel.height / 2)+200), 256);
		llama = new Enemy(cam, new Sprite("entity/llama_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 400, (GamePanel.height / 2) + 200), 128);
		pig = new Enemy(cam, new Sprite("entity/pig_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128);
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
			cam.update();
		}
		
	}

	public void input(MouseHandler mouse, KeyHandler key) {
		key.escape.tick();

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
	}

	@Override
	public void click(int x, int y) {
		if(!gsm.getState(GameStateManager.PAUSE)) {
			enemy.click(x,y);
			pig.click(x, y);
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
		cam.render(g);
	}
}
