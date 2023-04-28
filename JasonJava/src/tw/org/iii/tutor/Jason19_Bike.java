package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Jason19_Bike {

	public static void main(String[] args) {
		Bike bike = new Bike();
		System.out.println(bike.getColor());
		System.out.println(bike.getSpeed());
		
		bike.upSpeed(); 
		System.out.println(bike.getSpeed());
		while (bike.getSpeed() <= 7) {
	        bike.upSpeed();
	    }
		System.out.println(bike.getSpeed());
		
	}

}
