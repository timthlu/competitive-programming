import java.util.Scanner;

public class PalindromePanic {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 10; i++) { //10 inputs
			String input = scanner.nextLine();
			int maxLength = Integer.MIN_VALUE;
			
			for (int j = 0; j < input.length()-1; j++) {
				for (int k = j; k < input.length()-1; k++) {
					for (int l = k+1; l < input.length(); l++) {
						String sub = input.substring(k, l+1);
						int num = checkPalindrome(sub);
						if (num > maxLength) {
							maxLength = num;
						}
					}
				}
			}
			
			System.out.println(input.length()-maxLength);
		}
	}
	public static int checkPalindrome(String string) {
		boolean isPal = true;
		for (int i = 0; i < string.length()/2; i++) {
			if (string.charAt(i) != string.charAt(string.length()-i-1)) {
				isPal = false;
			}
		}
		
		if (isPal) return string.length();
		else return -1;
	}
}