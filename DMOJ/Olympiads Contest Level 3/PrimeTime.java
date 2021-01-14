import java.util.Scanner;

public class PrimeTime {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String s = " ABCDEFGHIJKLMNOPQRSTUVWXYZ.,!?";
		for (int i = 1; i <= 5; i++) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			long key;
			
			for (int j = 0; j < n; j++) {
				a[i] = scanner.nextLong();
			}
			
			key = a[0];
			for (int j = 2; j <= 3030; j++) {
				while (key % i == 0) key /= i;
			}
			String ans = "";
			for (int j = 0; j < n; j++) {
				a[i] /= key;
				int dl = (int)a[i]/100, d2 = (int)a[i]%100;
				ans = ans + s.charAt(d1) + s.charAt(d2);
			}
			System.out.println(ans);
		}
	}
}