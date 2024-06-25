package me.vault.game.model.player;


import me.vault.game.model.Vertex;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.troop.Faction;


public class Player implements Movable
{

	private static final Player INSTANCE = new Player();

	private Artifact selectedArtifact;

	private Faction selectedFaction;


	private Player ()
	{
		this.selectedFaction = Faction.NEW_TERRA;
		this.selectedArtifact = DamageArtifact.getInstance();
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


	public void setSelectedArtifact (final Artifact selectedArtifact)
	{
		this.selectedArtifact = selectedArtifact;
	}


	@Override
	public void move (final Vertex nextVertex)
	{

	}

}
