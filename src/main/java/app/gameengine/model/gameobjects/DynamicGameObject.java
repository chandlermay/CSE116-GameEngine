package app.gameengine.model.gameobjects;

import app.gameengine.model.physics.Vector2D;

public abstract class DynamicGameObject extends GameObject {

    protected Vector2D velocity = new Vector2D(0.0, 0.0);
    protected Vector2D orientation = new Vector2D(0.0,1.0);

    public DynamicGameObject(Vector2D location, int maxHP) {
        super(location);
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }
    private int maxHP;
    private int currentHP;
    public int getMaxHP() {
        return this.maxHP;
    }

    public int getHP() {
        return this.currentHP;
    }

    public void setHP(int hp) {
    if (hp > this.maxHP){
        this.currentHP = this.maxHP;
    }
    else {
        this.currentHP = hp;
    }
}
    public Vector2D getOrientation() {
        return this.orientation;
    }

    public void takeDamage(int damage){
        if (damage > 0){
            this.currentHP = this.currentHP - damage;
        }
    }
    public Vector2D getVelocity() {
        return this.velocity;
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void revive() {
        super.revive();
    }

    @Override
    public void collideWithStaticObject(StaticGameObject otherObject) {

    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {

    }

}
