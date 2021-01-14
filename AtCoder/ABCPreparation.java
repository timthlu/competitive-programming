import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ABCPreparation {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int ans = Integer.parseInt(input[0]);
		
		for (int i = 1; i < 4; i++) {
			ans = Math.min(ans, Integer.parseInt(input[i]));
		}
		
		System.out.println(ans);
	}
}