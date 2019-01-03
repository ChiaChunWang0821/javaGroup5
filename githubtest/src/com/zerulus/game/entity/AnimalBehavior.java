package com.zerulus.game.entity;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnimalBehavior extends JFrame
{
	private final JButton btn_feed;
	private final JButton btn_collect;
	
	public AnimalBehavior()
	{
		super("Select action");
		setLayout(new GridLayout(4, 1));
		setLocation(20, 20);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        btn_feed = new JButton("Feed");
        btn_collect = new JButton("Collect");
        
        btn_feed.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// FEED!!
        		action_feed();
        	}
        });
        
        btn_collect.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// COLLECT!!
        		action_collect();
        	}
        });
        
        add(btn_feed);
        add(btn_collect);
	}
	
	public void action_feed()
	{
		/*BufferedImage imgHeart;
        String[] src = new String('entity/heart.png');
        for(int i=0;i< heart;i++){
            imgHeart = ImageIO.read(getClass().getClassLoader().getResourceAsStream('entity/heart.png'));

        }*/
	}
	
	public void action_collect()
	{
		
	}
}