import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class ConvexHull {
	public static void main(String[] args) throws IOException { //adjacency list, not matrix (due to double roads)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int thick = Integer.parseInt(input1[0]);
		int islands = Integer.parseInt(input1[1]);
		int routes = Integer.parseInt(input1[2]);
		
		ArrayList<Route>[] adj = new ArrayList[islands+1];
		//int[][] T = new int[islands+1][islands+1];
		//int[][] H = new int[islands+1][islands+1];
		for (int i = 1; i <= islands; i++) {
			adj[i] = new ArrayList<Route>();
		}
		
		for (int i = 0; i < routes; i++) {
			String[] input2 = br.readLine().split(" ");
			
			int u = Integer.parseInt(input2[0]);
			int v = Integer.parseInt(input2[1]);
			int t = Integer.parseInt(input2[2]);
			int h = Integer.parseInt(input2[3]);
			
			//T[u][v] = t; T[v][u] = t;
			//H[u][v] = h; H[v][u] = h;
			adj[u].add(new Route(v, t, h));
			adj[v].add(new Route(u, t, h));
		}
		
		String[] input3 = br.readLine().split(" ");
		int start = Integer.parseInt(input3[0]);
		int goal = Integer.parseInt(input3[1]);
		
		Queue<Node> q = new LinkedList<Node>();
		for (int i = 0; i < adj[start].size(); i++) {
			if (adj[start].get(i).hull < thick) {
				q.add(new Node (adj[start].get(i).des, start, adj[start].get(i).time, adj[start].get(i).hull));
			}
		}
		
		int minTime = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node curNode = q.remove();
			int islandNum = curNode.num;
			
			if (islandNum == goal) {
				minTime = Math.min(minTime, curNode.time);
				continue;
			}
			
			for (int i = 0; i < adj[islandNum].size(); i++) {
				if (curNode.hull + adj[islandNum].get(i).hull < thick && adj[islandNum].get(i).des != curNode.prevNum) {
					Node nextNode = new Node (adj[islandNum].get(i).des, islandNum, curNode.time + adj[islandNum].get(i).time, curNode.hull + adj[islandNum].get(i).hull);
					q.add(nextNode);
				}
			}
		}
		
		if (minTime == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minTime);
	}
}
class Route {
	int des;
	int time;
	int hull;
	
	Route (int des, int time, int hull) {
		this.des = des;
		this.time = time;
		this.hull = hull;
	}
}
class Node {
	int num;
	int prevNum;
	int time;
	int hull;
	
	Node (int num, int prevNum, int time, int hull) {
		this.num = num;
		this.prevNum = prevNum;
		this.time = time;
		this.hull = hull;
	}
}