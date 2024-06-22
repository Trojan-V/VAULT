package me.vault.game.model.player;


import me.vault.game.model.GameMap;
import me.vault.game.model.Vertex;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.troop.Faction;


public class Player extends MapObject implements Movable
{

	private static Player INSTANCE;

	private final Artifact selectedArtifact;

	private final Faction selectedFaction;


	public Player (final GameMap map, final Vertex tile, final Artifact selectedArtifact, final Faction selectedFaction)
	{
		super(map, tile);
		this.selectedArtifact = selectedArtifact;
		this.selectedFaction = selectedFaction;
	}


	@Override
	public void move (final Vertex nextVertex)
	{

	}

}
