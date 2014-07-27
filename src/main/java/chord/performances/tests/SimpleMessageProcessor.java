package chord.performances.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleMessageProcessor implements Runnable
{
	private Socket socket;
	
	public SimpleMessageProcessor(Socket socket)
	{
		this.socket = socket;
	}

	public void processMessage() throws IOException
	{
		// establish input stream reader
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// read the message
		String msg = in.readLine(); // receive the message

		// process the message -- simply echo the message to the std out
		System.out.println(msg);
	}

	@Override
	public void run()
	{
		try
		{
			processMessage();
		}
		catch (IOException ex)
		{
			
		}
	}
}
