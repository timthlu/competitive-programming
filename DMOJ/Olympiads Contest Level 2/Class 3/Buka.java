import java.util.Scanner;

public class Buka {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String operation = scanner.nextLine();
		String b = scanner.nextLine();
		
		if (operation.equals("+")) {
			if (a.equals(b)) {
				System.out.println("2" + a.substring(1));
			} else if (a.length() > b.length()) {
				a = a.substring(0, a.length()-b.length());
				a = a + b;
				System.out.println(a);
			} else {
				b = b.substring(0, b.length()-a.length());
				b = b + a;
				System.out.println(b);
			}
		} else {
			for (int i = 0; i < a.length()-1; i++) {
				b = b + "0";
			}
			System.out.println(b);
		}
	}
}