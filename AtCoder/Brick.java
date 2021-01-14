import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Brick {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int ans = Integer.parseInt(input[0])/Integer.parseInt(input[1]);
		System.out.println(ans);
	}
}