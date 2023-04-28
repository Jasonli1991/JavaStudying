package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.TreeSet;

public class Jason37_CollectionSetLottery {

	public static void main(String[] args) {
		//不會重複，沒有順序
//		HashSet<Integer> lottery = new HashSet<>();
		//排序
		TreeSet<Integer> lottery = new TreeSet<>();
		while (lottery.size()<6) {
			lottery.add((int)(Math.random()*49+1));
		}
		
		System.out.println(lottery);
	}	

}
