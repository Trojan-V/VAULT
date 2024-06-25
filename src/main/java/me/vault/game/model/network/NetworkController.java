package me.vault.game.model.network;


public class NetworkController
{
	private static final int PORT_NUMBER = 13579;


	private static final String HOST_NAME = "127.0.0.1";


	public static void runServer ()
	{
		(new Thread(new Server(PORT_NUMBER))).start();

		while (!Server.isAccepted())
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (final InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
	}


	public static void runClient ()
	{
		(new Thread(new Client(HOST_NAME, PORT_NUMBER))).start();
	}
}
