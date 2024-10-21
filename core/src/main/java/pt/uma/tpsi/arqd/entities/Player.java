package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.tpsi.arqd.game.Animator;

public class Player {

    private int posX, posY;


    private Animator animator;

    public Player(SpriteBatch batch) {
        posX = 100;
        posY = 200;
        animator = new Animator(batch, "ship.png", 5, 2);
    }

    public void create(){
        animator.create();

    }


    public void render(){
        animator.render(posX, posY);
    }
}
