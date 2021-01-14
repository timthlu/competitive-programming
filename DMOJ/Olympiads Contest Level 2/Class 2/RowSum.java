import java.util.Scanner;

public class RowSum {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[][] array = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < size; i++) {
			int sum = 0;
			for (int j = 0; j < size; j++) {
				sum = sum + array[i][j];
			}
			System.out.println(sum);
		}
	}
}