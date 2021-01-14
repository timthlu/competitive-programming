import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HelloOfficer {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int houses = Integer.parseInt(input1[0]);
		int roads = Integer.parseInt(input1[1]);
		int destination = Integer.parseInt(input1[2]);
		int queries = Integer.parseInt(input1[3]);
		ArrayList<Edge> adj[] = new ArrayList[houses+1];
		
		for (int i = 0; i <= houses; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < roads; i++) {
			String[] input2 = br.readLine().split(" ");
			int u = Integer.parseInt(input2[0]);
			int v = Integer.parseInt(input2[1]);
			int w = Integer.parseInt(input2[2]);
			
			adj[u].add(new Edge(v, w));
			adj[v].add(new Edge(u, w));
		}
		
		for (int i = 0; i < queries; i++) {
			int start = Integer.parseInt(br.readLine());
			
			int[] dis = new int[houses+1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[start] = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			pq.add(new Edge(start, 0));
			
			while (!pq.isEmpty()) {
				int n = pq.peek().node;
				int w = pq.peek().weight;
				pq.poll();
				
				if (w > dis[n]) {
					continue;
				}
				
				for (Edge e: adj[n]) {
					if (dis[e.node] > dis[n] + e.weight) {
						dis[e.node] = dis[n] + e.weight;
						pq.add(new Edge(e.node, dis[e.node]));
					}
				}
			}
			
			if (dis[destination] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dis[destination]);
			}
		}
	}
	public static class Edge implements Comparable<Edge> {
		int node;
		int weight;
		
		Edge (int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		
		public int compareTo(Edge x) {
			return weight - x.weight;
		}
	}
}