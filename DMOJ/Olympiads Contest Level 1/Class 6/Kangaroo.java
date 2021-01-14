import java.util.Scanner;

public class Kangaroo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int start1 = scanner.nextInt();
		int speed1 = scanner.nextInt();
		int start2 = scanner.nextInt();
		int speed2 = scanner.nextInt();
		
		if (speed1 < speed2) {
			System.out.println("NO");
		} else {
			int diff = start2 - start1;
			int rate = speed1 - speed2;
			if (diff%rate == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}
}