import java.util.Scanner;

public class WishUponAStar {
	static int[] p;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int count = 0;
		p = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		for (int i = 1; i <= m; i++) {
			int fx = find(scanner.nextInt()), fy = find(scanner.nextInt());
			if (fx != fy) p[fx] = fy;
			else count++;
		}
		
		if (count > 1) System.out.println("NO");
		else System.out.println("YES");
	}
	public static int find(int n) {
		if (p[n] != n) p[n] = find(p[n]);
		
		return p[n];
	}
}