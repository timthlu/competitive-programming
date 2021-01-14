import java.util.Scanner;

public class MagicalBribery {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] cards = new int[n+1];
		for (int i = 1; i <= n; i++) {
			cards[i] = scanner.nextInt();
		}
		
		int[] optimal = new int[n+1];
		optimal[1] = cards[1];
		for (int i = 2; i <= n; i++) {
			optimal[i] = cards[i];
			for (int j = 1; j <= i/2; j++) {
				optimal[i] = Math.max(optimal[i-j] + optimal[j], optimal[i]);
			}
		}
		
		System.out.println(optimal[n]);
		
	}
}