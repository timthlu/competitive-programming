import java.util.Scanner;
//COMPLETED AND FUNCTIONAL
public class MatrixDiaSum {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[][] inputArray = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				inputArray[i][j] = scanner.nextInt();
			}
		}
		
		int diaSum = 0;
		for (int i = 0; i < size; i++) {
			diaSum = diaSum + inputArray[i][i];
		}
		
		for (int i = 0; i < size; i++) {
			inputArray[i][i] = diaSum - inputArray[i][i];
			inputArray[i][size-i-1] = diaSum - inputArray[i][size-i-1];
		}
		
		if (size%2 == 1) {
			inputArray[size/2][size/2] = diaSum - inputArray[size/2][size/2];
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}