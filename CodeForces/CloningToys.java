import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CloningToys {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int copied = Integer.parseInt(input[0]);
		int original = Integer.parseInt(input[1]);
		
		if (original <= 0) {
			System.out.println("No");
		} else if (original == 1) {
			if (copied == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else {
			original--;
			copied -= original;
			
			if (copied % 2 == 0 && copied >= 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		
	}
}