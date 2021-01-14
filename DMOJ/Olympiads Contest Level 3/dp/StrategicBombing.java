import java.util.Scanner;
import java.util.ArrayList;

public class StrategicBombing {
	static int[] countRoadUse;
	static int[][] adj;
	static int pathsCount = 0;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		adj = new int[26][26];
		ArrayList<String> paths = new ArrayList<String>();
		int num = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				adj[i][j] = -1;
			}
		}
		
		while (!input.equals("**")) {
			adj[(int)input.charAt(0)-65][(int)input.charAt(1)-65] = num;
			adj[(int)input.charAt(1)-65][(int)input.charAt(0)-65] = num;
			
			paths.add(input);
			input = scanner.nextLine();
			num++;
		}
		
		countRoadUse = new int[paths.size()];
		for (int i = 0; i < paths.size(); i++) {
			countRoadUse[i] = 0;
		}
		
		for (int i = 0; i < adj[0].length; i++) {
			if (adj[0][i] != -1) {
				boolean[] vis = new boolean[26];
				vis[0] = true;
				solve(i, 0, vis);
			}
		}
		
		int c = 0;
		for (int i = 0; i < paths.size(); i++) {
			if (countRoadUse[i] == pathsCount) {
				System.out.println(paths.get(i));
				c++;
			}
		}
		System.out.println("There are " + c + " disconnecting roads.");
		
	}
	public static int solve(int node, int prevNode, boolean[] vis) {
		vis[node] = true;
		
		if (node == 1) {
			pathsCount++;
			return 1;
		}
		
		if (countRoadUse[adj[node][prevNode]] != 0) {
			return countRoadUse[adj[node][prevNode]];
		}
		
		for (int i = 0; i < adj[node].length; i++) {
			if (adj[node][i] != -1 && !vis[i]) {
				return countRoadUse[adj[node][prevNode]] += solve(i, node, vis);
			}
		}
		
		return 0;
	}
}