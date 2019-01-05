package com.zerulus.game.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;
    private int itemCount = 0;

    public Inventory(String... initialItems) {
        items = new HashMap<String, Integer>();
        for (String item : initialItems)
        {
            add(item);
        }

    }

    public synchronized int getQuantity(String item) {
        Integer quantity = items.get(item);
        return quantity == null ? 0 : quantity;
    }

    public synchronized void setQuantity(String item, int quantity) {
        if (quantity == 0)
            items.remove(item);
        else
            items.put(item, quantity);
    }

    public synchronized void add(String item, int quantity) {
        setQuantity(item, getQuantity(item) + quantity);
    }

    public void add(String item) {
        add(item, 1);
    }

    public synchronized boolean remove(String item, int quantity) {
        int currentQuantity = getQuantity(item);
        if (currentQuantity < quantity)
            return false;
        setQuantity(item, currentQuantity - quantity);
        assert getQuantity(item) >= 0;
        return true;
    }

    public boolean remove(String item) {
        return remove(item, 1);
    }

    public int getSize()
    {
        return items.size();
    }

    /*public void printItems()
    {

        for(Map.Entry<Item, Integer> entry: items.entrySet())
        {
           System.out.println(entry.getKey().getItem() + "," + entry.getValue());
        }
    }*/

    public String[] getItems()
    {
        /*for(Map.Entry<Item, Integer> entry: items.entrySet())
        {
            return entry.getKey();
        }*/
        List<String> list = new ArrayList<String>();
        for(String key: items.keySet())
        {
            list.add(key);
        }
        String[] simpleArray = new String[items.size()];
        list.toArray(simpleArray);
        return simpleArray;
    }


   /* public static void main (String[] args) {
        Item item1 = new Item("apple");
        Item item2 = new Item("apple2");
        Inventory invent = new Inventory();
        invent.add(item1, 1);
        invent.add(item2);
        String[] a = new String[invent.getSize()];
        a = invent.getItems();
        for(String s : a)
        {
            System.out.println(s);
        }
    }*/

}
