import java.util.Scanner;

public class SafeFromRooks {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int a = 0; a < 5; a++) {
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooks = scanner.nextInt();
			
			boolean[] r = new boolean[rows+1];
			boolean[] c = new boolean[cols+1];
			for (int i = 0; i < rooks; i++) {
				r[scanner.nextInt()] = true;
				c[scanner.nextInt()] = true;
			}
			
			int countR = 0;
			int countC = 0;
			for (int i = 1; i <= rows; i++) {
				if (!r[i]) countR++;
			}
			for (int i = 1; i <= cols; i++) {
				if (!c[i]) countC++;
			}
			
			System.out.println(countR*countC);
		}
	}
}