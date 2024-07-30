package me.vault.game.model.network;


import javafx.fxml.FXMLLoader;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.view.ArenaDelegate;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import static me.vault.game.utility.constant.ArenaConstants.ARENA_FXML;


// TODO: Documentation and continuation of implementing the network stuff.
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
}
