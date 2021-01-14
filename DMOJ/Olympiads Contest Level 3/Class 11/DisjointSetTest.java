import java.util.Scanner;
import java.util.ArrayList;

public class DisjointSetTest {
	static int[] dis;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		dis = new int[vertices+1];
		
		ArrayList<Integer> print = new ArrayList<Integer>();
		
		for (int i = 0; i <= vertices; i++) {
			dis[i] = -1;
		}
		
		int edgesCount = 0;
		for (int i = 0; i < edges; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			
			if (dis[u] == -1) {
				dis[u] = u;
			}
			if (dis[v] == -1) {
				dis[v] = v;
			}
			
			if (find(u) != find(v)) {
				dis[find(u)] = find(v);
				print.add(i + 1);
				
				edgesCount++;
			}
			
		}
		
		if (edgesCount != vertices - 1) {
			System.out.println("Disconnected Graph");
		} else {
			for (int i = 0; i < print.size(); i++) {
				System.out.println(print.get(i));
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