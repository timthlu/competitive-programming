import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner; 

public class BFS {
	public static void main(String[] args) {
		
		int[][] adjMatrix = {{0, 1, 0, 0, 0},
							 {0, 0, 1, 1, 0},
							 {0, 0, 0, 0, 1},
							 {0, 1, 0, 0, 0},
							 {1, 0, 0, 0, 0}};
							 
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which node do you want to start at?: ");
		queue.add(scanner.nextInt()-1);
		boolean[] visited = new boolean[5];
		for (int i = 0; i < 5; i++) {
			visited[i] = false;
		}
		
		while (!queue.isEmpty()) {
			int currentNode = queue.remove();
			System.out.println(currentNode+1);
			for (int i = 4; i >= 0; i--) {
				if (adjMatrix[currentNode][i] == 1 && !visited[i]) {
					queue.add(i);
				}
			}
			visited[currentNode] = true;
		}
		
	}
}