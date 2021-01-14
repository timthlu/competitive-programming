import java.util.Scanner;

public class Candies {
	static int[][] dp;
	static int[] maxC;
	static int children, candies;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		children = scanner.nextInt();
		candies = scanner.nextInt();
		
		dp = new int[children+1][candies+1];
		maxC = new int[children+1];
		for (int i = 1; i <= children; i++) {
			maxC[i] = scanner.nextInt();
		}
		
		dp[1][1] = 1;
		for (int i = 0; i <= children; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i <= candies; i++) {
			dp[0][i] = 1;
		}
		
		System.out.println(solve(children, candies));
	}
	public static int solve(int i, int j) {
		if (dp[i][j] != 0) return dp[i][j];
		else {
			for (int a = 0; a <= maxC[i]; a++) {
				dp[i][j] += solve(i-1, j-a);
			}
			return dp[i][j];
		}
	}
}
/*
dp[number of kids][number of candies given to kids] = number of ways
dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j-2] + ... + dp[i-1][j-ai];
*/