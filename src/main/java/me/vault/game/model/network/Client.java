package me.vault.game.model.network;


import javafx.fxml.FXMLLoader;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.ArenaDelegate;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import static me.vault.game.utility.constant.EncounterConstants.ALLIES;
import static me.vault.game.utility.constant.EncounterConstants.ENCOUNTER_ONE_ENEMIES;


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
			final ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			final ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			String oneLine;

			FXMLLoader fxmlLoader = (new FXMLLoader().load(getClass().getResource(ArenaDelegate.ARENA_FXML).openStream()));
			ArenaDelegate arenaDelegate = (ArenaDelegate) fxmlLoader.getController();

			out.writeObject(arenaDelegate.getArena());
			out.flush();

			out.close();
			in.close();
			socket.close();
		}
		catch (final IOException e)
		{
			System.out.println(e.toString());
		}
	}

}
