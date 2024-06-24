package me.vault.game.model.encounter;


import me.vault.game.comparators.InitiativeComparator;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.constant.EncounterConstants;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;


public class Encounter
{

	private final EncounterMap map;


	private Timeline timeline;


	public Encounter (final EncounterMap map)
	{
		this.map = map;
	}


	public PriorityQueue<Troop> getTimeline ()
	{
		final ArrayList<Troop> allTroops = new ArrayList<>(this.getMap().allies);
		allTroops.addAll(new ArrayList<>(this.getMap().enemies));

		final PriorityQueue<Troop> timeline = new PriorityQueue<>(new InitiativeComparator());
		timeline.addAll(allTroops);

		return timeline;
	}


	public EncounterMap getMap ()
	{
		return this.map;
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