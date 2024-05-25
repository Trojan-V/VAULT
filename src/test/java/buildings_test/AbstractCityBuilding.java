package buildings_test;


import javafx.scene.Scene;
import javafx.scene.image.ImageView;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public class AbstractCityBuilding
{
	private static final String TO_STRING_PATTERN =
			"CityBuilding'{'names={0}, sprites={1}, scenes={2}, currentLevel={3}'}'";


	private final String[] names;


	private final ImageView[] sprites;


	private final Scene[] scenes;


	private final int currentLevel;


	AbstractCityBuilding (final String[] allDisplayNames, final ImageView[] sprites, final Scene[] scenes)
	{
		// TODO: Load Level from Config

		this.currentLevel = 0;
		this.names = allDisplayNames;
		this.sprites = sprites;
		this.scenes = scenes;
	}
}
