package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.StaticGameObject;
import app.gameengine.model.physics.Vector2D;

/**
 * A wall object the player can collide with, serves as a building block
 * for your levels.
 */
public class Wall extends StaticGameObject {

    public Wall(int x, int y) {
        super(x, y);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(3, 0);
    }
    public void collideWithDynamicObject(DynamicGameObject dynamicObject) {
        //all my corners of the wall hitbox
        double topleftcornery = this.getLocation().getY();
        double topleftcornerx = this.getLocation().getX();
        double bottomrightcornerx = topleftcornerx + this.getDimensions().getX();
        double bottomrightcornery = topleftcornery + this.getDimensions().getY();
        double bottomleftcornerx = topleftcornerx;
        double bottomleftcornery = bottomrightcornery;
        double toprightcornerx = bottomrightcornerx;
        double toprightcornery = topleftcornery;
        //all corners of the object
        double Topleftcornerx = dynamicObject.getLocation().getX();
        double Topleftcornery = dynamicObject.getLocation().getY();
        double Bottomrightcornerx = Topleftcornerx + dynamicObject.getDimensions().getX();
        double Bottomrightcornery = Topleftcornery + dynamicObject.getDimensions().getY();
        double Bottomleftcornerx = Topleftcornerx;
        double Bottomleftcornery = Bottomrightcornery;
        double Toprightcornerx = Bottomrightcornerx;
        double Toprightcornery = Topleftcornery;
        //finally some real coding
        double xshi = 0;
        double yshi = 0;
        if (Topleftcornerx < topleftcornerx){
            xshi = Toprightcornerx - topleftcornerx;
        } else{
            xshi = Topleftcornerx - toprightcornerx;
        }
        if( Topleftcornery < topleftcornery){
            yshi = Bottomleftcornery - topleftcornery;
        } else {
            yshi = Topleftcornery - bottomleftcornery;
        }
        if (Math.abs(yshi) < Math.abs(xshi)){
            dynamicObject.getLocation().setY(Topleftcornery - yshi);
        }
        else{
            dynamicObject.getLocation().setX(Topleftcornerx - xshi);
        }
    }
}
