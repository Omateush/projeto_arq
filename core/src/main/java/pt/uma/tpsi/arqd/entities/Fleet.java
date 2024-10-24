package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Iterator;

public class Fleet {
    private ArrayList<EnemyShip> enemyShips;
    private final int maxEnemies = 15; // Número máximo de inimigos
    private final int enemiesPerRow = 5; // Número de inimigos por fileira
    private final float enemyWidth = 50, enemyHeight = 50; // Tamanho dos inimigos
    private final float spacingX = 70; // Espaçamento horizontal entre os inimigos
    private final float spacingY = 50; // Espaçamento vertical entre as fileiras

    public Fleet() {
        enemyShips = new ArrayList<>();

        // Organizar os inimigos em 3 fileiras com 5 inimigos em cada
        for (int i = 0; i < maxEnemies; i++) {
            int row = i / enemiesPerRow; // Determina a fileira
            int col = i % enemiesPerRow; // Determina a posição na fileira

            float x = col * (enemyWidth + spacingX); // Calcula a posição no eixo X
            float y = Gdx.graphics.getHeight() - (row * (enemyHeight + spacingY)) - 100; // Calcula a posição no eixo Y

            // Adiciona um inimigo na posição calculada
            enemyShips.add(new EnemyShip(x, y, enemyWidth, enemyHeight));
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
