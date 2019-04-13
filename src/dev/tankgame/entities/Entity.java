package dev.tankgame.entities;

import dev.tankgame.Game;
import dev.tankgame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected Handler handler;
    protected float x;
    protected float y;
//    protected int vx;
//    protected int vy;
//    protected int angle;
    protected Rectangle bounds;
//    private BufferedImage img;

    public Entity(Handler handler, float x, float y){
        this.handler = handler;
        this.x = x;
        this.y = y;

        bounds = new Rectangle(0, 0, 64, 64);
    }

//    public Entity(Handler handler, float x, float y, int vx, int vy, int angle){
//        this.handler = handler;
//        this.x = x;
//        this.y = y;
//        this.vx = vx;
//        this.vy = vy;
//        this.angle = angle;
//
//        bounds = new Rectangle(0, 0, 64, 64);
//        //        this.img = img;
//    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if (e.equals(this))
                continue;

            if (e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset),
                bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
