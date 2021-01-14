import java.util.Scanner;
//finished user input, started on solution and making sense of grid
public class CrosswordPuzzle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char[][] grid = new char[10][10];
		for (int i = 0; i < 10; i++) {
			String input = scanner.nextLine();
			for (int j = 0; j < 10; j++) {
				grid[i][j] = input.charAt(j);
			}
		}
		String nounInput = scanner.nextLine();
		String[] nouns = nounInput.split(";");
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (grid[i][j] == '-') {
					checkNorth(grid, i, j);
				}
			}
		}
	}
	public static int checkNorth(char[][] grid, int row, int col) {
		if (row != 0 && col != 0 && grid[row][col] == '-') {
			return checkNorth(grid, row-1, col) + 1;
		} else {
			return 0;
		}
	}
}