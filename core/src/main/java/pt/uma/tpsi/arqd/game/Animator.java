package pt.uma.tpsi.arqd.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
    private Animation<TextureRegion> walkAnimation;
    private Texture walkSheet;
    private float stateTime;
    private int frameCols, frameRows;
    private int width, height;

    public Animator(SpriteBatch batch, String path, int frameCols, int frameRows) {
        this.frameCols = frameCols;
        this.frameRows = frameRows;
        walkSheet = new Texture(Gdx.files.internal(path));

        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / frameCols, walkSheet.getHeight() / frameRows);
        TextureRegion[] walkFrames = new TextureRegion[frameCols * frameRows];
        int index = 0;
        for (int i = 0; i < frameRows; i++) {
            for (int j = 0; j < frameCols; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        walkAnimation = new Animation<>(0.1f, walkFrames);
        stateTime = 0f;
        width = walkSheet.getWidth() / frameCols;
        height = walkSheet.getHeight() / frameRows;
    }

    public void render(SpriteBatch batch, int x, int y) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void dispose() {
        walkSheet.dispose();
    }
}
