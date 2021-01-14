import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobsFavoriteNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int base = 3;
		while (true) {
			if (n < Math.pow(base,2 )) {
				break;
			} else {
				base++;
			}
		}
		
		if (base % 2 == 1) {
			base--;
		}
		System.out.println(n/2 - (base-1)/2);
	}
}