import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class KingOfThieves {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String map = br.readLine();
		
		int maxGap = (int) Math.floor((n - 5)/4);
		//System.out.println(maxGap);
		
		for (int i = 0; i <= maxGap; i++) {
			int maxRunSpace = i*4+5;
			
			for (int j = 0; j <= n - maxRunSpace; j++) { //starting platform
				if (map.charAt(j) == '.') {
					continue;
				} else {
					boolean possible = true;
					for (int k = j+i+1; k < j + maxRunSpace; k += i+1) {
						if (map.charAt(k) == '.') {
							possible = false;
							break;
						}
					}
					
					if (possible) {
						System.out.println("yes");
						System.exit(0);
					}
				}
			}
		}
		
		System.out.println("no");
	}
}