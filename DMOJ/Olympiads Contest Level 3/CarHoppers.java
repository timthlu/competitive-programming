import java.util.Scanner;

public class CarHoppers {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int a = 0; a < 5; a++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			int[] cars = new int[n];
			for (int i = 0; i < n; i++) {
				cars[i] = scanner.nextInt();
			}
			
			int nextIndex = 0;
			int countGuards = 0;
			while (nextIndex < n) {
				nextIndex = solve(cars, nextIndex, m);
				countGuards++;
			}
			System.out.println(countGuards);
		}
	}
	public static int solve(int[] cars, int start, int m) {
		int maxIndex = start;
		for (int i = start+1; i <= start+m; i++) {
			if (i < cars.length && cars[i] >= cars[maxIndex]) {
				maxIndex = i;
			}
		}
		
		for (int i = maxIndex+1; i <= maxIndex+m; i++) {
			if (i >= cars.length) {
				return cars.length;
			} else if (cars[i] > cars[maxIndex]) {
				return i+1;
			}
		}
		
		return maxIndex+m+1;
	}
}