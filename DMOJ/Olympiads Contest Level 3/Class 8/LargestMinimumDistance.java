import java.util.Scanner;
import java.util.Arrays;

public class LargestMinimumDistance {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int seats = scanner.nextInt();
		int students = scanner.nextInt();
		
		int[] array = new int[seats];
		for (int i = 0; i < seats; i++) {
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		
		int indexGap = 2;
		int sol = 0;
		
		for (int j = 0; j <= array.length % indexGap; j++) {
			int minDis = Integer.MAX_VALUE;
			for (int i = j; i < array.length - indexGap - 1; i = i + indexGap) {
				System.out.println(array[i+indexGap] + " " + array[i]);
				minDis = Math.min(minDis, array[i+indexGap] - array[i]);
			}
			
			sol = Math.max(sol, minDis);
		}
		
		System.out.println(sol);
	}
}