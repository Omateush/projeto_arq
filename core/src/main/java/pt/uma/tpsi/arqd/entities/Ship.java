package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Ship {
    protected float x, y;           // Posição da nave
    protected float width, height;  // Dimensões da nave
    protected int health;           // Vida da nave
    protected Rectangle boundingBox; // Bounding box para detecção de colisão

    public Ship(float x, float y, float width, float height, int health) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        this.boundingBox = new Rectangle(x, y, width, height);
    }

    public abstract void shoot(); // Método abstrato para disparo, implementado nas subclasses

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public void updatePosition(float deltaX, float deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        this.boundingBox.setPosition(x, y);
    }

    public abstract void render(SpriteBatch batch); // Método abstrato para renderizar a nave
}
