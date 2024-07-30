package me.vault.game.model.network;

import me.vault.game.utility.constant.CharacterConstants;
import me.vault.game.utility.constant.StringConstants;


import java.io.IOException;


public class Client implements Runnable
{

	private String hostName = null;


	private int portNumber = -1;


	public Client (final String hostName, final int portNumber)
	{
		this.hostName = hostName;
		this.portNumber = portNumber;

	}


	@Override
	public void run ()
	{
		this.readAndSend(this.openSocket());
	}


	private java.net.Socket openSocket ()
	{
		try
		{
			return new java.net.Socket(this.hostName, this.portNumber);
		}
		catch (final IOException e)
		{
			System.out.print(StringConstants.EXCEPTION_SOCKET_CONSTRUCTOR_CLIENT);
			return null;
		}
	}


	private void readAndSend (final java.net.Socket socket)
	{
		if (socket == null)
		{
			return;
		}

		try
		{
			java.io.BufferedReader in =
				new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));

			java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);

			java.io.BufferedReader keyboard = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

			System.out.println(StringConstants.ENTER_TEXT);

			String inputLine;

			while (true)
			{
				inputLine = keyboard.readLine();

				if (inputLine.length() > 0)
				{
					out.println(inputLine);
					System.out.println(StringConstants.ECHO + CharacterConstants.WHITESPACE + inputLine);
				}
				else
				{
					break;
				}
			}
			out.close();
			in.close();
			keyboard.close();
			socket.close();
		}
		catch (final IOException e)
		{
			System.out.println(e.toString());
		}
	}
}
