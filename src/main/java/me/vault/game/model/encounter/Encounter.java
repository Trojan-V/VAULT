package me.vault.game.model.encounter;


import me.vault.game.model.GameMap;
import me.vault.game.model.Vertex;
import me.vault.game.model.troop.unit.Unit;
import me.vault.game.utility.constant.EncounterConstants;

import java.util.Map;
import java.util.Random;


public class Encounter
{
	private GameMap map;

	private Vertex tile;


	public Encounter (final GameMap map, final Vertex tile)
	{
		this.map = map;
		this.tile = tile;
	}


	private void initiative ()
	{
		Unit.MEDIC.getAllAttributes();
	}


	/**
	 * Random number generator
	 *
	 * @return a random number
	 */
	private double rollDice ()
	{
		final Random rand = new Random();
		double dice = rand.nextInt(EncounterConstants.DICE);
		dice += EncounterConstants.DICE;
		dice *= EncounterConstants.FIVE_PERCENT;
		return dice;
	}


	private void rollAttack (final double dice, final double dodge, boolean hit)
	{
		hit = dice > dodge;
	}

}