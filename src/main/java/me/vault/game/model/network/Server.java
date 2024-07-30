package me.vault.game.model.network;


import javafx.fxml.FXMLLoader;
import me.vault.game.model.arena.Arena;
import me.vault.game.utility.constant.StringConstants;
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

	private static final String ERROR_SERVER_SOCKET = StringConstants.ERROR_SERVER_SOCKET;

	private static final String ERROR_ACCEPTING = StringConstants.EXCEPTION_SOCKET_CONSTRUCTOR_CLIENT;

	private static final String CLIENT_CONNECTED = StringConstants.CLIENT_CONNECTED;

	private ObjectInputStream in;

	private ObjectOutputStream out;

	//--------------------------------------------
	private static boolean isAccepted = false;
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
		return new String(answer);
	}


	@Override
	public void run ()
	{
		java.net.ServerSocket server = null;

		try
		{
			server = new java.net.ServerSocket(this.portNumber);
		}
		catch (final java.io.IOException e)
		{
			System.out.print(ERROR_SERVER_SOCKET_CONSTRUCTOR);
			return;
		}
		System.out.println(WAIT_FOR_CONNECTIONREQUEST);
		java.net.Socket aClient = null;

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
			java.io.BufferedReader in =
				new java.io.BufferedReader(new java.io.InputStreamReader(aClient.getInputStream()));

			java.io.PrintWriter out = new java.io.PrintWriter(aClient.getOutputStream(), true);

			String line;

			while ( (line = in.readLine()) != null)
			{
				if (line.length() > 0)
				{
					out.println(createDoubleEcho(line));
				}
			}

			in.close();
			out.close();
			aClient.close();
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
