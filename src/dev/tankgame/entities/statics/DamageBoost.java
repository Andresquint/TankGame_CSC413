package dev.tankgame.entities.statics;

import dev.tankgame.Handler;
import dev.tankgame.graphics.Assets;

import java.awt.*;

public class DamageBoost extends StaticEntity {

    public DamageBoost(Handler handler, float x, float y) {
        super(handler, x, y);

        bounds.x = 24;
        bounds.y = 12;
        bounds.height = 30;
        bounds.width = 39;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rocket, (int) (x - handler.getGameCam().getxOffset()), (int) (y - handler.getGameCam().getyOffset()),null);
    }

    @Override
    // this will go in Tile class maybe???
    public void die() {
        //        handler.getWorld().getItemManager().addItem(Item.lifeBoost.createNew((int)x, (int) y));
    }
}
