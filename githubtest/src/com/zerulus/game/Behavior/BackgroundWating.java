package com.zerulus.game.Behavior;

import com.zerulus.game.entity.Player;

import javax.swing.*;

public class BackgroundWating extends SwingWorker {
    private int time;
    private Thread thread = new Thread();
    private String vegetable;
    public int test;
    private Player player;
    public BackgroundWating(int time,String vegetable,Player player)
    {
        if(vegetable!=null)
        {
            this.time = time;
            this.vegetable = vegetable;
            this.player = player;
        }
    }


    public Void doInBackground()
    {
        try{
            test = 0;
            thread.sleep(time);

        }catch (InterruptedException exception)
        {
            exception.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return null;
    }

    protected void done()
    {
        test = 1;
        player.addItem(vegetable);
    }


}
