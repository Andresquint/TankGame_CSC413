package dev.tankgame.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage intro, bg, tank, wall, unbreakableWall, bullet, health, end, rocket;
    private static final int dim = 64;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/resources/textures/towerDefense_tilesheet.png"));
        tank = ImageLoader.loadImage("/resources/textures/tank.png");
        intro = ImageLoader.loadImage("/resources/textures/intro.png");
        bg = sheet.crop(dim * 4, dim * 6, dim, dim);
//        wall = sheet.crop(dim * 7, dim * 6, dim, dim);
        wall = ImageLoader.loadImage("/resources/textures/testWall.png");
        unbreakableWall = sheet.crop(dim * 6, dim * 6, dim, dim);
        bullet = sheet.crop(dim * 4, dim * 11, dim, dim);
        health = ImageLoader.loadImage("/resources/textures/health.png");
        end = ImageLoader.loadImage("/resources/textures/game_over.png");
        rocket = sheet.crop(dim * 6, dim * 10, dim, dim);
//        explosion = ImageLoader.loadImage("/resources/textures/Explosion_large.gif");
        //        bg = ImageLoader.loadImage("/resources/textures/Background.bmp");
        //        wall = ImageLoader.loadImage("/resources/textures/testWall.png");
        //        unbreakableWall = ImageLoader.loadImage("/resources/textures/Wall2.gif");
    }
}
