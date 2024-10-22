import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameHUD {
    private BitmapFont font;
    private int playerHealth;
    private int playerScore;

    public GameHUD() {
        font = new BitmapFont();
        playerHealth = 100; // Valor inicial da vida do jogador
        playerScore = 0;    // Pontuação inicial
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        font.draw(batch, "Vida: " + playerHealth, 10, 470);
        font.draw(batch, "Pontuação: " + playerScore, 10, 440);
        batch.end();
    }

    public void updatePlayerHealth(int health) {
        this.playerHealth = health;
    }

    public void updatePlayerScore(int score) {
        this.playerScore = score;
    }

    public void dispose() {
        font.dispose();
    }
}
