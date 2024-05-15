package me.vault.vaultgame.city.model;

import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The {@code BuildingLevel} class is used to create objects which contain the respective properties for each level
 * of a {@link Building} object. Each {@code Building} is meant to contain a {@link java.util.List} of {@code
 * BuildingLevel} objects for all the levels the {@code Building} has.
 *
 * @param displayName The name, that is displayed in the building-view.
 * @param sprite      The sprite, that is displayed in the city-view.
 * @param dialog      The dialog, that is shown, when the building is selected in the city-view
 * @author Lasse-Leander Hillen
 * @see me.vault.vaultgame.city.controller.BuildingController
 * @see Building
 * @since 07.05.2024
 */
public record BuildingLevel(String displayName, Image sprite, Stage dialog)
{
	/**
	 * @return
	 */
	@Override
	public String displayName ()
	{
		return this.displayName;
	}

	/**
	 * @return
	 */
	@Override
	public Stage dialog ()
	{
		return this.dialog;
	}

	/**
	 * @return
	 */
	@Override
	public Image sprite ()
	{
		return this.sprite;
	}
}
