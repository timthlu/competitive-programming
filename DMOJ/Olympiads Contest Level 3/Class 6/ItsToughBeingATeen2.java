import java.util.Scanner;
import java.util.ArrayList;

public class ItsToughBeingATeen2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer>[] adj = new ArrayList[8];
		int[] inDeg = new int[8];
		for (int i = 1; i < 8; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		adj[1].add(7);
		adj[1].add(4);
		adj[2].add(1);
		adj[3].add(4);
		adj[3].add(5);
		
		inDeg[7] = 1;
		inDeg[4] = 2;
		inDeg[1] = 1;
		inDeg[5] = 1;
		
		int before = scanner.nextInt();
		int after = scanner.nextInt();
		while (before != 0 && after != 0) {
			adj[before].add(after);
			inDeg[after] = inDeg[after] + 1;
			
			before = scanner.nextInt();
			after = scanner.nextInt();
		}
		
		String ans = "";
		boolean changed = true;
		boolean[] vis = new boolean[8];
		
		while (changed) {
			changed = false;
		
			for (int i = 1; i < 8; i++) {
				if (inDeg[i] == 0 && !vis[i]) {
					for (int j : adj[i]) {
						inDeg[j] = inDeg[j] - 1;
					}
					ans = ans + i + " ";
					adj[i].clear();
					
					vis[i] = true;
					changed = true;
					break;
				}
			}
		}
		
		if (ans.length() == 14) {
			System.out.println(ans);
		} else {
			System.out.println("Cannot complete these tasks. Going to bed.");
		}
	}
}