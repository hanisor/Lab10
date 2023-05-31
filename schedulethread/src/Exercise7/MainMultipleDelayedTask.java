package Exercise7;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

/* This is the application to do multiple delay task
 * 
 * 
 * 
 */
public class MainMultipleDelayedTask {

	public static void main(String [] args)
	{
		System.out.println("Implementing a scheduled multiple delay task.");
		
		// Get a pool to schedule threads
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(7);
		
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
		LocalDateTime now = LocalDateTime.now();  
		
		// Display current time to mark the execution from the main( ) 
	    System.out.println("Task scheduled to execute after 3 seconds at : " + dtf.format(now) + "\n");
	  
	    
	    // create object for field School
	    Field book1 = new Field();
	    book1.setPrimaryKey(true);
	    book1.setName("Fiction");
	    book1.setType("Book");
	    
	    Field book2 = new Field();
	    book2.setPrimaryKey(false);
	    book2.setName("Non-Fiction");
	    book2.setType("Book");
	    
	    // create object of list of field for schools
	    List<Field> books = new ArrayList<Field>();
	    books.add(book1);
	    books.add(book2);
	    
	    
	    // create object for field Lecturer
	    Field title1 = new Field();
	    title1.setPrimaryKey(false);
	    title1.setName("Legendborn");
	    title1.setType("Trilogy");
	    
	    Field title2 = new Field();
	    title2.setPrimaryKey(true);
	    title2.setName("Happy Place");
	    title2.setType("Stand-alone");
	    
	    Field title3 = new Field();
	    title3.setPrimaryKey(false);
	    title3.setName("The Atomic Habits");
	    title3.setType("Stand-alone");
	    
	    // create object of list of field for lecturers
	    List<Field> titles = new ArrayList<Field>();
	    titles.add(title1);
	    titles.add(title2);
	    titles.add(title3);
	    
	    
	    // create object for field Student
	    Field author1 = new Field();
	    author1.setPrimaryKey(true);
	    author1.setName("Tracy Deonn");
	    author1.setType("Fiction Author");
	    
	    Field author2 = new Field();
	    author2.setPrimaryKey(false);
	    author2.setName("Emily Henry");
	    author2.setType("Fiction Author");
	    
	    Field author3 = new Field();
	    author3.setPrimaryKey(false);
	    author3.setName("James Clear");
	    author3.setType("Non-Fiction Author");
	    
	    // create object of list of field for students
	    List<Field> authors = new ArrayList<Field>();
	    authors.add(author1);
	    authors.add(author2);
	    authors.add(author3);
	    
	    
	    // create object for field Subject
	    Field genre1 = new Field();
	    genre1.setPrimaryKey(true);
	    genre1.setName("YA fantasy");
	    genre1.setType("Fiction");
	    
	    Field genre2 = new Field();
	    genre2.setPrimaryKey(false);
	    genre2.setName("Romance");
	    genre2.setType("Fiction");
	    
	    Field genre3 = new Field();
	    genre3.setPrimaryKey(false);
	    genre3.setName("Facts");
	    genre3.setType("Non-Fiction");
	    
	    // create object of list of field for subjects
	    List<Field> genres = new ArrayList<Field>();
	    genres.add(genre1);
	    genres.add(genre2);
	    genres.add(genre3);
	    
	    // Execute task 3 seconds after the application starts
	    Runnable data1 = new TableTask("Book", books);
	    Runnable data2 = new TableTask("Title", titles);
	    Runnable data3 = new TableTask("Author", authors);
	    Runnable data4 = new TableTask("Subject", genres);
	    
	    // delay task1 for 8 seconds
	    ScheduledFuture<?> result1 = 
	    		scheduledExecutor.schedule(data1, 5, TimeUnit.SECONDS);

	    // delay task1 for 3 seconds
	    ScheduledFuture<?> result2 = 
	    		scheduledExecutor.schedule(data2, 3, TimeUnit.SECONDS);
	    
	    // delay task1 for 18 seconds
	    ScheduledFuture<?> result3 = 
	    		scheduledExecutor.schedule(data3, 10, TimeUnit.SECONDS);
	    
	    // delay task1 for 13 seconds
	    ScheduledFuture<?> result4 = 
	    		scheduledExecutor.schedule(data4, 13, TimeUnit.SECONDS);
	    
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