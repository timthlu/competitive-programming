import java.util.Scanner;

public class CharMatching {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();
		
		int count = 0;
		int minLength = input1.length();
		if (input2.length() < input1.length()) {
			minLength = input2.length();
		}
		
		for (int i = 0; i < minLength; i++) {
			if (input1.charAt(i) == input2.charAt(i)) {
				count++;
			}
		}
		
		System.out.println(count + " matches.");
	}
}