import java.util.Scanner;

public class ConnectFour {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char[][] input = new char[6][7];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				String str = scanner.nextLine();
				input[i][j] = str.charAt(0);
			}
		}
		

		char result;
		boolean cont = true;
		

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 3; j++) {
				result = SquareCheck(input, i, j, i+4, j+4);
				
				if (result != 'N') {
					if (result == 'R') {
						System.out.println("Red wins!");
						cont = false;
					} else {
						System.out.println("Yellow wins!");
						cont = false;
					}
				}
				
			}
		}
		
		if (cont) {
			System.out.println("No winner!");
		}
		
	}
	public static char SquareCheck(char[][] array, int a, int b, int c, int d) {
		
		char[][] square = new char[4][4];
		int m = 0;
		int n = 0;
		
		for (int i = a; i < c; i++) {
			for (int j = b; j < d; j++) {
				square[m][n] = array[i][j];
				
				n++;
			}
			n = 0;
			m++;
		}

		if (square[0][0] == square[1][1] && square[2][2] == square[3][3] && square[1][1] == square[2][2] && square[0][0] != ' ') {
			return square[0][0];
		} else if (square[3][0] == square[2][1] && square[1][2] == square[0][3] && square[2][1] == square[1][2] && square[3][0] != ' ') {
			return square[3][0];
		} else {
			for (int i = 0; i < 4; i++) {
				if (square[i][0] == square[i][1] && square[i][2] == square[i][3] && square[i][1] == square[i][2] && square[i][0] != ' ') {
					return square[i][0];
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if (square[0][i] == square[1][i] && square[2][i] == square[3][i] && square[1][i] == square[2][i] && square[0][i] != ' ') {
					return square[0][i];
				}
			}
		}
			
		char no = 'N';
		return no;
	}
}