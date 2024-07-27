package me.vault.game.model.arena;


import me.vault.game.comparators.InitiativeComparator;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Timeline
{

	private ArrayList<Figure<Troop>> timelineElements = new ArrayList<>();


	public Timeline (final ArrayList<Figure<Troop>> timelineElements)
	{
		this.timelineElements = timelineElements;
	}


	public ArrayList<Figure<Troop>> getTimelineElements ()
	{
		return this.timelineElements;
	}


	public PriorityQueue<Figure<Troop>> getPriorityQueue ()
	{
		final PriorityQueue<Figure<Troop>> sortedTimeline = new PriorityQueue<Figure<Troop>>(new InitiativeComparator());
		sortedTimeline.addAll(this.timelineElements);

		return sortedTimeline;
	}


	public void removeTimelineElement (final Troop timelineElement)
	{
		if (!this.timelineElements.contains(timelineElement))
		{
			throw new NullPointerException(); //TODO: Add Exception Message
		}
		this.timelineElements.remove(timelineElement);
	}

}
