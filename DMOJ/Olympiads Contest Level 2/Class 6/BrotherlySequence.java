import java.util.Scanner;

public class BrotherlySequence {
	
	static int countIndex = -1;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array = new int[num];
		
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
		}
		
		int maxLength = 0;
		
		while (countIndex < array.length) {
			int count = findSequences(array, countIndex+1);
			if (count > maxLength) {
				maxLength = count;
			}
		}
	
		System.out.println(maxLength);
		
	}
	public static int findSequences(int[] array, int index) {
		countIndex = index;
		if (index >= array.length) {
			return 0;
		} else if (index == array.length - 1) {
			return 1;
		} else if (Math.abs(array[index] - array[index+1]) <= 2) {
			return 1 + findSequences(array, index+1);
		} else {
			return 1;
		}
	}
}