import java.util.Scanner;

public class HappyOrSad {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int countHappy = 0;
		int countSad = 0;
		for (int i = 0; i < input.length()-3; i++) {
			if (input.substring(i, i+3).equals(":-)")) {
				countHappy++;
			} else if (input.substring(i, i+3).equals(":-(")) {
				countSad++;
			}
		}
		
		if (countHappy == 0 && countSad == 0) {
			System.out.println("none");
		} else if (countHappy == countSad) {
			System.out.println("unsure");
		} else if (countHappy > countSad) {
			System.out.println("happy");
		} else {
			System.out.println("sad");
		}
	}
}