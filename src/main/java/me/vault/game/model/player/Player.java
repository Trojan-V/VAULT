package me.vault.game.model.player;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Movable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.energy.EnergyAbility;
import me.vault.game.model.energy.impl.MeleeAbility;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is a model for the player and stores different data about the player.
 * <br>
 * For instance, the {@link Artifact}, {@link EnergyAbility}, {@link Faction} and {@link Troop}s the player has currently selected are stored within this model.
 * <br>
 * As there can only be one player at all time (at least in Singleplayer mode), the player class is written using the singleton pattern.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Movable
 * @see Nameable
 * @see Artifact
 * @see EnergyAbility
 * @see Faction
 * @since 30.07.2024
 */
public final class Player implements Movable, Nameable
{
	/**
	 * Singleton instance, as there's no reason to have more than one {@link Player}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final Player INSTANCE = new Player();


	/**
	 * The path to the sprite that represents a player.
	 */
	private static final String SPRITE_PATH = GameConstants.WINDOW_ICON_PATH;


	/**
	 * This property is used to store and display the sprite of the player.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 * <br>
	 * Although there's no plan to change the sprite of the player, a property is used here anyway for consistency reasons throughout the entire project.
	 */
	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY =
		new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Arena#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "Player'{'selectedArtifact={0}, selectedEnergy={1}, selectedFaction={2}, selectedFigures={3}'}'";


	/**
	 * The {@link Artifact} that's currently selected by the player.
	 * <br>
	 * The buffs and nerfs this {@link Artifact} provides are applied.
	 */
	private Artifact selectedArtifact;


	/**
	 * The {@link EnergyAbility} that's currently selected by the player.
	 */
	private final EnergyAbility selectedEnergyAbility;


	/**
	 * The {@link Faction} that's currently selected by the player.
	 */
	private Faction selectedFaction;


	/**
	 * A {@link List} of {@link Figure}s that are currently selected by the player.
	 * <br>
	 * These are the {@link Figure}s that'll be spawned in the {@link Arena} for the first player, as he selected these.
	 */
	private List<Figure> selectedFigures;


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private Player ()
	{
		this.selectedFaction = Faction.NEW_TERRA;
		this.selectedArtifact = DamageArtifact.getInstance();
		this.selectedEnergyAbility = MeleeAbility.getInstance();
		this.selectedFigures = new ArrayList<>();
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static Player getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Returns the {@link Faction} that's currently selected by the player.
	 *
	 * @return The {@link Faction} that's currently selected by the player.
	 */
	public Faction getSelectedFaction ()
	{
		return this.selectedFaction;
	}


	/**
	 * Sets the {@link Faction} that's selected by the player.
	 *
	 * @param faction The {@link Faction} that'll be selected by the player.
	 */
	public void setSelectedFaction (final Faction faction)
	{
		this.selectedFaction = faction;
	}


	/**
	 * Returns the {@link Artifact} that's currently selected by the player.
	 *
	 * @return The {@link Artifact} that's currently selected by the player.
	 */
	public Artifact getSelectedArtifact ()
	{
		return this.selectedArtifact;
	}


	/**
	 * Sets the {@link Artifact} that's selected by the player.
	 *
	 * @param selectedArtifact The {@link Artifact} that'll be selected by the player.
	 */
	public void setSelectedArtifact (final Artifact selectedArtifact)
	{
		this.selectedArtifact = selectedArtifact;
	}


	/**
	 * Returns the {@link EnergyAbility} that's currently selected by the player.
	 *
	 * @return The {@link EnergyAbility} that's currently selected by the player.
	 */
	public EnergyAbility getSelectedEnergy ()
	{
		return this.selectedEnergyAbility;
	}


	/**
	 * Returns a {@link List} of {@link Figure}s that are currently selected by the player.
	 *
	 * @return A {@link List} of {@link Figure}s that are currently selected by the player.
	 */
	public List<Figure> getSelectedFigures ()
	{
		return this.selectedFigures;
	}


	/**
	 * Sets the {@link List} of {@link Figure}s that are currently selected by the player to the supplied {@link List}.
	 *
	 * @param figureArrayList The {@link List} of {@link Figure}s that'll be selected by the player.
	 */
	public void setSelectedFigures (final List<Figure> figureArrayList)
	{
		this.selectedFigures = figureArrayList;
	}


	/**
	 * Adds a {@link Figure} to the {@link Player#selectedFigures} {@link List}.
	 * <br>
	 * If three {@link Figure}s have already been selected, the {@link Figure} that was selected first will be removed and replaced with the newly selected
	 * {@link Figure}.
	 *
	 * @param figure The {@link Figure} that'll be added to the {@link Player#selectedFigures} {@link List}.
	 */
	public void addSelectedFigures (final Figure figure)
	{
		if (this.selectedFigures.size() >= 3)
		{
			this.selectedFigures.removeFirst();
		}
		this.selectedFigures.add(figure);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return SPRITE_PROPERTY.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		SPRITE_PROPERTY.set(sprite);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName ()
	{
		return "";
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName (final String name)
	{

	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return null;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Player#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Player#TO_STRING_PATTERN}.
	 * @precondition The {@link Player#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.selectedArtifact.toString(), this.selectedEnergyAbility.toString(),
			this.selectedFaction.toString(),
			Arrays.toString(this.selectedFigures.toArray()));
	}
}
