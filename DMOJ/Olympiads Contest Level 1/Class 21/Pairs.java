import java.util.Scanner;

public class Pairs {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		int count = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (Math.abs(array[i]-array[j]) == k) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}