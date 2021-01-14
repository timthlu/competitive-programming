import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class DealingWithKnots {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int strings = scanner.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[1001];
		
		for (int i = 0; i < strings; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			adj[a] = new ArrayList<Integer>();
			adj[a].add(b);
		}
		
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[1001];
		q.add(start);
		
		while (!q.isEmpty()) {
			int currentNode = q.remove();
			vis[currentNode] = true;
			
			if (adj[currentNode].get(0) == end) {
				System.out.println("Tangled");
				System.exit(0);
			} else if (!vis[adj[currentNode].get(0)]) {
				q.add(adj[currentNode].get(0));
			}
		}
		
		System.out.println("Not Tangled");
	}
}