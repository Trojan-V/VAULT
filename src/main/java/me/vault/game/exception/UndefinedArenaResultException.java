package me.vault.game.exception;


import me.vault.game.model.arena.ArenaResult;
import me.vault.game.view.ArenaFinishedDialogDelegate;


/**
 * This exception is thrown when the {@link ArenaResult} is undefined after the arena should be finished.
 * <br>
 * Usually, this exception should never be thrown unless a programmer messed something up in the control flow of the game.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see ArenaFinishedDialogDelegate
 * @since 30.07.2024
 */
public class UndefinedArenaResultException extends Exception
{

	/**
	 * The message which can be retrieved from the exception instance by invoking {@link UndefinedArenaResultException#getMessage()}.
	 * Usually, this message should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String MESSAGE = "Arena ended with an undefined result. Can't continue the active mission.";


	/**
	 * The default constructor of the exception.
	 * Constructs a new instance of this exception and provides the default {@link UndefinedArenaResultException#MESSAGE}.
	 *
	 * @precondition The constructor of the exception gets called.
	 * @postcondition A new instance of the exception is created.
	 */
	public UndefinedArenaResultException ()
	{
		super(MESSAGE);
	}

}
