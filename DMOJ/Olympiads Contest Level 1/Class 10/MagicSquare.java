import java.util.Scanner;

public class MagicSquare {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int array[][] = new int[4][4];
		
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				array[row][col] = scanner.nextInt();
			}
		}
		
		int row0 = AddingRow(array, 0);
		int row1 = AddingRow(array, 1);
		int row2 = AddingRow(array, 2);
		int row3 = AddingRow(array, 3);
		
		int col0 = AddingCol(array, 0);
		int col1 = AddingCol(array, 1);
		int col2 = AddingCol(array, 2);
		int col3 = AddingCol(array, 3);
		
		if (row0 == row1 && row2 == row3 && row1 == row2 && col0 == col1 && col2 == col3 && col1 == col2) {
			System.out.println("magic");
		} else {
			System.out.println("not magic");
		}	
	}
	public static int AddingRow(int array[][], int row) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum = array[row][i] + sum;
		}
		return sum;
	}
	public static int AddingCol(int array[][], int col) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum = array[i][col] + sum;
		}
		return sum;
	}
}