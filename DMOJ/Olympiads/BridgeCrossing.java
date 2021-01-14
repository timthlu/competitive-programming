import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BridgeCrossing {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n];
		int[] groups = new int[n];
		
		String[] names = new String[n];
		int[] times = new int[n];
		
		for (int i = 0; i < n; i++) {
			names[i] = br.readLine();
			times[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = times[0];
		groups[0] = 1;
		
		for (int i = 1; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= m && i-j+1>=0; j++) { //group of size j starting from i, including i
				int max = times[i];
				for (int k = i-1; k > i-j; k--) {
					max = Math.max(times[k], max);
				}
				
				if (i-j < 0) {
					if (max < dp[i]) {
						groups[i] = j;
					}
					
					dp[i] = Math.min(dp[i], max);
				} else {
					if (dp[i-j] + max < dp[i]) {
						groups[i] = j;
					}
					
					dp[i] = Math.min(dp[i], dp[i-j] + max);
				}
			}
		}
		
		String ans = "";
		int index = n-1;
		while (index >= 0) {
			for (int i = index; i > index - groups[index]; i--) {
				ans = " " + names[i] + ans;
			}
			ans = "\n" + ans.trim();
			
			index -= groups[index];
		}
		
		System.out.println("Total Time: " + dp[n-1] + ans);
	}
}