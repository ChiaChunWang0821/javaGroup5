package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Firststate extends GameState{
    private BufferedImage background;
    private BufferedImage start;
    private BufferedImage exit;
    private BufferedImage newstart;
    private boolean loading;
    private static boolean musicStopFirst = true;
    // private int posX=10;
    String music = "res/background/music01.wav";
    Clip clip;
    public Firststate(GameStateManager gsm){
        super(gsm);
        try{
            background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/back2.jpg"));
            start = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/start.png"));
            exit = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/exit.png"));
            newstart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/read.png"));
        }catch(Exception e){
            System.out.println(e);
        }
        if (musicStopFirst){
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
        }

    }

    @Override
    public void update(double time) {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void click(int x, int y) {
        if(x <= 100 + 350 & y <= 500 + 120 & x > 100 & y > 500){
            loading = true;
            PlayState.musicStop = false;
            musicStopFirst = true;
            clip.stop();
            gsm.add(GameStateManager.PLAY);
            gsm.pop(GameStateManager.FIRST);
        }
        if(x <= 500 + 350 & y <= 500 + 120 & x > 500 & y > 500){
        	loading = true;
            PlayState.musicStop = false;
            musicStopFirst = true;
            clip.stop();
            gsm.pop(GameStateManager.PLAY);
            gsm.add(GameStateManager.PLAY);
            gsm.pop(GameStateManager.FIRST);
        }
        if(x <= 900 + 350 & y <= 500 + 120 & x > 900 & y > 500){
            loading = true;
            PlayState.musicStop = false;
            musicStopFirst = true;
            clip.stop();
            gsm.add(GameStateManager.PLAY);
            gsm.pop(GameStateManager.FIRST);
            gsm.getPlayState().setInform();
        }
    }

    @Override
    public void render(Graphics2D g) {
    	 g.drawImage(background,0,0, GamePanel.width,GamePanel.height,null);
         g.drawImage(start,100,500,350,120,null);
         g.drawImage(exit,500,500,350,120,null);
         g.drawImage(newstart,900,500,350,120,null);
         Sprite.drawArray(g, "FLIPPED", new Vector2f(158, 80), 64, 68);
         Sprite.drawArray(g, "Start", new Vector2f(200, 530), 60, 48);
         Sprite.drawArray(g, "New", new Vector2f(620, 530), 60, 50);
         Sprite.drawArray(g, "Read", new Vector2f(1040, 530), 60, 48);
         if (loading == true){
             Sprite.drawArray(g, "Loading..", new Vector2f(470, 330), 60, 48);
         }
    }
}

