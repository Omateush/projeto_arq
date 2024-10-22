package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.tpsi.arqd.game.Animator;

public class Player {

    private int posX, posY;
    private Animator animator;

    public Player(SpriteBatch batch, int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        animator = new Animator(batch,"ship.png", 5,2);
    }

    public void create(){
        animator.create();
    }

    public void render(){
        handleInput();
        animator.render(posX,posY);
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            posX -= 5;
            if (posX < 0) posX = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            posX += 5;
            if (posX > Gdx.graphics.getWidth()) posX = Gdx.graphics.getWidth();
            }
        }

    }
