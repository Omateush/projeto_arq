package pt.uma.tpsi.arqd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.tpsi.arqd.entities.Player;
import pt.uma.tpsi.arqd.game.BackgroundManagement;
import pt.uma.tpsi.arqd.game.BitmapFont;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private Player player;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1280, 800);
        batch = new SpriteBatch();
        backgroundManagement = new BackgroundManagement(batch);
        player = new Player(batch);
        player.create();


    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        backgroundManagement.render();
        player.render();


        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
