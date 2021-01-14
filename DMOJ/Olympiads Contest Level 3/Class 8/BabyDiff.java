import java.util.Scanner;

public class BabyDiff {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String input1 = scanner.nextLine();
			String input2 = scanner.nextLine();
			
			int count = 0;
			for (int j = 0; j < Math.min(input1.length(), input2.length()); j++) {
				if (input1.charAt(j) == input2.charAt(j)) {
					count++;
				} else {
					break;
				}
			}
			
			System.out.println(count);
		}
	}
}