import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Stamp {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		if (m == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		input = br.readLine().split(" ");
		int[] a = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(a);
		
		ArrayList<Integer> gaps = new ArrayList<Integer>();
		
		int k = 0;
		if (a[0] != 1) {
			k = a[0] - 1;
			gaps.add(a[0] - 1);
		} else {
			k = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i < m; i++) {
			if (a[i] - a[i-1] - 1 != 0) {
				k = Math.min(k, a[i] - a[i-1] - 1);
				gaps.add(a[i] - a[i-1] - 1);
			}
		}
		
		if (n - a[m-1] != 0) {
			k = Math.min(k, n - a[m-1]);
			gaps.add(n - a[m-1]);
		}
		
		int count = 0;
		
		for (int i = 0; i < gaps.size(); i++) {
			//System.out.println(gaps.get(i));
			if (gaps.get(i) % k == 0) {
				count += gaps.get(i)/k;
			} else {
				count += gaps.get(i)/k + 1;
			}
		}
		
		System.out.println(count);
		
	}
}