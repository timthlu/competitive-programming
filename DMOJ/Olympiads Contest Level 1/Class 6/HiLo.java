import java.util.Scanner;

public class HiLo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean play = true;
		
		do {
			System.out.println("You have 6 guesses to guess a number between 0 and 100. Start guessing!");
			int guesses = 0;
			double generate = 100*Math.random();
			long num = Math.round(generate);
			long guess;
			
			do {
				guess = scanner.nextLong();
				guesses++;
				
				if (num > guess) {
					System.out.println("LO");
				} else if (num < guess) {
					System.out.println("HI");
				}
				
			} while (guess != num && guesses < 6);
			
			if (guesses != 6) {
				System.out.println("You have guessed the number in " + guesses + " tries!");
			} else {
				System.out.println("You did not correctly guess the number within 6 tries. The number was " + num + ".");
			}
		
			System.out.println("Play again? (y/n)");
			scanner.nextLine();
			String input = scanner.nextLine();
			if (input.equals("y")) {
				continue;
			} else if (input.equals("n")) {
				play = false;
			}
		
		} while(play);
		
	}
}