package me.vault.game.model.network;


import me.vault.game.utility.interfaces.constant.NetworkConstants;

import java.util.Random;


public class NetworkController
{
	private static final NetworkController INSTANCE = new NetworkController();



	private static Peer peer = new Peer();

	private Thread peerThread;

	private NetworkController ()
	{
	}
	public static NetworkController getInstance ()
	{
		return INSTANCE;
	}

	public Peer getPeer ()
	{
		return this.peer;
	}

	public Thread getPeerThread ()
	{
		return this.peerThread;
	}
	/**
	 *
	 */
	public void runPeer ()
	{
		(peerThread = new Thread(peer)).start();
	}


	public int getRandomPortNumber ()
	{
		return new Random().nextInt(NetworkConstants.MINIMUM_PORT_NUMBER, NetworkConstants.MAXIMUM_PORT_NUMBER);
	}

}
