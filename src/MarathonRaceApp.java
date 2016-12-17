import java.util.ArrayList;
import java.util.Scanner;

/**
 *  MarathoRace class, which start the race by creating threads.
 *  Also provides finishRace method.
 *  @author Shweta Mallurwar
 * 
 */

public class MarathonRaceApp {

	private static RunnersDAO runnerDAO = null;
    private static Scanner sc = null;
    private static ArrayList<Thread> threadList =new ArrayList<>();
    
	
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		boolean continueFlag=true;
		int choice;
		while(continueFlag)
		{
		   sc = new Scanner(System.in);
		   System.out.println("Welcome to Marathon Race Runner Program");
		   System.out.println("Select your data source:");
		   System.out.println("1 Derby database");
		   System.out.println("2 XML File");
		   System.out.println("3 Text File");
		   System.out.println("4 Default");
		   System.out.println("5.Exit");
		   
		   choice = Validator.getInt(sc, "Enter your choice:");
	       switch(choice)
	       {
	       case 1:
	    	   runnerDAO=DAOFactory.getRunnerDAO("derby");  
			   executeRace();
	    	   continueFlag=true;
	    	   break;
	    	   
	       case 2:
	    	   runnerDAO=DAOFactory.getRunnerDAO("xml");
	    	   executeRace();
	    	   continueFlag=true;
	    	   break;
	       case 3:
	    	   runnerDAO=DAOFactory.getRunnerDAO("txt");
	    	   executeRace();
	    	   continueFlag=true;
	    	   break;
	       case 4:
	    	   runnerDAO=DAOFactory.getRunnerDAO("default");
	    	   executeRace();
	    	   continueFlag=true;
	    	   break;
	       case 5:
	    	   continueFlag=false;
	    	   break;
	    	  
	       }
    }
		
		
}// main end
	
	private static void executeRace()
	{
		 ArrayList<Runner>  runners = runnerDAO.getRunners();
		 
		   Runner r = new Runner();
		   System.out.println("\n\nGet Set Go!!\n\n");
		   for(int i=0;i<runners.size();i++)
		   {
				r = runners.get(i);
				//System.out.println(r.getName()+" "+r.getSpeed()+" "+r.getRestPercentage());
				Thread t=new Thread(new ThreadRunner(r.getName(),r.getRestPercentage(),r.getSpeed()));
				t.setName(r.getName());
				threadList.add(t);
				t.start();
			
			}
	}
	public static synchronized void finishRace(Thread thr) 
	{
        
		System.out.println("The Race is over. The " + thr.getName() + " is the winner");
		
		for (Thread t : threadList) 
		{
			t.interrupt();
		} 
		
	
    }
     

}//classend