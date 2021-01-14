import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class SocialNetworkingGraph {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int people = scanner.nextInt();
		int connections = scanner.nextInt();
		
		int[][] adjMatrix = new int[people][people];
		for (int i = 0; i < connections; i++) {
			addToMatrix(adjMatrix, scanner.nextInt()-1, scanner.nextInt()-1);
		}
		
		int queries = scanner.nextInt();
		for (int i = 0; i < queries; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			System.out.println(findConnections(q, adjMatrix, scanner.nextInt()-1, scanner.nextInt()));
		}
	}
	public static void addToMatrix(int[][] matrix, int p1, int p2) {
		matrix[p1][p2] = 1;
		matrix[p2][p1] = 1;
	}
	public static int findConnections(Queue<Integer> queue, int[][] matrix, int start, int distance) {
		queue.add(start);
		boolean[] visited = new boolean[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			visited[i] = false;
		}
		
		int countDistance = 0; //trouble keeping track of connectivity distance
		while (countDistance < distance) {
			int currentNode = queue.remove();
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[currentNode][j] == 1 && !visited[j]) {
					queue.add(j);
				}
			}
			visited[currentNode] = true;
		}
		int finalNode = queue.remove();
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[finalNode][i] == 1 && !visited[i]) {
				count++;
			}
		}
		
		return count;
	}
}