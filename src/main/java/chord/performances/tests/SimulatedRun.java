package chord.performances.tests;

/**
 * Launch multiple nodes on its own process to simulate the nodes 
 * in a distributed computing environment
 * 
 * Separate processes represent different nodes (nodes represented by instances of the SimpleNode class) 
 * @author Seong-Hwan Jun (s2jun.uw@gmail.com)
 *
 */
public class SimulatedRun implements Runnable
{
	public int numNodes = 2;

	@Override
	public void run() 
	{
		// launch nodes
		for (int i = 0; i < numNodes; i++)
		{
			// create a new process for each node; 
			// each node (process) is multi-threaded to process requests between the nodes
		}
		
	}

	public static void main(String [] args)
	{
		SimulatedRun simulation = new SimulatedRun();
		simulation.run();
	}
}
