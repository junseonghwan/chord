package chord.performances.tests;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer implements Runnable
{
	private int portNumber;
	private int numClients;
	
	public SimpleServer(int portNumber, int numClients)
	{
		this.portNumber = portNumber;
		this.numClients = numClients;
	}
	
	public void run()
	{
		System.out.println("[SimpleServer]: launched.");

		int clientRequests = 0;
		
		try
		(
			ServerSocket serverSocket = new ServerSocket(portNumber);
		)
		{
			while (clientRequests < numClients)
			{
				System.out.println("[SimpleServer]: waiting for client requests.");

				Socket socket = serverSocket.accept();
				
				System.out.println("[SimpleServer]: received a client request.");

				Thread t = new Thread(new SimpleMessageProcessor(socket));
				t.start();
				clientRequests += 1;
			}
		}
		catch (IOException ex1)
		{
			System.out.println("[SimpleServer]:" + ex1.getMessage());
		}

		System.out.println("[SimpleServer]: terminating.");
	}
}
