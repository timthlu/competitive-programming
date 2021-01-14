import java.util.Scanner;

public class MinIndex {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] list = new int[size];
		for (int i = 0; i < size; i++) {
			list[i] = scanner.nextInt();
		}
		
		int minIndex = 0;
		for (int i = 1; i < size; i++) {
			if (list[minIndex] > list[i]) {
				minIndex = i;
			}
		}
		
		System.out.println(minIndex);
	}
}