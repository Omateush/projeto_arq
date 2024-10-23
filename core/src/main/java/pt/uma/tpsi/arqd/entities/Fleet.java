package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Fleet {
    private ArrayList<SmallShip> smallShips;
    private ArrayList<MediumShip> mediumShips;
    private ArrayList<LargeShip> largeShips;

    public Fleet() {
        smallShips = new ArrayList<>();
        mediumShips = new ArrayList<>();
        largeShips = new ArrayList<>();

        // Adiciona naves pequenas
        for (int i = 0; i < 3; i++) {
            float x = i * 150; // Ajusta a distância entre as naves
            smallShips.add(new SmallShip(x, 50, 50)); // Largura e altura de 50px
        }

        // Adiciona naves médias
        for (int i = 0; i < 2; i++) {
            float x = i * 200; // Ajusta a distância entre as naves
            mediumShips.add(new MediumShip(x, 75, 75)); // Largura e altura de 75px
        }

        // Adiciona naves grandes
        largeShips.add(new LargeShip(400, 100, 100)); // Adiciona uma nave grande
    }

    public void render(SpriteBatch batch) {
        // Renderiza as naves pequenas
        for (SmallShip ship : smallShips) {
            ship.render(batch);
        }

        // Renderiza as naves médias
        for (MediumShip ship : mediumShips) {
            ship.render(batch);
        }

        // Renderiza as naves grandes
        for (LargeShip ship : largeShips) {
            ship.render(batch);
        }
    }

    public void dispose() {
        // Libera os recursos das naves pequenas
        for (SmallShip ship : smallShips) {
            ship.dispose();
        }

        // Libera os recursos das naves médias
        for (MediumShip ship : mediumShips) {
            ship.dispose();
        }

        // Libera os recursos das naves grandes
        for (LargeShip ship : largeShips) {
            ship.dispose();
        }
    }
}
