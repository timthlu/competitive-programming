import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GeeseVsHawks {
	static long[][] dp;
	static String a, b;
	static int[] a1, b1;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		a = br.readLine();
		a1 = new int[n];
		String[] input1 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a1[i] = Integer.parseInt(input1[i]);
		}
		b = br.readLine();
		b1 = new int[n];
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			b1[i] = Integer.parseInt(input2[i]);
		}
		
		dp = new long[n][n];
		System.out.println(solve(n-1, n-1));
	}
	public static long solve(int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		} else if (dp[i][j] != 0) {
			return dp[i][j];
		} else if (a.substring(i, i+1).equals("W") && b.substring(j, j+1).equals("L") && a1[i] > b1[j]) {
			return dp[i][j] = Math.max(Math.max(a1[i] + b1[j] + solve(i-1, j-1), solve(i-1, j)), solve(i, j-1));
		} else if (a.substring(i, i+1).equals("L") && b.substring(j, j+1).equals("W") && a1[i] < b1[j]) {
			return dp[i][j] = Math.max(Math.max(a1[i] + b1[j] + solve(i-1, j-1), solve(i-1, j)), solve(i, j-1));
		} else {
			return dp[i][j] = Math.max(solve(i-1, j), solve(i, j-1));
		}
	}
}