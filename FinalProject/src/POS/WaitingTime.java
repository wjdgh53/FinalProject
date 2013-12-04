package POS;

import javax.swing.JButton;

public class WaitingTime extends Thread{	
		int minute = 0;
		int hour = 9;
		//public WaitingTime(int time,JButton jb)
		public void run()
		{
			for(int i = 0; i<20; i++)
			{
				//minute++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*if(minute == 60)
				{
					hour++;
					minute = 0;
				}*/
				//jb.setText(i+"");
				System.out.println(i+"");
			}
		}
	
}
