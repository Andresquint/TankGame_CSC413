package dev.tankgame.entities;

import dev.tankgame.Handler;
import dev.tankgame.entities.movingObjects.Tank;
import dev.tankgame.entities.statics.LifeBoost;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    private Tank tank1, tank2;
//    private LifeBoost lifeBoost;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Tank tank1, Tank tank2){
        this.handler = handler;
        this.tank1 = tank1;
        this.tank2 = tank2;
        entities = new ArrayList<Entity>();
//        addEntity(new LifeBoost(handler, 100, 100));
        addEntity(tank1);
        addEntity(tank2);

    }

    public void tick(){
//        Iterator<Entity> it = entities.iterator();
//
//        while(it.hasNext()){
//            Entity e = it.next();
//            e.tick();
//            if(!e.isActive())
//                it.remove();
//        }

        for (int i = 0; i < entities.size(); i++){

            Entity e = entities.get(i);
            e.tick();
        }

    }

    public void render(Graphics g){
        for (int i = 0; i < entities.size(); i++){

            Entity e = entities.get(i);
            e.render(g);
        }
    }

    public void removeEntity(Entity e){
        if (entities.contains(e)) {
            entities.remove(e);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Tank getTank1() {
        return tank1;
    }

    public void setTank1(Tank tank1) {
        this.tank1 = tank1;
    }

    public Tank getTank2() {
        return tank2;
    }

    public void setTank2(Tank tank2) {
        this.tank2 = tank2;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void printContents(){

        for(int i = 0; i < entities.size(); i++){

            System.out.println(entities.get(i));
        }
    }
}
