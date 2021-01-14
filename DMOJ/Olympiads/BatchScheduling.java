import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BatchScheduling {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		
		int[] sumT = new int[n+1];
		int[] sumF = new int[n+1];
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");
			sumT[i] = Integer.parseInt(input[0]);
			sumF[i] = Integer.parseInt(input[1]);
		}
		
		for (int i = n-1; i >= 1; i--) {
			sumT[i] += sumT[i+1];
			sumF[i] += sumF[i+1];
		}
		
		int[] dp = new int[n+2];
		dp[n+1] = 0;
		int last = n+1;
		for (int i = n; i >= 1; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = last; j > i; j--) {
				dp[i] = Math.min(dp[j] + (s + sumT[j] - sumT[i])*sumF[j], dp[i]);
			}
		}
		
		System.out.println(dp[n]);
	}
}