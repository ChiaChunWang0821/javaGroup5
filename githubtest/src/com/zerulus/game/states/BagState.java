package com.zerulus.game.states;

import com.zerulus.game.ui.Button;
import com.zerulus.game.util.KeyHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BagState extends GameState {
    private BufferedImage imgButton;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;

    public BagState(GameStateManager gsm)
    {
        super(gsm);
        System.out.println("bag");
        imgButton = GameStateManager.box.getSprite(0,0,64,64);

        btn1 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(0, -50), true);
        btn2 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(0, 44), true);
        btn3 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(0, 138), true);
        btn4 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(94, -50), true);
        btn5 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(94, 44), true);
        btn6 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(94, 138), true);
        btn7 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(188, -50), true);
        btn8 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(188, 44), true);
        btn9 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(188, 138), true);
        btn10 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(282, -50), true);
        btn11 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(282, 44), true);
        btn12 = new Button("", 32, 24, imgButton, 90, 90, new Vector2f(282, 138), true);

    }
    @Override
    public void update(double time) {
        btn1.update();
        btn2.update();
        btn3.update();
        btn4.update();
        btn5.update();
        btn6.update();
        btn7.update();
        btn8.update();
        btn9.update();
        btn10.update();
        btn11.update();
        btn12.update();
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        btn1.input(mouse, key);
        btn2.input(mouse, key);
        btn3.input(mouse, key);
        btn4.input(mouse, key);
        btn5.input(mouse, key);
        btn6.input(mouse, key);
        btn7.input(mouse, key);
        btn8.input(mouse, key);
        btn9.input(mouse, key);
        btn10.input(mouse, key);
        btn11.input(mouse, key);
        btn12.input(mouse, key);
    }

    @Override
    public void render(Graphics2D g) {
        btn1.render(g);
        btn2.render(g);
        btn3.render(g);
        btn4.render(g);
        btn5.render(g);
        btn6.render(g);
        btn7.render(g);
        btn8.render(g);
        btn9.render(g);
        btn10.render(g);
        btn11.render(g);
        btn12.render(g);
    }
	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
