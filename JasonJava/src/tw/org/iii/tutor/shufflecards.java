package tw.org.iii.tutor;

public class shufflecards {

	public static void main(String[] args) {
        String[] colors = {"黑桃", "愛心", "方塊", "梅花"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] cards = new String[52];
        
        // 初始化牌堆
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                cards[i * nums.length + j] = colors[i] + nums[j];
            }
        }
        
        // 洗牌
        for (int i = cards.length - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));
            String temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        
        // 印出洗好的牌堆
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
            if ((i + 1) % 13 == 0) {
                System.out.println();
            }
        }
    }
}
