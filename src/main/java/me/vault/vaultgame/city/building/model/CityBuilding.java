package me.vault.vaultgame.city.building.model;


import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.text.MessageFormat;
import java.util.Arrays;


/**
 * TODO: Write Javadoc
 * TODO: Fill the enum entries with actual data.
 * TODO: Attributes of enum constants stored in file, then read the data from the file?
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see IBuilding
 * @see IUpgradable
 * @since 02.05.2024
 */
public enum CityBuilding implements IBuilding, IUpgradable
{
	/**
	 * Represents the Command Center {@link CityBuilding} in the city.
	 */
	COMMAND_CENTER(
			new String[]{"Old Command-Center", "Command-Center", "Super-Command-Center"},
			new Image[]{null, null, null},
			new Scene[]{null, null, null}),


	/**
	 * Represents the Docks {@link CityBuilding} in the city.
	 */
	DOCKS(
			new String[]{"Old Docks", "Docks", "Super-Docks"},
			new Image[]{null, null, null},
			new Scene[]{null, null, null}),


	/**
	 * Represents the Space Bar {@link CityBuilding} in the city.
	 */
	SPACE_BAR(
			new String[]{"Old Space-Bar", "Space-Bar", "Super-Space-Bar"},
			new Image[]{null, null, null},
			new Scene[]{null, null, null}),


	/**
	 * Represents the Training Facility {@link CityBuilding} in the city.
	 */
	TRAINING_FACILITY(
			new String[]{"Old Training-Facility", "Training-Facility", "Super-Training-Facility"},
			new Image[]{null, null, null},
			new Scene[]{null, null, null}),


	/**
	 * Represents the Workshop {@link CityBuilding} in the city, which can be used to upgrade and build artifacts.
	 */
	WORKSHOP(
			new String[]{"Old Workshop", "Workshop", "Super-Workshop"},
			new Image[]{null, null, null},
			new Scene[]{null, null, null});


	/**
	 * This pattern is used by the {@link CityBuilding#toString()} method to represent the internal data structure of
	 * this class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN =
			"CityBuilding'{'names={0}, sprites={1}, scenes={2}, currentLevel={3}'}'";


	/**
	 * All names the building can ever have. The name of the building changes with each new level the building is
	 * upgraded to.
	 */
	private final String[] names;


	private final Image[] sprites;


	private final Scene[] scenes;


	private int currentLevel;


	/**
	 * Constructs an instance of the selected building from the provided enum options above.
	 *
	 * @param allDisplayNames A {@link String} array of all names the building can ever have. The name of the building
	 *                        changes with each new level the building is upgraded to.
	 * @param sprites         An {@link Image} array of all sprites the building can ever have. The sprite of the
	 *                        building changes with each new level the building is upgraded to.
	 * @param scenes          A {@link Scene} array of all scenes the building can ever have. The scene of the building
	 *                        is the dialog that will be opened once the player clicks on the building within the city
	 *                        and changes with each new level the building is upgraded to.
	 */
	CityBuilding (final String[] allDisplayNames, final Image[] sprites, final Scene[] scenes)
	{
		// TODO: Load Level from Config

		this.currentLevel = 0;
		this.names = allDisplayNames;
		this.sprites = sprites;
		this.scenes = scenes;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNames ()
	{
		return this.names;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCurrentName ()
	{
		return this.names[this.currentLevel];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Scene[] getScenes ()
	{
		return this.scenes;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Scene getCurrentScene ()
	{
		return this.scenes[this.currentLevel];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image[] getSprites ()
	{
		return this.sprites;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getCurrentSprite ()
	{
		return this.sprites[this.currentLevel];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final int level)
	{
		this.currentLevel = level;
	}


	/**
	 * Creates a string of all attributes this class owns to provide a human-readable format of these classes
	 * instances.
	 *
	 * @return The internal data structure of the city building.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, Arrays.toString(this.names), Arrays.toString(this.sprites),
				Arrays.toString(this.scenes), this.currentLevel);
	}
}
