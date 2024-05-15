package me.vault.vaultgame.city.model;

import javafx.scene.image.Image;

/**
 * The class {@link Forge} represents the upgrade center within the city. It contains methods to upgrade troops and is implemented as a
 * singleton-class, since there is only ever one {@code Forge} used within the game.
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see Building
 * @see Upgradable
 * @see me.vault.vaultgame.city.view.BuildingView
 * @since 30.04.2024
 */
public class Forge extends Building implements Upgradable
{
	/** The singleton instance of the class */
	private static Forge instance = null;

	/** The sprite of the building, which is used in the city-view */
	private static Image sprite = null;


	/**
	 * The constructor of the {@link Forge} class.
	 */
	private Forge ()
	{
		// sprite = new Image();
	}


	/**
	 * @return
	 */
	public static Forge getInstance ()
	{
		if (instance == null)
		{
			instance = new Forge();
		}
		return instance;
	}


	/**
	 * Elevates the {@link Building} to the next (higher) level, updates the sprite and unlocks new features based on the new level.
	 *
	 * @since 30.04.2024
	 */
	@Override
	public void upgrade ()
	{

	}

}
