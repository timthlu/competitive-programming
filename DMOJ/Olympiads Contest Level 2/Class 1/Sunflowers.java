import java.util.Scanner;

public class Sunflowers {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] data = new int[num][num];
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				data[i][j] = scanner.nextInt();
			}
		}
		
		int multipleOf90 = 0;
		boolean valid = false;
		
		do {
			if (multipleOf90 != 0) {
				data = rotateClockwise90(data);
			}
			valid = checkValid(data);
			multipleOf90++;
		} while (!valid);
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static int[][] rotateClockwise90(int[][] array) {
		int[][] newArray = new int[array.length][array.length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				newArray[j][array.length-i-1] = array[i][j];
			}
		}
		return newArray;
	}
	public static boolean checkValid(int[][] array) {
		boolean valid = true;
		
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if (array[i][j] > array[i][j+1]) {
					valid = false;
				}
			}
		}
		
		if (valid) {
			for (int i = 0; i < array.length-1; i++) {
				for (int j = 0; j < array.length-1; j++) {
					if (array[i][j] > array[i+1][j]) {
						valid = false;
					}
				}
			}
		}
		
		return valid;
	}
}