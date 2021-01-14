import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Friends {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int students = scanner.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[students];
		for (int i = 0; i < students; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		ArrayList<Integer> studentNumbers = new ArrayList<Integer>();
		
		for (int i = 0; i < students; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			int xIndex = -1;
			int yIndex = -1;
			
			for (int j = 0; j < studentNumbers.size(); j++) {
				if (studentNumbers.get(j) == x) {
					xIndex = j;
				} else if (studentNumbers.get(j) == y) {
					yIndex = j;
				}
			}
			
			if (xIndex == -1) {
				studentNumbers.add(x);
				xIndex = studentNumbers.size()-1;
			} else if (yIndex == -1) {
				studentNumbers.add(y);
				yIndex = studentNumbers.size()-1;
			}
			
			adj[xIndex].add(yIndex);
		}
		
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		
		while (input1 != 0 && input2 != 0) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < studentNumbers.size(); i++) {
				if (input1 == studentNumbers.get(i)) {
					q.add(i);
					break;
				}
			}
			int goalIndex = -1;
			for (int i = 0; i < studentNumbers.size(); i++) {
				if (input2 == studentNumbers.get(i)) {
					goalIndex = i;
					break;
				}
			}
			
			boolean[] vis = new boolean[students];
			int[] deg = new int[students];
			boolean found = false;
			
			while (!q.isEmpty() && !found) {
				int currentNode = q.remove();
				vis[currentNode] = true;
				
				for (int i = 0; i < adj[currentNode].size(); i++) {
					if (!vis[adj[currentNode].get(i)]) {
						q.add(adj[currentNode].get(i));
						deg[adj[currentNode].get(i)] = deg[currentNode] + 1;
					} else if (adj[currentNode].get(i) == goalIndex) {
						int sep = deg[currentNode] - 1;
						System.out.println("Yes " + sep);
						found = true;
						break;
					}
				}
			}
			
			if (!found) {
				System.out.println("No");
			}
			
			input1 = scanner.nextInt();
			input2 = scanner.nextInt();
		}
	}
}