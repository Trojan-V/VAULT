package me.vault.game.model.arena;


import me.vault.game.comparators.InitiativeComparator;

import java.util.List;
import java.util.PriorityQueue;


/**
 * This class provides the data structure for the timeline of the {@link Figure}s that are fighting in the arena.
 * <br>
 * The most important part here's the {@link FigureTimeline#createPriorityQueue()} method, which returns a priority queue that determines which {@link Figure}
 * is allowed to make the next move in the {@link Arena}.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Figure
 * @see PriorityQueue
 * @since 29.07.2024
 */
public class FigureTimeline
{
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
	 */
	public FigureTimeline (final List<Figure> figures)
	{
		this.elements = figures;
	}


	/**
	 * Returns a {@link List} which contains all elements of the timeline.
	 *
	 * @return A {@link List} which contains all elements of the timeline.
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
	 */
	public void removeFigure (final Figure figure)
	{
		if (!this.elements.contains(figure))
		{
			throw new NullPointerException(); // TODO: Add Exception Message
		}
		this.elements.remove(figure);
	}

}
