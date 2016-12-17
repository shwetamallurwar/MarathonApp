
public class Runner {
	private String name;
	private int restPercentage;
	private int speed;
	
	public Runner()
    {
        this("",0, 0);
    }
	
	public Runner(String a,int b,int c)
	{
		this.name = a;
		
		this.speed = c;
		
		this.restPercentage = b;
	}
	
	public String getName(){
        return name;
    }
	
	public void setName(String s){
        this.name=s;
    }
	

	public void setSpeed(int sp){
        this.speed=sp;
    }
	
	public void setrestPercent(int rp){
		this.restPercentage=rp;
    }
	public int getSpeed(){
        return speed;
    }
	
	public int getRestPercentage(){
        return restPercentage;
    }
	
	@Override
	public String toString()
	{
		return "Runner: "+name;
	}
}
