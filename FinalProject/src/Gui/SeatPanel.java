package Gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

import POS.Table;
import POS.ThreadDemo;
import POS.WaitingTime;


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
public class SeatPanel  extends JPanel implements ActionListener {
	private JButton seatButton1;
	private JButton seatButton2;
	private JButton seatButton3;
	private JButton seatButton4;
	private JButton seatButton5;
	private JButton seatButton6;
	private JButton seatButton7;
	private JButton seatButton8;	
	private JButton seatButton9;
	private JButton seatButton10;
	private JButton seatButton11;
	private JButton seatButton12;
	private static String seatChoose;
	//WaitingTime wt = new WaitingTime();

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
		
	public SeatPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(1000, 800));
			this.setLayout(null);		
			{
				seatButton1 = new JButton();
				this.add(seatButton1);
				seatButton1.setText("Seat 1");
				seatButton1.setBounds(95, 94, 145, 128);
				seatButton1.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton1.addActionListener(this);
				Table t1 = new Table();				
				if(!t1.isStatus())
				{									
					seatButton1.setEnabled(false);	
					new ThreadDemo(t1.getTime(),seatButton1,"Seat 1").start();					
				}
			}
			{
				seatButton2 = new JButton();
				this.add(seatButton2);
				seatButton2.setText("Seat 2");
				seatButton2.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton2.setBounds(95, 222, 145, 128);
				seatButton2.addActionListener(this);
				Table t2 = new Table();
				if(!t2.isStatus())
				{									
					seatButton2.setEnabled(false);	
					new ThreadDemo(t2.getTime(),seatButton2,"Seat 2").start();					
				}			
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
					new ThreadDemo(t3.getTime(),seatButton3,"Seat 3").start();					
				}
			}
			{
				seatButton4 = new JButton();
				this.add(seatButton4);
				seatButton4.setText("Seat 4");
				seatButton4.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton4.setBounds(95, 477, 145, 128);
				seatButton4.addActionListener(this);
				Table t4 = new Table();
				if(!t4.isStatus())
				{									
					seatButton4.setEnabled(false);	
					new ThreadDemo(t4.getTime(),seatButton4,"Seat 4").start();					
				}
			}
			{
				seatButton5 = new JButton();
				this.add(seatButton5);
				seatButton5.setText("Seat 5");
				seatButton5.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton5.setBounds(749, 67, 145, 128);
				seatButton5.addActionListener(this);
				Table t5 = new Table();
				if(!t5.isStatus())
				{									
					seatButton5.setEnabled(false);	
					new ThreadDemo(t5.getTime(),seatButton5,"Seat 5").start();					
				}
			}
			{
				seatButton6 = new JButton();
				this.add(seatButton6);
				seatButton6.setText("Seat 6");
				seatButton6.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton6.setBounds(749, 195, 145, 128);
				seatButton6.addActionListener(this);
				Table t6 = new Table();
				if(!t6.isStatus())
				{									
					seatButton6.setEnabled(false);	
					new ThreadDemo(t6.getTime(),seatButton6,"Seat 6").start();					
				}
			}
			{
				seatButton7 = new JButton();
				this.add(seatButton7);
				seatButton7.setText("Seat 7");
				seatButton7.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton7.setBounds(749, 323, 145, 128);
				seatButton7.addActionListener(this);
				Table t7 = new Table();
				if(!t7.isStatus())
				{									
					seatButton7.setEnabled(false);	
					new ThreadDemo(t7.getTime(),seatButton7,"Seat 7").start();					
				}
			}
			{
				seatButton8 = new JButton();
				this.add(seatButton8);
				seatButton8.setText("Seat 8");
				seatButton8.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton8.setBounds(749, 451, 145, 128);
				seatButton8.addActionListener(this);
				Table t8 = new Table();
				if(!t8.isStatus())
				{									
					seatButton8.setEnabled(false);	
					new ThreadDemo(t8.getTime(),seatButton8,"Seat 8").start();					
				}
			}
			{
				seatButton9 = new JButton();
				this.add(seatButton9);
				seatButton9.setText("Seat 9");
				seatButton9.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton9.setBounds(249, 650, 145, 128);
				seatButton9.addActionListener(this);
				Table t9 = new Table();
				if(!t9.isStatus())
				{									
					seatButton9.setEnabled(false);	
					new ThreadDemo(t9.getTime(),seatButton9,"Seat 9").start();					
				}
			}
			{
				seatButton10 = new JButton();
				this.add(seatButton10);
				seatButton10.setText("Seat 10");
				seatButton10.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton10.setBounds(394, 650, 145, 128);
				seatButton10.addActionListener(this);
				Table t10 = new Table();
				if(!t10.isStatus())
				{									
					seatButton10.setEnabled(false);	
					new ThreadDemo(t10.getTime(),seatButton10,"Seat 10").start();					
				}
			}
			{
				seatButton11 = new JButton();
				this.add(seatButton11);
				seatButton11.setText("Seat 11");
				seatButton11.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton11.setBounds(539, 650, 145, 128);
				seatButton11.addActionListener(this);
				Table t11 = new Table();
				if(!t11.isStatus())
				{									
					seatButton11.setEnabled(false);	
					new ThreadDemo(t11.getTime(),seatButton11,"Seat 11").start();					
				}
			}
			{
				seatButton12 = new JButton();
				this.add(seatButton12);
				seatButton12.setText("Seat 12");
				seatButton12.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				seatButton12.setBounds(684, 650, 145, 128);
				seatButton12.addActionListener(this);
				Table t12 = new Table();
				if(!t12.isStatus())
				{									
					seatButton12.setEnabled(false);	
					new ThreadDemo(t12.getTime(),seatButton12,"Seat 12").start();					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if (event.getActionCommand().equals("Seat 1")){	
			setSeatChoose("Seat 1");
			MainFrame.userpanel();			
		}
		if (event.getActionCommand().equals("Seat 2")){	
			setSeatChoose("Seat 2");
			MainFrame.userpanel();	
			}
		if (event.getActionCommand().equals("Seat 3")){	
			setSeatChoose("Seat 3");
			MainFrame.userpanel();			
		}
		if (event.getActionCommand().equals("Seat 4")){	
			setSeatChoose("Seat 4");
			MainFrame.userpanel();				
		}
		if (event.getActionCommand().equals("Seat 5")){	
			setSeatChoose("Seat 5");
			MainFrame.userpanel();			
		}
		if (event.getActionCommand().equals("Seat 6")){	
			setSeatChoose("Seat 6");
			MainFrame.userpanel();			
		}
		if (event.getActionCommand().equals("Seat 7")){	
			setSeatChoose("Seat 7");
			MainFrame.userpanel();				
		}
		if (event.getActionCommand().equals("Seat 8")){	
			setSeatChoose("Seat 8");
			MainFrame.userpanel();				
		}
		if (event.getActionCommand().equals("Seat 9")){	
			setSeatChoose("Seat 9");
			MainFrame.userpanel();				
		}
		if (event.getActionCommand().equals("Seat 10")){	
			setSeatChoose("Seat 10");
			MainFrame.userpanel();		
		}
		if (event.getActionCommand().equals("Seat 11")){	
			setSeatChoose("Seat 11");
			MainFrame.userpanel();				
		}
		if (event.getActionCommand().equals("Seat 12")){	
			setSeatChoose("Seat 12");
			MainFrame.userpanel();				
		}
		
	}

	public static String getSeatChoose() {
		return seatChoose;
	}

	public void setSeatChoose(String seatChoose) {
		this.seatChoose = seatChoose;
	}
	
}
