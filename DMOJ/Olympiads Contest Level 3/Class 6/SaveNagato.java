import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class SaveNagato {
	static int uniqueRanks = 0, people, farthestNode;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		people = Integer.parseInt(br.readLine());
		adj = new ArrayList[people+1];
		
		for (int i = 1; i < people+1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < people-1; i++) {
			String[] input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);
			
			adj[node1].add(node2);
			adj[node2].add(node1);
		}
		
		int[] dis = new int[people+1];
		bfs(1, dis);
		int p1 = farthestNode;
		int[] dis1 = new int[people+1];
		bfs(p1, dis1);
		int p2 = farthestNode;
		int[] dis2 = new int[people+1];
		bfs(p2, dis2);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for (int i = 1; i <= people; i++) {
			pw.println(Math.max(dis1[i], dis2[i]));
		}
		pw.close();
		
	}
	public static void bfs(int startNode, int[] dis) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[people+1];
		vis[startNode] = true;
		dis[startNode] = 1;
		q.add(startNode);
		
		int maxDis = 0;
		
		while (!q.isEmpty()) {
			int currentNode = q.remove();
			
			if (dis[currentNode] > maxDis) {
				maxDis = dis[currentNode];
				farthestNode = currentNode;
			}
			
			for (int i: adj[currentNode]) {
				if (!vis[i]) {
					q.add(i);
					dis[i] = dis[currentNode] + 1;
					vis[i] = true;
				}
			}
		}
		
		uniqueRanks = maxDis;
	}
}