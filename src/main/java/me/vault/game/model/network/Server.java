package me.vault.game.model.network;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable
{


	private static final String ERROR_SERVER_SOCKET = "Error with ServerSocket";


	private static final String ERROR_ACCEPTING = "error accepting";


	private static final String CLIENT_CONNECTED = "client connected";


	private static boolean hasClient = false;


	private int portNumber = -1;


	public Server (final int portNumber)
	{
		this.portNumber = portNumber;
	}


	public static boolean hasClient ()
	{
		return hasClient;
	}


	private static void setHasClient (final boolean bool)
	{
		hasClient = bool;
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
			System.out.print(ERROR_SERVER_SOCKET);
			return;
		}

		Socket client = null;

		try
		{
			setHasClient(true);
			client = server.accept();
		}
		catch (final IOException e)
		{
			System.out.print(ERROR_ACCEPTING);
			System.exit(0);
		}
		System.out.println(CLIENT_CONNECTED);
	}
}
