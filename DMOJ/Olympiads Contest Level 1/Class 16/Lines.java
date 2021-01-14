import java.util.Scanner;
import java.util.Stack;

public class Lines {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[][] grid = new String[n][n];
		for (int i = 0; i < n; i++) {
		String input = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				grid[i][j] = input.charAt(j);
			}
		}
		
		Stack<Coordinate> stack = new Stack<Coordinate>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j].equals("@")) {
					stack.push(new Coordinate(i, j));
				}
				break;
			}
		}
		
		Coordinate currentPos = stack.pop();
		int minSteps = Integer.MAX_VALUE;
		int count = 0;
		if (grid[currentPos.getRow()][currentPos.getCol()].equals("X")) {
			if (minSteps > count) {
				minSteps = count;
			}
		} else if (!grid[currentPos.getRow()][currentPos.getCol()].equals("O")) {
			if (currentPos.getRow() != 0 && !grid[currentPos.getRow()-1][currentPos.getCol()].equals("O")) {
				stack.push(new Coordinate(currentPos.getRow()-1, currentPos.getCol()));
			}
			if (currentPos.getCol() != n-1 && !grid[currentPos.getRow()][currentPos.getCol()+1].equals("O")) {
				stack.push(new Coordinate(currentPos.getRow(), currentPos.getCol()+1));
			}
			if (currentPos.getRow() != n-1 && !grid[currentPos.getRow()+1][currentPos.getCol()].equals("O")) {
				stack.push(new Coordinate(currentPos.getRow()+1, currentPos.getCol()));
			}
			if (currentPos.getCol() != 0 && !grid[currentPos.getRow()][currentPos.getCol()-1].equals("O")) {
				stack.push(new Coordinate(currentPos.getRow(), currentPos.getCol()-1));
			}
			
			if (grid[currentPos.getRow()][currentPos.getCol()].equals(".")) {
				grid[currentPos.getRow()][currentPos.getCol()] = "+";
			}
			count++;
		}
	}
}