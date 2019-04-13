package dev.tankgame;

import Display.Display;

public class Launcher {
    public static void main(String[] args){
        Game game = new Game("Tank Game", 1280, 800);
        game.start();
    }
}
