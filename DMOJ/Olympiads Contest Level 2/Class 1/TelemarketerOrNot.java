import java.util.Scanner;

public class TelemarketerOrNot {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int digit1 = scanner.nextInt();
		int digit2 = scanner.nextInt();
		int digit3 = scanner.nextInt();
		int digit4 = scanner.nextInt();
		
		boolean firstDigit = false;
		boolean lastDigit = false;
		boolean middleDigits = false;
		
		if (digit1 == 8 || digit1 == 9) {
			firstDigit = true;
		}
		if (digit4 == 8 || digit4 == 9) {
			lastDigit = true;
		}
		if (digit2 == digit3) {
			middleDigits = true;
		}
		
		if (firstDigit && lastDigit && middleDigits) {
			System.out.println("ignore");
		} else {
			System.out.println("answer");
		}
	}
}