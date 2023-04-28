package tw.org.iii.myclasses;

public class TWId {
	private String id;
	public TWId() {
		
	}
	public TWId(boolean isMale) {
		
	}
	public TWId(int area) {
		
	}
	public TWId(boolean isMale, int area) {
		
	}
	private TWId(String myid) {
		
	}
	
	public static boolean checkId(String id) {
		// 1. len = 10
		// 2. c1 => A-Z
		// 3. c2 => 1, 2
		// 4. c3-10 => 0-9

//		正規表示法
//		if (id.matches("[A-Z][1289][0-9]{8}")) {
//			
//		}
		
		boolean isRight = false;
		if (id.length() == 10) {
	        char c1 = id.charAt(0);
	        if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c1) != -1) {
	            char c2 = id.charAt(1);
	            if (c2 == '1' || c2 == '2') {
	                String afterc2 = id.substring(2, 10);
	                boolean allNums = true;
	                for (int i = 0; i < afterc2.length(); i++) {
	                    char num = afterc2.charAt(i);
	                    if (!Character.isDigit(num)) {
	                        allNums = false;
	                        break;
	                    }
	                }
	                if (allNums) {
	                    isRight = true;
	                }
	            }
	        }
	    }
	    return isRight;
	}
}
