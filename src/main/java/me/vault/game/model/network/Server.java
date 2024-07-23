package me.vault.game.model.network;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import me.vault.game.GameApplication;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.ArenaDelegate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static me.vault.game.utility.constant.EncounterConstants.ALLIES;
import static me.vault.game.utility.constant.EncounterConstants.ENCOUNTER_ONE_ENEMIES;


public class Server implements Runnable
{


	private static final String ERROR_SERVER_SOCKET = StringConstants.ERROR_SERVER_SOCKET;


	private static final String ERROR_ACCEPTING = StringConstants.ERROR_ACCEPTING;


	private static final String CLIENT_CONNECTED = StringConstants.CLIENT_CONNECTED;


	public static final String ACCEPTED = "Accepted";


	public static final String ERROR_ACCEPT = "Error accept!";


	public static final String WAIT_FOR_CONNECTIONREQUEST = "Wait for Connectionrequest";


	public static final String ERROR_SERVER_SOCKET_CONSTRUCTOR = "Error ServerSocket-Constructor!";


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
			final ObjectInputStream in =
				new ObjectInputStream(aClient.getInputStream());
			final ObjectOutputStream out = new ObjectOutputStream(aClient.getOutputStream());

			FXMLLoader fxmlLoader = (new FXMLLoader().load(getClass().getResource(ArenaDelegate.ARENA_FXML).openStream()));
			ArenaDelegate arenaDelegate = (ArenaDelegate) fxmlLoader.getController();

			arenaDelegate.setArena((Arena) in.readObject());

			in.close();
			out.close();
			aClient.close();
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	public Object getMessage () throws IOException, ClassNotFoundException
	{
		return in.readObject();
	}

}
