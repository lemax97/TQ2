package TQ;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TQGame extends BaseGame {
	@Override
	public void create() {

		super.create();
		setScreen(new LevelScreen());
	}
}