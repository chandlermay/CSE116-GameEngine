package app.games;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Goal;
import app.games.topdownobjects.Enemy;
import app.games.topdownobjects.TopDownLevel;
import app.games.commonobjects.Wall;
import app.games.topdownobjects.Tower;

public class SampleTopDownGame extends Game {

    public SampleTopDownGame() {
        this.init();
    }
    private LinkedListNode Level;
    public  LinkedListNode getLevelList(){
        return Level;
    }


    public void init() {
        this.loadLevel(levelZero());
    }

    @Override
    public void advanceLevel(){
        if(this.getCurrentLevel().getName().equals("level0")){
            this.loadLevel(this.levelOne());
        }else if(this.getCurrentLevel().getName().equals("level1")){
            this.loadLevel(this.levelTwo());
        }else if(this.getCurrentLevel().getName().equals("level2")){
            // You've won!
        }
    }

    public Level levelZero() {
        Level firstLevel = new TopDownLevel(this, 12, 8, "level0");
        firstLevel.getStaticObjects().add(new Wall(4, 1));
        firstLevel.getStaticObjects().add(new Wall(4, 2));
        firstLevel.getStaticObjects().add(new Wall(4, 3));
        firstLevel.getStaticObjects().add(new Wall(4, 4));
        firstLevel.getStaticObjects().add(new Wall(5, 4));
        firstLevel.getStaticObjects().add(new Wall(6, 4));
        firstLevel.getStaticObjects().add(new Wall(7, 4));
        firstLevel.getStaticObjects().add(new Wall(8, 4));
        firstLevel.getStaticObjects().add(new Tower(10, 1));
        firstLevel.getStaticObjects().add(new Goal(6, 2, this));
        firstLevel.getPlayerStartLocation().setX(2.0);
        firstLevel.getPlayerStartLocation().setY(2.0);

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 1.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 5.0)));
        return firstLevel;
    }

    public Level levelOne() {
        Level firstLevel = new TopDownLevel(this, 12, 9, "level1");
        firstLevel.getStaticObjects().add(new Goal(7, 4, this));
        firstLevel.getPlayerStartLocation().setX(2.0);
        firstLevel.getPlayerStartLocation().setY(4.0);

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 3.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 4.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 6.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 6.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 4.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 3.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 2.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 2.0)));

        return firstLevel;
    }

    public Level levelTwo() {
        Level firstLevel = new TopDownLevel(this, 17, 9, "level2");


        firstLevel.getStaticObjects().add(new Wall(2, 2));
        firstLevel.getStaticObjects().add(new Wall(2, 3));
        firstLevel.getStaticObjects().add(new Wall(2, 4));
        firstLevel.getStaticObjects().add(new Wall(2, 5));
        firstLevel.getStaticObjects().add(new Wall(2, 6));

        firstLevel.getStaticObjects().add(new Wall(3, 5));

        firstLevel.getStaticObjects().add(new Wall(4, 4));

        firstLevel.getStaticObjects().add(new Wall(5, 5));

        firstLevel.getStaticObjects().add(new Wall(6, 2));
        firstLevel.getStaticObjects().add(new Wall(6, 3));
        firstLevel.getStaticObjects().add(new Wall(6, 4));
        firstLevel.getStaticObjects().add(new Wall(6, 5));
        firstLevel.getStaticObjects().add(new Wall(6, 6));

        firstLevel.getStaticObjects().add(new Wall(8, 2));
        firstLevel.getStaticObjects().add(new Wall(8, 3));
        firstLevel.getStaticObjects().add(new Wall(8, 4));
        firstLevel.getStaticObjects().add(new Wall(8, 5));
        firstLevel.getStaticObjects().add(new Wall(8, 6));

        firstLevel.getStaticObjects().add(new Wall(10, 2));
        firstLevel.getStaticObjects().add(new Wall(10, 3));
        firstLevel.getStaticObjects().add(new Wall(10, 4));
        firstLevel.getStaticObjects().add(new Wall(10, 5));
        firstLevel.getStaticObjects().add(new Wall(10, 6));

        firstLevel.getStaticObjects().add(new Wall(11, 3));

        firstLevel.getStaticObjects().add(new Wall(12, 4));

        firstLevel.getStaticObjects().add(new Wall(13, 5));

        firstLevel.getStaticObjects().add(new Wall(14, 2));
        firstLevel.getStaticObjects().add(new Wall(14, 3));
        firstLevel.getStaticObjects().add(new Wall(14, 4));
        firstLevel.getStaticObjects().add(new Wall(14, 5));
        firstLevel.getStaticObjects().add(new Wall(14, 6));

        firstLevel.getPlayerStartLocation().setX(4.0);
        firstLevel.getPlayerStartLocation().setY(2.0);

        return firstLevel;
    }
}
