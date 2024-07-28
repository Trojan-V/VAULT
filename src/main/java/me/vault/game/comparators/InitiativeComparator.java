package me.vault.game.comparators;


import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.TroopTimeline;
import me.vault.game.model.troop.Troop;

import java.util.Comparator;


/**
 * This comparator is used for the priority queue to apply the initiative values of troops in the calculation.
 * The calculation determines which troop will make the next move.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see TroopTimeline#getPriorityQueue()
 * @since 28.07.2024
 */
public class InitiativeComparator implements Comparator<Figure<? extends Troop>>
{
	/**
	 * Compares two {@link Figure}'s by their initiative value.
	 * <br>
	 * As the initiative is simply an integer value, this method just redirects the comparison to
	 * {@link Integer#compare(int, int)}.
	 *
	 * @param figure        The first figure which is compared.
	 * @param anotherFigure The second figure which is compared.
	 * @return -1 if the first figure is smaller than the second figure,
	 * 0 if the first figure is equal to the second figure and 1 if the first figure is greater than the second figure.
	 */
	@Override
	public int compare (final Figure<? extends Troop> figure, final Figure<? extends Troop> anotherFigure)
	{
		return Integer.compare(figure.getStatistics().getDexterityStatistic().getInitiative(),
			anotherFigure.getStatistics().getDexterityStatistic().getInitiative());
	}
}
