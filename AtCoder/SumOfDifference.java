import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class SumOfDifference {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(a);
		
		long sum = 0;
		for (int i = n-1; i >= 0; i--) {
			sum += (long)i*a[i] - (long)(n-1-i)*a[i];
		}
		System.out.println(sum);
	}
}