import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int runTimes = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < runTimes; i++) {
			String input = scanner.nextLine();
			boolean valid = true;
			
			String tempO = replaceWithBlank(input, "O");
			int numO = input.length() - tempO.length();
			String tempX = replaceWithBlank(input, "X");
			int numX = input.length() - tempX.length();
			
			if (numO != numX && numO != numX-1) {
				valid = false;
			}
			
			boolean multipleWinners = false;
			if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(2) && input.charAt(0) != '.') {
				if (multipleWinners == false) {
					multipleWinners = true;
				} else {
					valid = false;
				}
			}
			if (input.charAt(3) == input.charAt(4) && input.charAt(4) == input.charAt(5) && input.charAt(3) != '.') {
				if (multipleWinners == false) {
					multipleWinners = true;
				} else {
					valid = false;
				}
			}
			if (input.charAt(6) == input.charAt(7) && input.charAt(7) == input.charAt(8) && input.charAt(6) != '.') {
				if (multipleWinners == false) {
					multipleWinners = true;
				} else {
					valid = false;
				}
			}
			
			if (valid) System.out.println("yes");
			else System.out.println("no");
		}
	}
	public static String replaceWithBlank(String str, String ch) {
		while (str.indexOf(ch) != -1) {
			int split = str.indexOf(ch);
			str = str.substring(0, split) + str.substring(split+1);
		}
		
		return str;
	}
}