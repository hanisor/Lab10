package Exercise4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Task for exercise 4
 *
 */

public class Task implements Runnable {
	
	private String name;
	private int totalSum = 0;
	

	/**
	 * Constructor - initialize field
	 * 
	 * @param name
	 */
	public Task(String name) {
		this.name = name;
	}


	
	/**
	 * Task: Display task name and current date
	 */
	@Override
	public void run() {
		
		// to create random number
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			
			totalSum = totalSum + random.nextInt(100);
		}
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		
		// Get current time
		LocalDateTime now = LocalDateTime.now();  
		
		// Display task and execution time
		System.out.println("\nTask " + name + " \nTotal = " + totalSum + " \nexecuted on : " + dtf.format(now));

	}
	

}
