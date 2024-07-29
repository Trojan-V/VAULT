package me.vault.game.model.player;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Movable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.energy.Energy;
import me.vault.game.model.energy.impl.MeleeAbility;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.util.ArrayList;


public final class Player implements Movable, Nameable
{

	private static final Player INSTANCE = new Player();


	private static final String SPRITE_PATH = GameConstants.WINDOW_ICON_PATH;


	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY =
		new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));

	private Artifact selectedArtifact;

	private Energy selectedEnergy;

	private Faction selectedFaction;


	private ArrayList<Figure> selectedTroops;


	private Player ()
	{
		this.selectedFaction = Faction.NEW_TERRA;
		this.selectedArtifact = DamageArtifact.getInstance();
		this.selectedEnergy = MeleeAbility.getInstance();
		this.selectedTroops = new ArrayList<>();
	}


	public static Player getInstance ()
	{
		return INSTANCE;
	}


	public Faction getSelectedFaction ()
	{
		return this.selectedFaction;
	}


	public void setSelectedFaction (final Faction faction)
	{
		this.selectedFaction = faction;
	}


	public Artifact getSelectedArtifact ()
	{
		return this.selectedArtifact;
	}


	public Energy getSelectedEnergy ()
	{
		return selectedEnergy;
	}


	public void setSelectedArtifact (final Artifact selectedArtifact)
	{
		this.selectedArtifact = selectedArtifact;
	}


	public ArrayList<Figure> getSelectedTroops ()
	{
		return this.selectedTroops;
	}


	public void setSelectedTroops (final ArrayList<Figure> troopArrayList)
	{
		this.selectedTroops = troopArrayList;
	}


	public void addSelectedTroop (final Figure troop)
	{
		if (this.selectedTroops.size() >= 3)
		{
			this.selectedTroops.removeFirst();
		}
		this.selectedTroops.add(troop);
	}


	public void clearSelectedTroops ()
	{
		this.selectedTroops.clear();
	}


	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {.
	 *
	 * @return The sprite of the displayable object.
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
	 */
	@Override
	public String getName ()
	{
		return "";
	}


	/**
	 * Sets the name of the nameable object to the supplied name.
	 *
	 * @param name The new name for the nameable object.
	 */
	@Override
	public void setName (final String name)
	{

	}


	/**
	 * Returns the name property of the nameable object.
	 *
	 * @return The name property of the nameable object.
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return null;
	}
}
