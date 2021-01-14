import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Frog3 {
	static long[] dp;
	static long[] h;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long c = Long.parseLong(input[1]);
		
		dp = new long[n+1];
		h = new long[n+1];
		ArrayList<Integer> q = new ArrayList<Integer>(); //using arraylist as monotonic deque
		
		input = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			h[i] = Long.parseLong(input[i-1]);
		}
		
		dp[1] = 0;
		q.add(1);
		for (int i = 2; i <= n; i++) {
			while (q.size() >= 2 && slope(q.get(0), q.get(1)) <= h[i]) {
				q.remove(0);
			}
			
			dp[i] = dp[q.get(0)] + (h[i] - h[q.get(0)])*(h[i] - h[q.get(0)]) + c;
			
			while (q.size() >= 2 && slope(q.get(q.size()-2), q.get(q.size()-1)) >= slope(q.get(q.size()-1), i)) {
				q.remove(q.size()-1);
			}
			q.add(i);
		}
		
		System.out.println(dp[n]);
	}
	
	public static double slope(int j, int k) {
		return (double) (dp[k] + h[k]*h[k] - dp[j] - h[j]*h[j])/(2.0*(h[k] - h[j]));
	}
}