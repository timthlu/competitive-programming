import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class DuodecimFerra {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n < 12) {
			System.out.println(0);
			System.exit(0);
		}
		
		BigInteger total = new BigInteger("1");
		n--;
		
		for (int i = n; i > n-11; i--) {
			total = total.multiply(new BigInteger(Integer.toString(i)));
		}
		
		for (int i = 11; i >= 2; i--) {
			total = total.divide(new BigInteger(Integer.toString(i)));
		}
		
		System.out.println(total);
	}
}