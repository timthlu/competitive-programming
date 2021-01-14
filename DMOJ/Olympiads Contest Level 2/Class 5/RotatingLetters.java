import java.util.Scanner;

public class RotatingLetters {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		boolean valid = true;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != 'I' && input.charAt(i) != 'O' && input.charAt(i) != 'S' && input.charAt(i) != 'H' && input.charAt(i) != 'Z' && input.charAt(i) != 'X' && input.charAt(i) != 'N') {
				valid = false;
				break;
			}
		}
		
		if (valid) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}