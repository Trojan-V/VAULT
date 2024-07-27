package me.vault.game.comparators;


import me.vault.game.model.arena.Figure;
import me.vault.game.model.troop.Troop;

import java.util.Comparator;


public class InitiativeComparator implements Comparator<Figure<Troop>>
{

	@Override
	public int compare (final Figure<Troop> o1, final Figure<Troop> o2)
	{
		return Integer.compare(o1.getStatistics().getDexterityStatistic().getInitiative(),
			o2.getStatistics().getDexterityStatistic().getInitiative());
	}

}
