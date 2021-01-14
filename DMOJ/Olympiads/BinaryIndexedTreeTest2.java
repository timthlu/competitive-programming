import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BinaryIndexedTreeTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] a = new int[n+1];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i+1] = Integer.parseInt(input[i]);
		}
		
		long[] bit = new long[n+1];
		long[] freqBit = new long[100001];
		for (int i = 1; i <= n; i++) {
			update(bit, i, a[i]);
			update(freqBit, a[i], 1);
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			String s = input[0];
			
			if (s.equals("C")) {
				update(bit, Integer.parseInt(input[1]), -a[Integer.parseInt(input[1])]);
				update(bit, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
				
				update(freqBit, a[Integer.parseInt(input[1])], -1);
				update(freqBit, Integer.parseInt(input[2]), 1);
				
				a[Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
				
			} else if (s.equals("S")) {
				System.out.println(sum(bit, Integer.parseInt(input[2])) - sum(bit, Integer.parseInt(input[1]) - 1));
			} else {
				System.out.println(sum(freqBit, Integer.parseInt(input[1])));
			}
		}
	}
	
	public static void update(long[] array, int index, int val) {
		while (index < array.length) {
			array[index] += val;
			
			index += index & (-index);
		}
	}
	
	public static long sum(long[] array, int index) {
		long sum = 0;
		
		while (index > 0) {
			sum += array[index];
			
			index -= index & (-index);
		}
		
		return sum;
	}
}