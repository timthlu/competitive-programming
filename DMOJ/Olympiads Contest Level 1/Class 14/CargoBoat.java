import java.util.Scanner;

public class CargoBoat {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] input = new int[n*2];
		int totalSum = 0;
		
		for (int i = 0; i < n*2; i++) {
			input[i] = scanner.nextInt();
			totalSum = totalSum + input[i];
		}
		
		int minDiff = Integer.MAX_VALUE;
		int sum;
		for (int i = 0; i < n*2-2; i++) {
			for (int j = i+1; j < n*2-1; j++) {
				for (int k = j+1; k < n*2; k++) {
					sum = input[i] + input[j] + input[k];
					if (Math.abs(totalSum - sum - sum) < minDiff) minDiff = Math.abs(totalSum - sum - sum);
				}
			}
		}
		
		System.out.println(minDiff);
	}
}