import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SuperPlumber {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		if (!input[0].equals("0") && !input[1].equals("0")) {
			int rows = Integer.parseInt(input[0]);
			int cols = Integer.parseInt(input[1]);
			
			int[][] a = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				String input2 = br.readLine();
				for (int j = 0; j < cols; j++) {
					if (input2.charAt(j) == '.') {
						a[i][j] = 0;
					} else if (input2.charAt(j) == '*') {
						a[i][j] = -1;
					} else {
						a[i][j] = Integer.parseInt(input2.substring(j, j+1));
					}
				}
			}
			
			input = br.readLine().split(" ");
		}
	}
	static class Pos {
		int row;
		int col;
		
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}