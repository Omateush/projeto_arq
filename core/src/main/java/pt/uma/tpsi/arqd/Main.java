package pt.uma.tpsi.arqd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.tpsi.arqd.entities.Player;
import pt.uma.tpsi.arqd.entities.Fleet;
import pt.uma.tpsi.arqd.game.BackgroundManagement;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private BackgroundManagement backgroundManagement;
    private Player player;
    private Fleet fleet;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(1280, 800);

        batch = new SpriteBatch();
        backgroundManagement = new BackgroundManagement(batch);

        player = new Player(batch, 100, 20); // Inicializa o Player
        player.create();

        fleet = new Fleet(); // Inicializa a frota de naves inimigas

        font = new BitmapFont();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin(); // Inicia o batch uma vez

        // Renderizar o fundo
        backgroundManagement.render();

        // Renderizar o jogador e os lasers
        player.render(batch);

        // Renderizar a frota de naves inimigas
        fleet.render(batch);

        // Renderizar o texto do Highscore
        font.draw(batch, "Aqui vai ficar o Highscore!", 10, 750);

        batch.end(); // Finaliza o batch após renderizar tudo
    }


    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        player.dispose(); // Libera os recursos do jogador
        fleet.dispose();  // Libera os recursos da frota
    }
}
