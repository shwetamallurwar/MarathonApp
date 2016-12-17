import java.util.ArrayList;

/** implements getRunners which populate 
 *  and return list
 * 
 *  @return			ArrayList of Runner
 */
public class TwoRunners implements RunnersDAO {

	@Override
	public ArrayList<Runner> getRunners() {
		// TODO Auto-generated method stub
		Runner r = null;
        ArrayList <Runner> runners = new ArrayList<>();
        
		r=new Runner("Tortoise",10,0);
		runners.add(r);
		r=new Runner("Hare",100,90);
		runners.add(r);
		return runners;
	}

}
