package pt.uma.tpsi.arqd.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private com.badlogic.gdx.graphics.g2d.BitmapFont font;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1280, 800);
        batch = new SpriteBatch();
        backgroundManagement = new BackgroundManagement(batch);


    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        backgroundManagement.render();

        BitmapFont.drawText(10,750,"HELLO WORLD!",batch);

        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
