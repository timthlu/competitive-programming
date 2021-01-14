import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Unlucky7 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = n;
		for (int i = 1; i <= n; i++) {
			boolean found = false;
			
			int curNum = i;
			while (curNum > 0) {
				if (curNum % 8 == 7) {
					count--;
					found = true;
					break;
				}
				curNum /= 8;
			}
			
			if (!found) {
				curNum = i;
				while (curNum > 0) {
					if (curNum % 10 == 7) {
						count--;
						break;
					}
					
					curNum /= 10;
				}
			}
			
			
		}
		
		System.out.println(count);
	}
}