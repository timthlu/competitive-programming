import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BloodTubes {
	static int[] bit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		bit = new int[n+1];
		
		long totalInv = 0;
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int curTube = Integer.parseInt(input[i]);
			
			//put on right of all tubes
			int right = sum(n) - sum(curTube);
			
			//put on left of all tubes
			int left = sum(curTube - 1);
			
			totalInv += Math.min(left, right);
			
			update(curTube, 1);
		}
		
		System.out.println(totalInv);
		
	}
	public static void update(int index, int val) {
		while (index < bit.length) {
			bit[index] += val;
			
			index += index & (-index);
		}
	}
	
	public static int sum(int index) {
		int sum = 0;
		
		while (index > 0) {
			sum += bit[index];
			
			index -= index & (-index);
		}
		
		return sum;
	}
}