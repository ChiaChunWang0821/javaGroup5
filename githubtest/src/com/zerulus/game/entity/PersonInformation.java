package com.zerulus.game.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PersonInformation extends JFrame {

    private final JLabel label1;
    private final JPanel panelHeart;


    public PersonInformation(int heart, BufferedImage[] img){
            super("好感度");
            setLayout(new GridLayout(4,1));
            setLocation(20,20);
            setSize(400,400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            Image rimg = img[0].getScaledInstance(80,80,Image.SCALE_SMOOTH);
            ImageIcon imageIcon =new ImageIcon(rimg);
            label1 = new JLabel("Lily",imageIcon,SwingConstants.LEFT);
            add(label1);
            draw_heart(heart);
    }

    private void draw_heart(int heart){
        BufferedImage imgHeart;
        String[] src = new String('entity/heart.png');
        for(int i=0;i< heart;i++){
            imgHeart = ImageIO.read(getClass().getClassLoader().getResourceAsStream('entity/heart.png'));

        }
    }

}
