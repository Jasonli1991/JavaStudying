package tw.org.iii.myclasses;

public class Scooter extends Bike {
	private int gear;
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * gear * 1.2;
	}
	
	public int changeGear(int newgear) {
		if (newgear >= 0 && newgear <= 4) {
			gear = newgear;
		}
		return gear;
	}
}
