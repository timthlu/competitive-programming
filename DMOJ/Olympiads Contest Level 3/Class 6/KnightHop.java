import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class KnightHop {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] hor = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] ver = {2, 1, -1, -2, -2, -1, 1, 2};
		int startRow = scanner.nextInt();
		int startCol = scanner.nextInt();
		int goalRow = scanner.nextInt();
		int goalCol = scanner.nextInt();
		
		if (startRow == goalRow && startCol == goalCol) {
			System.out.println(0);
			System.exit(0);
		}
		
		Queue<Integer> qRow = new LinkedList<>();
		Queue<Integer> qCol = new LinkedList<>();
		boolean[][] vis = new boolean[8][8];
		int[][] steps = new int[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				vis[i][j] = false;
				steps[i][j] = 0;
			}
		}
		
		qRow.add(startRow-1);
		qCol.add(startCol-1);
		
		while (!qRow.isEmpty()) {
			int curRow = qRow.remove();
			int curCol = qCol.remove();
			
			vis[curRow][curCol] = true;
			
			for (int i = 0; i < 8; i++) {
				int nextRow = curRow + ver[i];
				int nextCol = curCol + hor[i];
				
				if (nextRow >= 0 && nextRow <= 7 && nextCol >= 0 && nextCol <= 7) {
					if (nextRow == goalRow-1 && nextCol == goalCol-1) {
						System.out.println(steps[curRow][curCol] + 1);
						System.exit(0);
					} else if (!vis[nextRow][nextCol]) {
						qRow.add(nextRow);
						qCol.add(nextCol);
						
						steps[nextRow][nextCol] = steps[curRow][curCol] + 1;
					}
				}
			}
		}
	}
}