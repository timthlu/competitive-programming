import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class WhoIsTaller {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int people = Integer.parseInt(input1[0]);
		ArrayList<Integer>[] adj = new ArrayList[people+1];
		
		for (int i = 1; i < people+1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		int comparisons = Integer.parseInt(input1[1]);
		for (int i = 0; i < comparisons; i++) {
			String[] input2 = br.readLine().split(" ");
			int taller = Integer.parseInt(input2[0]);
			int shorter = Integer.parseInt(input2[1]);
			
			adj[taller].add(shorter);
		}
		
		String[] input3 = br.readLine().split(" ");
		int person1 = Integer.parseInt(input3[0]);
		int person2 = Integer.parseInt(input3[1]);
		
		Queue<Integer> q = new LinkedList<>();
		boolean vis1[] = new boolean[people+1];
		q.add(person1);
		
		while (!q.isEmpty()) {
			int currentPerson = q.remove();
			vis1[currentPerson] = true;
			
			for (int i = 0; i < adj[currentPerson].size(); i++) {
				if (adj[currentPerson].get(i) == person2) {
					System.out.println("yes");
					System.exit(0);
				} else if (!vis1[adj[currentPerson].get(i)]) {
					q.add(adj[currentPerson].get(i));
				}
			}
		}
		
		q.clear();
		boolean vis2[] = new boolean[people+1];
		q.add(person2);
		
		while (!q.isEmpty()) {
			int currentPerson = q.remove();
			vis2[currentPerson] = true;
			
			for (int i = 0; i < adj[currentPerson].size(); i++) {
				if (adj[currentPerson].get(i) == person1) {
					System.out.println("no");
					System.exit(0);
				} else if (!vis2[adj[currentPerson].get(i)]) {
					q.add(adj[currentPerson].get(i));
				}
			}
		}
		
		System.out.println("unknown");
	}
}