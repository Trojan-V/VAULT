package me.vault.game.model.mission;


import javafx.beans.property.SimpleBooleanProperty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tiles.ArenaStartTileAppearance;
import me.vault.game.utility.constant.ArenaConstants;
import me.vault.game.utility.constant.MissionConstants;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is the model for the missions that can be played.
 * <br>
 * Missions basically take place on a {@link GameBoard}, this class contains this {@link GameBoard} as well as other data related to the mission, such as the
 * rewards of the mission or the available arena encounters that are started when moving to an {@link ArenaStartTileAppearance} tile on the mission
 * {@link GameBoard}.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Arena
 * @see GameBoard
 * @since 30.07.2024
 */
public class Mission
{
	/**
	 * A list of all available {@link Arena} encounters.
	 * These encounters are pre-defined and are located in the {@link ArenaConstants} constant interface.
	 */
	private static final List<Arena> AVAILABLE_ARENA_ENCOUNTERS = new ArrayList<>();


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Mission#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "Mission'{'gameBoard={0}, missionReward={1}, isCompletedProperty={2}'}'";


	static
	{
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ArenaOne.ARENA_ONE);
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ArenaTwo.ARENA_TWO);
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ArenaThree.ARENA_THREE);
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ArenaFour.ARENA_FOUR);
	}


	/**
	 * The {@link GameBoard} where the mission takes place.
	 */
	private final GameBoard gameBoard;


	/**
	 * The {@link CurrencyTransaction} which represents the mission completion rewards.
	 */
	private final CurrencyTransaction missionReward;


	/**
	 * This property is used to store and dynamically display if the mission is completed or not.
	 * If the name is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleBooleanProperty isCompletedProperty;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * The missions that are used in the game are all pre-defined and stored in the {@link MissionConstants} constant interface.
	 *
	 * @param gameBoard The {@link GameBoard} where the mission will take place.
	 * @param missionReward The rewards the player receives upon completing the mission.
	 */
	public Mission (final GameBoard gameBoard, final CurrencyTransaction missionReward)
	{
		this.isCompletedProperty = new SimpleBooleanProperty(false);
		this.gameBoard = gameBoard;
		this.missionReward = missionReward;
	}


	/**
	 * Returns true if the mission is completed, otherwise false.
	 *
	 * @return True if the mission is completed, otherwise false.
	 */
	public boolean isCompleted ()
	{
		return this.isCompletedProperty.get();
	}


	/**
	 * Sets the completed state of the mission to the supplied boolean parameter.
	 *
	 * @param completed Whether the completed state of the mission should be true or false.
	 */
	public void setCompleted (final boolean completed)
	{
		this.isCompletedProperty.set(completed);
	}


	/**
	 * Returns the property that encapsulates the isCompleted state of the mission and makes it dynamically displayable in the JavaFX GUI.
	 *
	 * @return The property that encapsulates the isCompleted state of the mission.
	 */
	public SimpleBooleanProperty getIsCompletedProperty ()
	{
		return this.isCompletedProperty;
	}


	/**
	 * Returns the {@link GameBoard} where the mission takes place.
	 *
	 * @return The {@link GameBoard} where the mission takes place.
	 */
	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	/**
	 * Returns the {@link CurrencyTransaction} that represents the mission rewards the player receives upon mission completion.
	 *
	 * @return The {@link CurrencyTransaction} that represents the mission rewards the player receives upon mission completion.
	 */
	public CurrencyTransaction getMissionReward ()
	{
		return this.missionReward;
	}


	/**
	 * Returns a {@link List} of all available encounters in the arena this mission has to offer.
	 *
	 * @return A {@link List} of all available encounters in the arena this mission has to offer.
	 */
	public List<Arena> getAvailableArenaEncounters ()
	{
		return AVAILABLE_ARENA_ENCOUNTERS;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Mission#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Mission#TO_STRING_PATTERN}.
	 * @precondition The {@link Mission#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.gameBoard.toString(), this.missionReward.toString(), this.isCompletedProperty.get());
	}
}
