import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.math.BigInteger;

public class DeemosProblem {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		long[] w = new long[m+1];
		long sum = 0;
		for (int i = 1; i <= m; i++) {
			w[i] = BigInteger.probablePrime(32, new Random()).longValue();
			
			while (w[i] <= 190) {
				w[i] = BigInteger.probablePrime(32, new Random()).longValue();
			}
			
			sum += w[i];
		}
		
		long[] psa = new long[n];
		psa[0] = w[a[0]]%sum;
		for (int i = 1; i < n; i++) {
			psa[i] = (psa[i-1] + w[a[i]])%sum;
		}
		
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		hm.put((long)0, 1);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(psa[i])) {
				ans += hm.get(psa[i]);
				hm.put(psa[i], hm.get(psa[i]) + 1);
			} else {
				hm.put(psa[i], 1);
			}
		}
		
		System.out.println(ans);
	}
}