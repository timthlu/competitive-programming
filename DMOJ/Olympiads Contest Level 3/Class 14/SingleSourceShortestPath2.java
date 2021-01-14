import java.util.Scanner;
import java.util.Arrays;

public class SingleSourceShortestPath2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		
		int[][] adj = new int[vertices+1][vertices+1];
		
		for (int i = 0; i < edges; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			
			if (adj[u][v] > 0 && w < adj[u][v]) {
				adj[u][v] = w;
				adj[v][u] = w;
			} else if (adj[u][v] == 0) {
				adj[u][v] = w;
				adj[v][u] = w;
			}
		}
		
		int[] dis = new int[vertices+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		boolean[] vis = new boolean[vertices+1];
		dis[1] = 0;
		
		while(true) {
			int minDis = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 1; i <= vertices; i++) {
				if (!vis[i]) {
					if (dis[i] < minDis) {
						minDis = dis[i];
						minIndex = i;
					}
				}
			}
			
			if (minDis == Integer.MAX_VALUE) {
				break;
			}
			
			vis[minIndex] = true;
			
			for (int i = 1; i <= vertices; i++) {
				if (adj[minIndex][i] != 0 && minDis + adj[minIndex][i] < dis[i]) {
					dis[i] = minDis + adj[minIndex][i];
				}
			}
		}
		
		for (int i = 1; i <= vertices; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dis[i]);
			}
		}
	}
}