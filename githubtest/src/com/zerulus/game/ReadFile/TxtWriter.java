package com.zerulus.game.ReadFile;

import com.zerulus.game.entity.Animals;
import com.zerulus.game.entity.Human;
import com.zerulus.game.entity.Player;
import com.zerulus.game.states.GameState;
import com.zerulus.game.states.PlayState;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TxtWriter {

    private GameState play;
    private ArrayList<Human> human ;
    private ArrayList<Animals> animal ;
    private Player player ;
    FileWriter fw = new FileWriter("res/txt/save.txt");
    public TxtWriter(PlayState play) throws IOException {
        this.play = play;
        human = play.getHuman();
        animal=play.getAnimals();
        player = play.getPlayer();
        for(Human h : human){
            fw.write(h.getHeart()+"\r\n");
        }
        for(Animals a:animal){
            fw.write(a.getFeedCount()+"\r\n");
        }
        fw.write(player.getInventory().getSize()+"\r\n");
        String item[] = player.getInventory().getItems();
        for(String s : item){
            fw.write(s+"\r\n");
            fw.write(player.getInventory().getQuantity(s)+"\r\n");
        }
        fw.close();
    }
}
