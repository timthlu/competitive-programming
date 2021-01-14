import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Golf {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		int clubs = Integer.parseInt(br.readLine());
		int[] c = new int[clubs];
		
		for (int i = 0; i < clubs; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < clubs; j++) {
				if (dp[i] != Integer.MAX_VALUE && i + c[j] <= n) {
					dp[i + c[j]] = Math.min(dp[i + c[j]], dp[i] + 1);
				}
			}
		}
		
		if (dp[n] == Integer.MAX_VALUE) {
			System.out.println("Roberta acknowledges defeat.");
		} else {
			System.out.println("Roberta wins in " + dp[n] + " strokes.");
		}
		
		
	}
}