package me.vault.game.utility.concurrency;


public class ThreadUtil
{

	public static void sleepThread(long sleepTime)
	{
		try
		{
			Thread.sleep(sleepTime);
		}
		catch (InterruptedException interruptedException)
		{
			interruptedException.printStackTrace();
		}
	}
}
