import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class Roads {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		
		PriorityQueue<Edge> pq1 = new PriorityQueue<Edge>(); //w = 0 --> cobblestone, w = 1 --> concrete
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			Edge e = new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), -Integer.parseInt(input[2])); //give concrete priority first
			pq1.add(e);
		}
		
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pq2 = new PriorityQueue<Edge>(); //-1: important cobblestone, 0: cobblestone, 1: concrete
		Queue<Edge> ans = new LinkedList();
		
		//first kruskals
		int countAll = 0;
		int countCobble = 0;
		while(!pq1.isEmpty() && countAll < n) {
			Edge curEdge = pq1.remove();
			if (find(curEdge.u) != find(curEdge.v)) {
				union(curEdge.u, curEdge.v);
				if (curEdge.w == 0) { //important cobblestone edge
					Edge newEdge = new Edge(curEdge.u, curEdge.v, curEdge.w, -1);
					pq2.add(newEdge);
					countCobble++;
				} else { //used concrete edge
					Edge newEdge = new Edge(curEdge.u, curEdge.v, curEdge.w, -curEdge.pri);
					pq2.add(newEdge);
				}
				
				
				ans.add(curEdge);
				countAll++;
			} else {
				Edge newEdge = new Edge(curEdge.u, curEdge.v, curEdge.w, -curEdge.pri);
				pq2.add(newEdge);
			}
		}
		
		if (countAll < n-1 || countCobble > k) { //we cannot get spanning tree or more than k necessary cobblestone edges
			System.out.println("no solution");
		} else if (countCobble == k) { //if exactly k necessary cobblestone edges
			while (!ans.isEmpty()) {
				Edge e = ans.remove();
				System.out.println(e.u + " " + e.v + " " + e.w);
			}
		} else {
			ans = new LinkedList();
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			//second kruskals
			countCobble = 0;
			while (!pq2.isEmpty()) {
				Edge curEdge = pq2.remove();
				if (curEdge.w == 0 && countCobble >= k) {
					continue;
				} else {
					if (find(curEdge.u) != find(curEdge.v)) {
						union(curEdge.u, curEdge.v);
						
						if (curEdge.w == 0) {
							countCobble++;
						}
						
						ans.add(curEdge);
					}
				}
			}
			
			if (countCobble < k) {
				System.out.println("no solution");
			} else {
				while (!ans.isEmpty()) {
					Edge e = ans.remove();
					System.out.println(e.u + " " + e.v + " " + e.w);
				}
			}
		}
		
	}
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int w;
		int pri;
		
		public Edge(int u, int v, int w, int pri) {
			this.u = u;
			this.v = v;
			this.w = w;
			this.pri = pri;
		}
		
		public int compareTo(Edge e) {
			return pri - e.pri;
		}
	}
	
	public static int find(int i) {
		if (parent[i] == i) {
			return i;
		} else {
			int result = find(parent[i]);
			parent[i] = result;
			return result;
		}
	}
	
	public static void union(int i, int j) {
		int irep = find(i);
		int jrep = find(j);
		parent[irep] = jrep;
	}
}