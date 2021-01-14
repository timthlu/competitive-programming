import java.util.Scanner;

public class ShiftySum {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int base = scanner.nextInt();
		int shifts = scanner.nextInt();
		
		int sum = base;
		for (int i = 1; i <= shifts; i++) {
			sum = sum + base*(int)Math.pow(10, i);
		}
		System.out.println(sum);
	}
}