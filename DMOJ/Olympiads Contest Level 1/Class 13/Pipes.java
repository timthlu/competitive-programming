import java.util.Scanner;

public class Pipes {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.next();
		String input2 = scanner.next();
		String input3 = scanner.next();
		String input4 = scanner.next();
		
		System.out.println("Upper left, upper right, lower left, lower right:");
		boolean solution = false;
		
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					for (int d = 0; d < 4; d++) {
						if (input1.charAt(1) == input2.charAt(3) && input2.charAt(2) == input4.charAt(0) && input4.charAt(3) == input3.charAt(1) && input3.charAt(0) == input1.charAt(2)) {
							System.out.println(a + ", " + b + ", " + c + ", " + d);
							solution = true;
						}
						input4 = rotate(input4);
					}
					input3 = rotate(input3);
				}
				input2 = rotate(input2);
			}
			input1 = rotate(input1);
		}
		
		if (solution == false) {
			System.out.println("No solution.");
		}
	}
	public static String rotate(String input) {
		String temp1 = input.substring(0, 3);
		String temp2 = input.substring(3);
		
		return temp2 + temp1;
	}
}