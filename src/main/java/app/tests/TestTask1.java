package app.tests;

import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Hitbox;
import app.gameengine.model.physics.PhysicsEngine;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTask1 {

    static final double EPSILON = 0.0001;
    public void comparePlayers(Player p1, Player p2){
        assertEquals(p1.getLocation().getX(),p2.getLocation().getX(),EPSILON);
        assertEquals(p1.getLocation().getY(),p2.getLocation().getY(),EPSILON);
        assertEquals(p1.getVelocity().getX(),p2.getVelocity().getX(),EPSILON);
        assertEquals(p1.getVelocity().getY(),p2.getVelocity().getY(),EPSILON);
        assertEquals(p1.getOrientation().getX(),p2.getOrientation().getX(),EPSILON);
        assertEquals(p1.getOrientation().getY(),p2.getOrientation().getY(),EPSILON);
        assertEquals(p1.getHP(),p2.getHP(),EPSILON);
        assertEquals(p1.getMaxHP(),p2.getMaxHP(),EPSILON);
    }
    // TODO: write your tests here
    @Test
    public void testDynamicGameObject(){
        //setting players, locations and maxHP
        Player player1 = new Player(new Vector2D(0,0) , 0);
        Player player2 = new Player(new Vector2D(1,1) , 10);
        Player player3 = new Player(new Vector2D(-1,-1),0);
        Player player4 = new Player(new Vector2D(100,100),100);
        Player player5 = new Player(new Vector2D(10,10),100);
        Player p6 = new Player(new Vector2D(10,10),100);

        //testing players locations
        assertEquals(0,player1.getLocation().getX(),EPSILON);
        assertEquals(0,player1.getLocation().getY(),EPSILON);
        assertEquals(1,player2.getLocation().getY(),EPSILON);
        assertEquals(1,player2.getLocation().getX(),EPSILON);
        assertEquals(-1,player3.getLocation().getX(),EPSILON);
        assertEquals(-1,player3.getLocation().getY(),EPSILON);
        //testing maxHP
        assertEquals(0,player1.getMaxHP(),EPSILON);
        assertEquals(10,player2.getMaxHP(),EPSILON);
        //setting players velocities
        player1.getVelocity().setX(-1);
        player1.getVelocity().setY(-1);
        player2.getVelocity().setX(1);
        player2.getVelocity().setY(1);
        //testing players velocities
        assertEquals(-1,player1.getVelocity().getX(),EPSILON);
        assertEquals(-1,player1.getVelocity().getY(),EPSILON);
        assertEquals(1,player2.getVelocity().getX(),EPSILON);
        assertEquals(1,player2.getVelocity().getY(),EPSILON);
        //setting players orientations
        player2.getOrientation().setX(1);
        player2.getOrientation().setY(1);
        player3.getOrientation().setX(0);
        player3.getOrientation().setY(0);
        //testing orientation
        assertEquals(1,player2.getOrientation().getX(),EPSILON);
        assertEquals(1,player2.getOrientation().getY(),EPSILON);
        assertEquals(0,player3.getOrientation().getY(),EPSILON);
        assertEquals(0,player3.getOrientation().getX(),EPSILON);
        //setting hp
        player1.setHP(-1);
        player2.setHP(11);
        player3.setHP(0);
        player4.setHP(100);
        player5.setHP(100);
        p6.setHP(100);
        //testing hp
        assertEquals(-1,player1.getHP());
        assertEquals(10,player2.getHP());
        assertEquals(0,player3.getHP());

        player2.takeDamage(5);
        assertEquals(5,player2.getHP());
        player3.takeDamage(10);
        assertEquals(-10,player3.getHP());
        player4.takeDamage(0);
        assertEquals(100,player4.getHP());
        player5.takeDamage(100);
        assertEquals(0,player5.getHP());
        p6.takeDamage(-10);
        assertEquals(100,p6.getHP());
    }

    @Test
    public void testWallCollisionsSimple() {
        // we give you the tests for wall collisions. Don't change them
        //
        // However, you should read through these tests to better understand what you should
        // be testing for and how you should be testing
        Player player = new Player(new Vector2D(0, 0), 10);
        Wall w1 = new Wall(1, 0);
        Wall w2 = new Wall(0, 1);
        Wall w3 = new Wall(-1, 0);
        Wall w4 = new Wall(0, -1);

        // Move right
        player.getLocation().setX(0.5);
        player.getLocation().setY(0);
        w1.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move down
        player.getLocation().setX(0);
        player.getLocation().setY(0.5);
        w2.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move left
        player.getLocation().setX(-0.5);
        player.getLocation().setY(0);
        w3.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move up
        player.getLocation().setX(0);
        player.getLocation().setY(-0.5);
        w4.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);
    }

    @Test
    public void testWallCollisionsComplex() {
        Player player = new Player(new Vector2D(0.0, 0.0), 10);
        Wall w1 = new Wall(5, 2);

        player.getLocation().setX(4.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(4.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.0);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.2, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.8, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.2);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(5.2, player.getLocation().getX(), EPSILON);
        assertEquals(3.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.7);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.7, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.0);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);
    }

    @Test
    public void updateObjecttest(){
        PhysicsEngine chandler = new PhysicsEngine();
        Player p1 = new Player(new Vector2D(-12.1,-10.2),100);
        p1.getVelocity().setX(-10.1);
        p1.getVelocity().setY(-10.3);
        chandler.updateObject(p1,2.0);
        assertEquals(-32.3,p1.getLocation().getX(),EPSILON);
        assertEquals(-30.8,p1.getLocation().getY(),EPSILON);
    }
    @Test
    public void updateObjecttestnew(){
        PhysicsEngine chandlernew = new PhysicsEngine();
        Player p1 = new Player(new Vector2D(4,1),100);
        p1.getVelocity().setX(10);
        p1.getVelocity().setY(10);
        chandlernew.updateObject(p1,2.0);
        assertEquals(24,p1.getLocation().getX(),EPSILON);
        assertEquals(21,p1.getLocation().getY(),EPSILON);
    }
    @Test
    public void updateObjecttestnewest(){
        PhysicsEngine chandlernewest = new PhysicsEngine();
        Player p1 = new Player(new Vector2D(4,1),100);
        chandlernewest.updateObject(p1,2.0);
        assertEquals(4,p1.getLocation().getX(),EPSILON);
        assertEquals(1,p1.getLocation().getY(),EPSILON);
    }

    @Test
    public void detectCollisiontest(){
        PhysicsEngine newestchandler = new PhysicsEngine();
        Hitbox box1 = new Hitbox(new Vector2D(2,1), new Vector2D(15,12));
        Hitbox box2 = new Hitbox(new Vector2D(4,4), new Vector2D(21,11));
        assertEquals(true,newestchandler.detectCollision(box1, box2));
    }
    @Test
    public void detectsimpleCollisiontest(){
        PhysicsEngine newestchandler = new PhysicsEngine();
        Hitbox box1 = new Hitbox(new Vector2D(1,7), new Vector2D(1,1));
        Hitbox box2 = new Hitbox(new Vector2D(6,8), new Vector2D(2,3));
        assertEquals(false,newestchandler.detectCollision(box1, box2));
    }
    @Test
    public void detectCollisioncorners(){
        PhysicsEngine newestc = new PhysicsEngine();
        Hitbox box1 = new Hitbox(new Vector2D(2,2), new Vector2D(15,12));
        Hitbox box2 = new Hitbox(new Vector2D(2,3), new Vector2D(11,11));
        assertEquals(true,newestc.detectCollision(box1, box2));
    }
    @Test
    public void detectCollisionfalsepos(){
        PhysicsEngine newestchandler = new PhysicsEngine();
        Hitbox box1 = new Hitbox(new Vector2D(4,7), new Vector2D(15,12));
        Hitbox box2 = new Hitbox(new Vector2D(4,7), new Vector2D(11,11));
        assertEquals(true,newestchandler.detectCollision(box1, box2));
    }
    @Test
    public void detectCollisionfalse(){
        PhysicsEngine newestchandler = new PhysicsEngine();
        Hitbox box1 = new Hitbox(new Vector2D(2,1), new Vector2D(15,12));
        Hitbox box2 = new Hitbox(new Vector2D(2,1.1), new Vector2D(11,11));
        assertEquals(true,newestchandler.detectCollision(box1, box2));
    }
    @Test
    public void simpletest(){
        PhysicsEngine rev = new PhysicsEngine();
        Player player = new Player(new Vector2D(2,3),10);
        rev.updateObject(player,4);
        assertEquals(2,player.getLocation().getX(),EPSILON);
        assertEquals(3,player.getLocation().getY(),EPSILON);
    }
    @Test
    public void createtest(){
        PhysicsEngine rev = new PhysicsEngine();
        Player player = new Player(new Vector2D(2,5),10);
        player.getVelocity().setY(2);
        player.getVelocity().setX(4);
        rev.updateObject(player,5);
        assertEquals(22,player.getLocation().getX(),EPSILON);
    }
    @Test
    public void objective(){
        PhysicsEngine rev = new PhysicsEngine();
        Player player = new Player(new Vector2D(-1,7),10);
        player.getVelocity().setX(1);
        player.getVelocity().setY(4);
        rev.updateObject(player,4);
        assertEquals(3,player.getLocation().getX(),EPSILON);
        assertEquals(23,player.getLocation().getY(),EPSILON);
    }
    @Test
    public void popeyes(){
        PhysicsEngine rev = new PhysicsEngine();
        Player player = new Player(new Vector2D(-1.0,-2.4),10);
        player.getVelocity().setX(-2.3);
        player.getVelocity().setY(-1.5);
        rev.updateObject(player,4);
        assertEquals(-10.2,player.getLocation().getX(),EPSILON);
        assertEquals(-8.4,player.getLocation().getY(),EPSILON);
        assertEquals(-2.3,player.getVelocity().getX(),EPSILON);
        assertEquals(-1.5,player.getVelocity().getY(),EPSILON);
    }
    @Test
    public void bigpop(){
        Player player = new Player(new Vector2D(3,6),10);
        assertEquals(3.0,player.getLocation().getX(),EPSILON);
        assertEquals(6.0,player.getLocation().getY(),EPSILON);
        assertEquals(0.0,player.getVelocity().getX(),EPSILON);
        assertEquals(0.0,player.getVelocity().getY(),EPSILON);
        assertEquals(0.0,player.getOrientation().getX(),EPSILON);
        assertEquals(1.0,player.getOrientation().getY(),EPSILON);
    }
    @Test
    public void dynamc(){
        Player player = new Player(new Vector2D(9,7),10);
        assertEquals(0,player.getVelocity().getX(),EPSILON);
        assertEquals(0,player.getVelocity().getY(),EPSILON);
        assertEquals(9,player.getLocation().getX(),EPSILON);
        assertEquals(7,player.getLocation().getY(),EPSILON);
        assertEquals(10,player.getMaxHP(),EPSILON);
        assertEquals(10,player.getHP(),EPSILON);
        assertEquals(0,player.getOrientation().getX(),EPSILON);
        assertEquals(1,player.getOrientation().getY(),EPSILON);
    }
}
