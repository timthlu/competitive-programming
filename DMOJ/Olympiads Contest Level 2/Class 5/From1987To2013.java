import java.util.Scanner;

public class From1987To2013 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		boolean valid = false;
		String testing = input;
		while (!valid) {
			int num = Integer.parseInt(testing) + 1;
			testing = Integer.toString(num);
			
			String seenDigits = "";
			valid = true;
			for (int i = 0; i < testing.length(); i++) {
				for (int j = 0; j < seenDigits.length(); j++) {
					if (testing.charAt(i) == seenDigits.charAt(j)) {
						valid = false;
						break;
					}
				}
				
				if (!valid) {
					break;
				}
				
				seenDigits = seenDigits + testing.substring(i, i+1);
			}
		}
		
		System.out.println(testing);
	}
}