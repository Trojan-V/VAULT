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

	}
}
