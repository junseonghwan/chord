package chord.performances.tests;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * This class represents a main thread in the process/application (TODO: should be a singleton)
 * 
 * There are two sub threads, one that listens to the user input and 
 * the second one that listens to the requests from other nodes
 * 
 * @author Seong-Hwan Jun (s2jun.uw@gmail.com)
 *
 */
public class SimpleNode implements Runnable
{
	public String serverName = "70.70.62.45";
	public int portNumber = 9001;

	@Override
	public void run()
	{
		boolean listening = true;

		try
		(
			ServerSocket serverSocket = new ServerSocket(portNumber);
		)
		{
			while (listening)
			{
				// create a new thread and start it
				Thread t = new Thread(new SimpleMessageProcessor(serverSocket.accept()));
				t.start();
			}
		} catch (UnknownHostException ex1)
		{
			
		} catch (IOException ex2)
		{
			
		}
	}

	public static void main(String [] args)
	{
	}

}
