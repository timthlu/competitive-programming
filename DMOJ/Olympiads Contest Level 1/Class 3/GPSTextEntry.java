import java.util.Scanner;

public class GPSTextEntry {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] input = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'G', 'H', 'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P', 'Q', 'R'}, {'S', 'T', 'U', 'V', 'W', 'X'}, {'Y', 'Z', ' ', '-', '.', 0}};
		
		String waypoint = scanner.nextLine();
		char[] gps = waypoint.toCharArray();
		int steps = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (input[i][j] == gps[0]) {
					steps = steps + i + j;
				}
			}
		}
			
		for (int i = 1; i < gps.length; i++) {
			steps = steps + StepsCal(gps, i);
		}
		
		// last letter to the "enter"
		steps = steps + LastLetterToEnter(gps);
		
		System.out.println(steps);
		
		}
	public static int StepsCal (char[] input, int num) {
		int finalsteps = 0;
		int firsti = 0;
		int firstj = 0;
		
		char[][] machine = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'G', 'H', 'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P', 'Q', 'R'}, {'S', 'T', 'U', 'V', 'W', 'X'}, {'Y', 'Z', ' ', '-', '.', 0}};
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (machine[i][j] == input[num-1]) {
					firsti = i;
					firstj = j;
				}
			}
		}
			
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (machine[i][j] == input[num]) {
					finalsteps = Math.abs(i - firsti) + Math.abs(j - firstj);
				}
			}
		}
		
		return finalsteps;
	}
	public static int LastLetterToEnter (char[] input) {
		int finalsteps = 0;
		int lasti = 0;
		int lastj = 0;
		
		char[][] machine = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'G', 'H', 'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P', 'Q', 'R'}, {'S', 'T', 'U', 'V', 'W', 'X'}, {'Y', 'Z', ' ', '-', '.', 0}};
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (machine[i][j] == input[input.length-1]) {
					finalsteps = 4 - i + 5 - j;
				}
			}
		}
		
		return finalsteps;
	}
}