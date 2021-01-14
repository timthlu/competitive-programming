import java.util.Scanner;

public class ColMin {
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
			int min = array[0][i];
			for (int j = 0; j < size; j++) {
				if (min > array[j][i]) {
					min = array[j][i];
				}
			}
			System.out.println(min);
		}
	}
}