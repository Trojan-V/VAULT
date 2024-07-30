package me.vault.game.exception;


import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.Position;
import me.vault.game.model.gameboard.GameBoard;

import java.text.MessageFormat;


/**
 * This exception is thrown when an element on the {@link GameBoard} wasn't a {@link Figure} for some reason.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see GameBoard#getFigure(Position)
 * @since 30.07.2024
 */
public class NotAFigureException extends Exception
{
	/**
	 * The message which can be retrieved from the exception instance by invoking {@link NotAFigureException#getMessage()}.
	 * Usually, this message should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String MESSAGE = "The element on the game board is not a figure.";


	/**
	 * The datatype of the element on the game board that wasn't a {@link Figure} can be appended by using the second constructor of this exception.
	 * <br>
	 * This message pattern is used in combination with {@link MessageFormat#format(Object)} to append the datatype to the exception message.
	 */
	private static final String MESSAGE_APPENDIX_PATTERN = " The element is an instance of {0}";


	/**
	 * The default constructor of the exception. Constructs a new instance of this exception and provides the default
	 * {@link NotAFigureException#MESSAGE}.
	 */
	public NotAFigureException ()
	{
		super(MESSAGE);
	}


	/**
	 * This constructor takes the datatype of the element on the game board that wasn't a {@link Figure} and appends it to the message using the
	 * {@link NotAFigureException#MESSAGE_APPENDIX_PATTERN} so more specific information can be given out to the user.
	 *
	 * @param dataTypeOfElement The datatype of the element that wasn't a {@link Figure}.
	 */
	public NotAFigureException (final String dataTypeOfElement)
	{
		super(MESSAGE + MessageFormat.format(MESSAGE_APPENDIX_PATTERN, dataTypeOfElement));
	}
}
