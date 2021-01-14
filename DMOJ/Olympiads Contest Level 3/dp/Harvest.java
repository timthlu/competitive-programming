import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Harvest {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		boolean[][] field = new boolean[n+1][m+1];
		int min = Integer.parseInt(input[2]);
		
		if (min == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		for (int i = 1; i <= m; i++) {
			String[] input2 = br.readLine().split(" ");
			int start = Integer.parseInt(input2[0]);
			int stop = Integer.parseInt(input2[1]);
			
			for (int j = start; j <= stop; j++) {
				field[j][i] = true; //true = empty, false = potato
			}
		}
		
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!field[i][j]) {
					dp[1][i]++;
				}
			}
			if (dp[1][i] >= min) {
				System.out.println(1);
				System.exit(0);
			}
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n-i+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[1][j+i-1];
				
				if (dp[i][j] >= min) {
					System.out.println(i);
					System.exit(0);
				}
				
			}
		}
		
		System.out.println(-1);
	}
}

//dp[width of tractor][starting from which row] = number of potatoes
