import java.util.Scanner;

public class Troyangles {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); scanner.nextLine();
		String[][] array = new String[n][n]; int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				array[i][j] = input.substring(j, j+1);
				if (array[i][j].equals("#")) dp[i][j] = 1;
				else dp[i][j] = 0;
			}
		}
		
		for (int i = n-2; i >= 0; i--) {
			for (int j = 1; j < n-1; j++) {
				if (dp[i][j] == 1) {
					int temp = Math.min(dp[i+1][j-1], dp[i+1][j]);
					temp = Math.min(temp, dp[i+1][j+1]);
					if (temp > 0) dp[i][j] = temp + 1;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += dp[i][j];
			}
		}
		System.out.println(sum);
	}
}
/*
dp state: using dp[i][j] to count the number of times the point is counted in a triangle
all dots are 0
dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1];

*/