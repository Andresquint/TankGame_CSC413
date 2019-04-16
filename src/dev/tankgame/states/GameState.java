package dev.tankgame.states;

import dev.tankgame.Game;
import dev.tankgame.Handler;
import dev.tankgame.entities.movingObjects.Tank;
import dev.tankgame.entities.statics.LifeBoost;
import dev.tankgame.graphics.Assets;
import dev.tankgame.input.TankControl;
import dev.tankgame.tiles.Tile;
import dev.tankgame.worlds.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class GameState extends State{
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "\\src\\resources\\worlds\\world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick(){
        world.tick();
    }

    @Override
    public void render(Graphics g){
        world.render(g);
    }
}
