package POS;

public class tT extends Thread 
{
	int timer;		
	int minute;
	int second;
	public tT(int time) {
		super() ;
		timer = time;	
		minute = timer/60;
		second = timer%60;
	} 
	public void run()
	{

		//System.out.println(timer);
		for(int i = 0; i<timer; i++)
		{
			try {
				Thread.sleep(500);
				if(second == 0)
				{
					minute--;
					second =59;
				}else{
				second--;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
				
			//System.out.println(i+"");
			System.out.println(minute+":"+second);

		}

	}
		
	
}
