import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobsShortestNonSubsequence { 
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] a2 = new int[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a2[i] = Integer.parseInt(input[i]);
		}
		
		int val = n/m + 1;
		int[] a1 = new int[val*(m*2-1)];
		int curVal = 1;
		boolean goingDown = false;
		for (int i = 0; i < a1.length; i += val) {
			for (int j = 0; j < val; j++) {
				a1[i+j] = curVal;
			}
			
			if (goingDown) {
				curVal--;
			} else if (curVal == m) {
				goingDown = true;
				
				if (m > 1) {
					curVal--;
				}
			} else {
				curVal++;
			}
		}
		
		int ans = solve(a1, a2);
		System.out.println(ans);
    }
	
	public static int solve(int[] a1, int[] a2) {
		if (a1.length == 0) {
			return 1000000;
		}
		
		if (a2.length <= 0) {
			return 1;
		}
		
		int index = -1;
		for (int i = 0; i < a2.length; i++) {
			if (a1[0] == a2[i]) {
				index = i;
				break;
			}
		}
		
		if (index == -1) {
			return 1;
		}
		
		int[] newa1 = new int[a1.length-1];
		for (int i = 0; i < newa1.length; i++) {
			newa1[i] = a1[i+1];
		}
		
		int[] newa2 = new int[a2.length-1-index];
		for (int i = 0; i < newa2.length; i++) {
			newa2[i] = a2[i+index+1];
		}
		
		return Math.min(solve(newa1, a2), 1 + solve(newa1, newa2));
	}
}