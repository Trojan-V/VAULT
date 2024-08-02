package me.vault.game.utility.interfaces.constant;

/**
 * This interface provides constants for the use in the networkimplementation of this application.
 *
 *  @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 *  @version 1.0.0
 *  @since 02.08.2024
 */
public interface NetworkConstants
{
	/**
	 * The smallest ephemeral port (see https://en.wikipedia.org/wiki/Ephemeral_port).
	 */
	int MINIMUM_PORT_NUMBER = 49152;


	/**
	 * The larges ephemeral port (see https://en.wikipedia.org/wiki/Ephemeral_port).
	 */
	int MAXIMUM_PORT_NUMBER = 65535;


	/**
	 * Error message when the connection could not be established.
	 */
	String ERROR_ACCEPTING = "error accepting";


	/**
	 * Message when a connection was accepted by the Peer.
	 */
	String ACCEPTED = "Accepted";


	/**
	 * Error message that is displayed to the user.
	 */
	String INVALID_CONNETCTION_ATTEMPT = "Invalid connetction attempt.";
}
