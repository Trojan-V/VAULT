package me.vault.vaultgame.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.vault.vaultgame.utility.constant.CharacterConstants.*;

public class Logger
{
	private static final String COLOR_RESET = "\033[0m";
	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS");

	public enum Mode
	{
		VERBOSE,

		TIMESTAMP,

		CLASSNAME
	}

	private final String className;


	public Logger (String className)
	{
		this.className = className;
	}


	public void logDebug (String message)
	{
		this.logDebug(message, Mode.VERBOSE);
	}


	public void logDebug (String message, Mode mode)
	{
		System.out.println(Level.DEBUG.getColorCode() + buildPrefix(mode) + message + COLOR_RESET);
	}


	public void logNormal (String message)
	{
		this.logNormal(message, Mode.VERBOSE);
	}


	public void logNormal (String message, Mode mode)
	{
		System.out.println(Level.NORMAL.getColorCode() + buildPrefix(mode) + message + COLOR_RESET);
	}


	public void logWarning (String message)
	{
		logWarning(message, Mode.VERBOSE);
	}


	public void logWarning (String message, Mode mode)
	{
		System.out.println(Level.WARNING.getColorCode() + buildPrefix(mode) + message + COLOR_RESET);
	}


	public void logError (String message)
	{
		logError(message, Mode.VERBOSE);
	}


	public void logError (String message, Mode mode)
	{
		System.out.println(Level.ERROR.getColorCode() + buildPrefix(mode) + message + COLOR_RESET);
	}


	private String buildPrefix (Mode mode)
	{
		StringBuilder prefix = new StringBuilder().append(STARTING_BRACKET);
		if (mode == Mode.VERBOSE || mode == Mode.TIMESTAMP)
		{
			prefix.append(getTimeStamp());
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


	private static String getTimeStamp ()
	{
		return DATETIME_FORMAT.format(new Date());
	}


	public enum Level
	{
		DEBUG("\033[0;36m"),

		NORMAL("\033[0m"),

		WARNING("\033[0;33m"),

		ERROR("\033[0;31m");

		private final String colorCode;


		Level (String colorCode)
		{
			this.colorCode = colorCode;
		}


		public String getColorCode ()
		{
			return this.colorCode;
		}
	}

}
