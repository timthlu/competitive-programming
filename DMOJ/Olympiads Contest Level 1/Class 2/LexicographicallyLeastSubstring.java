import java.util.Scanner;

public class LexicographicallyLeastSubstring {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String least = input.substring(0, 4);
		
		for (int i = 0; i < input.length()-3; i++) {
			String word = input.substring(i, i+4);
			
			int compare = least.compareToIgnoreCase(word);
			if (compare == 0) {
				continue;
			} else if (compare > 0) {
				least = word;
			}
		}
		
		System.out.println(least);
	}
}