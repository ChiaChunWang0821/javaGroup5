package com.zerulus.game.tiles;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.Camera;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<TileMap> tm;
    public Camera cam;

    public TileManager() {
        tm = new ArrayList<TileMap>();
    }

    public TileManager(String path, Camera cam) {
        tm = new ArrayList<TileMap>();
        addTileMap(path, 64, 64, cam);
    }

    public TileManager(String path, int blockWidth, int blockHeight, Camera cam) {
        tm = new ArrayList<TileMap>();
        addTileMap(path, blockWidth, blockHeight, cam);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight, Camera cam) {
        this.cam = cam;
        String imagePath;

        int width = 0;
        int height = 0;
        int tileWidth;
        int tileHeight;
        int tileCount;
        int tileColumns[] = new int [3];
        int layers = 0;
        Sprite[] sprite = new Sprite[2];

        String[] data = new String[11];

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("tileset");
            Node node = list.item(0);
            Element eElement = (Element) node;

            imagePath = eElement.getAttribute("name");
            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));
            tileCount = Integer.parseInt(eElement.getAttribute("tilecount"));
            tileColumns[0] =  Integer.parseInt(eElement.getAttribute("columns"));
            sprite[0] = new Sprite("tile/" + imagePath + ".png", tileWidth, tileHeight);

            node = list.item(1);
            eElement = (Element) node;

            imagePath = eElement.getAttribute("name");
            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));
            tileCount = Integer.parseInt(eElement.getAttribute("tilecount"));
            tileColumns[1] =  Integer.parseInt(eElement.getAttribute("columns"));
            sprite[1] = new Sprite("tile/" + imagePath + ".png", tileWidth, tileHeight);


            list = doc.getElementsByTagName("layer");
            layers = list.getLength();

            for(int i = 0; i < layers; i++) {
                node = list.item(i);
                eElement = (Element) node;
                if(i <= 0) {
                    width = Integer.parseInt(eElement.getAttribute("width"));
                    height = Integer.parseInt(eElement.getAttribute("height"));
                }

                data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();
                //System.out.println(data[i]);

                if(i < 10 ) {

                    tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                } else { //i==10

                    tm.add(new TileMapObj(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                }

                cam.setLimit(width * blockWidth, height * blockHeight);

            }
        } catch(Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap");
        }
    }

    public void render(Graphics2D g) {
        if(cam == null)
            return;

        for(int i = 0; i < tm.size(); i++) {
            tm.get(i).render(g, cam.getBounds());
        }
    }
}
