import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Race {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long k = Long.parseLong(input[0]);
		int n = Integer.parseInt(input[1]);
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (k <= (x + 1)*x/2) {
				long sum = 0;
				for (int j = 1; j <= x; j++) {
					sum += j;
					if (sum >= k) {
						System.out.println(j);
						break;
					}
				}
			} else {
				long newK = k - (x + 1)*x/2;
				long sum = 0;
				
				boolean yes = false;
				int count = 0;
				for (int j = x; j <= 1000000000; j++) {
					sum += j;
					count++;
					
					if (sum >= newK) {
						System.out.println(x + count);
						break;
					}
					
					if (yes) {
						j--;
						yes = false;
					} else {
						yes = true;
					}
				}
			}
		}
	}
}