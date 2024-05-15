package me.vault.vaultgame.city.model;

import javafx.scene.image.Image;

import java.util.List;

/**
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @since 02.05.2024
 */
public enum Building
{

	/**
	 * Represents the Headquarter-Building in the city
	 */
	SPACESTATION("Spacestation", new Position(0, 0)),

	/**
	 * Represents the Headquarter-Building in the city
	 */
	HEADQUARTER("Headquarter", new Position(0, 0)),

	/**
	 * Represents the Forge-Building in the city
	 */
	FORGE("Forge", new Position(0, 0)),

	/**
	 * Represents the Training-Camp-Building in the city
	 */
	TRAINING_CAMP("Training Camp", new Position(0, 0));

	//------------------------------------------------------------------------------------------------------------------

	/**
	 * The displayed name of the city-building/object.
	 */
	private final String displayName;

	/**
	 * The screen position of the city-building/object.
	 */
	private final Position stagePosition;

	/**
	 * The current Level of the city building
	 */
	private List<BuildingLevel> levels;

	//------------------------------------------------------------------------------------------------------------------

	/**
	 * @param displayName
	 * @param stagePosition
	 */
	Building (String displayName, Position stagePosition)
	{
		this.displayName = displayName;
		this.stagePosition = stagePosition;
	}

	/**
	 * @param sprite
	 */
	private void setSprite (Image sprite)
	{

	}

	public String getDisplayName ()
	{
		return this.displayName;
	}

	public Position getStagePosition ()
	{
		return this.stagePosition;
	}
}
