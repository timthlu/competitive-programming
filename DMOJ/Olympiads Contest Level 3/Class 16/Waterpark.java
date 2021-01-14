import java.util.Scanner;
import java.util.ArrayList;

public class Waterpark {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		while (start != 0) {
			adj[start].add(end);
			
			start = scanner.nextInt();
			end = scanner.nextInt();
		}
		
		int[] pathsCount = new int[n+1];
		pathsCount[1] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				pathsCount[adj[i].get(j)] += pathsCount[i];
			}
		}
		
		System.out.println(pathsCount[n]);
	}
}