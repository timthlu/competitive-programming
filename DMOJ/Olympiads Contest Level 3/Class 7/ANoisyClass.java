import java.util.Scanner;
import java.util.ArrayList;

public class ANoisyClass {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int students = scanner.nextInt();
		int connections = scanner.nextInt();
		
		ArrayList<Integer>[] adj = new ArrayList[students+1];
		int[] inDeg = new int[students+1];
		
		for (int i = 1; i <= students; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < connections; i++) {
			int noisy = scanner.nextInt();
			int distracted = scanner.nextInt();
			
			adj[noisy].add(distracted);
			inDeg[distracted] = inDeg[distracted] + 1;
		}
		
		boolean removed = true;
		while (removed) {
			removed = false;
			
			for (int i = 1; i <= students; i++) {
				if (inDeg[i] == 0 && adj[i].size() != 0) {
					for (int j = 0; j < adj[i].size(); j++) {
						inDeg[adj[i].get(j)] = inDeg[adj[i].get(j)] - 1;
					}
					
					adj[i].clear();
					removed = true;
				}
			}
		}
		
		for (int i = 1; i <= students; i++) {
			if (inDeg[i] != 0) {
				System.out.println("N");
				System.exit(0);
			}
		}
		
		System.out.println("Y");
	}
}