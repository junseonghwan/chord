package chord.performances.tests;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;

public class TestCommonsExec 
{

	public static void main(String [] args) throws IOException
	{
		CommandLine cmdLine = new CommandLine("ls");
		cmdLine.addArgument("-l");
		
		Executor executor = new DefaultExecutor();
		executor.execute(cmdLine);
	}
}
