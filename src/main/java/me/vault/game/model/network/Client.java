package me.vault.game.model.network;


import javafx.fxml.FXMLLoader;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaObject;
import me.vault.game.utility.concurrency.ThreadUtil;
import me.vault.game.utility.interfaces.constant.LoggingConstants;
import me.vault.game.utility.interfaces.constant.MiscConstants;
import me.vault.game.view.arena.ArenaDelegate;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import static me.vault.game.utility.interfaces.constant.ArenaConstants.ARENA_FXML;


// TODO: Documentation and continuation of implementing the network stuff.


public class Client implements Runnable
{

	private static final String ERROR_SERVER_SOCKET = "Error with ServerSocket";

	private static final String ERROR_ACCEPTING = "error accepting";

	private static final String CLIENT_CONNECTED = "client connected";


	private int portNumber = -1;

	private Socket socket = null;

	private String hostName = socket.getLocalAddress().getHostName();

	private PrintWriter output = null;

	private BufferedReader input = null;

	private Boolean disconnect = false;

	private Boolean turnOver = false;


	public Client (final String hostName, final int portNumber)
	{
		this.hostName = hostName;
		this.portNumber = portNumber;

	}


	@Override
	public void run ()
	{
		Gson gson = new Gson();
		socket = createConnection(hostName, portNumber);
		try
		{
			output = new PrintWriter(socket.getOutputStream());
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
			turnOver = false;
			sendArena(ArenaObject.getInstance().getArena().toJSON());
			ThreadUtil.sleepThread(MiscConstants.TWO_HUNDRED);
		}
		while (!disconnect);
	}


	private Socket openSocket ()
	{
		try
		{
			return new Socket(this.hostName, this.portNumber);
		}
		catch (final UnknownHostException e)
		{
			System.out.print(ERROR_ACCEPTING);
			return null;
		}
		catch (final IOException e)
		{
			System.out.print(ERROR_ACCEPTING);
			return null;
		}
	}


	private void readAndSend (final Socket socket)
	{
		if (socket == null)
		{return;}

		try
		{
			final ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			final ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			String oneLine;

			final FXMLLoader fxmlLoader = (new FXMLLoader().load(this.getClass().getResource(ARENA_FXML).openStream()));
			final ArenaDelegate arenaDelegate = fxmlLoader.getController();

			objectOutputStream.writeObject(arenaDelegate.getArena());
			objectOutputStream.flush();

			objectOutputStream.close();
			objectInputStream.close();
			socket.close();
		}
		catch (final IOException e)
		{
			System.out.println(e.toString());
		}
	}

	public void sendArena(String arenaJSON)
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

	private Socket createConnection(String serverIP, int serverPort)
	{
		Socket newSocket = null;
		try
		{
			newSocket = new Socket(serverIP, serverPort);
		}
		catch (UnknownHostException unknownHostException)
		{
			unknownHostException.printStackTrace();
		}
		finally
		{
			return newSocket;
		}
	}

	public void setTurnOver(Boolean turnOver)
	{
		this.turnOver = turnOver;
	}
}
