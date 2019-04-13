package dev.tankgame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    // STATIC STUFF HERE

    public static Tile[] tiles = new Tile[256];

    // create one instance of a tile and store in tiles array
    public static Tile grassTile = new GrassTile(0);
    public static Tile wallTile = new WallTile(1);
    public static Tile unbreakableWallTile = new UnbreakableWall(2);

    // CLASS
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
