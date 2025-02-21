package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.Level;
import app.gameengine.model.gameobjects.StaticGameObject;

import java.util.ArrayList;

public class PhysicsEngine {

    public PhysicsEngine() {}

    public void updateLevel(Level level, double dt) {

        // Update the location of each dynamic object based on its velocity
        for(DynamicGameObject dynamicObject : level.getDynamicObjects()){
            updateObject(dynamicObject, dt);
        }

        // detect all collisions for each dynamic object
        for (int i = 0; i < level.getDynamicObjects().size(); i++) {
            DynamicGameObject dynamicObject1 = level.getDynamicObjects().get(i);

            // check for collisions with other dynamic objects
            // start at i+1 to avoid reporting collision multiple times
            for (int j = i+1; j < level.getDynamicObjects().size(); j++) {
                DynamicGameObject dynamicObject2 = level.getDynamicObjects().get(j);
                if(detectCollision(dynamicObject1.getHitBox(), dynamicObject2.getHitBox())){
                    dynamicObject1.collideWithDynamicObject(dynamicObject2);
                    dynamicObject2.collideWithDynamicObject(dynamicObject1);
                }
            }

            // check for collisions with static objects
            for(StaticGameObject so : level.getStaticObjects()){
                if(detectCollision(so.getHitBox(), dynamicObject1.getHitBox())){
                    so.collideWithDynamicObject(dynamicObject1);
                    dynamicObject1.collideWithStaticObject(so);
                }
            }
        }

    }

    public void updateObject(DynamicGameObject dynamicObject, double dt){
        // TODO: update location based on velocity
        double location_x = dynamicObject.getLocation().getX();
        double location_y = dynamicObject.getLocation().getY();
        double velocity_x = dynamicObject.getVelocity().getX();
        double velocity_y = dynamicObject.getVelocity().getY();
        double y_change = dt * velocity_y;
        double x_change = dt * velocity_x;
        dynamicObject.getLocation().setX(location_x + x_change);
        dynamicObject.getLocation().setY(location_y+y_change);
    }

    public boolean detectCollision(Hitbox hb1, Hitbox hb2){
        // TODO: return true if the 2 hitboxes overlap; false otherwise
        double locx1 = hb1.getLocation().getX();
        double locy1 = hb1.getLocation().getY();
        double dimx1 = hb1.getDimensions().getX();
        
        if( hb1.getLocation().equals(hb2.getLocation())) {

        }
        else{
            return false;
        }
    }

}
