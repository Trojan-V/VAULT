package me.vault.game.model.network;


import me.vault.game.utility.interfaces.constant.NetworkConstants;

import java.util.Random;


public class NetworkController
{
	public static final int SLEEP = 1000;

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
		return new Random().nextInt(NetworkConstants.MINIMUM_PORT_NUMBER, NetworkConstants.MAXIMUM_PORT_NUMBER);
	}

}
