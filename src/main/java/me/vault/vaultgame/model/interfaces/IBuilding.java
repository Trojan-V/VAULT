package me.vault.vaultgame.model.interfaces;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import me.vault.vaultgame.model.CityBuilding;


/**
 * Description
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see CityBuilding
 * @since 15.05.2024
 */
public interface IBuilding
{
	/**
	 * Returns an array of all display-names of the {@code CityBuilding} object.
	 *
	 * @return A {@link String} array containing all different display names.
	 */
	public abstract String[] getNames ();


	/**
	 * Returns the current display-name of the {@code CityBuilding} object.
	 *
	 * @return The current display-name of the object as an {@link String}.
	 */
	public abstract String getCurrentName ();


	/**
	 * Returns an array of all sprites of the {@code CityBuilding} object. The current sprite of the building changes
	 * with each new level the building is upgraded to.
	 *
	 * @return A {@link Image} array containing all different sprites.
	 */
	public abstract ImageView[] getSprites ();


	/**
	 * Returns the current sprite of the {@code CityBuilding} object. The current sprite of the building changes with
	 * each new level the building is upgraded to.
	 *
	 * @return The current spite of the object as an {@link Image}.
	 */
	public abstract ImageView getCurrentSprite ();


	/**
	 * Returns all scenes the building can ever have. The current scene of the building changes with each new level the
	 * building is upgraded to.
	 *
	 * @return A {@link Scene} array containing all different GUI-scenes.
	 */
	public abstract Scene[] getScenes ();


	/**
	 * Returns the current scene of the {@code CityBuilding} object.
	 *
	 * @return The current scene of the object as an {@link Scene}.
	 */
	public abstract Scene getCurrentScene ();
}
