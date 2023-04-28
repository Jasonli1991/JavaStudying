package tw.org.iii.tutor;

public class PokerV3 {

	public static void main(String[] args) {
        int count = 52;
        int[] poker = new int[count];
        // 初始化撲克牌
        for (int i = 0; i < count; i++) {
            poker[i] = i + 1;
        }
        // 洗牌
        for (int i = count - 1; i >= 1; i--) {
            int j = (int) (Math.random() * (i + 1));
            // 將亂數選擇的牌和最後一張牌交換
            int temp = poker[j];
            poker[j] = poker[i];
            poker[i] = temp;
        }
        // 印出洗牌後的牌組
        for (int card : poker) {
            System.out.print(card + " ");
        }
    }
}
