package me.vault.game.model.network;


import java.util.Random;


public class NetworkController
{
	public static final int SLEEP = 1000;


	public static final int MINIMUM_PORT_NUMBER = 49152;


	public static final int MAXIMUM_PORT_NUMBER = 65536;

	public static Peer peer = new Peer();

	/**
	 *
	 */
	public static void runPeer ()
	{
		(new Thread(peer)).start();
	}

	public static int getRandomPortNumber ()
	{
		return new Random().nextInt(MINIMUM_PORT_NUMBER, MAXIMUM_PORT_NUMBER);
	}

}
