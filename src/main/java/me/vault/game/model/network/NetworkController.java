package me.vault.game.model.network;


import java.util.Random;


public class NetworkController
{

	public static final int PORT_NUMBER = 13579;


	public static final String HOST_NAME = "127.0.0.1";


	public static final int SLEEP = 1000;


	public static final int MINIMUM_PORT_NUMBER = 49152;


	public static final int MAXIMUM_PORT_NUMBER = 65536;

	public static Peer peer = new Peer();

	/**
	 *
	 */
	public static void runServer ()
	{
		(new Thread(new Server(PORT_NUMBER))).start();

		while (!Server.isAccepted())
		{
			try
			{
				Thread.sleep(SLEEP);
			}
			catch (final InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
	}


	public static void runClient (final String hostName, final int portName)
	{
		(new Thread(new Client(hostName, portName))).start();
	}

	public static int getRandomPortNumber ()
	{
		return new Random().nextInt(MINIMUM_PORT_NUMBER, MAXIMUM_PORT_NUMBER);
	}

}
