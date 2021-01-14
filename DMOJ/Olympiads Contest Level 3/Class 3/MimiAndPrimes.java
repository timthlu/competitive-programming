import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MimiAndPrimes {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		String[] line = input.split(" ");
		
		long[] array = new long[num];
		for (int i = 0; i < num; i++) {
			array[i] = Long.parseLong(line[i]);
		}
		
		while (array.length > 1) {
			long[] temp = new long[array.length-1];
		
			for (int i = 0; i < array.length-1; i++) {
				temp[i] = EuclideanAlgorithm(array[i], array[i+1]);
			}
			
			array = temp;
		}
		
		long gcd = array[0];
		if (gcd == 1) {
			System.out.println("DNE");
		} else {
			boolean printed = false;
			for (int i = 2; i < gcd; i++) {
				if (gcd % i == 0) {
					gcd = gcd / i;
					i--;
				}
				
				if (gcd == 1) {
					System.out.println(i);
					printed = true;
					break;
				}
			}
			
			if (!printed) {
				System.out.println(gcd);
			}
		}
		
	}
	
	public static long EuclideanAlgorithm(long a, long b) {
		while (a != b) {
			if (a == 1 || b == 1) {
				a = 1;
				break;
			}
			
			if (a > b) {
				if (a % b == 0) {
					a = b;
				} else {
					a = a % b;
				}
			} else {
				if (b % a == 0) {
					b = a;
				} else {
					b = b % a;
				}
			}
		}
		
		return a;
	}
}