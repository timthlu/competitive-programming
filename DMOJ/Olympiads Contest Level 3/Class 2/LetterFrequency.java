import java.util.Scanner;

public class LetterFrequency {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int cases = scanner.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int firstIndex = scanner.nextInt();
			int lastIndex = scanner.nextInt();
			String ch = scanner.next();
			
			int count = 0;
			for (int j = firstIndex-1; j <= lastIndex-1; j++) {
				if (input.substring(j, j+1).equals(ch)) {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
} 