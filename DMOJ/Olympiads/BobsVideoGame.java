import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class BobsVideoGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int t = Integer.parseInt(input[2]);
		
		int[][] adj = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			adj[u][v] = w;
		}
		
		for (int i = 0; i < t; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(u);
			
			int[] dis = new int[n+1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[u] = 0;
			
			while (!q.isEmpty()) {
				int cur = q.remove();
				
				for (int j = 1; j <= n; j++) {
					if (adj[cur][j] != 0) {
						q.add(j);
						dis[j] = Math.min(adj[cur][j], dis[j]);
					}
				}
			}
			
			if (dis[v] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dis[v]);
			}
		}
		
	}
}