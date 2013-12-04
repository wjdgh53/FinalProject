package POS;

public class Demo extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int minute = 0;
		int hour = 9;

		for(int i = 0; i<720; i++)
		{
			minute++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(minute == 60)
			{
				hour++;
				minute = 0;
			}
			System.out.println(i+"");

		}
	}

}
