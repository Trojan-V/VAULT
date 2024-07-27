package me.vault.game.model.arena;


import me.vault.game.comparators.InitiativeComparator;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class TroopTimeline
{

	private List<Figure<? extends Troop>> timelineElements = new ArrayList<>();


	public TroopTimeline (final List<Figure<? extends Troop>> figures)
	{
		this.timelineElements = figures;
	}


	public List<Figure<? extends Troop>> getFigureList ()
	{
		return this.timelineElements;
	}


	public PriorityQueue<Figure<? extends Troop>> getPriorityQueue ()
	{
		final PriorityQueue<Figure<? extends Troop>> sortedTimeline = new PriorityQueue<Figure<? extends Troop>>(new InitiativeComparator());
		sortedTimeline.addAll(this.timelineElements);

		return sortedTimeline;
	}


	public void removeTimelineElement (final Figure<? extends Troop> timelineElement)
	{
		if (!this.timelineElements.contains(timelineElement))
		{
			throw new NullPointerException(); //TODO: Add Exception Message
		}
		this.timelineElements.remove(timelineElement);
	}

}
