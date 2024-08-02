package me.vault.game.model.network;


import com.google.gson.Gson;
import me.vault.game.control.PeerController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaObject;
import me.vault.game.utility.concurrency.ThreadUtil;
import me.vault.game.utility.interfaces.constant.CharacterConstants;
import me.vault.game.utility.interfaces.constant.MiscConstants;
import me.vault.game.utility.interfaces.constant.NetworkConstants;
import me.vault.game.view.arena.ArenaDelegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Peer implements Runnable
{
	// Messages -------------------------------------------


	// Own Peer information -----------------------------

	private ServerSocket myPeerHostSocket;

	private boolean isMyPeerHost;

	// Other Peer information ------------------------------

	private Socket otherPeer;

	//---------------------

	private PrintWriter output = null;

	private BufferedReader input = null;

	private boolean connected = false;

	private boolean turnOver = false;


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

	public Socket getOtherPeer ()
	{
		return this.otherPeer;
	}

	public void setOtherPeer (Socket otherPeer)
	{
		this.otherPeer = otherPeer;
	}

	public void setConnected (boolean connected)
	{
		this.connected = connected;
	}



	@Override
	public void run ()
	{
		Gson gson =new Gson();

		//PeerController.getInstance().acceptConnection();
		if (isMyPeerHost)
		{
			do
			{
				sendObjectAsJSON(ArenaObject.getInstance().getArena().toJSON());
				ThreadUtil.sleepThread(2000);
				ArenaObject.getInstance().setArena(gson.fromJson(readInput(), Arena.class));
				ArenaDelegate.show(ArenaObject.getInstance().getArena());
				while (!turnOver)
				{
					ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
				}
				turnOver = false;
				ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
			}
			while (!connected);
		}
		else
		{
			try
			{
				input = new BufferedReader(new InputStreamReader(otherPeer.getInputStream()));
			}
			catch (IOException ioException)
			{
				ioException.printStackTrace();
			}
			do
			{
				//TODO: write fucking method
				ArenaObject.getInstance().setArena(gson.fromJson(readInput(), Arena.class));
				ArenaDelegate.show(ArenaObject.getInstance().getArena());
				//			while(!turnOver)
				//			{
				//				ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
				//			}
				ThreadUtil.sleepThread(2000);
				sendObjectAsJSON(ArenaObject.getInstance().getArena().toJSON());
				ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
			}
			while (connected);
		}

	}

	public void sendObjectAsJSON (String objectJSON)
	{
		this.output.println(objectJSON);
		this.output.flush();
		ThreadUtil.sleepThread(MiscConstants.TEN);
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

}
