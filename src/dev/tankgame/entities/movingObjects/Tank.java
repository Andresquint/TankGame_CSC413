package dev.tankgame.entities.movingObjects;

import dev.tankgame.Handler;
import dev.tankgame.entities.statics.LifeBoost;
import dev.tankgame.graphics.Assets;
import dev.tankgame.input.TankControl;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Tank extends MovingObject {

//    private final int R = 4;
    private final int ROTATION_SPEED = 4;

    private TankControl tc;
    private int tankNumber;
    private int lifeCount;

    // attack timer
    // might not need these 3 statements; bullets hurt upon collision
//    private long lastAttackTimer;
//    private long attackCooldown = 400;
//    private long attackTimer = attackCooldown;

    public Tank(int tankNumber, Handler handler, float x, float y, int vx, int vy, int angle) {
//        super(handler, x, y, vx, vy, angle);
        super(handler, x, y, angle);
        health = 5;

        this.tankNumber = tankNumber;
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 49;
        bounds.height = 50;
        lifeCount = 3;
    }

    @Override
    public void tick() {
        getInput();
//        System.out.println(angle);
//        System.out.println(x);
//        move();
        handler.getGameCam().centerOnEntity(this);
//        checkAttacks();
        if(checkEntityCollisions(vx, vy)){
            if(getEntityCollided((float) vx, (float) vy) instanceof LifeBoost){
                handler.getWorld().getEntityManager().removeEntity(getEntityCollided((float) vx, (float) vy));
                lifeCount++;
            }
//            if(getEntityCollided((float) vx, (float) vy) instanceof DamageBoost){
//                handler.getWorld().getEntityManager().removeEntity(getEntityCollided((float) vx, (float) vy));
//            }
        }
    }

    @Override
    public void render(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance((x-handler.getGameCam().getxOffset()), (y - handler.getGameCam().getyOffset()));
        rotation.rotate(Math.toRadians(angle), Assets.tank.getWidth() / 2.0, Assets.tank.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        // drawImage() from Graphics2D:
        // drawImage(Image img, AffineTransform xform, ImageObserver obs)
        g2d.drawImage(Assets.tank, rotation, null);
//        g.setColor(Color.white);
//        g.drawRect((int) (x + bounds.x - handler.getGameCam().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCam().getyOffset()),
//                bounds.width, bounds.height);
        g.setColor(Color.ORANGE);
        for (int i = 0; i < lifeCount; i++) {
            g.fillOval((int) (x + (i * 15) - handler.getGameCam().getxOffset()),
                    (int) (y + bounds.y - 12 - handler.getGameCam().getyOffset()),
                    12, 12);
        }
        g.setColor(Color.blue);
        g.fillRect((int)(x - handler.getGameCam().getxOffset()),
                (int) (y + 70 +  - handler.getGameCam().getyOffset()),
                10 * health, 10);
    }

    private void getInput(){
//        vx = 0;
//        vy = 0;

        if (tankNumber == 1) {
            if (handler.getTankControl1().up1) {
                this.moveForwards();
            }
            if (handler.getTankControl1().down1) {
                this.moveBackwards();
            }
            if (handler.getTankControl1().left1) {
                this.rotateLeft();
            }
            if (handler.getTankControl1().right1) {
                this.rotateRight();
            }
            if (handler.getTankControl1().enter){
                this.checkAttacks();
            }
//            if (handler.getTankControl1().checkEntities)
//            {
//                handler.getWorld().getEntityManager().printContents();
//            }
        }

        if (tankNumber == 2){
            if (handler.getTankControl1().up2) {
                this.moveForwards();
            }
            if (handler.getTankControl1().down2) {
                this.moveBackwards();
            }
            if (handler.getTankControl1().left2) {
                this.rotateLeft();
            }
            if (handler.getTankControl1().right2) {
                this.rotateRight();
            }
            if (handler.getTankControl1().space){
                this.checkAttacks();
            }
        }

    }

    @Override
    public void die() {
        lifeCount--;
        health = 5;
        if (tankNumber == 1) {
            x = handler.getWorld().getSpawnX1();
            y = handler.getWorld().getSpawnY1();
        }

        if (tankNumber == 2) {
            x = handler.getWorld().getSpawnX2();
            y = handler.getWorld().getSpawnY2();
        }
        if (lifeCount == 0) {
            handler.getWorld().getEntityManager().removeEntity(this);
            handler.getGame().setState(handler.getGame().overState);
        }
    }
    //
//    private void rotateLeft() {
//        this.angle -= this.ROTATION_SPEED;
//    }
//
//    private void rotateRight() {
//        this.angle += this.ROTATION_SPEED;
//    }
}
