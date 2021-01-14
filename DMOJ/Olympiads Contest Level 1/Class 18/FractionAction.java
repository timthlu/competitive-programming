import java.util.Scanner;

public class FractionAction {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int den = scanner.nextInt();
		if (num == 0) {
			System.out.println("0");
		} else {
			int quotient = num/den;
			if (num%den != 0) {
				num = num - quotient*den;
				for (int i = num; i > 1; i--) {
					if (num%i == 0 && den%i == 0) {
						num = num/i;
						den = den/i;
						break;
					}
				}
			}
			
			if (quotient >= 1 && num%den == 0) {
				System.out.print(quotient);
			} else if (quotient != 0) {
				System.out.print(quotient + " " + num + "/" + den);
			} else {
				System.out.print(num + "/" + den);
			}
		}
	}
}