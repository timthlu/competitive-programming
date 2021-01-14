import java.util.Scanner;

public class NotQuitePrime {
	static int[] primes = new int[1001];
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			int n = scanner.nextInt();
			
			if (ifPrime(n) == 2) {
				System.out.println("not");
			} else {
				int factor = findPrimeFactor(n);
				n = n/factor;
				
				if (ifPrime(n) == 2) {
					System.out.println("semiprime");
				} else {
					System.out.println("not");
				}
			}
		}
	}
	public static int ifPrime(int n) {
		if (primes[n] != 0) return primes[n];
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				return primes[n] = 1;
			}
		}
		return primes[n] = 2;
	}
	public static int findPrimeFactor(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0 && ifPrime(i) == 2) return i;
		}
		
		return -1;
	}
}