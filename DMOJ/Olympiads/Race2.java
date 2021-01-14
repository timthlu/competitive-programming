import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Race2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long k = Long.parseLong(input[0]);
		int n = Integer.parseInt(input[1]);
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			long y = (long) Math.floor(Math.sqrt((2*k + Math.pow(x, 2) - x)/2.0));
			
			long left = k - y*(y+1)/2 - (y+x-1)*(y-x)/2;
			long ans = y + y - x;
			
			if (left%y == 0) {
				System.out.println(left/y + ans);
			} else {
				System.out.println(left/y + 1 + ans);
			}
		}
	}
}