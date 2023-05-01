package tw.org.iii.tutor;

import tw.org.iii.myclasses.TWIdteach;

public class Jason23_twID {

	public static void main(String[] args) {
		String id = "A123456789";
//		if (id.matches("[A-Z][12][0-9]{8}")) {
		if (TWIdteach.checkId(id)) {
		
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		System.out.println("-------");
		
		
		TWIdteach id1 = new TWIdteach();
		//地區臺中市'B'
		TWIdteach id2 = new TWIdteach(1);
		//女性
		TWIdteach id3 = new TWIdteach(false);
		//地區臺北市男性
		TWIdteach id4 = new TWIdteach(true, 0);
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		
		TWIdteach id5 = TWIdteach.createTWIdteach("A123456789");
		System.out.println(id5.getId());
		
	}


}