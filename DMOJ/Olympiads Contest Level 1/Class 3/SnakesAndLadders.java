import java.util.Scanner;

public class SnakesAndLadders {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int currentSquare = 1;
		
		while (true) {
			int diceroll = scanner.nextInt();
			if (diceroll == 0) {
				System.out.println("You Quit!");
				break;
			} else if (diceroll < 2 || diceroll > 12) {
				continue;
			} else {
				currentSquare = currentSquare + diceroll;
			}
			
			if (currentSquare == 9) {
				currentSquare = 34;
			} else if (currentSquare == 54) {
				currentSquare = 19;
			} else if (currentSquare == 40) {
				currentSquare = 64;
			} else if (currentSquare == 90) {
				currentSquare = 48;
			} else if (currentSquare == 67) {
				currentSquare = 86;
			} else if (currentSquare == 90) {
				currentSquare = 77;
			} else if (currentSquare > 100) {
				currentSquare = currentSquare - diceroll;
			}
			
			System.out.println("You are now on square " + currentSquare);
			
			if (currentSquare == 100) {
				System.out.println("You Win!");
				break;
			}
			
		}
		
	}
}