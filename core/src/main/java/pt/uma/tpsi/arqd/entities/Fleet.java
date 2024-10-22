package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Fleet {
    private ArrayList<EnemyShip> enemyShips;

    public Fleet() {
        enemyShips = new ArrayList<>();

        // Adiciona várias naves inimigas à frota
        for (int i = 0; i < 5; i++) {
            float x = i * 150; // Posiciona as naves horizontalmente com uma separação de 150px
            enemyShips.add(new EnemyShip(x, 100, 100)); // Largura e altura de 100px
        }
    }

    public void render(SpriteBatch batch) {
        for (EnemyShip ship : enemyShips) {
            ship.render(batch); // Renderiza cada nave inimiga
        }
    }

    public void dispose() {
        for (EnemyShip ship : enemyShips) {
            ship.dispose(); // Libera os recursos de cada nave inimiga
        }
    }
}
