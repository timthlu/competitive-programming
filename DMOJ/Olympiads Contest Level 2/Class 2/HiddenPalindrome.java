import java.util.Scanner;

public class HiddenPalindrome {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int longestPalindrome = 0;
		for (int i = 0; i < input.length()-1; i++) {
			for (int j = i+1; j < input.length(); j++) {
				if (j-i+1 > longestPalindrome && checkIfPalindrome(input.substring(i, j+1))) {
					longestPalindrome = j-i+1;
				}
			}
		}
		
		System.out.println(longestPalindrome);
		
	}
	public static boolean checkIfPalindrome(String letters) {
		for (int i = 0; i < letters.length()/2; i++) {
			if (letters.charAt(i) != letters.charAt(letters.length()-1-i)) {
				return false;
				
			}
		}
		
		return true;
	}
}