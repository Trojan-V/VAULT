package me.vault.game.model.player;


import me.vault.game.model.GameMap;
import me.vault.game.model.Vertex;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.troop.Faction;


public class Player implements Movable
{

	private static Player INSTANCE = new Player(null, null, null, null);

	private final Artifact selectedArtifact;

	private Faction selectedFaction;


	public Player (final GameMap map, final Vertex tile, final Artifact selectedArtifact, final Faction selectedFaction)
	{
		this.selectedArtifact = selectedArtifact;
		this.selectedFaction = selectedFaction;
	}


	public static Player getInstance ()
	{
		return INSTANCE;
	}


	public void setSelectedFaction (Faction newFaction)
	{
		this.selectedFaction = newFaction;
	}


	@Override
	public void move (final Vertex nextVertex)
	{

	}

}
