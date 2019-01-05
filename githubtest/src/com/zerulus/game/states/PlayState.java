package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.entity.Animals;
import com.zerulus.game.entity.Human;
import com.zerulus.game.entity.Player;
import com.zerulus.game.entity.ShopNPC;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.*;

import java.awt.*;
import java.util.ArrayList;

public class PlayState extends GameState {

	private Player player;
	private Human enemy;
	private TileManager tm;
	private Camera cam;
	private ArrayList<Animals> animals = new ArrayList<>(3);
	private ArrayList<Human> human  = new ArrayList<>(5);
	private ShopNPC george;

	public static Vector2f map;

	public PlayState(GameStateManager gsm) {
		super(gsm);

		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);

		cam = new Camera(new AABB(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));

		tm = new TileManager("tile/test.xml", cam);

		player = new Player(cam, new Sprite("entity//超商老闆.png",48,48), new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 128);
		george = new ShopNPC(cam, new Sprite("entity/george.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 300, (GamePanel.height / 2) + 800), 64);

		animals.add(new Animals("Cow", new String("milk"), cam, new Sprite("entity/cow_walk.png",128, 128), new Vector2f(0+(GamePanel.width / 2)+200 , (GamePanel.height / 2)+200), 256, 1,player));
		animals.add(new Animals("Llama", new String("fig"), cam, new Sprite("entity/llama_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 400, (GamePanel.height / 2) + 200), 128, 1,player));
		animals.add(new Animals("Pig", new String("meat"), cam, new Sprite("entity/pig_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128, 1,player));

		human.add(new Human(cam, new Sprite("entity/男1_2.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1300, (GamePanel.height / 2) + 1300), 128, "Gray",player));
		human.add(new Human(cam, new Sprite("entity/男2_4.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1500, (GamePanel.height / 2) + 1500), 128, "Tashi",player));
		human.add(new Human(cam, new Sprite("entity/男3.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 900, (GamePanel.height / 2) + 900), 128, "Abner",player));
		human.add(new Human(cam, new Sprite("entity/男4.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1500, (GamePanel.height / 2) + 1000), 128, "Bill",player));
		human.add(new Human(cam, new Sprite("entity/男5.png", 48, 48), new Vector2f(0 + (GamePanel.width / 2) + 1300, (GamePanel.height / 2) + 900), 128, "Colin",player));
		
		cam.target(player);
	}

	public void update(double time) {
		Vector2f.setWorldVar(map.x, map.y);
		if(!gsm.getState(GameStateManager.PAUSE)) {
			player.update(enemy, time);
			/*for(int i=0;i<5;i++){
				human.get(i).update(player);
			}*/
			for(int i = 0; i < 3; i++) {
				animals.get(i).update(player);
			}
			george.update(player);
			cam.update();
		}
		
		for(int i=0;i<5;i++){
			if(human.get(i).getMarry()){
				// gsm.pop(GameStateManager.PLAY);
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
			for(int i=0;i<5;i++){
				human.get(i).click(x,y);
			}
			for(int i = 0; i < 3; i++) {
				animals.get(i).click(x, y);
			}
			george.click(x,y);
			player.click(x,y);
		}
	}

	public void render(Graphics2D g) {
		tm.render(g);
		String fps = GamePanel.oldFrameCount + " FPS";
		Sprite.drawArray(g, fps, new Vector2f(GamePanel.width - fps.length() * 32, 32), 32, 24);

		String tps = GamePanel.oldTickCount + " TPS";
		Sprite.drawArray(g, tps, new Vector2f(GamePanel.width - tps.length() * 32, 64), 32, 24);

		for(int i=0;i<5;i++){
			human.get(i).render(g);
		}
		for(int i = 0; i < 3; i++) {
			animals.get(i).render(g);
		}
		george.render(g);
		cam.render(g);
		player.render(g);
	}
}
