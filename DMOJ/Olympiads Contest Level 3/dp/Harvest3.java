import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Harvest3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		long min = Long.parseLong(input[2]);
		long[] pda = new long[n+1];
		
		if (min == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		for (int i = 1; i <= m; i++) {
			String[] input2 = br.readLine().split(" ");
			
			int start = Integer.parseInt(input2[0]);
			int stop = Integer.parseInt(input2[1]);
			pda[start]--;
			if (stop < n) {
				pda[stop+1]++;
			}
		}
		
		long[] potatoesPerRow = new long[n+1];
		potatoesPerRow[1] = m + pda[1];
		long[] psa = new long[n+1];
		psa[1] = potatoesPerRow[1];
		for (int i = 2; i <= n; i++) {
			potatoesPerRow[i] = potatoesPerRow[i-1] + pda[i];
			psa[i] = psa[i-1] + potatoesPerRow[i];
		}
		
		if (psa[n] < min) {
			System.out.println(-1);
			System.exit(0);
		}
		
		int top = 1;
		int bottom = 1;
		int sol = n;
		while (bottom <= n) {
			if (psa[bottom] - psa[top-1] >= min) {
				sol = Math.min(sol, bottom - top + 1);
				top++;
			} else {
				bottom++;
			}
		}
		
		System.out.println(sol);
	}
}