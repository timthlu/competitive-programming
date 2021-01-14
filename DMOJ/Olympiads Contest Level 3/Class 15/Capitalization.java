import java.util.Scanner;

public class Capitalization {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String output = input.substring(0, 1).toUpperCase();
		boolean capNextLetter = false;
		
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == '.') {
				output = output + ".";
				capNextLetter = true;
			} else if (input.charAt(i) == ' ') {
				output = output + " ";
			} else if (capNextLetter && !input.substring(i, i+1).equals(input.substring(i, i+1).toUpperCase())) {
				output = output + input.substring(i, i+1).toUpperCase();
				capNextLetter = false;
			} else if (!capNextLetter) {
				output = output + input.substring(i, i+1);
			}
		}
		
		System.out.println(output);
	}
}