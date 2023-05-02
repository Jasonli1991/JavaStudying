package tw.org.iii.myclasses;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

//public class MyClock extends JLabel{
//	private Timer timer;
//	public MyClock() {
//		timer = new Timer();
//		timer.schedule(new MyTask(), 0, 1000);
//	}
//	
//	private class MyTask extends TimerTask {
//		@Override
//		public void run() {
//			 Date now = new Date();
//		     DateFormat df = new SimpleDateFormat("HH:mm:ss");
//		     String time = df.format(now);
//		     setText(time);			
//		}
//	}
//}

public class MyClock extends JLabel {
    private Timer timer;

    public MyClock() {
        timer = new Timer();
        timer.schedule(new MyTask(), 0, 1000);
    }

    private class MyTask extends TimerTask {
//    	private int i;
    	
        @Override
        public void run() {
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("EEEE, MM月dd日, yyyy年 HH:mm:ss", Locale.ENGLISH));
            setText(time);
//        	DateFormat df = new SimpleDateFormat("EEEE, MM月dd日, yyyy年 HH:mm:ss", Locale.ENGLISH);
//            setText(df.format(new Date()));	
            
        }
    }
}
