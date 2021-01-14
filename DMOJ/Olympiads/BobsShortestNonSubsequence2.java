import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobsShortestNonSubsequence2 { 
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] a2 = new int[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a2[i] = Integer.parseInt(input[i]);
		}
		
		int val = n/m + 1;
		int[] a1 = new int[val*(m*2-1)];
		int curVal = 1;
		boolean goingDown = false;
		for (int i = 0; i < a1.length; i += val) {
			for (int j = 0; j < val; j++) {
				a1[i+j] = curVal;
			}
			
			if (goingDown) {
				curVal--;
			} else if (curVal == m) {
				goingDown = true;
				
				if (m > 1) {
					curVal--;
				}
			} else {
				curVal++;
			}
		}
		
		int[][] dp = new int[a1.length+1][a2.length+1];
		
		for (int i = 0; i <= a1.length; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 0; i <= a2.length; i++) {
			dp[0][i] = 1000000;
		}
		
		for (int i = 1; i <= a1.length; i++) {
			for (int j = 1; j <= a2.length; j++) {
				int index = -1;
				for (int k = j-1; k >= 0; k--) {
					if (a1[i-1] == a2[k]) {
						index = k;
						break;
					}
				}
				
				if (index == -1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][index] + 1);
				}
			}
		}
		
		System.out.println(dp[a1.length][a2.length]);
    }
}