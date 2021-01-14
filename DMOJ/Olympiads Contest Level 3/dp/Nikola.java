import java.util.Scanner;

public class Nikola {
	static int n, dp[][], fee[];
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt(); dp = new int[n+1][n+1]; fee = new int[n+1];
		for (int i = 1; i <= n; i++) fee[i] = scanner.nextInt();
		System.out.println(solve(2, 1));
	}
	static int solve(int pos, int len) {
		if (pos < 1 || pos > n) return Integer.MAX_VALUE;
		if (pos == n) return fee[n];
		if (dp[pos][len] > 0) return dp[pos][len];
		return dp[pos][len] = fee[pos] + Math.min(solve(pos-len, len), solve(pos+len+1, len+1));
	}
}

/*
dp state = where you put your answer
dp[currentPos][length of prev jump]: min fee
= dp[i][j]

2 options each time: jump forward or jump backward
problem is finished when answer is found

dp[i-j][j] = dp[i][j] + fee[i-j] (backward)
dp[i+j+1][j+1] = dp[i][j] + fee[i+j+1] (forward)
*/