import java.util.Scanner;

public class Tides {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
		}
		
		int minIndex = 0;
		int maxIndex = 0;
		for (int i = 1; i < num; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}
		
		if (minIndex > maxIndex) {
			System.out.println("unknown");
		} else {
			boolean bad = false;
			
			for (int i = minIndex; i <= maxIndex-1; i++) {
				if (array[i] > array[i+1]) { 
					bad = true;
					System.out.println("unknown");
					break;
				}
			}
			
			if (!bad) {
				System.out.println(array[maxIndex] - array[minIndex]);
			}
		}
	}
}