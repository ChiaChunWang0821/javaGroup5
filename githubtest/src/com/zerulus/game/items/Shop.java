package com.zerulus.game.items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame {
    private JPanel p;
    private JPanel foodPanel1;
    private JPanel foodPanel2;
    private JPanel foodPanel3;
    private JPanel foodPanel4;
    private JPanel foodPanel5;
    private JPanel foodPanel6;
    private JPanel foodPanel7;
    private JPanel foodPanel8;
    private JPanel foodPanel9;
    private JPanel foodPanel10;
    private JPanel foodPanel11;
    private JPanel foodPanel12;
    private JPanel foodPanel13;
    private JPanel foodPanel14;
    private JPanel foodPanel15;
    private JPanel foodPanel16;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;

    private final JLabel label1 = new JLabel();
    private final JLabel label2 = new JLabel();
    private final JLabel label3 = new JLabel();
    private final JLabel label4 = new JLabel();
    private final JLabel label5 = new JLabel();
    private final JLabel label6 = new JLabel();
    private final JLabel label7 = new JLabel();
    private final JLabel label8 = new JLabel();
    private final JLabel label9 = new JLabel();
    private final JLabel label10 = new JLabel();
    private final JLabel label11 = new JLabel();
    private final JLabel label12 = new JLabel();
    private final JLabel label13 = new JLabel();
    private final JLabel label14 = new JLabel();
    private final JLabel label15 = new JLabel();
    private final JLabel label16 = new JLabel();

    public Shop()
    {
        super("shop");
        
        p = new JPanel(new GridLayout(8,2));
        JScrollPane scrollP = new JScrollPane(p);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollP, BorderLayout.CENTER);
        foodPanel1 = new JPanel();
        foodPanel2 = new JPanel();
        foodPanel3 = new JPanel();
        foodPanel4 = new JPanel();
        foodPanel5 = new JPanel();
        foodPanel6 = new JPanel();
        foodPanel7 = new JPanel();
        foodPanel8 = new JPanel();
        foodPanel9 = new JPanel();
        foodPanel10 = new JPanel();
        foodPanel11 = new JPanel();
        foodPanel12 = new JPanel();
        foodPanel13 = new JPanel();
        foodPanel14 = new JPanel();
        foodPanel15 = new JPanel();
        foodPanel16 = new JPanel();

        Icon beet = new ImageIcon(getClass().getResource("item/beet.png"));
        Icon broccoli = new ImageIcon(getClass().getResource("item/broccoli.png"));
        Icon cabbage = new ImageIcon(getClass().getResource("item/cabbage.png"));
        Icon carrot = new ImageIcon(getClass().getResource("item/carrot.png"));
        Icon cucumber = new ImageIcon(getClass().getResource("item/cucumber.png"));
        Icon eggplant = new ImageIcon(getClass().getResource("item/eggplant.png"));
        Icon cauliflower = new ImageIcon(getClass().getResource("item/cauliflower.png"));
        Icon garlic = new ImageIcon(getClass().getResource("item/garlic.png"));
        Icon pineapple = new ImageIcon(getClass().getResource("item/pineapple.png"));
        Icon potato = new ImageIcon(getClass().getResource("item/potato.png"));
        Icon tomato = new ImageIcon(getClass().getResource("item/tomato.png"));
        Icon flour = new ImageIcon(getClass().getResource("item/flour.png"));
        Icon bread = new ImageIcon(getClass().getResource("item/bread.png"));
        Icon milk = new ImageIcon(getClass().getResource("item/milk.png"));
        Icon cheese = new ImageIcon(getClass().getResource("item/cheese.png"));
        Icon rice = new ImageIcon(getClass().getResource("item/carbohydrates.png"));

        label1.setIcon(beet);
        label1.setToolTipText("甜菜種子");
        label2.setIcon(broccoli);
        label2.setToolTipText("花椰菜種子");
        label3.setIcon(cabbage);
        label3.setToolTipText("高麗菜種子");
        label4.setIcon(carrot);
        label4.setToolTipText("胡蘿蔔種子");
        label5.setIcon(cucumber);
        label5.setToolTipText("黃瓜種子");
        label6.setIcon(eggplant);
        label6.setToolTipText("茄子種子");
        label7.setIcon(cauliflower);
        label7.setToolTipText("包菜花種子");
        label8.setIcon(garlic);
        label8.setToolTipText("大蒜種子");
        label9.setIcon(pineapple);
        label9.setToolTipText("鳳梨種子");
        label10.setIcon(potato);
        label10.setToolTipText("馬鈴薯種子");
        label11.setIcon(tomato);
        label11.setToolTipText("番茄種子");
        label12.setIcon(flour);
        label12.setToolTipText("麵粉");
        label13.setIcon(bread);
        label13.setToolTipText("麵包");
        label14.setIcon(milk);
        label14.setToolTipText("牛奶");
        label15.setIcon(cheese);
        label15.setToolTipText("乳酪");
        label16.setIcon(rice);
        label16.setToolTipText("白飯");

        foodPanel1.add(label1);
        textField1 = new JTextField(5);
        foodPanel1.add(textField1);
        button1 = new JButton("Buy");
        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        foodPanel1.add(button1);
        p.add(foodPanel1);

        foodPanel2.add(label2);
        textField2 = new JTextField(5);
        foodPanel2.add(textField2);
        button2 = new JButton("Buy");
        ButtonHandler handler2 = new ButtonHandler();
        button2.addActionListener(handler);
        foodPanel2.add(button2);
        p.add(foodPanel2);

        foodPanel3.add(label3);
        textField3 = new JTextField(5);
        foodPanel3.add(textField3);
        button3 = new JButton("Buy");
        ButtonHandler handler3 = new ButtonHandler();
        button3.addActionListener(handler);
        foodPanel3.add(button3);
        p.add(foodPanel3);

        foodPanel4.add(label4);
        textField4 = new JTextField(5);
        foodPanel4.add(textField4);
        button4 = new JButton("Buy");
        ButtonHandler handler4 = new ButtonHandler();
        button4.addActionListener(handler);
        foodPanel4.add(button4);
        p.add(foodPanel4);

        foodPanel5.add(label5);
        textField5 = new JTextField(5);
        foodPanel5.add(textField5);
        button5 = new JButton("Buy");
        ButtonHandler handler5 = new ButtonHandler();
        button5.addActionListener(handler);
        foodPanel5.add(button5);
        p.add(foodPanel5);

        foodPanel6.add(label6);
        textField6 = new JTextField(5);
        foodPanel6.add(textField6);
        button6 = new JButton("Buy");
        ButtonHandler handler6 = new ButtonHandler();
        button6.addActionListener(handler);
        foodPanel6.add(button6);
        p.add(foodPanel6);

        foodPanel7.add(label7);
        textField7 = new JTextField(5);
        foodPanel7.add(textField7);
        button7 = new JButton("Buy");
        ButtonHandler handler7 = new ButtonHandler();
        button7.addActionListener(handler);
        foodPanel7.add(button7);
        p.add(foodPanel7);

        foodPanel8.add(label8);
        textField8 = new JTextField(5);
        foodPanel8.add(textField8);
        button8 = new JButton("Buy");
        ButtonHandler handler8 = new ButtonHandler();
        button8.addActionListener(handler);
        foodPanel8.add(button8);
        p.add(foodPanel8);

        foodPanel9.add(label9);
        textField9 = new JTextField(5);
        foodPanel9.add(textField9);
        button9 = new JButton("Buy");
        ButtonHandler handler9 = new ButtonHandler();
        button9.addActionListener(handler);
        foodPanel9.add(button9);
        p.add(foodPanel9);

        foodPanel10.add(label10);
        textField10 = new JTextField(5);
        foodPanel10.add(textField10);
        button10 = new JButton("Buy");
        ButtonHandler handler10 = new ButtonHandler();
        button10.addActionListener(handler);
        foodPanel10.add(button10);
        p.add(foodPanel10);

        foodPanel11.add(label11);
        textField11 = new JTextField(5);
        foodPanel11.add(textField11);
        button11 = new JButton("Buy");
        ButtonHandler handler11 = new ButtonHandler();
        button11.addActionListener(handler);
        foodPanel11.add(button11);
        p.add(foodPanel11);

        foodPanel12.add(label12);
        textField12 = new JTextField(5);
        foodPanel12.add(textField12);
        button12 = new JButton("Buy");
        ButtonHandler handler12 = new ButtonHandler();
        button12.addActionListener(handler);
        foodPanel12.add(button12);
        p.add(foodPanel12);

        foodPanel13.add(label13);
        textField13 = new JTextField(5);
        foodPanel13.add(textField13);
        button13 = new JButton("Buy");
        ButtonHandler handler13 = new ButtonHandler();
        button13.addActionListener(handler);
        foodPanel13.add(button13);
        p.add(foodPanel13);

        foodPanel14.add(label14);
        textField14 = new JTextField(5);
        foodPanel14.add(textField14);
        button14 = new JButton("Buy");
        ButtonHandler handler14 = new ButtonHandler();
        button14.addActionListener(handler);
        foodPanel14.add(button14);
        p.add(foodPanel14);

        foodPanel15.add(label15);
        textField15 = new JTextField(5);
        foodPanel15.add(textField15);
        button15 = new JButton("Buy");
        ButtonHandler handler15 = new ButtonHandler();
        button15.addActionListener(handler);
        foodPanel15.add(button15);
        p.add(foodPanel15);

        foodPanel16.add(label16);
        textField16 = new JTextField(5);
        foodPanel16.add(textField16);
        button16 = new JButton("Buy");
        ButtonHandler handler16 = new ButtonHandler();
        button16.addActionListener(handler);
        foodPanel16.add(button16);
        p.add(foodPanel16);
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==button1)
            {
                System.out.println(textField1.getText());
            }
            if(event.getSource()==button2)
            {
                System.out.println(textField2.getText());
            }
            if(event.getSource()==button3)
            {
                System.out.println(textField3.getText());
            }
            if(event.getSource()==button4)
            {
                System.out.println(textField4.getText());
            }
            if(event.getSource()==button5)
            {
                System.out.println(textField5.getText());
            }
            if(event.getSource()==button6)
            {
                System.out.println(textField6.getText());
            }
            if(event.getSource()==button7)
            {
                System.out.println(textField7.getText());
            }
            if(event.getSource()==button8)
            {
                System.out.println(textField8.getText());
            }
            if(event.getSource()==button9)
            {
                System.out.println(textField9.getText());
            }
            if(event.getSource()==button10)
            {
                System.out.println(textField10.getText());
            }
            if(event.getSource()==button11)
            {
                System.out.println(textField11.getText());
            }
            if(event.getSource()==button12)
            {
                System.out.println(textField12.getText());
            }
            if(event.getSource()==button13)
            {
                System.out.println(textField13.getText());
            }
            if(event.getSource()==button14)
            {
                System.out.println(textField14.getText());
            }
            if(event.getSource()==button15)
            {
                System.out.println(textField15.getText());
            }
            if(event.getSource()==button16)
            {
                System.out.println(textField16.getText());
            }
        }
    }

    public static void main(String[] args)
    {
        Shop shop = new Shop();
        shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shop.setSize(400,400);
        shop.setVisible(true);
    }
}
