import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class StrategicBombing2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean[][] adj = new boolean[26][26];
		ArrayList<String> paths = new ArrayList<String>();
		String input = scanner.nextLine();
		while (!input.equals("**")) {
			adj[(int) input.charAt(0) - 65][(int) input.charAt(1) - 65] = true;
			adj[(int) input.charAt(1) - 65][(int) input.charAt(0) - 65] = true;
			
			paths.add(input);
			input = scanner.nextLine();
		}
		
		//brute force bfs
		int countSols = 0;
		for (int i = 0; i < paths.size(); i++) {
			boolean bFound = false;
			
			Queue<Integer> q = new LinkedList<Integer>();
			adj[(int) paths.get(i).charAt(0) - 65][(int) paths.get(i).charAt(1) - 65] = false;
			adj[(int) paths.get(i).charAt(1) - 65][(int) paths.get(i).charAt(0) - 65] = false;
			
			q.add(0);
			boolean[] vis = new boolean[26];
			
			while (!q.isEmpty()) {
				int currentNode = q.remove();
				vis[currentNode] = true;
				
				if (currentNode == 1) {
					bFound = true;
					break;
				}
				
				for (int j = 0; j < adj[currentNode].length; j++) {
					if (adj[currentNode][j] && !vis[j]) {
						q.add(j);
					}
				}
			}
			
			if (!bFound) {
				System.out.println(paths.get(i));
				countSols++;
			}
			
			adj[(int) paths.get(i).charAt(0) - 65][(int) paths.get(i).charAt(1) - 65] = true;
			adj[(int) paths.get(i).charAt(1) - 65][(int) paths.get(i).charAt(0) - 65] = true;
		}
		
		System.out.println("There are " + countSols + " disconnecting roads.");
	}
}