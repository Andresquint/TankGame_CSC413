package dev.tankgame;

import dev.tankgame.graphics.GameCamera;
import dev.tankgame.input.TankControl;
import dev.tankgame.worlds.World;

public class Handler {
    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }

    public GameCamera getGameCam(){
        return game.getGameCam();
    }

    public TankControl getTankControl1(){
        return game.getTankControl();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
