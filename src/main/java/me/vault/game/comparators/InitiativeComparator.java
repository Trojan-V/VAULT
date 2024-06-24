package me.vault.game.comparators;


import me.vault.game.model.troop.Troop;

import java.util.Comparator;


public class InitiativeComparator implements Comparator<Troop>
{

	@Override
	public int compare (final Troop o1, final Troop o2)
	{
		return Integer.compare(o1.getStatistic().getDexterityStatistic().getInitiative(),
			o2.getStatistic().getDexterityStatistic().getInitiative());
	}
}
