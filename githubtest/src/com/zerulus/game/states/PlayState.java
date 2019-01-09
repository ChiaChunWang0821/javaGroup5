package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.ReadFile.TxtReader;
import com.zerulus.game.entity.*;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.items.Inventory;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.*;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class PlayState extends GameState {

	private Player player;
	private Human enemy;
	private TileManager tm;
	private Camera cam;

	private ArrayList<Farm> farm = new ArrayList<>(9);
	private ArrayList<Sea> seas = new ArrayList<>(9);

	private ArrayList<Animals> animals = new ArrayList<>(3);
	private ArrayList<Human> human  = new ArrayList<>(5);
	private ArrayList<Pet> pets= new ArrayList<>(3);

	String music = "res/background/music02.wav";
	String musicclick = "res/background/click.wav";
	public static Vector2f map;
	protected static boolean musicStop;
	Clip clip;

	public PlayState(GameStateManager gsm) {
		super(gsm);

		try {
			File file = new File(music);
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);

		cam = new Camera(new AABB(new Vector2f(0, 0), GamePanel.width + 64, GamePanel.height + 64));

		tm = new TileManager("tile/test.xml", cam);

        player = new Player(cam, new Sprite("entity//超商老闆.png",48,48), new Vector2f(0 + (GamePanel.width / 2)+500, 0 + (GamePanel.height / 2) + 1300), 128);

		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(190,190)/*框框起始位置 世界座標*/,256 ,1, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(380,190)/*框框起始位置 世界座標*/,256 ,2, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(570,190)/*框框起始位置 世界座標*/,256 ,3, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(190,380)/*框框起始位置 世界座標*/,256 ,4, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(380,380)/*框框起始位置 世界座標*/,256 ,5, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(570,380)/*框框起始位置 世界座標*/,256 ,6, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(190,570)/*框框起始位置 世界座標*/,256 ,7, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(380,570)/*框框起始位置 世界座標*/,256 ,8, player, 0));
		farm.add(new Farm(cam , new Sprite("entity//heart.png",128,128),new Vector2f(570,570)/*框框起始位置 世界座標*/,256 ,9, player, 0));

		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 1900), 316, 1, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 2058), 316, 2, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 2216), 316, 3, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 2374), 316, 4, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 2532), 316, 5, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 2690), 316, 6, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 2848), 316, 7, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 3006), 316, 8, player, 0));
		seas.add(new Sea(cam, new Sprite("entity//heart.png", 128, 128), new Vector2f(3008, 3164), 316, 9, player, 0));

		animals.add(new Animals("Cow", new String("milk"), cam, new Sprite("entity/cow_walk.png",128, 128), new Vector2f(0+(GamePanel.width / 2)+200 , (GamePanel.height / 2)+200), 256, 1, player));
		animals.add(new Animals("Llama", new String("wool"), cam, new Sprite("entity/llama_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 400, (GamePanel.height / 2) + 200), 128, 1, player));
		animals.add(new Animals("Pig", new String("meat"), cam, new Sprite("entity/pig_walk.png", 128, 128), new Vector2f(0 + (GamePanel.width / 2) + 800, (GamePanel.height / 2) + 200), 128, 1, player));
		
		pets.add(new Pet("Dog", cam, new Sprite("entity/p.png", 96, 96), new Vector2f(0 + (GamePanel.width / 2)+500, 0 + (GamePanel.height / 2) + 1300) , 96, 1, player));
		
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
			for(int i = 0; i < 3; i++) {
				animals.get(i).update(player);
			}
			pets.get(0).update(player);
			cam.update();
		}
		
		for(int i=0;i<5;i++){
			if(human.get(i).getMarry()){
				gsm.add(GameStateManager.MARRY);
				break;
			}
		}
		
		if (musicStop){
			clip.stop();
		}
		else {
			clip.start();
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
			for(int i = 0; i < 9; i++){
				farm.get(i).click(x, y);
			}
			for(int i = 0; i < 9; i++) {
				seas.get(i).click(x, y);
			}
			for(int i=0;i<5;i++){
				human.get(i).click(x,y);
			}
			for(int i = 0; i < 3; i++) {
				animals.get(i).click(x, y);
			}
			player.click(x,y);
		}
		try {
            Clip clickclip;
            File file = new File(musicclick);
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clickclip = (Clip)AudioSystem.getLine(info);
            clickclip.open(ais);
            clickclip.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
	}

	public void render(Graphics2D g) {
		tm.render(g);
		String fps = GamePanel.oldFrameCount + " FPS";
		Sprite.drawArray(g, fps, new Vector2f(GamePanel.width - fps.length() * 32, 32), 32, 24);

		String tps = GamePanel.oldTickCount + " TPS";
		Sprite.drawArray(g, tps, new Vector2f(GamePanel.width - tps.length() * 32, 64), 32, 24);

		for(int i = 0; i < 9; i++){
			farm.get(i).render(g);
		}
		for(int i = 0; i < 9; i++) {
			seas.get(i).render(g);
		}
		for(int i=0;i<5;i++){
			human.get(i).render(g);
		}
		for(int i = 0; i < 3; i++) {
			animals.get(i).render(g);
		}
		pets.get(0).render(g);
		cam.render(g);
		player.render(g);
	}
	
	public ArrayList<Human> getHuman() {
		return human;
	}

	public ArrayList<Animals> getAnimals() {
		return animals;
	}

	public Player getPlayer() {
		return player;
	}

	public void setInform() {
		TxtReader reader = new TxtReader();
		ArrayList<String> record = reader.InputRecord("save.txt");
		for(int i=0;i<5;i++){
			try{
				human.get(i).setHeart(record.get(i));
			}catch(Exception e){
			}
		}
		for(int i=0;i<3;i++){
			try{
				animals.get(i).setFeedCount(record.get(i+5));
			}catch (Exception e){
			}
		}
		
		int tmpCount = Integer.parseInt(record.get(8));
		Inventory tmpInv = new Inventory();
		for(int i=0;i<tmpCount*2;i+=2){
			try {
				System.out.println(record.get(i+9)+record.get(i+10));
				tmpInv.add(record.get(i+9), Integer.parseInt(record.get(i+10)));
			}catch (Exception e){
			}
		}
		player.setInventory(tmpInv);
	}
}
