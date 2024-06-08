package me.vault.game.player;


import me.vault.game.artifact.Artifact;
import me.vault.game.troop.Faction;


public class Player extends MissionObject implements Movable
{
	private static final Player INSTANCE = new Player();


	private Artifact selectedArtifact;


	private Faction selectedFaction;


	public Player ()
	{
		// TODO: IN FACTION und ARTIFACT ähnlich zu Transaction.EMPTY implementieren und einfügen und laden, solange Config.load nichts zurück gibt
		super(new Tile());
		this.selectedArtifact = null;
		this.selectedFaction = null;
	}


	public Artifact getSelectedArtifact ()
	{
		return this.selectedArtifact;
	}


	public void setSelectedArtifact (final Artifact selectedArtifact)
	{
		this.selectedArtifact = selectedArtifact;
	}


	public Faction getSelectedFaction ()
	{
		return this.selectedFaction;
	}


	public void setSelectedFaction (final Faction selectedFaction)
	{
		this.selectedFaction = selectedFaction;
	}
}
