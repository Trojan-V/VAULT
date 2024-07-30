package me.vault.game.model.arena;


import me.vault.game.comparators.InitiativeComparator;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * This class provides the data structure for the timeline of the {@link Figure}s that are fighting in the arena.
 * <br>
 * The most important part here's the {@link FigureTimeline#createPriorityQueue()} method, which returns a priority queue that determines which {@link Figure}
 * is allowed to make the next move in the {@link Arena}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Figure
 * @see PriorityQueue
 * @since 29.07.2024
 */
public class FigureTimeline
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link FigureTimeline#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "FigureTimeline'{'elements={0}'}'";


	/**
	 * This {@link List} contains all elements of the timeline.
	 * <br>
	 * This list is used every time {@link FigureTimeline#createPriorityQueue()} is invoked to create a fresh priority queue for all {@link Figure}s that are
	 * part of the timeline.
	 */
	private final List<Figure> elements;


	/**
	 * Constructs an instance of this class.
	 *
	 * @param figures A {@link List} that contains all {@link Figure}s that should be added to the timeline.
	 *
	 * @precondition The {@link List} that contains all {@link Figure}s exists.
	 * @postcondition The {@link Figure}s are added to the timeline.
	 */
	public FigureTimeline (final List<Figure> figures)
	{
		this.elements = figures;
	}


	/**
	 * Returns a {@link List} which contains all elements of the timeline.
	 *
	 * @return A {@link List} which contains all elements of the timeline.
	 *
	 * @precondition The elements of the timeline exists.
	 * @postcondition The {@link List} of the elements of the timeline
	 */
	public List<Figure> getFigureList ()
	{
		return this.elements;
	}


	/**
	 * Creates a priority queue which contains all {@link FigureTimeline#elements}.
	 * <br>
	 * This timeline is created by using the {@link InitiativeComparator}, so the {@link Figure}s with the highest initiative value are allowed to make the
	 * first move in the arena.
	 *
	 * @return A priority queue which contains all {@link FigureTimeline#elements}.
	 *
	 * @precondition The {@link FigureTimeline#elements} exists.
	 * @postcondition The priority queue which contains all {@link FigureTimeline#elements} is created.
	 */
	public PriorityQueue<Figure> createPriorityQueue ()
	{
		final PriorityQueue<Figure> sortedTimeline = new PriorityQueue<>(new InitiativeComparator());
		sortedTimeline.addAll(this.elements);

		return sortedTimeline;
	}


	/**
	 * Removes the supplied {@link Figure} from the timeline.
	 *
	 * @param figure The {@link Figure} which should be removed.
	 *
	 * @precondition The {@link Figure} that will be removed exists.
	 * @postcondition The supplied {@link Figure} is removed from the timeline.
	 */
	public void removeFigure (final Figure figure)
	{
		if (!this.elements.contains(figure))
		{
			throw new NullPointerException();
		}
		this.elements.remove(figure);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link FigureTimeline#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link FigureTimeline#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link FigureTimeline#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, Arrays.deepToString(this.elements.toArray()));
	}

}
