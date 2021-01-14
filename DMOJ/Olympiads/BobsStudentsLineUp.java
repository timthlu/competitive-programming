import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobsStudentsLineUp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] l = new int[n];
		int[] r = new int[n];

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'L' && i != n-1) {
				l[i+1] = l[i] + 1;
			} else if (i != n-1) {
				l[i+1] = l[i];
			}
			
			if (s.charAt(n-i-1) == 'R' && i != n-1) {
				r[n-i-2] = r[n-i-1] + 1;
			} else if (i != n-1) {
				r[n-i-2] = r[n-i-1];
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, l[i] + r[i]);
		}
		
		System.out.println(ans);
	}
}