package me.vault.game.model.network;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Peer implements Runnable
{
	// Messages -------------------------------------------
	private static final String ERROR_SERVER_SOCKET = "Error with ServerSocket";

	private static final String ERROR_ACCEPTING = "error accepting";

	private static final String CLIENT_CONNECTED = "client connected";

	private static final String ACCEPTED = "Accepted";

	private static final String ERROR_ACCEPT = "Error accept!";

	private static final String WAIT_FOR_CONNECTIONREQUEST = "Wait for Connection request";

	private static final String ERROR_SERVER_SOCKET_CONSTRUCTOR = "Error ServerSocket-Constructor!";

	// Own Peer information -----------------------------

	private ServerSocket myPeerHostSocket;

	// Other Peer information ------------------------------

	private Socket otherPeer;


	public Peer ()
	{
		try
		{
			this.myPeerHostSocket = new ServerSocket(NetworkController.getRandomPortNumber());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void createConnection (String otherPeerHostName, int otherPeerPortNumber) throws UnknownHostException
	{
		try
		{
			this.otherPeer = new Socket(otherPeerHostName, otherPeerPortNumber);
			System.out.print(CLIENT_CONNECTED);
		}
		catch (IOException e)
		{
			throw new UnknownHostException();
		}
	}

	public String getMyPeerHostName ()
	{
		return this.myPeerHostSocket.getInetAddress().getHostName();
	}

	public int getMyPeerPortNumber ()
	{
		return this.myPeerHostSocket.getLocalPort();
	}

	@Override
	public void run ()
	{
		try
		{
			otherPeer = myPeerHostSocket.accept();
		}
		catch (final IOException e)
		{
			System.out.println(ERROR_ACCEPTING);
			System.exit(0);
		}
		System.out.println(ACCEPTED);

	}
}
