package me.vault.game.utility.concurrency;


/**
 * Provides methods for the use in the implementation of concurrency.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 02.08.2024
 */
public class ThreadUtil
{

	/**
	 * Lets the calling thread sleep for the specified amount of time.
	 *
	 * @param sleepTime time that the calling thread should sleep.
	 *
	 * @precondition none.
	 * @postcondition The calling thread sleeps (is unresponsive) for the specified amount of time.
	 */
	public static void sleepThread (final long sleepTime)
	{
		try
		{
			Thread.sleep(sleepTime);
		}
		catch (final InterruptedException interruptedException)
		{
			interruptedException.printStackTrace();
		}
	}

}
