package me.vault.game.model.arena;


import me.vault.game.comparators.InitiativeComparator;

import java.util.List;
import java.util.PriorityQueue;


public class TroopTimeline
{

	private final List<Figure> timelineElements;


	public TroopTimeline (final List<Figure> figures)
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


	public void removeTimelineElement (final Figure timelineElement)
	{
		if (!this.timelineElements.contains(timelineElement))
		{
			throw new NullPointerException(); // TODO: Add Exception Message
		}
		this.timelineElements.remove(timelineElement);
	}

}
