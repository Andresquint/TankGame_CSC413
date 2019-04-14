/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tankgame.input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;


/**
 *
 * @author anthony-pc
 */
public class TankControl implements KeyListener {
    private boolean[] keys;
//    private static int[] keys;
    public boolean up1, down1, left1, right1,
                    up2, down2, left2, right2, space, enter;
//    public int up1, down1, left1, right1;

    public TankControl(){
        keys = new boolean[256];
    }

    public void tick(){
        up1 = keys[KeyEvent.VK_UP];
        up2 = keys[KeyEvent.VK_W];
        down1 = keys[KeyEvent.VK_DOWN];
        down2 = keys[KeyEvent.VK_S];
        left1 = keys[KeyEvent.VK_LEFT];
        left2 = keys[KeyEvent.VK_A];
        right1 = keys[KeyEvent.VK_RIGHT];
        right2 = keys[KeyEvent.VK_D];
        space = keys[KeyEvent.VK_SPACE];
        enter = keys[KeyEvent.VK_ENTER];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

//        private Tank t1;
//    private final int up1;
//    private final int down1;
//    private final int right1;
//    private final int left1;
//    private final int shoot;
//
//    public TankControl(Tank t1, int up1, int down1, int left1, int right1) {
//        keys = new boolean[256];
//
//        keys[up1] = true;
//        keys[down1] = true;
//        keys[left1] = true;
//        keys[right1] = true;
//
//        System.out.println("up1: " + up1);
//        System.out.println("keys[up1]: " + keys[up1]);
//
//        this.t1 = t1;
//        this.up1 = up1;
//        this.down1 = down1;
//        this.right1 = right1;
//        this.left1 = left1;
//        this.shoot = shoot;
//    }
//
//    @Override
//    public void keyTyped(KeyEvent ke) {
//
//    }
//
//    @Override
//    // calls toggle methods from Tank.java
//    public void keyPressed(KeyEvent ke) {
//        // from KeyEvent: getKeyCode() returns integer keyCode associated with key
//        int keyPressed = ke.getKeyCode();
//        System.out.println("Key pressed " + keyPressed + " " + keys[up1]);
//        if (keys[keyPressed] && keyPressed == up1) {
//            this.t1.toggleUpPressed();
//        }
//        if (keys[keyPressed] && keyPressed == down1) {
//            this.t1.toggleDownPressed();
//        }
//        if (keys[keyPressed] && keyPressed == left1) {
//            this.t1.toggleLeftPressed();
//        }
//        if (keys[keyPressed] && keyPressed == right1) {
//            this.t1.toggleRightPressed();
//        }
//
//
//    }
//
//    @Override
//    // calls untoggle methods from Tank.java
//    public void keyReleased(KeyEvent ke) {
//        int keyReleased = ke.getKeyCode();
//        System.out.println("Key released");
//        if (keys[keyReleased] && keyReleased == up1) {
//            this.t1.unToggleUpPressed();
//        }
//        if (keys[keyReleased] && keyReleased == down1) {
//            this.t1.unToggleDownPressed();
//        }
//        if (keys[keyReleased] && keyReleased == right1) {
//            this.t1.unToggleLeftPressed();
//        }
//        if (keys[keyReleased] && keyReleased == left1) {
//            this.t1.unToggleRightPressed();
//        }
//    }
}
