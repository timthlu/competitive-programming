import java.util.Scanner;

public class Balance {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int badCount = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' && count2 == 0) {
				count1++;
			} else if (input.charAt(i) == ')') {
				count2++;
			} else {
				if (count1 != count2) {
					badCount++;
				}
				
				count1 = 1;
				count2 = 0;
			}
		}
		
		if (count1 != count2) {
			badCount++; 
		}
		
		if (badCount <= 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}