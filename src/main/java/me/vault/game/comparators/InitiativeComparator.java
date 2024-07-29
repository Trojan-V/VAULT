package me.vault.game.comparators;


import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.FigureTimeline;

import java.util.Comparator;


/**
 * This comparator is used for the priority queue to apply the initiative values of troops in the calculation.
 * The calculation determines which troop will make the next move.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see FigureTimeline#createPriorityQueue()
 * @since 28.07.2024
 */
public class InitiativeComparator implements Comparator<Figure>
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
	public int compare (final Figure figure, final Figure anotherFigure)
	{
		return Integer.compare(figure.getStatistics().getDexterity().getInitiativePoints(),
			anotherFigure.getStatistics().getDexterity().getInitiativePoints());
	}
}
