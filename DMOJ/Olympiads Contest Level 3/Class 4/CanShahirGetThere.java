import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class CanShahirEvenGetThere {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> q = new LinkedList();
		int houses = scanner.nextInt();
		boolean[][] adj = new boolean[houses][houses];
		boolean[] vis = new boolean[houses];
		int roads = scanner.nextInt();
		
		for (int i = 0; i < houses; i++) {
			for (int j = 0; j < houses; j++) {
				adj[i][j] = false;
			}
			
			vis[i] = false;
		}
		
		int shahirHouse = scanner.nextInt();
		vis[shahirHouse-1] = true;
		q.add(shahirHouse-1);
		int dateHouse = scanner.nextInt();
		
		for (int i = 0; i < roads; i++) {
			int input1 = scanner.nextInt();
			int input2 = scanner.nextInt();
			adj[input1-1][input2-1] = true;
			adj[input2-1][input1-1] = true;
		}
		
		for (int i = 0; i < houses; i++) {
			for (int j = 0; j < houses; j++) {
				if (adj[i][j]) {
					System.out.print("0");
				} else {
					System.out.print("1");
				}
			}
			System.out.println();
		}
		
		boolean result = bfs(q, adj, vis, dateHouse-1);
		
		if (result) {
			System.out.println("GO SHAHIR!");
		} else {
			System.out.println("NO SHAHIR!");
		}
	}
	public static boolean bfs(Queue<Integer> q, int[][] adj, boolean[] vis, int des) {
		while (!q.isEmpty()) {
			int currentHouse = q.remove();
			
			for (int i = 0; i < adj.length; i++) {
				if (adj[currentHouse][i] == 1 && !vis[i]) {
					q.add(i);
					vis[i] = true;
				}
				
				if (i == des) {
					return true;
				}
			}
		}
		
		return false;
	}
}