import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MartianDNA {
	
	static int[] obsFreq;
	static int[] expFreq;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int r = Integer.parseInt(input[2]);
		
		int[] dna = new int[n];
		obsFreq = new int[k];
		expFreq = new int[k];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			dna[i] = Integer.parseInt(input[i]);
		}
		
		for (int i = 0; i < r; i++) {
			input = br.readLine().split(" ");
			expFreq[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
		}
		
		int left = 0;
		int right = 0;
		obsFreq[dna[0]]++;
		int ans = Integer.MAX_VALUE;
		while (true) {
			while(!check() && right <= n-2) {
				obsFreq[dna[right+1]]++; 
				right++;
			}
			
			if (right == n-1 && left == 0 && !check()) {
				System.out.println("impossible");
				System.exit(0);
			}
			
			while (check() && left < right) {
				obsFreq[dna[left]]--;
				left++;
			}
			
			ans = Math.min(ans, right - left + 2);
			
			if (right == n-1) {
				break;
			}
		}
		
		System.out.println(ans);
	}
	public static boolean check() {
		for (int i = 0; i < obsFreq.length; i++) {
			if (obsFreq[i] < expFreq[i]) {
				return false;
			}
		}
		
		return true;
	}
}