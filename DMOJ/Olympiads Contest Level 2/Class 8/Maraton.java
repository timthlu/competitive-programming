import java.util.Scanner;

public class Maraton {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		scanner.nextLine();
		
		if (size < 3) {
			System.out.println("ongoing");
		} else {
			char[][] array = new char[size][size];
			
			for (int i = 0; i < size; i++) {
				String input = scanner.nextLine();
				
				for (int j = 0; j < size; j++) {
					array[i][j] = input.charAt(j);
				}
			}
			
			boolean winner = false;
			
			for (int i = 0; i <= size - 3; i++) {
				for (int j = 0; j <= size - 3; j++) {
					char c = checkIfWinner(i, j, array);
					
					if (c != '?' && !winner) {
						System.out.println(c);
						winner = true;
					}
				}
			}
			
			if (!winner) {
				System.out.println("ongoing");
			}
		}
	}
	public static char checkIfWinner(int row, int col, char[][] array) {
		for (int i = 0; i < 3; i++) {
			if (array[row][col+i] != '.' && array[row][col+i] == array[row+1][col+i] && array[row+1][col+i] == array[row+2][col+i]) {
				return array[row][col+i];
			}
			
			if (array[row+i][col] != '.' && array[row+i][col] == array[row+i][col+1] && array[row+i][col+1] == array[row+i][col+2]) {
				return array[row+i][col];
			}
		}
		
		if (array[row][col] != '.' && array[row][col] == array[row+1][col+1] && array[row+1][col+1] == array[row+2][col+2]) {
			return array[row][col];
		}
		
		if (array[row][col+2] != '.' && array[row][col+2] == array[row+1][col+1] && array[row+1][col+1] == array[row+2][col]) {
			return array[row][col+2];
		}
		
		return '?';
	}
}