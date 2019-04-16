package dev.tankgame.worlds;

import dev.tankgame.Handler;
import dev.tankgame.entities.EntityManager;
import dev.tankgame.entities.movingObjects.Tank;
import dev.tankgame.entities.statics.LifeBoost;
import dev.tankgame.entities.statics.UnbreakableWall;
import dev.tankgame.entities.statics.Wall;
import dev.tankgame.tiles.Tile;
import dev.tankgame.utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height, spawnX1, spawnY1, spawnX2, spawnY2;
    private int[][] tilePos;

    // Entities
    private EntityManager entityManager;
    // Items


    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Tank(1, handler, 100, 100, 0, 0, 0), new Tank(2, handler, 300, 300, 0, 0, 0));

        loadWorld(path);
//        entityManager.addEntity(new LifeBoost(handler, 100, 100));

        entityManager.getTank1().setX(spawnX1);
        entityManager.getTank1().setY(spawnY1);
        entityManager.getTank2().setX(spawnX2);
        entityManager.getTank2().setY(spawnY2);

        entityManager.addEntity(new LifeBoost(handler, 250, 300));
        entityManager.addEntity(new LifeBoost(handler, 600, 400));
        entityManager.addEntity(new LifeBoost(handler, 1000, 800));
        entityManager.addEntity(new LifeBoost(handler, 24*64, 15*64));

        //        entityManager.addEntity(new DamageBoost(handler, 100, 800));


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
                if(tilePos[x][y] == 1){
                    entityManager.addEntity(new Wall(handler, (float) (x * 64), (float) (y * 64)));
                }
                if(tilePos[x][y] == 2){
                    entityManager.addEntity(new UnbreakableWall(handler, (float)(x*64), (float)(y*64)));
                }
            }
        }
    }

    public void setTileArray(int x, int y, int newID){
        this.tilePos[x][y] = newID;
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

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public int getSpawnX1() {
        return spawnX1;
    }

    public void setSpawnX1(int spawnX1) {
        this.spawnX1 = spawnX1;
    }

    public int getSpawnY1() {
        return spawnY1;
    }

    public void setSpawnY1(int spawnY1) {
        this.spawnY1 = spawnY1;
    }

    public int getSpawnX2() {
        return spawnX2;
    }

    public void setSpawnX2(int spawnX2) {
        this.spawnX2 = spawnX2;
    }

    public int getSpawnY2() {
        return spawnY2;
    }

    public void setSpawnY2(int spawnY2) {
        this.spawnY2 = spawnY2;
    }
}
