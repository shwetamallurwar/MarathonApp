


	public class DAOFactory
	{
	    /**
	     *  this method maps the ProductDAO interface
	     * @param strDatabase
	     * @return
	     */
	    /**
	     *  to the appropriate data storage mechanism
	     * @param strDatabase
	     * @return
	     */
	    public static RunnersDAO getRunnerDAO(String strDatabase)
	    {
	        RunnersDAO rDAO = null; 
	    		switch (strDatabase) {
	    		case "xml":
	    	        rDAO = new RunnerXMLFile();
	    			break;
	       		case "derby":
	    	        rDAO = new Derby();
	    			break;
	    		case "txt":
	    			 rDAO = new RunnerTextFile();
		    		 break;
	    		case "default":
	    			rDAO = new TwoRunners();
	    			break;
	    
	    		}
	        return rDAO;
	    }
	}
	

