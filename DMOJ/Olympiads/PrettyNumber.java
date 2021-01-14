import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrettyNumber {
	static long[][][] dp = new long[20][2520][1<<8];
	static int n;
	static int[] d = new int[20];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; t++) {
			String[] input = br.readLine().split(" ");
			System.out.println(solve(input[1]) - solve(input[0]-1)); 
		}
	}
	
	public static long solve(long x) {
		n = 0;
		for (; x; x /= 10) {
			d[++n] = x%10;
		}
		return fun(n, 0, 0, 1);
	}
	
	public static long fun(int pos, int rem, int mask, boolean lmt) {
		if (!lmt && dp[pos][rem][mask] != -1) {
			return dp[pos][rem][mask];
		}
		
		if (pos == 0) {
			for (int i = 2; i <= 9; i++) {
				if ((mask & 1<<(i-2)) && rem % i != 0) {
					return 0;
				}
			}
			
			return 1;
		}
		
		int up;
		if (lmt) {
			up = d[pos];
		} else {
			up = 9;
		}
		
		long ret = 0;
		
		for (int i = 0; i <= up; i++) {
			int newMask;
			if (i >= 2) {
				newMask = mask | 1<<(i-2);
			} else {
				newMask = mask;
			}
			
			ret += fun(pos-1, (rem*10+i)%2520, newMask, lmt && i == dp[pos]);
		}
		
		if (!lmt) {
			dp[pos][rem][mask] = ret;
		}
		
		return ret;
	}
}