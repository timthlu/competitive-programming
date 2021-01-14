import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class RoyalGuard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] px = new long[n];
		long[] py = new long[n];
		long seed = (long) 1e9;
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]); px[i] = x*seed + y; py[i] = y*seed + x;
		}
		Arrays.sort(px); Arrays.sort(py);
		int m = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int x0 = Integer.parseInt(input[0]);
		int y0 = Integer.parseInt(input[1]);
		long ans = 0;
		for (int i = 1; i < m; i++) {
			String[] input2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(input2[0]);
			int y1 = Integer.parseInt(input2[1]);
			if (y0 == y1) { //horizontal move
				int left = Arrays.binarySearch(py, y0*seed + Math.min(x0, x1)); //returns - insertionPoint - 1 if not found, where insertionPoint is first index after desired
				int right = Arrays.binarySearch(py, y0*seed + Math.max(x0, x1));
				
				if (left < 0) left = -left - 1; //desired = insertionPoint; -(-insertionPoint - 1) - 1 = insertionPoint
				if (right < 0) right = -right - 2; //desired = insertionPoint - 1; -(-insertionPoint - 1) - 2 = insertionPoint - 1
				ans += right - left + 1;
			} else { //vertical move
				int low = Arrays.binarySearch(px, x0*seed + Math.min(y0, y1));
				int high = Arrays.binarySearch(px, x0*seed + Math.max(y0, y1));
				
				if (low < 0) low = -low - 1;
				if (high < 0) high = -high - 2;
				ans += high - low + 1;
			}
			
			x0 = x1; y0 = y1;
		}
		
		System.out.println(ans);
	}
}