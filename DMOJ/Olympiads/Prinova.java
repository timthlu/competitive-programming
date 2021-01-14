import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Prinova {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(input[i]);
		}
		
		Arrays.sort(a);
		
		input = br.readLine().split(" ");
		long min = Long.parseLong(input[0]);
		long max = Long.parseLong(input[1]);
		
		long dis = 0;
		long ans = 0;
		
		for (int i = 1; i < n; i++) {
			long attempt = (a[i] + a[i-1])/2;
			if (attempt <= max && attempt >= min) {
				if (attempt % 2 == 0 && attempt-1 >= min && attempt-1 <= max) {
					attempt--;
				} else if (attempt % 2 == 0 && attempt+1 >= min && attempt+1 <= max) {
					attempt++;
				}
				
				if (dis < Math.min(Math.min(max - attempt, attempt - min), Math.min(a[i] - attempt, attempt - a[i-1]))) {
					dis = Math.min(Math.min(max - attempt, attempt - min), Math.min(a[i] - attempt, attempt - a[i-1]));
					ans = attempt;
				}
			}
		}
		
		if (max > a[n-1]) {
			if (max % 2 == 0 && dis < max-1 - a[n-1]) {
				ans = max-1;
			} else if (max % 2 != 0 && dis < max - a[n-1]) {
				ans = max;
			}
		} else if (min < a[0]) {
			if (min % 2 == 0 && dis < a[0] - (min+1)) {
				ans = min+1;
			} else if (min % 2 != 0 && dis < a[0] - min) {
				ans = min;
			}
		}
		
		System.out.println(ans);
	}
}