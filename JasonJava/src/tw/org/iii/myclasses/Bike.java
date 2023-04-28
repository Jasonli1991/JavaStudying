package tw.org.iii.myclasses;
import java.io.Serializable;
public class Bike extends Object implements Serializable{
	//全開放
//	public double speed;
	//僅開放此括號內
//	private double speed;
	//開放至子類別
	protected double speed;
	private String color;
	
	//物件的屬性初始化用建構式處理
	public Bike() {
		System.out.println("Bike()");
		color = "yellow";
	}
	public String getColor() {
		return color;
	}
	
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.7;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bike:" + speed;
	}
	
}
