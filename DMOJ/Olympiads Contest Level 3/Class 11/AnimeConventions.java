import java.util.Scanner;

public class AnimeConventions {
	static int[] dis;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cities = scanner.nextInt();
		int queries = scanner.nextInt();
		dis = new int[cities+1];
		
		for (int i = 0; i <= cities; i++) {
			dis[i] = i;
		}
		
		for (int i = 0; i < queries; i++) {
			String c = scanner.next();
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			
			if (c.equals("A")) {
				dis[find(u)] = find(v);
			} else {
				if (find(u) == find(v)) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
			}
		}
	}
	public static int find(int x) {
		if (dis[x] != x) {
			dis[x] = find(dis[x]);
		}
		return dis[x];
	}
}