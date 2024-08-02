package me.vault.game.control;


import me.vault.game.model.network.Peer;
import me.vault.game.utility.interfaces.constant.CharacterConstants;
import me.vault.game.utility.interfaces.constant.NetworkConstants;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;


public class PeerController
{
	private static final PeerController INSTANCE = new PeerController();

	private static Peer peer = new Peer();

	private PeerController ()
	{
	}
	public static PeerController getInstance ()
	{
		return INSTANCE;
	}

	public Peer getPeer ()
	{
		return this.peer;
	}

	public void runPeer ()
	{
		(new Thread(peer)).start();
	}


	public int getRandomPortNumber ()
	{
		return new Random().nextInt(NetworkConstants.MINIMUM_PORT_NUMBER, NetworkConstants.MAXIMUM_PORT_NUMBER);
	}

	public void createConnection (String hostName, int portNumber) throws IOException, UnknownHostException
	{
		if ( hostName == null || portNumber == 0 ||
		     portNumber == this.getPeer().getMyPeerPortNumber() || !hostName.contains(String.valueOf(CharacterConstants.DOT)))
		{
			System.out.println(NetworkConstants.INVALID_CONNETCTION_ATTEMPT);
			throw new UnknownHostException();
		}

		this.getPeer().setForeignPeer(new Socket(hostName, portNumber));
		this.acceptIncomingConnection();

	}

	public void acceptIncomingConnection ()
	{
		try
		{
			this.getPeer().setForeignPeer(this.getPeer().getMyPeerHostSocket().accept());

		}
		catch (final IOException e)
		{
			System.out.println(NetworkConstants.ERROR_ACCEPTING);
			System.exit(0);
		}
		this.getPeer().setConnected(true);
		System.out.println(NetworkConstants.ACCEPTED);
	}
}
