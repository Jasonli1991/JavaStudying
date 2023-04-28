package tw.org.iii.tutor;

public class primeNum {
    public static void main(String[] args) {
    	int range = 100;
        for (int i = 2; i <= range; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}