package me.vault.game.exception;


public class UndefinedResultException extends Exception
{

	private static final String EXCEPTION_MESSAGE = "Arena ended with an undefined result. Can't continue the active mission.";


	public UndefinedResultException ()
	{
		super(EXCEPTION_MESSAGE);
	}

}
