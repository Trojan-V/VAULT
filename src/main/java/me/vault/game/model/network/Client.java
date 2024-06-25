package me.vault.game.model.network;


import me.vault.game.utility.constant.StringConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


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


	private Socket openSocket ()
	{
		try
		{
			return new Socket(this.hostName, this.portNumber);
		}
		catch (final UnknownHostException e)
		{
			System.out.print(StringConstants.ERROR_ACCEPTING);
			return null;
		}
		catch (final IOException e)
		{
			System.out.print(StringConstants.ERROR_ACCEPTING);
			return null;
		}
	}


	private void readAndSend (final Socket socket)
	{
		if (socket == null)
		{return;}

		try
		{
			final BufferedReader in =
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
			final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			final BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Bitte Text eingeben (Ende mit leerer Zeile)");
			String oneLine;

			while (true)
			{
				oneLine = keyboard.readLine();
				if (oneLine.length() > 0)
				{
					out.println(oneLine);
					System.out.println("Echo: " + in.readLine());
				}
				else
				{break;}
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
