import java.util.Scanner;

public class HiddenPalindrome2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int largestLength = Integer.MIN_VALUE;
		for (int i = 0; i < input.length(); i++) {
			for (int j = i+1; j < input.length()+1; j++) {
				String newString = input.substring(i, j);
				String reversedString = "";
				for (int k = 0; k < newString.length(); k++) {
					reversedString = reversedString + newString.substring(newString.length()-k-1, newString.length()-k);
				}
				
				if (largestLength < newString.length() && newString.equals(reversedString)) {
					largestLength = newString.length();
				}
			}
		}
		
		System.out.println(largestLength);
	}
}