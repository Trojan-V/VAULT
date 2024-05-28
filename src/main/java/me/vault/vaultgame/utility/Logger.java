package me.vault.vaultgame.utility;


import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import static me.vault.vaultgame.utility.constant.CharacterConstants.*;

// TODO: Mode macht keinen Sinn? Mode muss per Konfigurationsmethode gesetzt werden können (z.B. JVM Argument), und
//  sollte dann intern von den einzelnen Log-Methoden abgefragt werden, um Logging ein- oder auszuschalten zu können.
//  Dabei sollten auch verschiedene Logging-Level aktiviert und deaktiviert werden können, das könnte folgendermaßen
//  aussehen: switch (Mode mode) {
//  case ALL: sendLogsFromAllLevels = true;
//  case CRITICAL: only send critical logs, such as error (and maybe warning)}

public class Logger
{
	private static final String COLOR_RESET = "\033[0m";


	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS", Locale.GERMANY);


	private final String className;
	private Level depth;


	public Logger (final String className)
	{
		this(className, Level.DEBUG);
	}

	public Logger (final String className, final Level depth)
	{
		this.className = className;
		this.depth = depth;
	}


	private void log (final Level level, final String message)
	{
		if (level.ordinal() >= this.depth.ordinal())
		{
			System.out.println(level.toString() + this.getPrefix() + message + COLOR_RESET);
		}
	}


	public void logDebug (final String message)
	{
		this.log(Level.DEBUG, message);
	}


	public void logNormal (final String message)
	{
		this.log(Level.NORMAL, message);
	}


	public void logWarning (final String message)
	{
		this.log(Level.WARNING, message);
	}


	public void logError (final String message)
	{
		this.log(Level.ERROR, message);
	}


	private static String getTimestamp ()
	{
		return DATETIME_FORMAT.format(Date.from(Instant.now(Clock.systemDefaultZone())));
	}


	private String getClassName ()
	{
		return this.className;
	}


	private String getPrefix ()
	{
		return OPENING_BRACKET + getTimestamp() + WHITESPACE + PIPE + WHITESPACE + this.getClassName() + CLOSING_BRACKET + WHITESPACE;
	}


	public enum Level
	{
		DEBUG("\033[0;36m"),

		NORMAL("\033[0m"),

		WARNING("\033[0;33m"),

		ERROR("\033[0;31m");


		private final String colorCode;


		Level (final String colorCode)
		{
			this.colorCode = colorCode;
		}


		@Override
		public String toString ()
		{
			return this.colorCode;
		}
	}

}
