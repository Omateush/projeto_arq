package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class EnemyShip {
    private float x, y;
    private float width, height;
    private Texture texture;
    private Rectangle boundingBox;

    public EnemyShip(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = new Texture("enemy-ship.png"); // Certifique-se de que a imagem está no diretório assets
        this.boundingBox = new Rectangle(x, y, width, height); // Define a bounding box para colisões
    }

    public void update(float deltaTime) {
        // Atualiza a posição ou movimento da nave inimiga
        // Atualiza a posição da boundingBox
        boundingBox.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height); // Renderiza a nave inimiga
    }

    public Rectangle getBoundingBox() {
        return boundingBox; // Retorna a boundingBox para detecção de colisões
    }

    public void dispose() {
        texture.dispose();
    }
}
