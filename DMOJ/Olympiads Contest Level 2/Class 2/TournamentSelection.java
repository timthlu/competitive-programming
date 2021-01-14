import java.util.Scanner;

public class TournamentSelection {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int countW = 0;
		for (int i = 0; i < 6; i++) {
			String input = scanner.nextLine();
			if (input.equals("W")) {
				countW++;
			}
		}
		
		if (countW == 0) {
			System.out.println(-1);
		} else if (countW == 1 || countW == 2) {
			System.out.println(3);
		} else if (countW == 3 || countW == 4) {
			System.out.println(2);
		} else {
			System.out.println(1);
		}	
	}
}