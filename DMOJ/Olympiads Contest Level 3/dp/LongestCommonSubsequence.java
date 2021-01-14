import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LongestCommonSubsequence {
	static int[] x, y;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int n = Integer.parseInt(input1[0]);
		int m = Integer.parseInt(input1[1]);
		x = new int[n+1];
		y = new int[m+1];
		String[] input2 = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			x[i] = Integer.parseInt(input2[i-1]);
		}
		String[] input3 = br.readLine().split(" ");
		for (int i = 1; i <= m; i++) {
			y[i] = Integer.parseInt(input3[i-1]);
		}
		
		dp = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(solve(n, m));
	}
	public static int solve(int i, int j) {
		if (i <= 0 || j <= 0) {
			return 0;
		} else if (dp[i][j] >= 0) {
			return dp[i][j];
		} else if (x[i] == y[j]) {
			return dp[i][j] = solve(i-1, j-1) + 1;
		} else {
			return dp[i][j] = Math.max(solve(i-1, j), solve(i, j-1));
		}
	}
}

/*
dp state:
dp[i][j]
final answer:
dp[m][n]

c[i][j] = 
	if i or j = 0, return 0
	if i, j > 0 and xi = yj, return c[i-1][j-1]+1
	if i, j > 0 and xi != yj, return max(c[i-1]j, c[i,j-1])

*/