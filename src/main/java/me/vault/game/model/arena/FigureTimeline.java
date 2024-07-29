package me.vault.game.model.arena;


import me.vault.game.comparators.InitiativeComparator;

import java.util.List;
import java.util.PriorityQueue;


public class FigureTimeline
{

	private final List<Figure> timelineElements;


	public FigureTimeline (final List<Figure> figures)
	{
		this.timelineElements = figures;
	}


	public List<Figure> getFigureList ()
	{
		return this.timelineElements;
	}


	public PriorityQueue<Figure> getPriorityQueue ()
	{
		final PriorityQueue<Figure> sortedTimeline = new PriorityQueue<>(new InitiativeComparator());
		sortedTimeline.addAll(this.timelineElements);

		return sortedTimeline;
	}


	public void removeFigure (final Figure figure)
	{
		if (!this.timelineElements.contains(figure))
		{
			throw new NullPointerException(); // TODO: Add Exception Message
		}
		this.timelineElements.remove(figure);
	}

}
