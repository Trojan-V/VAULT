package me.vault.game.model;


import javafx.beans.property.SimpleBooleanProperty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tile.impl.ArenaStartTileAppearance;
import me.vault.game.utility.interfaces.constant.ArenaConstants;
import me.vault.game.utility.interfaces.constant.MissionConstants;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This class is the model for the missions that can be played.
 * <br>
 * Missions basically take place on a {@link GameBoard}, this class contains this {@link GameBoard} as well as other data related to the mission, such as the
 * rewards of the mission or the available arena encounters that are started when moving to an {@link ArenaStartTileAppearance} tile on the mission
 * {@link GameBoard}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Arena
 * @see GameBoard
 * @since 30.07.2024
 */
public class Mission
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Mission#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "Mission'{'gameBoard={0}, missionReward={1}, isCompletedProperty={2}, availableArenas={3}'}'";

	/**
	 * A list of all available {@link Arena} encounters.
	 * These encounters are pre-defined and are located in the {@link ArenaConstants} constant interface.
	 */
	private static final Collection<Arena> AVAILABLE_ARENA_ENCOUNTERS = new ArrayList<>();


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
	 * The available Arenas of the current Mission instance.
	 */
	private final List<Arena> availableArenas;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * The missions that are used in the game are all pre-defined and stored in the {@link MissionConstants} constant interface.
	 *
	 * @param gameBoard     The {@link GameBoard} where the mission will take place.
	 * @param missionReward The rewards the player receives upon completing the mission.
	 *
	 * @precondition A GameBoard and CurrencyTransaction != null are passed into the method.
	 * @postcondition A new instance of the class was created
	 */
	public Mission (final GameBoard gameBoard, final CurrencyTransaction missionReward)
	{
		this.isCompletedProperty = new SimpleBooleanProperty(false);
		this.gameBoard = gameBoard;
		this.missionReward = missionReward;
		this.availableArenas = new ArrayList<>();
		this.availableArenas.addAll(AVAILABLE_ARENA_ENCOUNTERS);
	}


	/**
	 * Returns true if the mission is completed, otherwise false.
	 *
	 * @return True if the mission is completed, otherwise false.
	 *
	 * @precondition Method gets called and the isCompletedProperty has been set within the instance.
	 * @postcondition A boolean gets returned, that describes, if the Mission is already at the completed level.
	 */
	public boolean isCompleted ()
	{
		return this.isCompletedProperty.get();
	}


	/**
	 * Sets the completed state of the mission to the supplied boolean parameter.
	 *
	 * @param completed Whether the completed state of the mission should be true or false.
	 *
	 * @precondition A valid boolean value is passed into the method.
	 * @postcondition The isCompletedProperty attribute within the object is set to the passed value.
	 */
	public void setCompleted (final boolean completed)
	{
		this.isCompletedProperty.set(completed);
	}


	/**
	 * Returns the property that encapsulates the isCompleted state of the mission and makes it dynamically displayable in the JavaFX GUI.
	 *
	 * @return The property that encapsulates the isCompleted state of the mission.
	 *
	 * @precondition Method gets called and the isCompletedProperty has been set within the instance.
	 * @postcondition The isCompletedProperty of the object has been returned.
	 */
	public SimpleBooleanProperty getIsCompletedProperty ()
	{
		return this.isCompletedProperty;
	}


	/**
	 * Returns the {@link GameBoard} where the mission takes place.
	 *
	 * @return The {@link GameBoard} where the mission takes place.
	 *
	 * @precondition Method gets called and the gameBoard has been set within the instance.
	 * @postcondition The gameBoard attribute of the instance got returned.
	 */
	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	/**
	 * Returns the {@link CurrencyTransaction} that represents the mission rewards the player receives upon mission completion.
	 *
	 * @return The {@link CurrencyTransaction} that represents the mission rewards the player receives upon mission completion.
	 *
	 * @precondition Method gets called and the missionReward has been set within the instance.
	 * @postcondition The missionReward of the object has been returned.
	 */
	public CurrencyTransaction getMissionReward ()
	{
		return this.missionReward;
	}


	/**
	 * Returns a {@link List} of all available encounters in the arena this mission has to offer.
	 *
	 * @return A {@link List} of all available encounters in the arena this mission has to offer.
	 *
	 * @precondition Method gets called and the availableArenas has been set within the instance.
	 * @postcondition The availableArenas of the object has been returned.
	 */
	public List<Arena> getAvailableArenaEncounters ()
	{
		return this.availableArenas;
	}


	/**
	 * Removes an Arena from the {@link List} of all available encounters in the arena this instance contains.
	 *
	 * @param arena The Arena object which is supposed to be removed from the availableArenas of the instance.
	 *
	 * @precondition Method gets called and the passed Arena is != null. availableArenas has been set within the instance.
	 * @postcondition The Arena object has been removed from the availableArenas.
	 */
	public void removeAvailableArena (final Arena arena)
	{
		this.availableArenas.remove(arena);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Mission#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Mission#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link Mission#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.gameBoard.toString(), this.missionReward.toString(), this.isCompletedProperty.get(), this.availableArenas);
	}

}
