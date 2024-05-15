package me.vault.vaultgame.city.building.model;


import javafx.scene.Scene;
import javafx.scene.image.Image;


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
	 * Description
	 *
	 * @return
	 */
	public  abstract String[] getNames ();


	/**
	 * Description
	 *
	 * @return
	 */
	public abstract String getCurrentName ();


	/**
	 * Description
	 *
	 * @return
	 */
	public abstract Image[] getSprites ();


	/**
	 * Description
	 *
	 * @return
	 */
	public abstract Image getCurrentSprite ();


	/**
	 * Description
	 *
	 * @return
	 */
	public abstract Scene[] getScenes ();


	/**
	 * Description
	 *
	 * @return
	 */
	public abstract Scene getCurrentScene ();
}
