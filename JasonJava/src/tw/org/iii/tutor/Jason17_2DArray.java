package tw.org.iii.tutor;

public class Jason17_2DArray {

	public static void main(String[] args) {
		int[][] a = new int[3][];
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];
	
		//for-each迴圈
//		for (int[] a1: a) {
//			for (int a2 : a1) {
//				System.out.print(a2 + " ");
//			}
//			System.out.println();
//		}
		
		//單純for迴圈
		for (int i = 0; i < a.length; i++) {
		    for (int j = 0; j < a[i].length; j++) {
		        System.out.print(a[i][j] + " ");
		    }
		    System.out.println();
		}
		
		
		
	}

}
