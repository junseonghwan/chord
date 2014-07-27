package chord.performances.tests;

import briefj.opt.Option;
import briefj.run.Mains;

/**
 * Simulate one server many clients distributed computing environment
 * 
 * Launch the server and the clients as a separate thread -- this is not a truly simulated environment
 * as threads share the same resources such as memory but can be used for testing features of
 * Java Socket programming and program basic Chord logic
 * @author Seong-Hwan Jun (s2jun.uw@gmail.com)
 *
 */
public class SimulateSimpleServerClients implements Runnable
{
	@Option(required=true)
	public int numClients;
	@Option(required=true)
	public int portNumber;

	public void run()
	{
		Thread t = new Thread(new SimpleServer(portNumber, numClients));
		t.start();

		// execute SimpleClient and SimpleServer as separate threads
		for (int id = 0; id < numClients; id++)
		{
			t = new Thread(new SimpleClient(id, portNumber));
			t.start();
		}
		
		while (true)
		{
			
		}
	}

	public static void main(String [] args)
	{
		Mains.instrumentedRun(args, new SimulateSimpleServerClients());
	}
}
