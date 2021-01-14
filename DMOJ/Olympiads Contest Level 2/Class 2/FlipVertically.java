import java.util.Scanner;

public class FlipVertically {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[][] array = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < size/2; i++) {
			for (int j = 0; j < size; j++) {
				int temp = array[i][j];
				array[i][j] = array[size-1-i][j];
				array[size-1-i][j] = temp;
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}