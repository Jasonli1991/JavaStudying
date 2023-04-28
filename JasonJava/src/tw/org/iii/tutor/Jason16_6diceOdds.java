package tw.org.iii.tutor;

public class Jason16_6diceOdds {

	public static void main(String[] args) {
		int[] p = new int[7];
		
		for (int i=0; i<10000000; i++) {
			
			//正常
//			int point = (int)(Math.random()*6+1);	// 1 ~ 6
//			if (point >= 1 && point <= 9) {
//				p[point]++;
//			}else {
//				p[0]++;
//			}
			
			//賠率
			int point = (int)(Math.random()*9+1);	// 1 ~ 9  7,8,9列入4,5,6
			if (point >= 1 && point <= 9) {
				p[point>=7?point-3:point]++;
			}else {
				p[0]++;
			}
			
			
		}
		
		if (p[0] == 0) {
			for (int i=1; i<=6; i++) {
				System.out.printf("%d點出現%d次\n", i, p[i]);
			}
		}else {
			System.out.println("debug = " + p[0]);
		}
		System.out.println("----");
		
		// for-each尋訪
		int i = 0;
		for (int v : p) {
			//System.out.println(v);		
			System.out.printf("%d點出現%d次\n", i, v);	
			i++;
		}
		
		
	}
}

