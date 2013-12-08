package POS;

import javax.swing.JButton;

//import Gui.SimulPanel;

public class ThreadDemo extends Thread 
{
	int timer;
	JButton jbutton;
	String seatName;
	int minute;
	int second;
	public ThreadDemo(int time, JButton jb, String seat) {
		super() ;
		timer = time;
		jbutton = jb;
		seatName = seat;
		minute = timer/60;
		second = timer%60;
	} //
	public void run()
	{
		//System.out.println(timer);
		for(int i = 0; i<timer; i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(second == 0)
			{
				minute--;
				second =59;
			}else{
			second--;
			}
			jbutton.setText(minute+" : "+second);
			
			//System.out.println(i+"");
			
		}
		jbutton.setText(seatName);
		jbutton.setEnabled(true);
	}
	

}