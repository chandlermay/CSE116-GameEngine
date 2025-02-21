package app.tests;

import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Hitbox;
import app.gameengine.model.physics.PhysicsEngine;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestTask1 {

    static final double EPSILON = 0.0001;

    // TODO: write your tests here
    @Test
    public void testDynamicGameObject(){
        //setting players, locations and maxHP
        Player player1 = new Player(new Vector2D(0,0) , 0);
        Player player2 = new Player(new Vector2D(1,1) , 10);
        Player player3 = new Player(new Vector2D(-1,-1),0);
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
        //testing hp
        assertEquals(-1,player1.getHP());
        assertEquals(10,player2.getHP());
        assertEquals(0,player3.getHP());
        player2.takeDamage(5);
        assertEquals(5,player2.getHP());
        player3.takeDamage(10);
        assertEquals(-10,player3.getHP());
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

}
