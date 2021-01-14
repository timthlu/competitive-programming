import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Akvizna2 {
	static double[] dp;
	static int N, K;
	static int[] count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		dp = new double[N+1];
		count = new int[N+1];
		
		double lo = 0.0;
		double hi = 1.0;
		
		for (int i = 0; i < 40; i++) {
			double mid = (lo + hi)/2;
			if (check(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		
		System.out.println(dp[N] + lo*K);
	}
	
	public static double slope (int p, int q) {
		return (double) (dp[q] - dp[p])/(q-p);
	}
	
	public static boolean check (double mid) {
		ArrayList<Integer> md = new ArrayList<Integer>();
		md.add(0);
		for (int i = 1; i <= N; i++) {
			while (md.size() >= 2 && slope(md.get(0), md.get(1)) >= (double)1.0/i) {
				md.remove(0);
			}
			
			dp[i] = dp[md.get(0)] + (double)(i - md.get(0))/i - mid;
			count[i] = count[md.get(0)] + 1;
			
			while (md.size() >= 2 && slope(md.get(md.size()-2), md.get(md.size()-1)) <= slope(md.get(md.size()-1), i)) {
				md.remove(md.size()-1);
			}
			md.add(i);
		}
		
		return count[N] > K;
	}
}