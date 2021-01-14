import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FujoNeko {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] temp = input.trim().split(" ");
		int rows = Integer.parseInt(temp[0]);
		int cols = Integer.parseInt(temp[1]);
		char[][] grid = new char[rows][cols];
		
		int countBeings = 0;
		for (int i = 0; i < rows; i++) {
			input = br.readLine();
			for (int j = 0; j < cols; j++) {
				grid[i][j] = input.charAt(j);
				if (input.charAt(j) == 'X') {
					countBeings++;
				}
			}
		}
		
		int recordBeings = 0;
		int[] beingsPosX = new int[countBeings];
		int[] beingsPosY = new int[countBeings];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 'X') {
					beingsPosX[recordBeings] = i;
					beingsPosY[recordBeings] = j;
					
					recordBeings++;
				}
			}
		}
		
		input = br.readLine();
		int cases = Integer.parseInt(input);
		for (int i = 0; i < cases; i++) {
			input = br.readLine();
			temp = input.trim().split(" ");
			int posY = Integer.parseInt(temp[0]);
			int posX = Integer.parseInt(temp[1]);
			
			boolean canSee = false;
			for (int j = 0; j < countBeings; j++) {
				if (beingsPosX[j] == posX-1 || beingsPosY[j] == posY-1) {
					canSee = true;
					break;
				}
			}
			
			if (canSee) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
	}
}