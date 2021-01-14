import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DrazilAndHisHappyFriends {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int boys = Integer.parseInt(input[0]);
		int girls = Integer.parseInt(input[1]);
		
		int gcd = calcGCD(boys, girls);
		
		if (gcd == 1) {
			System.out.println("Yes");
		} else {
			input = br.readLine().split(" ");
			int[] happyBoys = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				happyBoys[i] = Integer.parseInt(input[i]);
			}
			
			input = br.readLine().split(" ");
			int[] happyGirls = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				happyGirls[i] = Integer.parseInt(input[i]);
			}
			
			for (int i = 0; i < gcd; i++) {
				boolean found = false;
				for (int j = 0; j < happyBoys[0]; j++) {
					if ((happyBoys[j+1]-i) % gcd == 0) {
						found = true;
					}
				}
				
				for (int j = 0; j < happyGirls[0]; j++) {
					if ((happyGirls[j+1]-i) % gcd == 0) {
						found = true;
					}
				}
				
				if (!found) {
					System.out.println("No");
					System.exit(0);
				}
			}
			
			System.out.println("Yes");
		}
	}
	public static int calcGCD(int x, int y) {
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		} else {
			if (x >= y) {
				return calcGCD(x%y, y);
			} else {
				return calcGCD(y%x, x);
			}
		}
	}
}