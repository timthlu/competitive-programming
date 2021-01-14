import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SmartphoneAddiction {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int nCopy = n;
		int m = Integer.parseInt(input[1]);
		int t = Integer.parseInt(input[2]);
		
		int curTime = 0;
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			n -= a - curTime;
			
			if (n <= 0) {
				System.out.println("No");
				System.exit(0);
			}
			
			n += (b - a);
			n = Math.min(nCopy, n);
			
			curTime = b;
		}
		
		n -= t - curTime;
		
		if (n <= 0) {
			System.out.println("No");
			System.exit(0);
		}
		
		System.out.println("Yes");
	}
}