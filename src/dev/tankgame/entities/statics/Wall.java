package dev.tankgame.entities.statics;

import dev.tankgame.Handler;

import java.awt.*;

public class Wall extends StaticEntity {
    public Wall(Handler handler, float x, float y) {

        super(handler, x, y);
    }

    @Override
    public void tick(){
    }

    @Override
    public void render(Graphics g){
    }

    @Override
    public void die() {
        handler.getWorld().setTileArray((int)(x/64), (int)(y/64), 0);
        handler.getWorld().getEntityManager().removeEntity(this);
    }
}
