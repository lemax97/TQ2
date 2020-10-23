package TQ;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Coin extends BaseActor {

    public Coin(float x, float y, Stage s) {

        super(x, y, s);
        loadTexture("assets/coin.png");

        Action pulse = Actions.sequence(
                Actions.scaleTo(1.4f, 1.4f, 0.2f),
                Actions.rotateBy( 10f, 0.2f),
                Actions.scaleTo(1.5f, 1.5f, 0.2f));
//        Action rotation = Actions.rotateBy(30f, 0.1f);

        addAction( Actions.forever(pulse) );
//        addAction( Actions.forever(rotation));
    }
}
