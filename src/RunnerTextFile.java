import java.util.*;

//import demoday7.Product;

//import demoday7.Product;

import java.io.*;
import java.nio.file.*;

/** implements getRunners which populate 
 *  and return list
 * 
 *  @return			ArrayList of Runner
 */
public  class RunnerTextFile implements RunnersDAO {

	 	private ArrayList<Runner> runners = null;
	    private Path runnersPath = null;
	    private File runnersFile = null;

	    private final String FIELD_SEP = "\t";

	    public RunnerTextFile()
	    {
	    	runnersPath = Paths.get("FinalTextData.txt");
	    	runnersFile = runnersPath.toFile();
	        
	    }

	@Override
	public ArrayList<Runner> getRunners() {
		
        runners = new ArrayList<>();        
        
        if (Files.exists(runnersPath))  // prevent the FileNotFoundException
        {
            try (BufferedReader in = 
                     new BufferedReader(
                     new FileReader(runnersFile)))
            {
                // read all products stored in the file
                // into the array list
                String line = in.readLine();
                while(line != null)
                {
                    String[] columns = line.split(FIELD_SEP);
                    String name = columns[0];
                    String speed = columns[1];
                    String restPercentage = columns[2];

                    Runner r = new Runner(
                    		name, Integer.parseInt(speed), Integer.parseInt(restPercentage));

                    runners.add(r);

                    line = in.readLine();                    
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return runners;            

		
	}

}
