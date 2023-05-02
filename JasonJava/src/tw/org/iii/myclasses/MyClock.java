package tw.org.iii.myclasses;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel{
	private Timer timer;
	public MyClock() {
//		setText("10:20:30");
		timer = new Timer();
		timer.schedule(new MyTask(), 0, 1000);
	}
	
	private class MyTask extends TimerTask {
		private int i ; 
		@Override
		public void run() {
			setText("" + i++);
		}
	}
}
