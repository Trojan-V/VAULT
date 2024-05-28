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


// TODO: Delegation der weiteren log-Methoden an eine "base" log Methode. Nur diese "base" log Methode sollte den
//  Aufruf zu sout beinhalten.
public class Logger
{
	private static final String COLOR_RESET = "\033[0m";


	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS",
		Locale.GERMANY);


	private final String className;


	public Logger (final String className)
	{
		this.className = className;
	}


	private static String getTimestamp ()
	{
		return DATETIME_FORMAT.format(Date.from(Instant.now(Clock.systemDefaultZone())));
	}


	public void logDebug (final String message)
	{
		this.logDebug(message, Mode.VERBOSE);
	}


	public void logDebug (final String message, final Mode mode)
	{
		System.out.println(Level.DEBUG.toString() + this.buildPrefix(mode) + message + COLOR_RESET);
	}


	public void logNormal (final String message)
	{
		this.logNormal(message, Mode.VERBOSE);
	}


	public void logNormal (final String message, final Mode mode)
	{
		System.out.println(Level.NORMAL.toString() + this.buildPrefix(mode) + message + COLOR_RESET);
	}


	public void logWarning (final String message)
	{
		this.logWarning(message, Mode.VERBOSE);
	}


	public void logWarning (final String message, final Mode mode)
	{
		System.out.println(Level.WARNING.toString() + this.buildPrefix(mode) + message + COLOR_RESET);
	}


	public void logError (final String message)
	{
		this.logError(message, Mode.VERBOSE);
	}


	public void logError (final String message, final Mode mode)
	{
		System.out.println(Level.ERROR.toString() + this.buildPrefix(mode) + message + COLOR_RESET);
	}


	public void log (final Level level, final String message)
	{
		System.out.println(level.toString() + message);
	}


	private String buildPrefix (final Mode mode)
	{
		final StringBuilder prefix = new StringBuilder().append(OPENING_BRACKET);
		if (mode == Mode.VERBOSE || mode == Mode.TIMESTAMP)
		{
			prefix.append(getTimestamp());
		}
		if (mode == Mode.VERBOSE || mode == Mode.CLASSNAME)
		{
			prefix.append(WHITESPACE).append(PIPE).append(WHITESPACE).append(this.getClassName());
		}
		prefix.append(CLOSING_BRACKET).append(WHITESPACE);
		return prefix.toString();
	}


	private String getClassName ()
	{
		return this.className;
	}


	public enum Mode
	{
		VERBOSE,

		TIMESTAMP,

		CLASSNAME
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
