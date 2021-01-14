import java.util.Scanner;

public class EnglishOrFrench {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		int s = 0;
		int t = 0;
		
		for (int i = 0; i < num; i++) {
			String input = scanner.nextLine();
			char[] array = input.toCharArray();
			
			for (int j = 0; j < input.length(); j++) {
				
				if (array[j] == 's' || array[j] == 'S') {
					s++;
				} else if (array[j] == 't' || array[j] == 'T') {
					t++;
				}
				
			}
		}
		if (s >= t) {
			System.out.println("French");
		} else {
			System.out.println("English");
		}
	}
}