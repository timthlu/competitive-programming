import java.util.Scanner;

public class Harambe {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int lowerCount = 0;
		int upperCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if ((int)input.charAt(i) >= 65 && (int)input.charAt(i) <= 90) {
				upperCount++;
			} else if ((int)input.charAt(i) >= 97 && (int)input.charAt(i) <= 122) {
				lowerCount++;
			}
		}
		
		if (upperCount == lowerCount) {
			System.out.println(input);
		} else if (upperCount > lowerCount) {
			System.out.println(input.toUpperCase());
		} else {
			System.out.println(input.toLowerCase());
		}
	}
}