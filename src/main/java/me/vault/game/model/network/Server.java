package me.vault.game.model.network;


import me.vault.game.utility.constant.StringConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable
{


	private static final String ERROR_SERVER_SOCKET = StringConstants.ERROR_SERVER_SOCKET;


	private static final String ERROR_ACCEPTING = StringConstants.ERROR_ACCEPTING;


	private static final String CLIENT_CONNECTED = StringConstants.CLIENT_CONNECTED;


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
		ServerSocket server = null;

		try
		{
			server = new ServerSocket(this.portNumber);
		}
		catch (final IOException e)
		{
			System.out.print("Error ServerSocket-Constructor!");
			return;
		}
		System.out.println("Wait for Connectionrequest");
		Socket aClient = null;

		try
		{
			isAccepted = true;
			aClient = server.accept();
		}
		catch (final IOException e)
		{
			System.out.println("Error accept!");
			System.exit(0);
		}
		System.out.println("Client connected.");
		this.serveClient(aClient);
	}


	private void serveClient (final Socket aClient)
	{
		try
		{
			final BufferedReader in =
				new BufferedReader(new InputStreamReader(aClient.getInputStream()));
			final PrintWriter out = new PrintWriter(aClient.getOutputStream(), true);
			String line;

			while ((line = in.readLine()) != null)
			{
				if (line.length() > 0)
				{
					out.println(this.createDoubleEcho(line));
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
