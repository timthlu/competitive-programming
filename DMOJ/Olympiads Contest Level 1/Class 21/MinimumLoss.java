import java.util.Scanner;
//done
public class MinimumLoss {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scanner.nextInt();
		}
		
		int minLoss = Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (prices[i] > prices[j] && prices[i]-prices[j] < minLoss) {
					minLoss = prices[i] - prices[j];
				}
			}
		}
		
		System.out.println(minLoss);
	}
}