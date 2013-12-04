package POS;

import javax.swing.JButton;

public class Table extends Thread {
	boolean status = false;
	int time;
	public Table(boolean status) {
		super();
		this.status = status;
	}
	public Table(){
		super();
		this.status = randomStatus();
		this.time = randomTime();
	}
	@Override
	public String toString() {
		return "Table [status=" + status + "]";
	}
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean randomStatus(){
		int check = (int)(Math.random()*2);
		if(check == 1){
			setStatus(true);
			return status;
		}
		else{
			setStatus(false);
			return status;
		}
		
	}
	public int randomTime(){
		return (int)(Math.random()*750);
	}
	public void countdown(){
		System.out.println(time);
		for(int i = 0; i<time; i++)
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
		start();
	}
	
}
