import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ChooseYourOwnPath {

	static int shortestNode = 0;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int pages = scanner.nextInt();
		Queue<Integer> q = new LinkedList();
		boolean[][] adj = new boolean[pages][pages];
		boolean[] vis = new boolean[pages];
		int[] dis = new int[pages];
		
		for (int i = 0; i < pages; i++) {
			for (int j = 0; j < pages; j++) {
				adj[i][j] = false;
			}
			vis[i] = false;
			dis[i] = 0;
		}
		
		for (int i = 0; i < pages; i++) {
			int choices = scanner.nextInt();
			for (int j = 0; j < choices; j++) {
				adj[i][scanner.nextInt()-1] = true;
			}
		}
		
		q.add(0);
		vis[0] = true;
		dis[0] = 1;
		boolean everythingReachable = bfs(q, adj, vis, dis);
		
		if (everythingReachable) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		
		System.out.println(dis[shortestNode]);
	}
	public static boolean bfs(Queue<Integer> q, boolean[][] adj, boolean[] vis, int[] dis) {
		boolean shortestFound = false;
		
		while (!q.isEmpty()) {
			int currentNode = q.remove();
			
			boolean ending = true;
			for (int i = 0; i < adj[currentNode].length; i++) {
				if (adj[currentNode][i] && !vis[i]) {
					q.add(i);
					vis[i] = true;
					ending = false;
					dis[i] = dis[currentNode]+1;
				} else if (adj[currentNode][i] && vis[i]) {
					ending = false;
				}
			}
			
			if (ending && !shortestFound) {
				shortestFound = true;
				shortestNode = currentNode;
			}
		}
		
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				return false;
			}
		}
		return true;
	}
}