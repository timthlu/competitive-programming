import java.util.Scanner;

public class RoundToSecondPrime {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			int n = scanner.nextInt();
			
			int a = 1;
			boolean firstUp = false;
			boolean firstDown = false;
			boolean secondUp = false;
			boolean secondDown = false;
			int x = -1;
			int y = -1;
			while (!secondUp || !secondDown) {
				if (ifPrime(n+a) && !firstUp && !secondUp) {
					firstUp = true;
				} else if (ifPrime(n+a) && firstUp && !secondUp) {
					x = n+a;
					secondUp = true;
				}
				
				if (ifPrime(n-a) && !firstDown && !secondDown) {
					firstDown = true;
				} else if (ifPrime(n-a) && firstDown && !secondDown) {
					y = n-a;
					secondDown = true;
				}
				
				a++;
			}
			
			if (x-n > n-y) {
				System.out.println(y);
			} else {
				System.out.println(x);
			}
		}
	}
	public static boolean ifPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
}