import java.util.Scanner;

public class FindTheMedian {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < n; i++) {
				if (array[i] < array[i-1]) {
					sorted = false;
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
				}
			}
		}
		
		if (n%2 != 0) {
			System.out.println(array[n/2]);
		} else {
			System.out.println(array[n/2-1] + " " + array[n/2]);
		}
	}
}