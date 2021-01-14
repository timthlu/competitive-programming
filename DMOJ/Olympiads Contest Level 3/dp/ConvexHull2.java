import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class ConvexHull2 {
	public static void main(String[] args) { //2d dijkstra, dis[node][hull consumption] = min time, ans = destination node with best answer
		
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Edge>[] adj = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int t = scanner.nextInt();
			int h = scanner.nextInt();
			
			adj[u].add(new Edge(v, t, h));
			adj[v].add(new Edge(u, t, h));
		}
		
		int start = scanner.nextInt();
		int goal = scanner.nextInt();
		
		int[][] dis = new int[n+1][k];
		boolean[] vis = new boolean[n+1];
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(start, 0, 0));
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < k; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dis[start][0] = 0;
		vis[start] = true;
		
		while (!pq.isEmpty()) {
			Node node = pq.remove();
			int curNode = node.num;
			
			for (int i = 0; i < adj[curNode].size(); i++) {
				int nextNode = adj[curNode].get(i).des;
				int totalTime = node.time + adj[curNode].get(i).time;
				int totalHull = node.hull + adj[curNode].get(i).hull;
				
				if (totalHull < k && totalTime < dis[nextNode][totalHull]) {
					dis[nextNode][totalHull] = totalTime;
					pq.add(new Node(nextNode, totalTime, totalHull));
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			min = Math.min(min, dis[goal][i]);
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}
class Edge { //hull refers to hull consumption
	int des, time, hull;
	
	Edge (int des, int time, int hull) {
		this.des = des;
		this.time = time;
		this.hull = hull;
	}
}
class Node implements Comparable<Node> { //hull refers to hull consumption
	int num, time, hull;
	
	Node (int num, int time, int hull) {
		this.num = num;
		this.time = time;
		this.hull = hull;
	}
	
	public int compareTo (Node n) {
		return time - n.time;
	}
}