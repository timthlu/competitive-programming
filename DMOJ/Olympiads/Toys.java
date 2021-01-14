import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Arrays;

public class Toys {
	static HashSet<Integer> sols = new HashSet<Integer>();
	static int[] a = new int[1000000];
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		solve(n, 2, 0);
		Arrays.sort(a);
		
		System.out.println(sols.size());
		for (int i = 0; i < sols.size(); i++) {
			System.out.print(a[i] + " ");
		} System.out.println();
	}
	
	public static void solve(int cur, int fact, int sum) {
		int size = sols.size();
		sols.add(sum + cur - 1);
		
		if (sols.size() != size) {
			a[count] = sum + cur - 1;
			count++;
		}
		
		for (int i = fact; i*i <= cur; i++) {
			if (cur % i == 0) {
				solve(cur/i, i, sum + i - 1);
			}
		}
	}
}