import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.Arrays;

public class Golf {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goal = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] clubs = new int[n];
		for (int i = 0; i < n; i++) {
			clubs[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(clubs);
		
		int[] dp = new int[goal+1];
		for (int i = 1; i <= goal; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		while (dp[goal] == Integer.MAX_VALUE && !s.isEmpty()) {
			int curDis = s.pop();
			for (int i = 0; i < n; i++) {
				if (clubs[i] + curDis > goal) {
					continue;
				} else {
					dp[clubs[i] + curDis] = Math.min(dp[curDis] + 1, dp[clubs[i] + curDis]);
					s.push(clubs[i] + curDis);
				}
			}
		}
		
		if (dp[goal] == Integer.MAX_VALUE) {
			System.out.println("Roberta acknowledges defeat.");
		} else {
			System.out.println("Roberta wins in " + dp[goal] + " strokes.");
		}
	}
}
/*
dp[distance] = strokes;

*/