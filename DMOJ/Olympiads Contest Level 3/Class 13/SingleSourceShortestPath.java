import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//dijkstra's algorithm
//select node that has not been visited yet, and has the shortest distance so far
//update the distances of all nodes that it goes to
//repeat until all nodes are visited

public class SingleSourceShortestPath {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		ArrayList<Edge> adj[] = new ArrayList[vertices+1];
		
		for (int i = 0; i <= vertices; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		
		for (int i = 1; i <= edges; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			
			adj[u].add(new Edge(v, w));
			adj[v].add(new Edge(u, w));
		}
		
		int dis[] = new int[vertices+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dis[1] = 0;
		pq.add(new Edge(1, 0));
		
		while (!pq.isEmpty()) {
			int u = pq.peek().v;
			int d = pq.peek().w;
			pq.poll();
			
			if (d > dis[u]) {
				continue;
			}
			
			for (Edge e: adj[u]) {
				if (dis[e.v] > dis[u] + e.w) {
					dis[e.v] = dis[u] + e.w;
					pq.add(new Edge(e.v, dis[e.v]));
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
	public static class Edge implements Comparable<Edge> {
		int v, w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(Edge x) {
			return w - x.w;
		}
	}
}