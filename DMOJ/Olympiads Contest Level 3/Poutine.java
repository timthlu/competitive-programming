/*
Floyd's algorithm
int path[][]: path[i][j] is the shortest possible path from i to j

Procedure:
for k : 1 to n
	for i : 1 to n
		for j : 1 to n
			path[i][j] = min(path[i][j], path[i][k] + path[k][j]);


*/

import java.util.Scanner;

public class Poutine {
	static int[][][] dp;
	static int[][] dis;
	static int n;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		dis = new int[n+1][n+1];
		dp = new int[n+1][n+1][n+1];
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				dis[i][j] = scanner.nextInt();
			}
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
				}
			}
		}
		int m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			int d = scanner.nextInt();
			
			if (dis[s][t] > Math.pow(10, 12)) System.out.println(0);
			else System.out.println(fun(s, t, d));
		}
	}
	public static long fun(int s, int t, int d) {
		if (dp[s][t][d] != -1) return dp[s][t][d];
		if (d == 1 || s == t) return dis[s][t];
		long ans = (long) Math.pow(10, 12);
		for (int u = 1; u <= n; u++) {
			ans = Math.min(ans, Math.max(dis[s][u], fun(u, t, d-1)));
		}
		return dp[s][t][d] = (int) ans;
	}
}