import java.util.Scanner;

public class Klopka {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] rows = new int[num];
		int[] cols = new int[num];
		for (int i = 0; i < num; i++) {
			rows[i] = scanner.nextInt();
			cols[i] = scanner.nextInt();
		}
		
		int rowMin = 0, rowMax = 0, colMin = 0, colMax = 0;
		for (int i = 1; i < num; i++) {
			if (rows[rowMin] > rows[i]) {
				rowMin = i;
			}
			if (rows[rowMax] < rows[i]) {
				rowMax = i;
			}
			if (cols[colMin] > cols[i]) {
				colMin = i;
			}
			if (cols[colMax] < cols[i]) {
				colMax = i;
			}
		}
		
		int diffRow = rows[rowMax] - rows[rowMin];
		int diffCol = cols[colMax] - cols[colMin];
		
		if (diffRow == diffCol) {
			if (diffRow == 0) {
				System.out.println(1);
			} else {
				System.out.println(diffRow*diffCol);
			}
		} else if (diffRow > diffCol) {
			System.out.println(diffRow*diffRow);
		} else {
			System.out.println(diffCol*diffCol);
		}
	}
}