import java.util.Scanner;
import java.util.Stack;

public class RunningInCircles {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			int n = scanner.nextInt();
			
			boolean[][] adj = new boolean[n*2][n*2];
			int[] vis = new int[n*2];
			int[] length = new int[n*2];
			
			for (int j = 0; j < n*2; j++) {
				for (int k = 0; k < n*2; k++) {
					adj[j][k] = false;
				}
				vis[j] = 0;
				length[j] = 0;
			}
			
			for (int j = 0; j < n; j++) {
				int fromHere = scanner.nextInt();
				int toHere = scanner.nextInt();
				
				adj[fromHere-1][toHere-1] = true;
			}
			
			Stack<Integer> s = new Stack<Integer>();
			s.push(0);
			vis[0] = 1;
			System.out.println(dfsLengthOfCycle(s, adj ,vis, length));
		}
	}
	public static int dfsLengthOfCycle(Stack<Integer> s, boolean[][] adj, boolean[] vis, int[] length) {
		while (!s.isEmpty()) {
			int currentNode = s.pop();
			
			boolean somethingAdded = false;
			for (int i = 0; i < adj.length; i++) {
				if (adj[currentNode][i] && vis[i] == 0) {
					s.push(i);
					vis[i] = 1;
					somethingAdded = true;
					length[i] = length[currentNode] + 1;
				} else if (adj[currentNode][i] && vis[i] == 1) {
					return length[currentNode] + 1;
				}
			}
			
			if (!somethingAdded) {
				vis[currentNode] = 2;
			}
		}
		return -1;
	}
}