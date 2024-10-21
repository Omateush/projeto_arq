package pt.uma.tpsi.arqd.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BitmapFont {
    private static com.badlogic.gdx.graphics.g2d.BitmapFont font;
    private static void initialize() {
        if (font == null) {
            // Load the font file from the assets folder
            FileHandle fontFile = Gdx.files.internal("gamefont.fnt");

            // Create a new BitmapFont object using the font file
            font = new com.badlogic.gdx.graphics.g2d.BitmapFont(fontFile);

            // Set the color of the font to white
            font.setColor(Color.YELLOW);
        }
    }
    public static void drawText(int x, int y, String text, SpriteBatch batch) {
        initialize();
        font.draw(batch, text, x, y);
    }
}
