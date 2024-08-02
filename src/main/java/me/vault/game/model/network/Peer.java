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

//TODO: Javadoc

public class Peer implements Runnable
{
	// Own Peer information -----------------------------

	private final ServerSocket myPeerHostSocket;

	private boolean isMyPeerHost;

	// Other Peer information ------------------------------

	private Socket foreignPeer;

	//---------------------

	private final PrintWriter output = null;

	private final BufferedReader input = null;

	private boolean connected = false;


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


	public void sendObjectAsJSON (final String objectJSON)
	{
		this.output.println(objectJSON);
		this.output.flush();
		ThreadUtil.sleepThread(MiscConstants.SLEEP_TEN);
	}


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


	public ServerSocket getMyPeerHostSocket ()
	{
		return this.myPeerHostSocket;
	}


	public int getMyPeerPortNumber ()
	{
		return this.myPeerHostSocket.getLocalPort();
	}


	public boolean getIsMyPeerHost ()
	{
		return this.isMyPeerHost;
	}


	public void setIsMyPeerHost (final boolean isHost)
	{
		this.isMyPeerHost = isHost;
	}


	public boolean isConnected ()
	{
		return this.connected;
	}


	public void setConnected (final boolean connected)
	{
		this.connected = connected;
	}


	public Socket getForeignPeer ()
	{
		return this.foreignPeer;
	}


	public void setForeignPeer (final Socket foreignPeer)
	{
		this.foreignPeer = foreignPeer;
	}


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

}
