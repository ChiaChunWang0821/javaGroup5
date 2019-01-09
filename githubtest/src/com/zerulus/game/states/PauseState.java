package com.zerulus.game.states;

import com.zerulus.game.ReadFile.TxtWriter;
import com.zerulus.game.ui.Button;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PauseState extends GameState {
    
    private BufferedImage imgButton;
    private Button btnResume;
    private Button btnExit;
    private Button btnBack;
    private PlayState play;

    public PauseState(GameStateManager gsm) {
        super(gsm);
        this.play = gsm.getPlayState();
        imgButton = GameStateManager.ui.getSprite(0, 0, 128, 64);

        btnResume = new Button("SAVE", 32, 24, imgButton, 200, 75, new Vector2f(0, -50), true);
        btnExit = new Button("EXIT", 32, 24, imgButton, 200, 75, new Vector2f(0, 150), true);
        btnBack = new Button("BACK", 32, 24, imgButton, 200, 75, new Vector2f(0, 50), true);

        btnResume.addEvent(e -> {
            gsm.pop(GameStateManager.PAUSE);
            try{
                new TxtWriter(play);
            }catch(IOException ioe){
                System.out.println(ioe);
            }

        });

        btnExit.addEvent(e -> {
            System.exit(0);
        });
        btnBack.addEvent(e -> {
            gsm.pop(GameStateManager.PAUSE);
            PlayState.musicStop = true;
            gsm.add(GameStateManager.FIRST);
        });
    }

    @Override
    public void update(double time) {
        btnResume.update();
        btnExit.update();
        btnBack.update();
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        btnResume.input(mouse, key);
        btnExit.input(mouse, key);
        btnBack.input(mouse, key);
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void render(Graphics2D g) {
        btnResume.render(g);
        btnExit.render(g);
        btnBack.render(g);
    }
}
