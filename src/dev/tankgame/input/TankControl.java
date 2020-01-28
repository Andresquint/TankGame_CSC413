/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tankgame.input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class TankControl implements KeyListener {
    private boolean[] keys;
    //    private static int[] keys;
    public boolean up1, down1, left1, right1,
            up2, down2, left2, right2,
            space, enter, play, exit;
    //    public int up1, down1, left1, right1;

    public TankControl() {
        keys = new boolean[256];
    }

    public void tick() {
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
        play = keys[KeyEvent.VK_P];
        exit = keys[KeyEvent.VK_ESCAPE];
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
}
