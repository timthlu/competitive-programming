import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Throne {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String[] input = br.readLine().split(" ");
			
			long n = Long.parseLong(input[0]);
			long s = Long.parseLong(input[1]);
			long k = Long.parseLong(input[2]);
			
			//linear congruence k*x = n-s (mod n)
			long a = k;
			long c = n-s;
			long m = n;
			long d = gcd(a, m);
			
			
			if (c % d != 0) {
				System.out.println(-1);
			} else {
				long particularSolution = findParticularSolution(a, m, c, d);
				long mod = particularSolution % (m/d);
				if (mod < 0) {
					mod += m/d;
				}
				System.out.println(mod);
			}
		}
		
	}
	public static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		} else if (b == 0) {
			return a;
		} else {
			if (a > b) {
				return gcd(a%b, b);
			} else {
				return gcd(b%a, a);
			}
		}
	}
	public static long findParticularSolution(long a, long m, long c, long d) {
		//m always > a
		long[] firstRow = {1, 0, m, 0};
		long[] secondRow = {0, 1, a, 0};
		
		while (firstRow[2] % secondRow[2] != 0) {
			long[] newRow = new long[4];
			long r = firstRow[2] % secondRow[2];
			newRow[2] = r;
			long q = firstRow[2] / secondRow[2];
			newRow[3] = q;
			newRow[0] = firstRow[0] - (long)q*secondRow[0];
			newRow[1] = firstRow[1] - (long)q*secondRow[1];
			
			firstRow = secondRow;
			secondRow = newRow;
		}
		
		return secondRow[1]*(c/d);
	}
}