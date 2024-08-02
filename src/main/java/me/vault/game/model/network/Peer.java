package me.vault.game.model.network;


import com.google.gson.Gson;
import me.vault.game.control.PeerController;
import me.vault.game.utility.concurrency.ThreadUtil;
import me.vault.game.utility.interfaces.constant.MiscConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//TODO: Javadoc

public class Peer implements Runnable
{
	// Own Peer information -----------------------------

	private ServerSocket myPeerHostSocket;

	private boolean isMyPeerHost;

	// Other Peer information ------------------------------

	private Socket foreignPeer;

	//---------------------

	private PrintWriter output = null;

	private BufferedReader input = null;

	private boolean connected = false;

	public Peer ()
	{
		try
		{
			this.myPeerHostSocket = new ServerSocket(PeerController.getInstance().getRandomPortNumber());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run ()
	{
		Gson gson =new Gson();

		if (isMyPeerHost)
		{
			//beginArenaMatch()
		}
		do
		{
			//game
		}while (connected);
	}

	public void sendObjectAsJSON (String objectJSON)
	{
		this.output.println(objectJSON);
		this.output.flush();
		ThreadUtil.sleepThread(MiscConstants.SLEEP_TEN);
	}

	public String readInput()
	{
		String outputString = null;
		try
		{
			outputString = this.input.readLine();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}
		return outputString;
	}

	// ------------------

	public ServerSocket getMyPeerHostSocket ()
	{
		return myPeerHostSocket;
	}

	public int getMyPeerPortNumber ()
	{
		return this.myPeerHostSocket.getLocalPort();
	}

	public boolean getIsMyPeerHost ()
	{
		return this.isMyPeerHost;
	}

	public void setIsMyPeerHost ( boolean isHost)
	{
		this.isMyPeerHost = isHost;
	}

	public boolean isConnected ()
	{
		return this.connected;
	}

	public Socket getForeignPeer ()
	{
		return this.foreignPeer;
	}

	public void setForeignPeer (Socket foreignPeer)
	{
		this.foreignPeer = foreignPeer;
	}

	public void setConnected (boolean connected)
	{
		this.connected = connected;
	}

	public String getMyPeerHostName ()
	{
		try
		{
			return this.myPeerHostSocket.getInetAddress().getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e)
		{
			throw new RuntimeException(e);
		}
	}

}
