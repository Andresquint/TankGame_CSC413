package dev.tankgame.entities.statics;

import dev.tankgame.Handler;
import dev.tankgame.graphics.Assets;

import java.awt.*;

public class LifeBoost extends StaticEntity {
    public LifeBoost(Handler handler, float x, float y) {
        super(handler, x, y);

        bounds.x = 19;
        bounds.y = 18;
        bounds.height = 12;
        bounds.width = 11;
    }

    @Override
    public void tick() {
    }

    // change image later!
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.health, (int) x, (int) y, null);
        g.setColor(Color.white);
        g.drawRect((int) (x + bounds.x), (int) (y + bounds.y),
                bounds.width, bounds.height);
    }
}
