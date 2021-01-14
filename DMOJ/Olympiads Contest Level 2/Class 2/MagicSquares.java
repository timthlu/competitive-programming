import java.util.Scanner;

public class MagicSquares {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[][] array = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		
		boolean magic = true;
		int sum = array[0][0] + array[0][1] + array[0][2] + array[0][3];
		for (int i = 1; i < 4; i++) {
			int currentSum = 0;
			for (int j = 0; j < 4; j++) {
				currentSum = currentSum + array[i][j];
			}
			if (currentSum != sum) {
				magic = false;
			}
		}
		
		if (magic) {
			for (int i = 0; i < 4; i++) {
				int currentSum = 0;
				for (int j = 0; j < 4; j++) {
					currentSum = currentSum + array[j][i];
				}
				if (currentSum != sum) {
					magic = false;
					break;
				}
			}
		}
		
		if (magic) {
			System.out.println("magic");
		} else {
			System.out.println("not magic");
		}
	}
}