package com.zerulus.game.states;

import com.zerulus.game.GamePanel;
import com.zerulus.game.graphics.Font;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class GameStateManager {

    private GameState states[];

    public static Vector2f map;

    public static final int PLAY = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int MARRY = 3;
    public static final int FIRST = 4;

    public int onTopState = 0;

    public static Font font;
    public static Sprite ui;
    public static Sprite box;
    public static Sprite inform;
    public static Sprite shopMenu;
    public static Sprite shopButton;
    public static Sprite talk;

    public GameStateManager() {
        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);

        states = new GameState[5];

        font = new Font("font/font.png", 10, 10);
        Sprite.currentFont = font;

        ui = new Sprite("ui/ui.png", 64, 64);

        inform = new Sprite("ui/inform.png",64,64);
        box = new Sprite("ui/slot.png", 64, 64);
        shopMenu = new Sprite("ui/board.jpg", 64, 64);
        // shopButton = new Sprite("ui/greenSheet.png", 64, 64);
        talk = new Sprite("ui/talk1.png",64,64);

        states[FIRST] = new Firststate(this);

    }

    public boolean getState(int state) {
        return states[state] != null;
    }

    public void pop(int state) {
        states[state] = null;
    }

    public void add(int state) {
        if (states[state] != null)
            return;
        if (state == FIRST) {
            states[FIRST] = new Firststate(this);
        }
        if (state == PLAY) {
            states[PLAY] = new PlayState(this);
        }
        if (state == MENU) {
            states[MENU] = new MenuState(this);
        }
        if (state == PAUSE) {
            states[PAUSE] = new PauseState(this);
        }
        if (state == MARRY) {
            states[MARRY] = new MarryState(this);
        }
    }

    public void addAndpop(int state) {
        addAndpop(state, 0);
    }

    public void addAndpop(int state, int remove) {
        pop(state);
        add(state);
    }

    public void update(double time) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].update(time);
            }
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].input(mouse, key);
            }
        }        
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].render(g);
            }
        }
    }
    public void click(int x, int y){
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].click(x, y);
            }
        }
    }

}
