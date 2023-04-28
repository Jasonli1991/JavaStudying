package tw.org.iii.tutor;

public class Jason43_ExceptionBird {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setleg(3);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Error");
		}
	}

}

class Bird {
	private int leg;
	void setleg(int leg) throws Exception{
		if (leg >= 0 && leg <= 2) {
			this.leg = leg;			
		}else {
			throw new Exception();
		}
	}
}