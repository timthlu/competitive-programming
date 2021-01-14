import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ThirdPlace {
	static long n, farthestNode, length, ans;
	static ArrayList<Pair>[] adj;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[(int)n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Pair>();
		}
		
		for (int i = 1; i < n; i++) {
			String[] input = br.readLine().split(" ");
			long node1 = Long.parseLong(input[0]);
			long node2 = Long.parseLong(input[1]);
			long weight = Long.parseLong(input[2]);
			
			adj[(int)node1].add(new Pair(node2, weight));
			adj[(int)node2].add(new Pair(node1, weight));
		}
		
		long[] dis = new long[(int)n+1];
		bfs(1, dis);
		long point1 = farthestNode;
		bfs(point1, dis);
		long point2 = farthestNode;
		
		for (int i = 1; i <= n; i++) {
			if (i != point2) {
				ans = Math.max(ans, dis[i]);
			}
		}
		bfs(point2, dis);
		for (int i = 1; i <= n; i++) {
			if (i != point1) {
				ans = Math.max(ans, dis[i]);
			}
		}
		System.out.println(ans);
	}
	public static void bfs(long start, long[] dis) {
		boolean[] vis = new boolean[(int)n+1];
		Queue<Long> q = new LinkedList<>();
		q.add(start);
		vis[(int)start] = true;
		dis[(int)start] = 0;
		length = 0;
		
		while (!q.isEmpty()) {
			long currentNode = q.remove();
			if (dis[(int)currentNode] > length) {
				length = dis[(int)currentNode];
				farthestNode = currentNode;
			}
			
			for (Pair p: adj[(int)currentNode]) {
				if (!vis[(int)p.v]) {
					q.add(p.v);
					vis[(int)p.v] = true;
					dis[(int)p.v] = dis[(int)currentNode] + p.w;
				}
			}
		}
	}
	public static class Pair {
		long v, w;
		public Pair(long v, long w) {
			this.v = v;
			this.w = w;
		}
	}
}