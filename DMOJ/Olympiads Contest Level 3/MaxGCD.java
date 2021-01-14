import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaxGCD {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		if (n == 2) System.out.println(Math.max(num[0], num[1]));
		else {
			int max = 1;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, calculateGcd(num, i));
			}
			System.out.println(max);
		}
	}
	public static int calculateGcd(int[] num, int omitted) {
		int ans;
		if (omitted == 0) {
			ans = num[1];
			for (int i = 2; i < num.length; i++) {
				ans = gcd(ans, num[i]);
			}
		} else {
			ans = num[0];
			for (int i = 1; i < num.length; i++) {
				if (i == omitted) continue;
				else ans = gcd(ans, num[i]);
			}
		}
		return ans;
	}
	public static int gcd( int a, int b ) {
		while (b != 0) {
			final int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}