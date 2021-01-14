import java.util.Scanner;

public class ASubstringProblem {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		boolean outputted = false;
		
		for (int i = 0; i < input.length()-1; i++) {
			for (int j = i+1; j < input.length(); j++) {
				String substring = input.substring(i, j+1);
				boolean pal = checkIfPalindrome(substring);
				
				if (pal && substring.length()%2 == 0 && !outputted) {
					System.out.println("Even");
					outputted = true;
				}
			}
		}
		
		if (!outputted) {
			System.out.println("Odd");
		}
	}
	public static boolean checkIfPalindrome(String string) {
		for (int i = 0; i < string.length()/2; i++) {
			if (string.charAt(i) != string.charAt(string.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}