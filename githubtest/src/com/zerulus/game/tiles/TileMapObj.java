package com.zerulus.game.tiles;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.tiles.blocks.Block;
import com.zerulus.game.tiles.blocks.ObjBlock;
import com.zerulus.game.util.AABB;
import com.zerulus.game.util.Vector2f;

import java.awt.*;

public class TileMapObj extends TileMap {

    public static Block[] event_blocks;

    private int tileWidth;
    private int tileHeight;

    public static int width;
    public static int height;

    public TileMapObj(String data, Sprite sprite[], int width, int height, int tileWidth, int tileHeight, int tileColumns[]) {
        Block tempBlock;
        event_blocks = new Block[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        TileMapObj.width = width;
        TileMapObj.height = height;

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            long temp = Long.parseLong(block[i].replaceAll("\\s+",""),10);
            if(temp != 0)
            {
                if(temp < 1729 && temp > 0) {
                    tempBlock = new ObjBlock(sprite[0].getSprite((int) ((temp - 1) % tileColumns[0]), (int) ((temp - 1) / tileColumns[0])), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                else  {
                    temp = temp -1728;
                    tempBlock = new ObjBlock(sprite[1].getSprite((int) ((temp - 1) % tileColumns[1]), (int) ((temp - 1) / tileColumns[1])), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                event_blocks[i] = tempBlock;
            }
        }
    }

    public void render(Graphics2D g, AABB cam) {
        int x = (int) ((cam.getPos().x) / tileWidth);
        int y = (int) ((cam.getPos().y) / tileHeight);
        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if(event_blocks[i + (j * height)] != null)
                    event_blocks[i + (j * height)].render(g);
            }
        }
    }
}
