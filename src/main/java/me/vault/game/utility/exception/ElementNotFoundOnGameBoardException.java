package me.vault.game.utility.exception;


import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.utility.interfaces.Placeable;


/**
 * This exception is thrown when a {@link Placeable} element wasn't found on the {@link GameBoard}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see GameBoard#getPosition(Placeable)
 * @since 30.07.2024
 */
public class ElementNotFoundOnGameBoardException extends Exception
{

	/**
	 * The message which can be retrieved from the exception instance by invoking {@link NotAFigureException#getMessage()}.
	 * Usually, this message should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String MESSAGE = "The element wasn't found on the game board.";


	/**
	 * The default constructor of the exception. Constructs a new instance of this exception and provides the default
	 * {@link ElementNotFoundOnGameBoardException#MESSAGE}.
	 *
	 * @precondition The constructor of the exception gets called.
	 * @postcondition A new instance of the exception is created.
	 */
	public ElementNotFoundOnGameBoardException ()
	{
		super(MESSAGE);
	}

}
