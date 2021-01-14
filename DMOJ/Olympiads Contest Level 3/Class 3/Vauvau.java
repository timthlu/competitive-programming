import java.util.Scanner;

public class Vauvau {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		
		for (int i = 0; i < 3; i++) {
			int num = scanner.nextInt();
			boolean one = false;
			boolean two = false;
			
			int mod1;
			if (num <= a + b) {
				mod1 = num;
			} else {
				mod1 = num % (a + b);
			}
			
			if (mod1 <= a) {
				one = true;
			}
			
			int mod2;
			if (num <= c + d) {
				mod2 = num;
			} else {
				mod2 = num % (c + d);
			}
			
			if (mod2 <= c) {
				two = true;
			}
			
			if (one && two) {
				System.out.println("both");
			} else if (!one && two) {
				System.out.println("one");
			} else if (one && !two) {
				System.out.println("one");
			} else {
				System.out.println("none");
			}
		}
	}
}