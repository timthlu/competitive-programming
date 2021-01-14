import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GoodNumbers {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			String base3 = "";
			
			int q = x/3;
			int r = x%3;
			base3 = Integer.toString(r);
			while (q != 0) {
				r = q%3;
				base3 = Integer.toString(r) + base3;
				q /= 3;
			}
			
			//System.out.println(base3);
			
			int ans = x;
			boolean invalid = false;
			int firstZero = -1;
			boolean findFirstZero = false;
			boolean foundFirstZero = false;
			for (int j = base3.length()-1; j >= 0; j--) {
				if (base3.charAt(j) == '2') {
					invalid = true;
					findFirstZero = true;
					foundFirstZero = false;
					firstZero = -1;
				} else if (base3.charAt(j) == '0' && !foundFirstZero && findFirstZero) {
					firstZero = j;
					foundFirstZero = true;
				}
			}
			
			if (invalid) {
				ans += (int) Math.pow(3, base3.length()-firstZero-1);
				
				for (int j = firstZero+1; j < base3.length(); j++) {
					ans -= (int) Math.pow(3, base3.length()-j-1)*Integer.parseInt(base3.substring(j, j+1));
				}
			}
			
			System.out.println(ans);
		}
	}
}