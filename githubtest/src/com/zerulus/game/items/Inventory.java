package com.zerulus.game.items;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Item beet = new Item("beet");
    private Map<Item, Integer> items;

    public Inventory(Item... initialItems) {
        items = new HashMap<Item, Integer>();
        for (Item item : initialItems)
            add(item);
    }

    public synchronized int getQuantity(Item item) {
        Integer quantity = items.get(item);
        return quantity == null ? 0 : quantity;
    }

    public synchronized void setQuantity(Item item, int quantity) {
        if (quantity == 0)
            items.remove(item);
        else
            items.put(item, quantity);
    }

    public synchronized void add(Item item, int quantity) {
        setQuantity(item, getQuantity(item) + quantity);
    }

    public void add(Item item) {
        add(item, 1);
    }

    public synchronized boolean remove(Item item, int quantity) {
        int currentQuantity = getQuantity(item);
        if (currentQuantity < quantity)
            return false;
        setQuantity(item, currentQuantity - quantity);
        assert getQuantity(item) >= 0;
        return true;
    }

    public boolean remove(Item item) {
        return remove(item, 1);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel p = new JPanel(new GridLayout(5,4));
        JScrollPane scrollP = new JScrollPane(p);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollP, BorderLayout.CENTER);

        Inventory inventory = new Inventory(beet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
