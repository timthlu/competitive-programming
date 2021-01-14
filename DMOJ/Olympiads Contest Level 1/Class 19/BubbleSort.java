import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		boolean sorted = false;
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < n; i++) {
				if (array[i] < array[i-1]) {
					sorted = false;
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					
					for (int j = 0; j < n; j++) {
						System.out.print(array[j] + " ");
					}
					System.out.println();
				}
			}
		}
	}
}