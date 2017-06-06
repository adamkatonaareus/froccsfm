package hu.guci.froccsfm.server;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	private App()
	{
		//--- Default constructor
	}
	
    public static void main( String[] args )
    {
		SparkService service = new SparkService();

		String portStr = System.getenv("PORT");
		if (portStr != null)
		{
			service.setPort(Integer.valueOf(portStr));
		}
		
		//--- Start services
		service.start();

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		
		service.stop();
		
    }
}
