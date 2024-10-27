package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Fleet {
    private ArrayList<EnemyShip> enemyShips;
    private final int enemiesPerRow = 10;
    private final float enemyWidth = 50, enemyHeight = 50;
    private final float spacingX = 100, spacingY = 100;

    public Fleet(SpriteBatch batch) {
        enemyShips = new ArrayList<>();

        // Linha 1: Inimigos grandes (enemy-big.png)
        for (int i = 0; i < enemiesPerRow; i++) {
            float x = i * (enemyWidth + spacingX);
            float y = 800 - 100;
            enemyShips.add(new EnemyShip(batch, (int) x, (int) y, (int) enemyWidth, (int) enemyHeight, "enemy-big.png", 2, 1));
        }

        // Linha 2: Inimigos médios (enemy-medium.png)
        for (int i = 0; i < enemiesPerRow; i++) {
            float x = i * (enemyWidth + spacingX);
            float y = 800 - 200;
            enemyShips.add(new EnemyShip(batch, (int) x, (int) y, (int) enemyWidth, (int) enemyHeight, "enemy-medium.png", 2, 1));
        }

        // Linha 3: Inimigos pequenos (enemy-small.png)
        for (int i = 0; i < enemiesPerRow; i++) {
            float x = i * (enemyWidth + spacingX);
            float y = 800 - 300;
            enemyShips.add(new EnemyShip(batch, (int) x, (int) y, (int) enemyWidth, (int) enemyHeight, "enemy-small.png", 2, 1));
        }
    }

    public void render(SpriteBatch batch) {
        for (EnemyShip enemyShip : enemyShips) {
            enemyShip.render(batch);
        }
    }

    public void dispose() {
        for (EnemyShip enemyShip : enemyShips) {
            enemyShip.dispose();
        }
    }
}
