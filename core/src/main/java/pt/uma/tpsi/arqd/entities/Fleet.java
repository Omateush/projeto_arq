package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Iterator;

public class Fleet {
    private ArrayList<EnemyShip> enemyShips;
    private final int enemiesPerRow = 10; // Número de inimigos por fileira
    private final float enemyWidth = 50, enemyHeight = 50; // Tamanho padrão dos inimigos
    private final float spacingX = 100; // Espaçamento horizontal entre os inimigos
    private final float spacingY = 100; // Espaçamento vertical entre as fileiras

    public Fleet() {
        enemyShips = new ArrayList<>();

        // Fileira 1 - 10 inimigos grandes (enemy-big.png)
        for (int i = 0; i < enemiesPerRow; i++) {
            float x = i * (enemyWidth + spacingX); // Calcula a posição no eixo X
            float y = Gdx.graphics.getHeight() - (0 * (enemyHeight + spacingY)) - 100; // Posição da primeira fileira
            enemyShips.add(new EnemyShip(x, y, enemyWidth, enemyHeight, "enemy-big.png"));
        }

        // Fileira 2 - 10 inimigos médios (enemy-medium.png)
        for (int i = 0; i < enemiesPerRow; i++) {
            float x = i * (enemyWidth + spacingX); // Calcula a posição no eixo X
            float y = Gdx.graphics.getHeight() - (1 * (enemyHeight + spacingY)) - 100; // Posição da segunda fileira
            enemyShips.add(new EnemyShip(x, y, enemyWidth, enemyHeight, "enemy-medium.png"));
        }

        // Fileira 3 - 10 inimigos pequenos (enemy-small.png)
        for (int i = 0; i < enemiesPerRow; i++) {
            float x = i * (enemyWidth + spacingX); // Calcula a posição no eixo X
            float y = Gdx.graphics.getHeight() - (2 * (enemyHeight + spacingY)) - 100; // Posição da terceira fileira
            enemyShips.add(new EnemyShip(x, y, enemyWidth, enemyHeight, "enemy-small.png"));
        }
    }

    public void render(SpriteBatch batch, ArrayList<Laser> lasers) {
        // Verifica colisões e renderiza as naves inimigas
        Iterator<EnemyShip> shipIterator = enemyShips.iterator();
        while (shipIterator.hasNext()) {
            EnemyShip enemyShip = shipIterator.next();
            enemyShip.update(Gdx.graphics.getDeltaTime());

            // Verifica se algum laser colide com a nave inimiga
            Iterator<Laser> laserIterator = lasers.iterator();
            while (laserIterator.hasNext()) {
                Laser laser = laserIterator.next();

                if (laser.getBoundingBox().overlaps(enemyShip.getBoundingBox())) {
                    // Colisão detectada: Remove a nave e o laser
                    shipIterator.remove();
                    laserIterator.remove();
                    break; // Para evitar múltiplas remoções
                }
            }

            // Renderiza a nave inimiga
            enemyShip.render(batch);
        }
    }

    public void dispose() {
        // Libera os recursos das naves
        for (EnemyShip enemyShip : enemyShips) {
            enemyShip.dispose();
        }
    }
}
