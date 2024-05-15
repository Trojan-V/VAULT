package me.vault.vaultgame.city.model;

import javafx.scene.image.Image;

import java.util.UUID;

/**
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @since 02.05.2024
 */
public enum Building
{
	/** Represents the Headquarter-Building in the city */
	SPACESTATION(UUID.fromString("Spacestation"), "Spacestation", new Position(0, 0)),

	/** Represents the Headquarter-Building in the city */
	HEADQUARTER(UUID.fromString("Headquarter"), "Headquarter", new Position(0, 0)),

	/** Represents the Forge-Building in the city */
	FORGE(UUID.fromString("Forge"), "Forge", new Position(0, 0)),

	/** Represents the Training-Camp-Building in the city */
	TRAINING_CAMP(UUID.fromString("Training Camp"), "Training Camp", new Position(0, 0));

	/**  */
	private final String displayName;

	/**  */
	private final UUID uuid;

	/**  */
	private final Position stagePosition;

	/**  */
	private int currentLevel;


	/**
	 * @param uuid
	 * @param displayName
	 * @param stagePosition
	 */
	Building (UUID uuid, String displayName, Position stagePosition)
	{
		this.uuid = uuid;
		this.displayName = displayName;
		this.stagePosition = stagePosition;
	}


	/**
	 * @param sprite
	 */
	private void setSprite (Image sprite)
	{

	}

	public UUID getUuid ()
	{
		return this.uuid;
	}


	public String getDisplayName ()
	{
		return this.displayName;
	}


	public Position getStagePosition ()
	{
		return this.stagePosition;
	}


	public int getCurrentLevel ()
	{
		return this.currentLevel;
	}

	public void setCurrentLevel (int i)
	{
		this.currentLevel = i;
	}
}
