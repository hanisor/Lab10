package Exercise4;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * This class compute a summation of 100 random number
 * 
 * 
 */
public class SummationOfRandomNumber {

	public static void main(String[] args) {
		
		System.out.println("Summation of 100 random number");
		
		// Get a pool to schedule threads
		ScheduledExecutorService scheduledExecutor = 
				Executors.newScheduledThreadPool(1);
		
		
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		LocalDateTime now = LocalDateTime.now();  
		
		// Display current time to mark the execution from the main( ) 
	    System.out.println("Task scheduled to execute after 5 seconds at : " 
	    		+ dtf.format(now));
	    
	    // Execute task 5 seconds after the application starts
	    Runnable task = new Task(" Exercise 4 ");
	    ScheduledFuture<?> result = 
	    		scheduledExecutor.schedule(task, 5, TimeUnit.SECONDS);
	    
	    System.out.println("Shutdown and await requested at : " 
	    		+ dtf.format(now));
	    
	    shutdownAndAwaitTermination(scheduledExecutor);

	}
	
	/**
	 * This method disable more from being submitted.
	 * 
	 * @param executorService
	 */
	static void shutdownAndAwaitTermination(ExecutorService executorService) {
		
		executorService.shutdown();
		
		try {
			if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException ie) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
	
}