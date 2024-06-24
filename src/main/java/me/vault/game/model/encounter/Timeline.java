package me.vault.game.model.encounter;


import me.vault.game.comparators.InitiativeComparator;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Timeline
{
	private ArrayList<Troop> timelineElements = new ArrayList<>();


	public Timeline (final ArrayList<Troop> timelineElements)
	{
		this.timelineElements = timelineElements;
	}


	public ArrayList<Troop> getTimelineElements ()
	{
		return this.timelineElements;
	}


	public PriorityQueue<Troop> getSortedTimeline ()
	{
		final PriorityQueue sortedTimeline = new PriorityQueue<>(new InitiativeComparator());
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
