package me.vault.game.model.network;


import com.google.gson.Gson;
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
			this.myPeerHostSocket = new ServerSocket(NetworkController.getInstance().getRandomPortNumber());
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



	@Override
	public void run ()
	{
		Gson gson =new Gson();

		acceptConnection();
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

	public void createConnection (String hostName, int portNumber) throws IOException, UnknownHostException
	{
		if ( hostName == null || portNumber == NetworkController.getInstance().getPeer().getMyPeerPortNumber()|| !hostName.contains(String.valueOf(CharacterConstants.DOT)))
		{
			System.out.println(NetworkConstants.INVALID_CONNETCTION_ATTEMPT);
			throw new UnknownHostException();
		}

		this.otherPeer = new Socket(hostName, portNumber);
		acceptConnection();

	}

	private void acceptConnection ()
	{
		try
		{
			otherPeer = myPeerHostSocket.accept();
		}
		catch (final IOException e)
		{
			System.out.println(NetworkConstants.ERROR_ACCEPTING);
			System.exit(0);
		}
		this.connected = true;
		System.out.println(NetworkConstants.ACCEPTED);
	}
}
