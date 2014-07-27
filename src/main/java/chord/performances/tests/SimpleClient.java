package chord.performances.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient implements Runnable
{
	private int id;
	private int portNumber;
	
	public static String serverIp = "192.168.0.16";

	public SimpleClient(int id, int portNumber)
	{
		this.id = id;
		this.portNumber = portNumber;
	}

	public void run()
	{
		System.out.println("SimpleClient" + id + " launched.");
		try
		(
			Socket socket = new Socket(serverIp, portNumber);
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		)
		{
			writer.println("Client " + this.id);
		}
		catch (IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		System.out.println("SimpleClient" + id + " terminating.");
	}
}
