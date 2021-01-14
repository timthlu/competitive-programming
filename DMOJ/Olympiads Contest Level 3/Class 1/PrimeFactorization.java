import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimeFactorization {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCases; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (checkIfPrime(input)) {
				System.out.println(input);
			} else {
				for (int j = 2; j <= input; j++) {
					if (input % j == 0) {
						System.out.print(j + " ");
						input = input / j;
						j--;
						
						if (input == 1) {
							break;
						} else if (checkIfPrime(input)) {
							System.out.print(input);
							break;
						}
					}
				}
				System.out.println();
			}
		}
	}
	public static boolean checkIfPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
}