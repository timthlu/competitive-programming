import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Akvizna {
	static double[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		ArrayList<Integer>[] md = new ArrayList[K+1];
		for (int i = 0; i <= K; i++) {
			md[i] = new ArrayList<Integer>();
		}
		
		md[0].add(0);
		dp = new double[K+1][N+1];
		for (int k = 1; k <= K; k++) {
			md[k].add(k);
			for (int i = k; i <= N; i++) {
				while(md[k-1].size() >= 2 && slope(k-1, md[k-1].get(0), md[k-1].get(1)) >= 1.0/i) {
					md[k-1].remove(0);
				}
				
				int j = md[k-1].get(0);
				dp[k][i] = dp[k-1][j] + (double)(i-j)/i;
				
				while(md[k].size() >= 2 && slope(k, md[k].get(md[k].size()-2), md[k].get(md[k].size()-1)) <= slope(k, md[k].get(md[k].size()-1), i)) {
					md[k].remove(md[k].size()-1);
				}
				
				md[k].add(i);
			}
		}
		
		System.out.println(dp[K][N]);
	}
	public static double slope (int k, int p, int q) {
		return (double) (dp[k][q] - dp[k][p])/(q-p);
	}
}