import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** implements getRunners which populate 
 *  and return list
 * 
 *  @return			ArrayList of Runner
 */

public class Derby implements RunnersDAO{

	private static Connection connection = null;
	
	private Connection getConnection()
	{        
		  try 
		  {        
			  /**
			   * if necessary, set the home directory for Derby     
			   */    
			  String dbDirectory = "C:/DBderby/bin";        
			  System.setProperty("derby.system.home",dbDirectory);
			  /**
			   *  create and return the connection         
			   */
			  String dbUrl = "jdbc:derby:DB/MurachDB";         
			  String username = "";         
			  String password = "";         
			  connection = DriverManager.getConnection(dbUrl,username,password);
			  System.out.println("Connected");
			  return connection;    
		  }         
		  catch (SQLException e) 
		  {         for (Throwable t : e)             
			  		e.printStackTrace();        
		  			return null;     
		  } 
	}
	
	public boolean disconnect() 
	{     
		try     
		{        
		 /**
		  * On a successful shutdown, this throws         
		 * an exception  
		 */      
		 String shutdownURL = "jdbc:derby:;shutdown=true";         
		 DriverManager.getConnection(shutdownURL);  
		} 
		catch (SQLException e)   
		{        
		 if (e.getMessage().equals("Derby system shutdown."))            
		 return true;     
		}   
		return false; 
	}
	
	public ArrayList<Runner> getRunners() 
	{
		
		
		try
        {
			connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM runner");
            Runner r = null;
            ArrayList <Runner> runners = new ArrayList<>();
            System.out.println("Runner list:");
            while(rs.next())
            {
                String name = rs.getString("RunnersName");
                int speed = rs.getInt("RunnersSpeed");
                int rest = rs.getInt("RestPercentage");

                r = new Runner(name, speed, rest);
                runners.add(r);
                
              
            }
            System.out.println();

            rs.close();
            statement.close();
            disconnect();
            return runners;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

	}
	



}

