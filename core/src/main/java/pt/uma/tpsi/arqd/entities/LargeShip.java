package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

class LargeShip {
    private float x, y, width, height;
    private Texture texture;
    private Rectangle boundingBox;

    public LargeShip(float x, float width, float height) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.y = Gdx.graphics.getHeight() - height; // Coloca a nave no topo da tela

        // Carrega a textura da nave grande
        texture = new Texture("enemy-big.png");

        // Define a bounding box da nave
        boundingBox = new Rectangle(x, y, width, height);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height); // Renderiza a nave na posição x, y
    }

    public void dispose() {
        texture.dispose(); // Libera os recursos da textura
    }
}
