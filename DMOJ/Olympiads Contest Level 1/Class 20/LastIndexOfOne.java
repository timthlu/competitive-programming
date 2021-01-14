import java.util.Scanner;

public class LastIndexOfOne {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {
			String input = scanner.nextLine();
			int indexCount = -1;
			for (int j = input.length()-1; j >= 0; j--) {
				if (input.charAt(j) == '1') {
					indexCount = j;
					break;
				}
			}
			System.out.println(indexCount);
		}
	}
}