package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Laser {
    private float x, y;
    private float width, height;
    private float speed;
    private Texture texture;
    private Rectangle boundingBox;

    public Laser(float x, float y, float width, float height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.texture = new Texture("laser-bolts.png"); // Certifique-se de que a imagem está no diretório assets
        this.boundingBox = new Rectangle(x, y, width, height);
    }

    public void update() {
        y += speed; // Atualiza a posição do laser
        boundingBox.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }


    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void dispose() {
        texture.dispose();
    }
}
