package me.vault.game.model.arena;


import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;


public final record Position(int x, int y)
{

	private static final Logger LOGGER = new Logger(Position.class.getSimpleName());

	private static final String TO_STRING_PATTERN = "Pos[x:{0},y:{1}]";


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.x, this.y);
	}

}
