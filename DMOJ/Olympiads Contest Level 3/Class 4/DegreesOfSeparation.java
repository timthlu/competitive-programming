import java.util.Scanner;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class DegreesOfSeparation {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] in = {1, 2, 6, 3, 4, 5, 3, 4, 7, 3, 3, 8, 9, 9, 15, 12, 12, 11, 13, 16, 16, 18};
		int[] out = {6, 6, 7, 6, 6, 6, 4, 5, 8, 5, 15, 9, 10, 12, 13, 13, 11, 10, 14, 18, 17, 17};
		
		boolean[][] adj = new boolean[50][50];
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				adj[i][j] = false;
			}
		}
		
		for (int i = 0; i < in.length; i++) {
			adj[in[i]-1][out[i]-1] = true;
			adj[out[i]-1][in[i]-1] = true;
		}
		
		while (true) {
			String input = scanner.nextLine();
		
			if (input.equals("i")) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				adj[a-1][b-1] = true;
				adj[b-1][a-1] = true;
			} else if (input.equals("d")) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				adj[a-1][b-1] = adj[b-1][a-1] = false;
			} else if (input.equals("n")) {
				int a = scanner.nextInt();
				int count = 0;
				for (int i = 0; i < adj.length; i++) {
					if (adj[a-1][i]) {
						count++;
					}
				}
				System.out.println(count);
			} else if (input.equals("f")) {
				int a = scanner.nextInt();
				HashSet<Integer> hs = new HashSet<Integer>();
				
				for (int i = 0; i < adj.length; i++) {
					if (adj[a-1][i]) {
						hs.add(i);
					}
				}
				
				int[] friends = new int[hs.size()];
				Iterator<Integer> it = hs.iterator();
				for (int i = 0; i < hs.size(); i++) {
					friends[i] = it.next();
				}
				
				for (int i = 0; i < friends.length; i++) {
					int currentFriend = friends[i];
					for (int j = 0; j < adj.length; j++) {
						if (adj[currentFriend][j] && j != a-1) {
							hs.add(j);
						}
					}
				}
				System.out.println(hs.size() - friends.length);
			} else if (input.equals("s")) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				Queue<Integer> q = new LinkedList();
				boolean[] vis = new boolean[50];
				int[] deg = new int[50];
				
				for (int i = 0; i < 50; i++) {
					vis[i] = false;
				}
				q.add(a-1);
				vis[a-1] = true;
				deg[a-1] = 0;
				boolean ansFound = false;
				
				while (!q.isEmpty() && !ansFound) {
					int currentNode = q.remove();
					
					for (int i = 0; i < 50; i++) {
						if (adj[currentNode][i] && !vis[i]) {
							q.add(i);
							vis[i] = true;
							deg[i] = deg[currentNode] + 1;
						}
						
						if (currentNode == b-1) {
							System.out.println(deg[b-1]);
							ansFound = true;
							break;
						}
					}
				}
				
				if (!ansFound) {
					System.out.println("Not connected");
				}
			} else {
				System.exit(0);
			}
			
			scanner.nextLine();
		}
	}
}