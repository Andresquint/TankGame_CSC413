package dev.tankgame.tiles;

import dev.tankgame.graphics.Assets;

public class UnbreakableWall extends Tile{

    public UnbreakableWall(int id) {
        super(Assets.unbreakableWall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
