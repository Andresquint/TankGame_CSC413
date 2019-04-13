package dev.tankgame.entities.movingObjects;

import dev.tankgame.Handler;
import dev.tankgame.graphics.Assets;
import dev.tankgame.input.TankControl;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Tank extends MovingObject {

//    private final int R = 4;
    private final int ROTATION_SPEED = 4;

    private TankControl tc;
    private int tankNumber;

    public Tank(int tankNumber, Handler handler, float x, float y, int vx, int vy, int angle) {
        super(handler, x, y, vx, vy, angle);
        health = 10;

        this.tankNumber = tankNumber;
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 49;
        bounds.height = 50;
    }

    @Override
    public void tick() {
        getInput();
//        move();
        handler.getGameCam().centerOnEntity(this);
    }

    private void getInput(){
        vx = 0;
        vy = 0;

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
        g.setColor(Color.white);
        g.drawRect((int) (x + bounds.x - handler.getGameCam().getxOffset()),
                (int) (y + bounds.y - handler.getGameCam().getyOffset()),
                bounds.width, bounds.height);
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
