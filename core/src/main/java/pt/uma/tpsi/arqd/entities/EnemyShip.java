package pt.uma.tpsi.arqd.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import pt.uma.tpsi.arqd.game.Animator;

public class EnemyShip {
    private Animator animator;
    private int x, y, width, height;
    private Rectangle boundingBox;

    public EnemyShip(SpriteBatch batch, int x, int y, int width, int height, String spriteSheetPath, int frameCols, int frameRows) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.animator = new Animator(batch, spriteSheetPath, frameCols, frameRows);
        this.boundingBox = new Rectangle(x, y, width, height);
    }

    public void render(SpriteBatch batch) {
        animator.render(batch, x, y);
    }

    public void update(float deltaTime) {
        // Atualizar a posição ou lógica da nave se necessário
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void dispose() {
        animator.dispose();
    }
}
