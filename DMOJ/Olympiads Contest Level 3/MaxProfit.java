import java.util.Scanner;

public class MaxProfit {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] v = new int[n];
		int[] c = new int[n];
		
		for (int i = 0; i < n; i++) {
			v[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (v[i] > c[i]) sum = sum + v[i] - c[i];
		}
		
		System.out.println(sum);
	}
}