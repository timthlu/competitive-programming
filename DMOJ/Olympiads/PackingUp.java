import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class PackingUp {
	static long[] dp;
	static long[] psaLengths;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long l = Long.parseLong(input[1]);
		
		long[] lengths = new long[n+1];
		for (int i = 1; i <= n; i++) {
			lengths[i] = Long.parseLong(br.readLine());
		}
		
		psaLengths = new long[n+1];
		for (int i = 1; i <= n; i++) {
			psaLengths[i] = psaLengths[i-1] + lengths[i];
		}

		ArrayList<Integer> md = new ArrayList<Integer>();
		dp = new long[n+1];
		dp[1] = (long)Math.pow(lengths[1] - l, 2);
		
		md.add(1);
		for (int i = 2; i <= n; i++) {
			while (md.size() >= 2 && slope(md.get(0), md.get(1)) <= 2*(i+psaLengths[i]-l)) {
				md.remove(0);
			}
			
			dp[i] = dp[md.get(0)-1] + (long)Math.pow((i-md.get(0)) + psaLengths[i] - psaLengths[md.get(0)-1] - l, 2);
			
			while(md.size() >= 2 && slope(md.get(md.size()-2), md.get(md.size()-1)) >= slope(md.get(md.size()-1), i)) {
				md.remove(md.size()-1);
			}
			
			md.add(i);
		}
		
		System.out.println(dp[n]);
	}
	
	public static double slope(int j, int k) {
		return (double) ((dp[k-1]-dp[j-1])/(k+psaLengths[k-1]-j-psaLengths[j-1]))+j+psaLengths[j-1]+k+psaLengths[k-1];
	}
}