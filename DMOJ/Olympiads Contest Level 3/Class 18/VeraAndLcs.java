import java.util.Scanner;

public class VeraAndLcs {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int lcs = scanner.nextInt();
		scanner.nextLine();
		String a = scanner.nextLine();
		int[] freq = new int[26];
		
		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i) - 'a']++;
		}
		
		int min = Integer.MAX_VALUE;
		char letter = ' ';
		
		for (int i = 0; i < 26; i++) {
			if (freq[i] < min) {
				min = freq[i];
				letter = (char)('a'+i);
			}
		}
		
		if (min > lcs || n < lcs) {
			System.out.println("WRONGANSWER");
		} else {
			for (int i = 0; i < n; i++) {
				if (min < lcs) {
					System.out.print(a.charAt(i));
					if (a.charAt(i) != letter) {
						min++;
					} 
				} else {
					System.out.print(letter);
				}
			}
			System.out.println();
		}
	}
}