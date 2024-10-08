package me.vault.game.model;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.implementation.DamageArtifact;
import me.vault.game.model.energy.EnergyAbility;
import me.vault.game.model.energy.implementation.MeleeAbility;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.interfaces.Movable;
import me.vault.game.utility.interfaces.Nameable;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;

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
	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY = new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Arena#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "Player'{'selectedArtifact={0}, selectedEnergy={1}, selectedFaction={2}, selectedFigures={3}'}'";

	/**
	 * The {@link EnergyAbility} that's currently selected by the player.
	 */
	private final EnergyAbility selectedEnergyAbility;

	/**
	 * The {@link Artifact} that's currently selected by the player.
	 * <br>
	 * The buffs and nerfs this {@link Artifact} provides are applied.
	 */
	private Artifact selectedArtifact;

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
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of Player is created.
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
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance of this class has been returned.
	 */
	public static Player getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Returns the {@link Faction} that's currently selected by the player.
	 *
	 * @return The {@link Faction} that's currently selected by the player.
	 *
	 * @precondition The selectedFaction attribute has been set and contains a list.
	 * @postcondition The selectedFaction attribute of the instance was returned.
	 */
	public Faction getSelectedFaction ()
	{
		return this.selectedFaction;
	}


	/**
	 * Sets the {@link Faction} that's selected by the player.
	 *
	 * @param faction The {@link Faction} that'll be selected by the player.
	 *
	 * @precondition The selectedFaction attribute has been set and contains a list. A valid Faction is passed into the method.
	 * @postcondition The selectedFaction within the instance were set to the passed Faction.
	 */
	public void setSelectedFaction (final Faction faction)
	{
		this.selectedFaction = faction;
	}


	/**
	 * Returns the {@link Artifact} that's currently selected by the player.
	 *
	 * @return The {@link Artifact} that's currently selected by the player.
	 *
	 * @precondition The selectedArtifact attribute has been set and contains an Artifact.
	 * @postcondition The selectedArtifact attribute of the instance was returned.
	 */
	public Artifact getSelectedArtifact ()
	{
		return this.selectedArtifact;
	}


	/**
	 * Sets the {@link Artifact} that's selected by the player.
	 *
	 * @param selectedArtifact The {@link Artifact} that'll be selected by the player.
	 *
	 * @precondition The selectedArtifact attribute has been set and contains a list. A valid Artifact is passed into the method.
	 * @postcondition The selectedArtifact within the instance were set to the passed Artifact.
	 */
	public void setSelectedArtifact (final Artifact selectedArtifact)
	{
		this.selectedArtifact = selectedArtifact;
	}


	/**
	 * Returns the {@link EnergyAbility} that's currently selected by the player.
	 *
	 * @return The {@link EnergyAbility} that's currently selected by the player.
	 *
	 * @precondition The selectedEnergyAbility attribute has been set and contains an EnergyAbility.
	 * @postcondition The selectedEnergyAbility attribute of the instance was returned.
	 */
	public EnergyAbility getSelectedEnergy ()
	{
		return this.selectedEnergyAbility;
	}


	/**
	 * Returns a {@link List} of {@link Figure}s that are currently selected by the player.
	 *
	 * @return A {@link List} of {@link Figure}s that are currently selected by the player.
	 *
	 * @precondition The selectedFigures attribute has been set and contains a list.
	 * @postcondition The selectedFigures attribute of the instance was returned.
	 */
	public List<Figure> getSelectedFigures ()
	{
		return this.selectedFigures;
	}


	/**
	 * Sets the {@link List} of {@link Figure}s that are currently selected by the player to the supplied {@link List}.
	 *
	 * @param selectedFigures The {@link List} of {@link Figure}s that'll be selected by the player.
	 *
	 * @precondition The selectedFigures attribute has been set and contains a list. A valid list of troop figures is passed into the method.
	 * @postcondition The selectedFigures within the instance were set to the passed list of troop figures.
	 */
	public void setSelectedFigures (final List<Figure> selectedFigures)
	{
		this.selectedFigures = selectedFigures;
	}


	/**
	 * Adds a {@link Figure} to the {@link Player#selectedFigures} {@link List}.
	 * <br>
	 * If three {@link Figure}s have already been selected, the {@link Figure} that was selected first will be removed and replaced with the newly selected
	 * {@link Figure}.
	 *
	 * @param figure The {@link Figure} that'll be added to the {@link Player#selectedFigures} {@link List}.
	 *
	 * @precondition The selectedFigures attribute has been set and contains a list. A valid Figure of a troop is passed into the method.
	 * @postcondition The figure was added to the selectedFigures. If the selectedFigures were too long, then the first element is removed.
	 */
	public void addSelectedFigure (final Figure figure)
	{
		if (this.selectedFigures.size() >= 3)
		{
			this.selectedFigures.removeFirst();
		}
		this.selectedFigures.add(figure);
	}


	/**
	 * Returns the sprite stored within the property of the displayable object as an {@link Image}.
	 *
	 * @return The sprite of the displayable object.
	 *
	 * @precondition The sprite attribute of the Displayable has been set and is != null.
	 * @postcondition The sprite attribute of the Displayable was returned.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return SPRITE_PROPERTY.get();
	}


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 *
	 * @precondition A valid instance of {@link MetaDataImage} that isn't equal to null has been passed into the method.
	 * @postcondition The sprite attribute in the Displayable has been set to the passed {@link MetaDataImage}.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		SPRITE_PROPERTY.set(sprite);
	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 *
	 * @precondition The spriteProperty attribute of the Displayable has been set and is != null.
	 * @postcondition The spriteProperty attribute of the Displayable was returned.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}


	/**
	 * Returns the name stored within the property of the nameable object as a {@link String}.
	 *
	 * @return The name of the nameable object.
	 *
	 * @precondition The method gets called.
	 * @postcondition The name of the nameable object was returned as a {@link String}.
	 */
	@Override
	public String getName ()
	{
		return Player.class.getSimpleName();
	}


	/**
	 * Sets the name of the nameable object to the supplied name.
	 *
	 * @param name The new name for the nameable object.
	 *
	 * @precondition The method gets called and a valid name gets passed as a {@link String}.
	 * @postcondition The name property of the nameable object was set to the passed {@link String}.
	 */
	@Override
	public void setName (final String name) {}


	/**
	 * Returns the name property of the nameable object.
	 *
	 * @return The name property of the nameable object.
	 *
	 * @precondition The method gets called.
	 * @postcondition The name property of the nameable object was returned as a {@link String}.
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
	 *
	 * @precondition The {@link Player#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.selectedArtifact.toString(), this.selectedEnergyAbility.toString(), this.selectedFaction.toString(),
			Arrays.toString(this.selectedFigures.toArray()));
	}

}
