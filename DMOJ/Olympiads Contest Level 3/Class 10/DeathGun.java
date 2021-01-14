import java.util.Scanner;
import java.util.ArrayList;

public class DeathGun {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer>[] adj = new ArrayList[n*2];
		for (int i = 0; i < n*2; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		int[] inDeg = new int[n*2];
		
		for (int i = 0; i < n; i++) {
			String name1 = scanner.next();
			String name2 = scanner.next();
			
			boolean found1 = false;
			boolean found2 = false;
			for (int j = 0; j < names.size(); j++) {
				if (names.get(j).equals(name1)) found1 = true;
				if (names.get(j).equals(name2)) found2 = true;
			}
			
			if (!found1) names.add(name1);
			if (!found2) names.add(name2);
			
			adj[names.indexOf(name2)].add(names.indexOf(name1));
			inDeg[names.indexOf(name1)] = inDeg[names.indexOf(name1)] + 1;
		}
		
		boolean[] removed = new boolean[n*2];
		boolean r = true;
		while (r) {
			r = false;
			for (int i = 0; i < names.size(); i++) {
				if (inDeg[i] == 0 && !removed[i]) {
					r = true;
					System.out.println(names.get(i));
					for (int j = 0; j < adj[i].size(); j++) {
						inDeg[adj[i].get(j)] = inDeg[adj[i].get(j)] - 1;
					}
					
					removed[i] = true;
					break;
				}
			}
		}
	}
}