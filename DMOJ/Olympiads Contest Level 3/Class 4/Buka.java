import java.util.Scanner;

public class Buka {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String operation = scanner.nextLine();
		String b = scanner.nextLine();
		
		String result;
		
		if (operation.equals("+")) {
			if (a.length() > b.length()) {
				result = a.substring(0, a.length()-b.length()) + b;
			} else if (b.length() > a.length()) {
				result = b.substring(0, b.length()-a.length()) + a;
			} else {
				result = "2" + a.substring(1);
			}
		} else {
			result = "1";
			for (int i = 0; i < a.length() + b.length()-2; i++) {
				result = result + "0";
			}
		}
		
		System.out.println(result);
	}
}