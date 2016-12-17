
public class ThreadRunner extends Thread {

	private String runnersName;
	private int runnersSpeed;
	private int restPercentage;
	
	
	public ThreadRunner(String a,int b,int c)
	{
		this.runnersName = a;
		this.runnersSpeed = b;
		this.restPercentage = c;
	}
	
	public void run()
	{
		int distance = 0;
		while(distance < 1000 && !isInterrupted())
		{
			try
			{
				int rand = (int) (Math.random()* 100);
				if(rand > this.restPercentage)
				{
					distance+=this.runnersSpeed;
					System.out.println(this.runnersName+" : "+distance);
				}
				Thread.sleep(100);
			}
			catch(InterruptedException e){
			
				System.out.println(this.runnersName+": You beat me fair and square.");
				break;
				
			}
			
		}
		if(distance >= 1000)
		{
			System.out.println(this.runnersName+": I finished ");
			
			MarathonRaceApp.finishRace(Thread.currentThread());
		}
	}
}
