import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class BobsJumping {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int x = Integer.parseInt(input[2]);
		
		int[] heights = new int[n+1];
		for (int i = 1; i <= n; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] adj = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				adj[i][j] = -1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int t = Integer.parseInt(input[2]);
			
			adj[u][v] = t;
			adj[v][u] = t;
		}
		
		Queue<State> q = new LinkedList();
		q.add(new State(1, x, 0, 0));
		int ans = Integer.MAX_VALUE;
		boolean[] vis = new boolean[n+1];
		while(!q.isEmpty()) {
			State cur = q.remove();
			
			if (cur.tree == n) {
				ans = Math.min(ans, cur.time + heights[n] - cur.height);
			} else {
				//climb up current tree
				if (cur.height < heights[cur.tree]) {
					for (int i = 1; i <= n; i++) {
						if (adj[cur.tree][i] != -1 && cur.tree != i && !vis[i] && cur.height - adj[cur.tree][i] < 0 && heights[cur.tree] - adj[cur.tree][i] <= heights[i]) {
							q.add(new State(cur.tree, heights[i] + adj[cur.tree][i], cur.jumps, cur.time + heights[i] + adj[cur.tree][i] - cur.height));
						}
					}
				}
				
				//climb down current tree
				if (cur.height > 0) {
					for (int i = 1; i <= n; i++) {
						if (adj[cur.tree][i] != -1 && cur.tree != i && !vis[i] && cur.height - adj[cur.tree][i] > heights[i] && heights[i] + adj[cur.tree][i] <= heights[cur.tree]) {
							q.add(new State(cur.tree, heights[i] + adj[cur.tree][i], cur.jumps, cur.time + cur.height - heights[i] - adj[cur.tree][i]));
						}
					}
				}
				
				//jump to another tree
				if (cur.jumps < m) {
					for (int i = 1; i <= n; i++) {
						if (adj[cur.tree][i] != -1 && cur.tree != i && !vis[i] && cur.height - adj[cur.tree][i] <= heights[i] && cur.height - adj[cur.tree][i] >= 0) {
							q.add(new State(i, cur.height - adj[cur.tree][i], cur.jumps+1, cur.time + adj[cur.tree][i]));
							vis[i] = true;
						}
					}
				}
			}
		}
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	
	static class State {
		int height;
		int tree;
		int jumps;
		int time;
		
		public State(int tree, int height, int jumps, int time) {
			this.tree = tree;
			this.height = height;
			this.jumps = jumps;
			this.time = time;
		}
	}
}