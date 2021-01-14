import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class ItsToughBeingATeen {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 7; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(6);
		adj.get(0).add(3);
		adj.get(1).add(0);
		adj.get(2).add(3);
		adj.get(2).add(4);
		
		
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		
		while (input1 != input2) {
			adj.get(input1-1).add(input2-1);
			
			input1 = scanner.nextInt();
			input2 = scanner.nextInt();
		}
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int[] vis = new int[adj.size()];
		for (int i = 0; i < vis.length; i++) {
			vis[i] = 0;
		}
		dfs(s, vis, adj);
	}
	public static void dfs(Stack<Integer> s, int[] vis, ArrayList<ArrayList<Integer>> adj) {
		//detect cycles and if all nodes are connected
		while (!s.isEmpty()) {
			int currentNode = s.pop();
			vis[currentNode]++;
			
			for (int i = 0; i < adj.get(currentNode).size(); i++) {
				if (vis[adj.get(currentNode).get(i) == 0) {
					s.push(i);
				} else if (vis[adj.get(currentNode).get(i) == 1) {
					System.out.println("Cannot complete these tasks. Going to bed.");
					System.exit(0);
				}
			}
		}
		
	}
}