package me.vault.game.model.network;


import javafx.fxml.FXMLLoader;
import me.vault.game.model.arena.Arena;
import me.vault.game.view.ArenaDelegate;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import static me.vault.game.utility.constant.ArenaConstants.ARENA_FXML;


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
		this.serveClient(aClient);
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
