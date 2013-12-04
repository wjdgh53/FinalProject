package Gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import POS.Table;




/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SimulPanel extends JPanel implements ActionListener  {
	private JLabel timeLabel;
	private JButton startButton;
	private JButton seatButton1;
	private JButton seatButton2;
	private JButton seatButton3;
	int hour = 9;
	int minute = 0;
	int totalTime;




	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 * @throws InterruptedException 
	 */

	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public SimulPanel()  {
		super();
		initGUI();
	}
	private void initGUI(){

		try {
			setPreferredSize(new Dimension(1000, 800));
			this.setLayout(null);			
			{
				timeLabel = new JLabel();
				this.add(timeLabel);
				timeLabel.setBounds(819, 12, 159, 89);
				timeLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
			}
			{
				startButton = new JButton();
				this.add(startButton);
				startButton.setText("Start");
				startButton.setBounds(786, 672, 157, 68);
				startButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,24));
				startButton.addActionListener(this);
			}
			{
				seatButton1 = new JButton();
				this.add(seatButton1);
				seatButton1.setText("Seat 1");
				seatButton1.setBounds(95, 94, 145, 128);
				seatButton1.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton1.addActionListener(this);
				
				
			}
			{
				seatButton2 = new JButton();
				this.add(seatButton2);
				seatButton2.setText("Seat 2");
				seatButton2.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton2.setBounds(95, 222, 145, 128);
				seatButton2.addActionListener(this);
				/*Table t2 = new Table();
				if(!t2.isStatus())
				{
					seatButton2.setEnabled(false);
					//wt.run(t2.getTime(),seatButton2);
				}		*/		
			}
			{
				seatButton3 = new JButton();
				this.add(seatButton3);
				seatButton3.setText("Seat 3");
				seatButton3.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton3.setBounds(95, 349, 145, 128);
				seatButton3.addActionListener(this);
				Table t3 = new Table();
				if(!t3.isStatus())
				{
					seatButton3.setEnabled(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("Start")){
			ThreadDemo123 th1 = new ThreadDemo123();			
			th1.start();
			Table t1 = new Table();
			Table t2 = new Table();
			
			if(!t1.isStatus())
			{									
				seatButton1.setEnabled(false);	
				Thread12 th2 = new Thread12(t1.getTime());		
				//th1.run(t1.getTime(),seatButton1);
				//th1.start();
				//WaitingTime wt1 = new WaitingTime();
				//wt1.start();
				//t1.countdown();
				//jButton1.setVisible(false);
			}
			if(!t2.isStatus())
			{									
				seatButton2.setEnabled(false);	
				/*ThreadDemo123 th1 = new ThreadDemo123();		
				th1.run(t1.getTime(),seatButton1);
				th1.start();*/
				//jButton1.setVisible(false);
			}
			}			
			startButton.setVisible(false);
		
	}
	public class Thread12 extends Thread
	{
		public Thread12(int time){
			for(int i = 0; i < time; i++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				seatButton1.setText(i+"");

			}

		}
	}
	public class ThreadDemo123 extends Thread 
	{
		int minute = 0;
		int hour = 9;

		public void run()
		{
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
				timeLabel.setText(hour+ " : "+minute);

			}
		}

	}

}
