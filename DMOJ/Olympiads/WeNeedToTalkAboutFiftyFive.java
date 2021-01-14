import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class WeNeedToTalkAboutFiftyFive {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pair[] a = new Pair[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			a[i] = new Pair(Long.parseLong(input[0]), Long.parseLong(input[1]));
		}
		
		Arrays.sort(a);
		
		int decayCount = 1;
		long ans = a[n-1].start;
		
		for (int i = n-2; i >= 0; i--) {
			ans += a[i].start - a[i].decay*(decayCount-1);
			decayCount++;
		}
		
		ans %= (long)Math.pow(10, 9) + 7;
		if (ans < 0) {
			ans += (long)Math.pow(10, 9) + 7;
		}
		System.out.println(ans);
	}
	
	static class Pair implements Comparable<Pair> {
		long start;
		long decay;
		
		public Pair(long start, long decay) {
			this.start = start;
			this.decay = decay;
		}
		
		public int compareTo(Pair p) {
			return (int) (decay - p.decay);
		}
	}
}
