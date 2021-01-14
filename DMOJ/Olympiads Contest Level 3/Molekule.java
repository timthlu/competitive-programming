import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Molekule {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scanner = new Scanner(System.in);
		int nodes = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj = new ArrayList[nodes+1];
		int[][] connections = new int[nodes-1][2];
		for (int i = 1; i <= nodes; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < nodes-1; i++) {
			String[] input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			adj[u].add(v);
			adj[v].add(u);
			connections[i][0] = u;
			connections[i][1] = v;
		}
		
		int[] dis = new int[nodes+1];
		boolean[] vis = new boolean[nodes+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		vis[1] = true;
		while (!q.isEmpty()) {
			int curNode = q.remove();
			for (int i = 0; i < adj[curNode].size(); i++) {
				int nextNode = adj[curNode].get(i);
				if (!vis[nextNode] && nextNode != curNode) {
					q.add(nextNode);
					vis[nextNode] = true;
					dis[nextNode] = dis[curNode] + 1;
				}
			}
		}
		
		for (int i = 0; i < nodes-1; i++) {
			if (dis[connections[i][0]] % 2 == 0 && dis[connections[i][1]] % 2 != 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}