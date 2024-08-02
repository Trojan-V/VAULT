package me.vault.game.control;


import me.vault.game.model.network.Peer;
import me.vault.game.utility.interfaces.constant.CharacterConstants;
import me.vault.game.utility.interfaces.constant.NetworkConstants;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Controller class that handles actions relating to the Network and in particular the peer-class.
 * <br>
 * This class is implemented as a singleton, as only one controller should be active at all times.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Peer
 * @since 29.07.2024
 */
public class PeerController
{
	/**
	 * Instance of the PeerController-Class for the implementation of a singleton.
	 */
	private static final PeerController INSTANCE = new PeerController();


	/**
	 * Instance of the Peer class that is used for networking.
	 */
	 private static final Peer peer = new Peer();


	/**
	 * Constructor for the PeerController class. As this is a singleton implementation and there should only be one
	 * controller at a time this constructor is private.
	 *
	 * @precondition The constructor has to be called from within the class.
	 * @postcondition A new Instance of the PeerController class is created.
	 */
	private PeerController ()
	{
	}


	/**
	 * Returns the saved instance of the PeerController.
	 *
	 * @return PeerController instance.
	 *
	 * @precondition none.
	 * @postcondition Returns the instance of the PeerController.
	 */
	public static PeerController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Getter-Method; returns the Peer-attribute.
	 *
	 * @return The peer attribute of the PeerController
	 *
	 * @precondition none.
	 * @postcondition Retruns the Peer attribute.
	 */
	public Peer getPeer ()
	{
		return this.peer;
	}


	/**
	 * Starts a new Thread and executes the run method of the peer attribute.
	 *
	 * @precondition The peer-attribute must be != null.
	 * @postcondition The peer.run method is executed in a new thread.
	 */
	public void runPeer ()
	{
		(new Thread(peer)).start();
	}


	/**
	 * Returns a random port number in the range of the ephemeral ports (minus one).
	 * Thus, in the range from 49152 to 65534.
	 *
	 * @return portnumber in the range of the ephemeral ports.
	 *
	 * @precondition none.
	 * @postcondition a integer in the range of [49152;65534] is returned.
	 */
	public int getRandomPortNumber ()
	{
		return new Random().nextInt(NetworkConstants.MINIMUM_PORT_NUMBER, NetworkConstants.MAXIMUM_PORT_NUMBER);
	}


	/**
	 * Tries to create a connection with the provided hostName and portNumber. If they point to an open socket, a new
	 * connection is created. Otherwise a respective error is thrown.
	 *
	 * @param hostName Hostname of the foreignPeer
	 * @param portNumber Portnumber of the foreignClient.
	 * @throws IOException if an I/ O error occurs when creating the socket.
	 * @throws UnknownHostException if the IP address of the host could not be determined or if the port is 0.
	 *
	 * @precondition none.
	 * @postcondition If the hostName and portNumber combination is valid, a new connection is established. Else
	 * either an IOException or a UnknownHostException is thrown.
	 */
	public void createConnection (final String hostName, final int portNumber) throws IOException, UnknownHostException
	{
		if (hostName == null || portNumber == 0 ||
		    portNumber == this.getPeer().getMyPeerPortNumber() || !hostName.contains(String.valueOf(CharacterConstants.DOT)))
		{
			System.out.println(NetworkConstants.INVALID_CONNETCTION_ATTEMPT);
			throw new UnknownHostException();
		}

		this.getPeer().setForeignPeer(new Socket(hostName, portNumber));
		this.acceptIncomingConnection();

	}


	/**
	 * Accepts the connection request to the ServerSocket of the PeerController Peer instance.
	 *
	 * @precondition There has to be a connection request.
	 * @postcondition The connection is accepted by the ServerSocket and a corresponding message is printed to the
	 * terminal. If there was an error a message is printed to
	 * the terminal and the application is exited.
	 */
	public void acceptIncomingConnection ()
	{
		try
		{
			this.getPeer().setForeignPeer(this.getPeer().getMyPeerHostSocket().accept());

		}
		catch (final IOException e)
		{
			System.out.println(NetworkConstants.ERROR_ACCEPTING);
			System.exit(0);
		}
		this.getPeer().setConnected(true);
		System.out.println(NetworkConstants.ACCEPTED);
	}
}
