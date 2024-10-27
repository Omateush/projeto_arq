package pt.uma.tpsi.arqd.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundManagement {

    private Texture background;
    private Sprite sprite;

    public BackgroundManagement() {
        background = new Texture("space.png");
        sprite = new Sprite(background);
        sprite.setPosition(0, 0);
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch); // Corrigido para desenhar o sprite corretamente
    }

    public void dispose() {
        background.dispose();
    }
}
