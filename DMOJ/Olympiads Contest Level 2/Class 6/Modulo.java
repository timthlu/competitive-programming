import java.util.Scanner;

public class Modulo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean[] values = new boolean[42];
		for (int i = 0; i < 10; i++) {
			int input = scanner.nextInt();
			input = input%42;
			values[input] = true;
		}
		
		int count = 0;
		for (int i = 0; i < 42; i++) {
			if (values[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}