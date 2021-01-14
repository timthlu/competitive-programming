import java.util.Scanner;
import java.util.ArrayList;

public class Palindromes {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < num; i++) {
			String input = scanner.nextLine();
			int m = 0;
			int n = 0;
			
			ArrayList<String> palins = new ArrayList<String>();
			ArrayList<Integer> lengths = new ArrayList<Integer>();
			int largestLength = 0;
			
			for (m = 0; m < input.length()-1; m++) {
				for (n = input.length(); n > m; n--) {
					boolean palin = palindromeCheck(input.substring(m, n));
					if (palin == true) {
						palins.add(input.substring(m, n));
						lengths.add(input.substring(m, n).length());
						
						if (input.substring(m, n).length() > largestLength) {
							largestLength = input.substring(m, n).length();
						}
					}
				}
			}
			System.out.println(palins.get(lengths.indexOf(largestLength)));
			System.out.println(largestLength);
		}
		
	}
	public static boolean palindromeCheck(String pal) {
		boolean isPalin = true;
		
		for (int i = 0; i < (pal.length()/2)+1; i++) {
			if (!pal.substring(i, i+1).equals(pal.substring(pal.length()-i-1, pal.length()-i))) {
				isPalin = false;
				break;
			}
		}
		return isPalin;
	}
}