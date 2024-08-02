package me.vault.game.model.network;


import com.google.gson.Gson;
import me.vault.game.control.PeerController;
import me.vault.game.utility.concurrency.ThreadUtil;
import me.vault.game.utility.interfaces.constant.MiscConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * The Peer class provides the Model implementation for the network communication.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 29.07.2024
 */
public class Peer implements Runnable
{
	// Own Peer information -----------------------------


	/**
	 * The {@link ServerSocket} from this Peer.
	 */
	private final ServerSocket myPeerHostSocket;


	/**
	 * A boolean value that denotes if this Peer initializes the game.
	 */
	private boolean isMyPeerHost;

	// Other Peer information ------------------------------


	/**
	 * The socket of the Peer that should be connected to.
	 */
	private Socket foreignPeer;

	//---------------------


	/**
	 * The {@link PrintWriter} used to send information to the other Peer.
	 */
	private final PrintWriter output = null;


	/**
	 * The {@link BufferedReader} used to receive information from the other Peer.
	 */
	private final BufferedReader input = null;


	/**
	 * boolean value that denotes if the Peer is connected to another peer.
	 */
	private boolean connected = false;


	/**
	 * Constructor for the Peer class.
	 *
	 * @precondition none.
	 * @postcondition Creates a new Instance of the peer class with a new ServerSocket that is initialized with a
	 * random ephemeral port number.
	 */
	public Peer ()
	{
		try
		{
			this.myPeerHostSocket = new ServerSocket(PeerController.getInstance().getRandomPortNumber());
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}


	/**
	 * Executes the methods that are required for this Peer to connect to other Peers.
	 *
	 * @precondition none.
	 * @postcondition The methods contained within this method are executed.
	 */
	@Override
	public void run ()
	{
		final Gson gson = new Gson();

		if (this.isMyPeerHost)
		{
			//beginArenaMatch()
		}
		do
		{
			//game
		}
		while (this.connected);
	}


	/**
	 * Sends a JSON object in the form of a String via the PrintWriter output.
	 *
	 * @param objectJSON Object that has been converted to JSON
	 *
	 * @precondition The parameter is != null.
	 * @postcondition The value of the String is written to the PrintWriter.
	 */
	public void sendObjectAsJSON (final String objectJSON)
	{
		this.output.println(objectJSON);
		this.output.flush();
	}


	/**
	 * Read the input from the BufferedReader input and returns it as a String.
	 *
	 * @return Message from the BufferedReader input.
	 *
	 * @precondition none.
	 * @postcondition The message from the BufferedReader. If an error occurs, the stackTrace is printed to terminal
	 * and null is returned.
	 */
	public String readInput ()
	{
		String outputString = null;
		try
		{
			outputString = this.input.readLine();
		}
		catch (final IOException ioException)
		{
			ioException.printStackTrace();
		}
		return outputString;
	}

	// ------------------


	/**
	 * Getter-Method for the myPeerHostSocket attribute.
	 * @return the ServerSocket of this Peer.
	 *
	 * @precondition none.
	 * @postcondition returns the myPeerHostSocket attribute.
	 */
	public ServerSocket getMyPeerHostSocket ()
	{
		return this.myPeerHostSocket;
	}


	/**
	 * Getter-Method for the myPeerHostSocket attribute.
	 *
	 * @return the port number of the attribute myPeerHostSocket.
	 *
	 * @precondition none.
	 * @postcondition returns the Portnumber of the myPeerHostSocket attribute.
	 */
	public int getMyPeerPortNumber ()
	{
		return this.myPeerHostSocket.getLocalPort();
	}


	/**
	 * Getter-Method for the isMyPeerHost attribute.
	 *
	 * @return if this Peer is host.
	 *
	 * @precondition none.
	 * @postcondition returns the value of the attribute isMyPeerHost.
	 */
	public boolean getIsMyPeerHost ()
	{
		return this.isMyPeerHost;
	}


	/**
	 * Getter-Method for the foreignPeer attribute.
	 *
	 * @return the Socket associated with the foreign Peer.
	 *
	 * @precondition none.
	 * @postcondition returns the Socket associated with the foreign Peer.
	 */
	public Socket getForeignPeer ()
	{
		return this.foreignPeer;
	}


	/**
	 * Getter-Method for the Peer Socket hostName.
	 *
	 * @return the Hostname of the ServerSocket associated with this Peer.
	 *
	 * @precondition none.
	 * @postcondition returns Hostname of the myPeerHostSocket attribute.
	 */
	public String getMyPeerHostName ()
	{
		try
		{
			this.myPeerHostSocket.getInetAddress();
			return InetAddress.getLocalHost().getHostAddress();
		}
		catch (final UnknownHostException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Getter-Method for the isConnected attribute.
	 *
	 * @return if this peer is connected to another peer.
	 *
	 * @precondition none.
	 * @postcondition returns the state of the isConnected attribute.
	 */
	public boolean isConnected ()
	{
		return this.connected;
	}

	/**
	 * Setter-Method for the isMyPeerHost attribute.
	 *
	 * @param isHost denotes if this peer is the host.
	 *
	 * @precondition The parameter is true or false.
	 * @postcondition The value of the attribute isMyPeerHost is set to the value of the parameter.
	 */
	public void setIsMyPeerHost (final boolean isHost)
	{
		this.isMyPeerHost = isHost;
	}


	/**
	 * Setter-Method for the connected attribute.
	 *
	 * @param connected state of the connection
	 *
	 * @precondition The attribute is either true or false.
	 * @postcondition the value of the parameter is set as the value of the attribute.
	 */
	public void setConnected (final boolean connected)
	{
		this.connected = connected;
	}


	/**
	 * Setter-Method for the foreignPeer attribute.
	 *
	 * @param foreignPeer Socket associated with the foreign Socket.
	 *
	 * @precondition The parameter must be != null.
	 * @postcondition The parameter is set as the value of the attribute.
	 */
	public void setForeignPeer (final Socket foreignPeer)
	{
		this.foreignPeer = foreignPeer;
	}

}
