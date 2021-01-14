import java.util.Scanner;
import java.util.Arrays;

public class HouseOfCards {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		Arrays.sort(w);
		
		int[] layers = new int[n];
		layers[0] = 1;
		for (int i = 1; i < n; i++) {
			int max = -1;
			for (int j = i-1; j >= 0; j--) {
				if (w[i] - k >= w[j]) {
					max = Math.max(max, layers[j]);
				}
			}
			
			layers[i] = max+1;
		}
		
		int ans = -1;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, layers[i]);
		}
		System.out.println(ans);
	}
}