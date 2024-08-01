package me.vault.game.model.network;


import com.google.gson.Gson;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaObject;
import me.vault.game.utility.concurrency.ThreadUtil;
import me.vault.game.utility.interfaces.constant.MiscConstants;
import me.vault.game.view.arena.ArenaDelegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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

	private boolean isMyPeerHost;

	// Other Peer information ------------------------------

	private Socket otherPeer;

	//---------------------

	private PrintWriter output = null;

	private BufferedReader input = null;

	private Boolean disconnect = false;

	private Boolean turnOver = false;


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

	public String getMyPeerHostName ()
	{
		return this.myPeerHostSocket.getInetAddress().getHostName();
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

		do
		{
			sendObjectAsJSON(ArenaObject.getInstance().getArena().toJSON());
			ThreadUtil.sleepThread(2000);
			ArenaObject.getInstance().setArena(gson.fromJson(readInput(), Arena.class));
			ArenaDelegate.show(ArenaObject.getInstance().getArena());
			while(!turnOver)
			{
				ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
			}
			turnOver = false;
			ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
		} while(!disconnect);

	}

	public void sendObjectAsJSON (String arenaJSON)
	{
		output.println(arenaJSON);
		output.flush();
		ThreadUtil.sleepThread(MiscConstants.TEN);
	}

	public String readInput()
	{
		String outputString = null;
		try
		{
			outputString = input.readLine();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}
		return outputString;
	}

	public void createConnection (String serverIP, int serverPort) throws IOException
	{
		otherPeer= new Socket(serverIP, serverPort);
	}
}
