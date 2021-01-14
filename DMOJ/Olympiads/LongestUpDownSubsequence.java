import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LongestUpDownSubsequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		int count = 0;
		int prev = 0; //1 is above, 2 is below
		for (int i = 0; i < n-1; i++) {
			int a1 = a[i];
			int a2 = a[i+1];
			
			if (prev == 1 && a2 > a1) {
				count++;
				prev = 2;
			} else if (prev == 2 && a2 < a1) {
				count++;
				prev = 1;
			} else if (prev == 0) {
				count++;
				
				if (a1 > a2) {
					prev = 1;
				} else {
					prev = 2;
				}
			}
		}
		
		System.out.println(count+1);
	}
}