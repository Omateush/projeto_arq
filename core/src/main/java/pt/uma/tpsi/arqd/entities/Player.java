package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.tpsi.arqd.game.Animator;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    private int posX, posY;
    private Animator animator;
    private ArrayList<Laser> lasers; // Lista de lasers disparados
    private float laserWidth = 10, laserHeight = 20, laserSpeed = 10; // Dimensões e velocidade do laser

    public Player(SpriteBatch batch, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        animator = new Animator(batch, "ship.png", 5, 2);
        lasers = new ArrayList<>(); // Inicializa a lista de lasers
    }

    public void create() {
        animator.create();
    }

    public void render(SpriteBatch batch) {
        handleInput(); // Manipula o input do jogador (movimento e disparo)
        animator.render(posX, posY); // Renderiza a nave do jogador

        // Renderizar e atualizar todos os lasers disparados
        Iterator<Laser> iterator = lasers.iterator();
        while (iterator.hasNext()) {
            Laser laser = iterator.next();
            laser.update(); // Atualiza a posição do laser

            // Se o laser sair da tela, remove-o da lista
            if (laser.getBoundingBox().y > Gdx.graphics.getHeight()) {
                iterator.remove();
            } else {
                laser.render(batch); // Renderiza o laser
            }
        }
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            posX -= 5;
            if (posX < 0) posX = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            posX += 5;
            if (posX > Gdx.graphics.getWidth()) {
                posX = Gdx.graphics.getWidth();
            }
        }

        // Verifica se a barra de espaço foi pressionada para disparar o laser
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            shootLaser();
        }
    }

    private void shootLaser() {
        // Cria um novo laser na posição atual do jogador
        Laser laser = new Laser(posX + (animator.getWidth() / 2) - (laserWidth / 2), posY + animator.getHeight(), laserWidth, laserHeight, laserSpeed);
        lasers.add(laser); // Adiciona o laser à lista de lasers disparados
    }

    // Novo método getLasers() para retornar a lista de lasers
    public ArrayList<Laser> getLasers() {
        return lasers;
    }

    public void dispose() {
        animator.dispose(); // Libera os recursos da nave

        // Libera os recursos de cada laser
        for (Laser laser : lasers) {
            laser.dispose();
        }
    }
}
