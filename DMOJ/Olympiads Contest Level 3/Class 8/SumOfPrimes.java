import java.util.Scanner;
import java.util.ArrayList;

public class SumOfPrimes {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 2; i <= 100000; i++) {
			boolean prime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					prime = false;
					break;
				} 
			}
			
			if (prime) {
				primes.add(i);
			}
		}
		
		for (int i = 0; i < 5; i++) {
			int num = scanner.nextInt();
			
			int sum = 0;
			for (int j = 0; j < primes.size(); j++) {
				if (primes.get(j) <= num) {
					sum = sum + primes.get(j);
				}
			}
			
			System.out.println(sum);
		}
	}
}