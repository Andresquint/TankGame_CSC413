package dev.tankgame.entities.movingObjects;

import dev.tankgame.Handler;
import dev.tankgame.entities.Entity;

public abstract class MovingObject extends Entity {

    public static final int DEFAULT_HEALTH = 1;
//    public static final float DEFAULT_SPEED = 3.0f;

    protected int health;
    protected float speed;
    protected int vx, vy, angle;

    private final int DEFAULT_SPEED = 6;
    private final int ROTATION_SPEED = 4;

    public MovingObject(Handler handler, float x, float y, int vx, int vy, int angle){
        super(handler, x, y);
        this.vx = vx;
        this.vy = vy;
        this.angle = angle;
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
    }

//    public MovingObject(Handler handler, float x, float y, int vx, int vy, int angle) {
//        super(handler, x, y, vx, vy, angle);
//        health = DEFAULT_HEALTH;
//        speed = DEFAULT_SPEED;
//    }

    public void move() {
    }

    public void moveBackwards() {
        if(checkBorder())
            return;

        vx = (int) Math.round(DEFAULT_SPEED * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(DEFAULT_SPEED * Math.sin(Math.toRadians(angle)));
        if (!checkEntityCollisions(vx, vy)) {
            int leftX = (int) (x + bounds.x - vx) / 64;
            int rightX = (int) (x + bounds.x + bounds.width - vx) / 64;
            int topY = (int) (y + bounds.y - vy) / 64;
            int bottomY = (int) (y + bounds.y + bounds.height - vy) / 64;

            if (!collisionWithTile(leftX, topY) &&
                    !collisionWithTile(rightX, topY) &&
                    !collisionWithTile(leftX, bottomY) &&
                    !collisionWithTile(rightX, bottomY)) {
                x -= vx;
                y -= vy;
            }
            // add code here to make tank flush against walls
            // for loop
            //        else{}
        }
    }

    public void moveForwards() {
        if (checkBorder())
            return;

        vx = (int) Math.round(DEFAULT_SPEED * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(DEFAULT_SPEED * Math.sin(Math.toRadians(angle)));

        if (!checkEntityCollisions(vx, vy)) {
            int leftX = (int) (x + bounds.x + vx) / 64;
            int rightX = (int) (x + bounds.x + bounds.width + vx) / 64;
            int topY = (int) (y + bounds.y + vy) / 64;
            int bottomY = (int) (y + bounds.y + bounds.height + vy) / 64;

            if (!collisionWithTile(leftX, topY) &&
                    !collisionWithTile(rightX, topY) &&
                    !collisionWithTile(leftX, bottomY) &&
                    !collisionWithTile(rightX, bottomY)) {
                x += vx;
                y += vy;
            }

            // add code here to make tank flush against walls
            // for loop
            //        else{
            //        }
        }
    }

    public void rotateLeft() {
        this.angle -= this.ROTATION_SPEED;
    }

    public void rotateRight() {
        this.angle += this.ROTATION_SPEED;
    }

    // barrier walls do not have to be collidable because this function takes care of that
    // if the x or y of the tank is beyond borders, adjust borders
    public boolean checkBorder() {
        if (x < 64) {
            x = 64;
            return true;
        }
        if (x >= 1856 - 64) {
            x = 1856 - 64;
            return true;
        }
        if (y < 64) {
            y = 64;
            return true;
        }
        if (y >= 1216 - 64) {
            y = 1216 - 64;
            return true;
        }
        return false;
    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getvx() {
        return vx;
    }

    public void setvx(int vx) {
        this.vx = vx;
    }

    public float getvy() {
        return vy;
    }

    public void setvy (int vy) {
        this.vy = vy;
    }
}
