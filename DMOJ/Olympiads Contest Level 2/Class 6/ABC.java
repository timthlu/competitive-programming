import java.util.Scanner;
import java.util.Arrays;

public class ABC {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[3];
		for (int i = 0; i < 3; i++) {
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		
		scanner.nextLine();
		String input = scanner.nextLine();
		for (int i = 0; i < 3; i++) {
			if (input.charAt(i) == 'A') {
				System.out.print(array[0] + " ");
			} else if (input.charAt(i) == 'B') {
				System.out.print(array[1] + " ");
			} else {
				System.out.print(array[2] + " ");
			}
		}
	}
}