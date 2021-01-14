import java.util.Scanner;

public class CommonChild {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();
		
		System.out.println(count(input1, input2, 0, 0, 0));
	}
	public static int count(String str1, String str2, int one, int two, int bound) {
		if (bound == str2.length() || one == str1.length()) {
			return 0;
		} else if (one == str1.length()-1 && two == str2.length()) {
			return 0;
		} else if (two == str2.length()) {
			return count(str1, str2, one+1, bound, bound+1);
		} else if (str1.charAt(one) == str2.charAt(two)) {
			return 1 + count(str1, str2, one+1, two+1, bound);
		}
		
		return count(str1, str2, one, two+1, bound);
	}
}