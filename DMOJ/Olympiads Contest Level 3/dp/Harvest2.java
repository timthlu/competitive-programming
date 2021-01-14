import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Harvest2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int min = Integer.parseInt(input[2]);
		int[] pda = new int[n+1];
		
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
		
		int[] potatoesPerRow = new int[n+1];
		potatoesPerRow[1] = m + pda[1];
		for (int i = 2; i <= n; i++) {
			potatoesPerRow[i] = potatoesPerRow[i-1] + pda[i];
		}
		
		for (int i = 1; i <= n; i++) {
			if (potatoesPerRow[i] >= min) {
				System.out.println(1);
				System.exit(0);
			}
		}
		
		int sol = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) { //i = starting row
			int[] psa = new int[n-i+2];
			psa[1] = potatoesPerRow[i];
			
			for (int j = 2; j <= n-i+1; j++) { //parse downwards, j = width
				psa[j] = psa[j-1] + potatoesPerRow[j+i-1];
				
				if (psa[j] >= min) {
					sol = Math.min(sol, j);
				}
			}
		}
		
		if (sol == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(sol);
	}
}