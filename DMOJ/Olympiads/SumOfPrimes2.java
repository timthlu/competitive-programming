import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SumOfPrimes2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] primes = new int[100001]; //0 = undecided, 1 = prime, 2 = not prime
		int[] psa = new int[100001];
		
		primes[1] = 2;
		
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] != 2) {
				primes[i] = 1;
				
				for (int j = 2; i*j < primes.length; j++) {
					primes[i*j] = 2;
				}
				
				psa[i] = psa[i-1] + i;
			} else {
				psa[i] = psa[i-1];
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			String[] input = br.readLine().split(" ");
			
			System.out.println(psa[Integer.parseInt(input[1])] - psa[Integer.parseInt(input[0])-1]);
		}
	}
}