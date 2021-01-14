import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class BobsShortestNonSubsequence3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		HashSet<String> hs = new HashSet<String>();
		int ans = 1;
		
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			hs.add(input[i]);
			
			if (hs.size() == m) {
				ans++;
				hs = new HashSet<String>();
			}
		}
		
		System.out.println(ans);
		
	}
}