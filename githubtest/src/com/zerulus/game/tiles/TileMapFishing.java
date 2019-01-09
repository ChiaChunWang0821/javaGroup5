package com.zerulus.game.tiles;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.tiles.blocks.Block;
import com.zerulus.game.tiles.blocks.HoleBlock;
import com.zerulus.game.util.AABB;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class TileMapFishing extends TileMap {

    private Block[] blocks;

    private int tileWidth;
    private int tileHeight;

    private int height;

    public TileMapFishing(String data, Sprite sprite[], int width, int height, int tileWidth, int tileHeight, int tileColumns[]) {

        blocks = new Block[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        this.height = height;

        String[] block = data.split(",");

        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                if (temp < 1729 && temp > 0) {
                    blocks[i] = new HoleBlock(sprite[0].getSprite((int) ((temp - 1) % tileColumns[0]), (int) ((temp - 1) / tileColumns[0])), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                else {
                	temp = temp - 1728;
                    blocks[i] = new HoleBlock(sprite[1].getSprite((int) ((temp - 1) % tileColumns[1]), (int) ((temp - 1) / tileColumns[1])), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                /*else if (temp >= 1729 && temp < 2753) {
                    temp = temp - 1728;
                    blocks[i] = new HoleBlock(sprite[1].getSprite((int) ((temp - 1) % tileColumns[1]), (int) ((temp - 1) / tileColumns[1])), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                } else if (temp >= 2753) {
                    temp = temp - 2752;
                    blocks[i] = new HoleBlock(sprite[2].getSprite((int) ((temp - 1) % tileColumns[2]), (int) ((temp - 1) / tileColumns[2])), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }*/
            }

        }

    }


    public void render(Graphics2D g, AABB cam) {

        int x = (int) ((cam.getPos().x) / tileWidth);
        int y = (int) ((cam.getPos().y) / tileHeight);
        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                try{
                    if(blocks[i + (j * height)] != null)
                    blocks[i + (j * height)].render(g);
                }catch(Exception e){
                    //System.out.println(e);
                }
            }
        }
    }
}
