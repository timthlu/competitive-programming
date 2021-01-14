import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Friends2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int students = scanner.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[10000];
		
		for (int i = 0; i < students; i++) {
			int friend = scanner.nextInt();
			int recipient = scanner.nextInt();
			
			adj[friend] = new ArrayList<Integer>();
			adj[friend].add(recipient);
		}
		
		int student1 = scanner.nextInt();
		int student2 = scanner.nextInt();
		
		while (student1 != 0 && student2 != 0) {
			Queue<Integer> q = new LinkedList<>();
			int finalDeg = -1;
			
			boolean found1 = false;
			boolean[] vis1 = new boolean[10000];
			int[] deg1 = new int[10000];
			q.add(student1);
			while (!q.isEmpty() && !found1) {
				int currentStudent = q.remove();
				vis1[currentStudent] = true;
				
				for (int i = 0; i < adj[currentStudent].size(); i++) {
					if (adj[currentStudent].get(i) == student2) {
						found1 = true;
						finalDeg = deg1[currentStudent];
						break;
					} else if (!vis1[adj[currentStudent].get(i)]) {
						q.add(adj[currentStudent].get(i));
						deg1[adj[currentStudent].get(i)] = deg1[currentStudent] + 1;
					}
				}
			}
			
			if (found1) {
				q.clear();
				boolean found2 = false;
				boolean[] vis2 = new boolean[10000];
				int[] deg2 = new int[10000];
				q.add(student2);
				while (!q.isEmpty() && !found2) {
					int currentStudent = q.remove();
					vis2[currentStudent] = true;
					
					for (int i = 0; i < adj[currentStudent].size(); i++) {
						if (adj[currentStudent].get(i) == student1) {
							found2 = true;
							break;
						} else if (!vis2[adj[currentStudent].get(i)]) {
							q.add(adj[currentStudent].get(i));
							deg2[adj[currentStudent].get(i)] = deg2[currentStudent] + 1;
						}
					}
				}
				
				if (found1 && found2) {
					System.out.println("Yes " + finalDeg);
				} else {
					System.out.println("No");
				}
			} else {
				System.out.println("No");
			}
			
			student1 = scanner.nextInt();
			student2 = scanner.nextInt();
		}
	}
}