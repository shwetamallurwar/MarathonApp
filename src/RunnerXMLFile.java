import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;



/** implements getRunners which populate 
 *  and return list
 * 
 *  @return			ArrayList of Runner
 */
public class RunnerXMLFile implements RunnersDAO {
	
	private Path runnersPath = null;
    private ArrayList<Runner> runners = null;
    private int speedInt=0;
    private int restInt=0;
    private String name="";
    public RunnerXMLFile()
    {
        runnersPath = Paths.get("FinalXMLData.xml");
        runners = this.getRunners();
    }

	@Override
	public ArrayList<Runner> getRunners() {
		
        runners = new ArrayList<>();        
       Runner r1 = null;        
        if (Files.exists(runnersPath))  // prevent the FileNotFoundException
        {
            // create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try
            {
                // create a XMLStreamReader object
                FileReader fileReader =
                    new FileReader(runnersPath.toFile());
                XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(fileReader);

                // read the products from the file
                while (reader.hasNext())
                {
                    int eventType = reader.getEventType();
                    switch (eventType)
                    {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                             
                                name = reader.getAttributeValue(0);
                                
                            }
                      
                     
                            
                            if (elementName.equals("RunnersMoveIncrement"))
                            {
                                String speedText = reader.getElementText();
                                speedInt=Integer.parseInt(speedText);
                                
                            }
                            
                            if (elementName.equals("RestPercentage"))
                            {
                                String restText = reader.getElementText();
                                restInt=Integer.parseInt(restText);
                               
                            }
                            
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                                r1=new Runner(name,speedInt,restInt);
                            	runners.add(r1);
                            }
                            break;
                        default:
                            break;
                    }
                    reader.next();
                }
            }
            catch (IOException | XMLStreamException e)
            {
                System.out.println(e);
                return null;
            }
        }

		return runners;
	}

}
