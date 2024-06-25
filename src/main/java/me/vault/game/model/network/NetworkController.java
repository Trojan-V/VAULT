package me.vault.game.model.network;


/**
 *
 */
public class NetworkController
{

	public static final int PORT_NUMBER = 13579;


	public static final String HOST_NAME = "127.0.0.1";


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
				Thread.sleep(1000);
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

}
