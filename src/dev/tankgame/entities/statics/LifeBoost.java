package dev.tankgame.entities.statics;

import dev.tankgame.Handler;
import dev.tankgame.graphics.Assets;

import java.awt.*;

public class LifeBoost extends StaticEntity {

    public LifeBoost(Handler handler, float x, float y) {
        super(handler, x, y);

        bounds.x = 0;
        bounds.y = 0;
        bounds.height = 30;
        bounds.width = 30;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.health, (int) (x - handler.getGameCam().getxOffset()), (int) (y - handler.getGameCam().getyOffset()), 30, 30, null);
    }

    @Override
    // this will go in Tile class maybe???
    public void die() {
//        handler.getWorld().getItemManager().addItem(Item.lifeBoost.createNew((int)x, (int) y));
    }

}
