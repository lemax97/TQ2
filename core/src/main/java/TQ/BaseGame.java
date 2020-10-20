package TQ;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public abstract class BaseGame extends Game{

    private static BaseGame game;

    public static LabelStyle labelStyle;

    public static TextButtonStyle textButtonStyle;

    public static Skin skin;

    public BaseGame() {
        skin = new Skin();
        game = this;
    }

    @Override
    public void create() {

        FreeTypeFontGenerator fontGenerator =
                new FreeTypeFontGenerator((Gdx.files.internal("assets/OpenSans.ttf")));

        FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
        fontParameter.size = 32;
        fontParameter.color = Color.WHITE;
        fontParameter.borderWidth = 2;
        fontParameter.borderColor = Color.BLACK;
        fontParameter.borderStraight = true;
        fontParameter.minFilter = TextureFilter.Linear;
        fontParameter.magFilter = TextureFilter.Linear;

        BitmapFont customFont = fontGenerator.generateFont(fontParameter);

        textButtonStyle = new TextButtonStyle();
        Texture buttonTexture = new Texture(Gdx.files.internal("assets/button.png"));
        NinePatch buttonPatch = new NinePatch(buttonTexture, 24,24,24,24);
        textButtonStyle.up    = new NinePatchDrawable( buttonPatch );
        textButtonStyle.font      = customFont;
        textButtonStyle.fontColor = Color.GRAY;

        labelStyle = new LabelStyle();
        labelStyle.font = customFont;

        // prepare for multiple classes/stages to receive discrete input
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(inputMultiplexer);


    }

    public static void setActiveScreen(BaseScreen screen){

        game.setScreen(screen);
    }
}
