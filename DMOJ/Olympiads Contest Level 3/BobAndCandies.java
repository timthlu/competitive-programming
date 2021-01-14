import java.util.Scanner;

public class BobAndCandies {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		System.out.println(Math.min(b/a, c));
	}
}