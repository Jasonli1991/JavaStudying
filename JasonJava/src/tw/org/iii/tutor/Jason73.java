package tw.org.iii.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Jason73 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Jason731 task = new Jason731();
		timer.schedule(task, 3*1000);
		timer.schedule(new Jason732(timer), 10*1000);
		timer.schedule(new Jason733(), 0, 1000);
		System.out.println("main");
	}

}
class Jason731 extends TimerTask {
	@Override
	public void run() {
		System.out.println("OK");
	}
}
class Jason732 extends TimerTask {
	private Timer timer;
	Jason732(Timer timer) {
		this.timer = timer;
	}
	
	@Override
	public void run() {
		timer.cancel();
		//清空
		timer.purge();
		timer = null;
	}
}
class Jason733 extends TimerTask {
	private int i ;
	@Override
	public void run() {
		System.out.println(i++);
	}
}