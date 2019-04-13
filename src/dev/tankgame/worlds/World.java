package dev.tankgame.worlds;

import dev.tankgame.Handler;
import dev.tankgame.entities.EntityManager;
import dev.tankgame.entities.movingObjects.Tank;
import dev.tankgame.tiles.Tile;
import dev.tankgame.utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height, spawnX1, spawnY1, spawnX2, spawnY2;
    private int[][] tilePos;

    private EntityManager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Tank(1, handler, 100, 100, 0, 0, 0), new Tank(2, handler, 300, 300, 0, 0, 0));

        loadWorld(path);

        entityManager.getTank1().setX(spawnX1);
        entityManager.getTank1().setY(spawnY1);
        entityManager.getTank2().setX(spawnX2);
        entityManager.getTank2().setY(spawnY2);
    }

    public void tick(){
        entityManager.tick();
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCam().getxOffset() / 64);
        int xEnd = (int) Math.min(width, (handler.getGameCam().getxOffset() + handler.getWidth()) / 64 + 1);
        int yStart = (int) Math.max(0, handler.getGameCam().getyOffset() / 64);
        int yEnd = (int) Math.min(height, (handler.getGameCam().getyOffset() + handler.getHeight()) / 64 + 1);


        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTile(x, y).render(g, (int)(x*64 - handler.getGameCam().getxOffset()),
                        (int) (y*64 - handler.getGameCam().getyOffset()));
            }
        }
        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        if (x < 0 || y < 0 || x >= width || y >= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tilePos[x][y]];
        if (t == null){
            return Tile.grassTile;
        }

        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX1 = Utils.parseInt(tokens[2]);
        spawnY1 = Utils.parseInt(tokens[3]);
        spawnX2 = Utils.parseInt(tokens[4]);
        spawnY2 = Utils.parseInt(tokens[5]);

        tilePos = new int[width][height];
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tilePos[x][y] = Utils.parseInt(tokens[(x+y * width) + 6]);
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
