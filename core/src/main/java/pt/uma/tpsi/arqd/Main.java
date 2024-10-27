package pt.uma.tpsi.arqd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.tpsi.arqd.entities.Fleet;
import pt.uma.tpsi.arqd.entities.Player;
import pt.uma.tpsi.arqd.game.BackgroundManagement;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private Player player;
    private Fleet fleet;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1280, 800);
        batch = new SpriteBatch();
        backgroundManagement = new BackgroundManagement(); // Inicializando sem o batch
        player = new Player(batch, 100, 20);
        fleet = new Fleet(batch);
    }

    @Override
    public void render() {
        // Limpa a tela
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Início do desenho
        batch.begin();
        backgroundManagement.render(batch); // Passando o batch para renderizar o fundo
        player.render(batch);
        fleet.render(batch);
        batch.end(); // Fim do desenho
    }

    @Override
    public void dispose() {
        batch.dispose();
        backgroundManagement.dispose();
        player.dispose();
        fleet.dispose();
    }
}
