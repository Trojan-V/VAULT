package me.vault.game.model.player;


import me.vault.game.model.Vertex;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;


public final class Player implements Movable
{

	private static final Player INSTANCE = new Player();

	private Artifact selectedArtifact;

	private Faction selectedFaction;

	private ArrayList<Troop> selectedTroops;


	private Player ()
	{
		this.selectedFaction = Faction.NEW_TERRA;
		this.selectedArtifact = DamageArtifact.getInstance();
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


	public void setSelectedArtifact (final Artifact selectedArtifact)
	{
		this.selectedArtifact = selectedArtifact;
	}


	public ArrayList<Troop> getSelectedTroops ()
	{
		return this.selectedTroops;
	}


	public void addSelectedTroop (Troop troop)
	{
		this.selectedTroops.add(troop);
	}


	public void setSelectedTroops (ArrayList<Troop> troopArrayList)
	{
		this.selectedTroops = troopArrayList;
	}


	public void clearSelectedTroops ()
	{
		this.selectedTroops.clear();
	}


	@Override
	public void move (final Vertex nextVertex)
	{

	}

}
