package me.vault.game.model.network;


import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaObject;
import me.vault.game.utility.concurrency.ThreadUtil;
import me.vault.game.utility.interfaces.constant.MiscConstants;
import me.vault.game.view.arena.ArenaDelegate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import static me.vault.game.utility.interfaces.constant.ArenaConstants.ARENA_FXML;


public class Server implements Runnable
{

	private static final String ACCEPTED = "Accepted";

	private static final String ERROR_ACCEPT = "Error accept!";

	private static final String WAIT_FOR_CONNECTIONREQUEST = "Wait for Connection request";

	private static final String ERROR_SERVER_SOCKET_CONSTRUCTOR = "Error ServerSocket-Constructor!";

	private static boolean isAccepted = false;

	private ObjectInputStream in;

	private ObjectOutputStream out;


	private int portNumber = -1;

	private Socket socket = null;

	private PrintWriter output = null;

	private BufferedReader input = null;

	private Boolean disconnect = false;

	private Boolean turnOver = false;


	public Server (final int portNumber)
	{
		this.portNumber = portNumber;
	}


	public static boolean isAccepted ()
	{
		return isAccepted;
	}


	private String createDoubleEcho (final String line)
	{
		final StringBuffer answer = new StringBuffer();

		for (int i = 0; i < line.length(); i++)
		{
			answer.append(line.charAt(i));
			answer.append(line.charAt(i));
		}
		System.out.println(answer);
		return new String(answer);
	}


	@Override
	public void run ()
	{
		ServerSocket server = null;
		Gson gson = new Gson();

		try
		{
			server = new ServerSocket(this.portNumber);
		}
		catch (final IOException e)
		{
			System.out.print(ERROR_SERVER_SOCKET_CONSTRUCTOR);
			return;
		}
		System.out.println(WAIT_FOR_CONNECTIONREQUEST);
		Socket aClient = null;

		try
		{
			isAccepted = true;
			aClient = server.accept();
		}
		catch (final IOException e)
		{
			System.out.println(ERROR_ACCEPT);
			System.exit(0);
		}
		System.out.println(ACCEPTED);

		do
		{
			sendArena(ArenaObject.getInstance().getArena().toJSON());
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


	private void serveClient (final Socket aClient)
	{
		try
		{
			final ObjectInputStream objectInputStream = new ObjectInputStream(aClient.getInputStream());
			final ObjectOutputStream objectOutputStream = new ObjectOutputStream(aClient.getOutputStream());

			final FXMLLoader fxmlLoader = (new FXMLLoader().load(Objects.requireNonNull(this.getClass()
				.getResource(ARENA_FXML)).openStream()));
			final ArenaDelegate arenaDelegate = fxmlLoader.getController();

			arenaDelegate.setArena((Arena) objectInputStream.readObject());

			objectInputStream.close();
			objectOutputStream.close();
			aClient.close();
		}
		catch (final IOException | ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}


	public Object getMessage () throws IOException, ClassNotFoundException
	{
		return this.in.readObject();
	}

}
