import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TooSpooky4Me {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int S = Integer.parseInt(input[2]);
		
		int[] array = new int[L+1];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]);
			
			array[a] += s;
			
			if (b != array.length-1) {
				array[b+1] -= s;
			}
		}
		
		int curSum = 0;
		int ans = 0;
		for (int i = 1; i <= L; i++) {
			curSum += array[i];
			if (curSum < S) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}