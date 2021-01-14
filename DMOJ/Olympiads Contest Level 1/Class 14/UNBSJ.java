import java.util.Scanner;

public class UNBSJ {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		scanner.nextLine();
		char[][] input = new char[row][col];
		
		for (int i = 0; i < row; i++) {
			String take = scanner.nextLine();
			for (int j = 0; j < col; j++) {
				input[i][j] = take.charAt(j);
			}
		}
		
		int outputI;
		int outputJ;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col-5; j++) {
				if (input[i][j] == 'U' && input[i][j+1] == 'N' && input[i][j+2] == 'B' && input[i][j+3] == 'S' && input[i][j+4] == 'J') {
					outputI = i+1;
					outputJ = j+1;
					System.out.println(outputI + " " + outputJ);
				}
			}
		}
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row-5; j++) {
				if (input[j][i] == 'U' && input[j+1][i] == 'N' && input[j+2][i] == 'B' && input[j+3][i] == 'S' && input[j+4][i] == 'J') {
					outputI = i+1;
					outputJ = j+1;
					System.out.println(outputI + " " + outputJ);
				}
			}
		}
	}
}