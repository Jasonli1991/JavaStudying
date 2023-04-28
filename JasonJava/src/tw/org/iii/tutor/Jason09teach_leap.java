package tw.org.iii.tutor;

public class Jason09teach_leap {

	public static void main(String[] args) {
		int year = 2023;
		boolean isLeap;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 閏
					isLeap = true;
				}else {
					// 平
					isLeap = false;
				}
			}else {
				// 閏
				isLeap = true;
			}
		}else {
			// 平
			isLeap = false;
		}
		
		System.out.printf("%d年為%s年", year, (isLeap?"閏":"平"));
		
		
		//----------------------------效能較差
//		if (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) {
//			//閏
//		}else {
//			//平
//		}
			
		
	}

}
