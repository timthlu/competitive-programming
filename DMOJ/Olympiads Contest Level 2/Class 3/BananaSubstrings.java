import java.util.Scanner;

public class BananaSubstrings {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String banana = "banana";
		int largestLength = Integer.MIN_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = i+1; j < 7; j++) {
				String newString = banana.substring(i, j);
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