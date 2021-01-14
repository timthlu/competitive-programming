import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Race3 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			long dis = 0;
			long count = 0;
			
			for (long j = 1; true; j++) {
				dis += j;
				count++;
				
				if (dis >= k) {
					break;
				}
				
				if (j >= x) {
					dis += j;
					count++;
					
					if (dis >= k) {
						break;
					}
				}
			}
			
			System.out.println(count);
		}
	}
}