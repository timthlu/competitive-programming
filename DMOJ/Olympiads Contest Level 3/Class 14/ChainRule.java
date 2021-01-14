import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ChainRule {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cities = scanner.nextInt();
		int roads = scanner.nextInt();
		
		ArrayList<int[]>[] adj = new ArrayList[cities];
		for (int i = 0; i < roads; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			
			int[] x = {v, w};
			int[] y = {u, w};
			
			adj[u].add(x);
			adj[v].add(y);
		}
		
		int[] dis1 = new int[cities];
		Arrays.fill(dis1, Integer.MAX_VALUE);
		boolean[] vis1 = new boolean[cities];
		dis1[0] = 0;
		
		while (true) {
			int minDis = Integer.MAX_VALUE;
			int minIndex = -1;
			
			for (int i = 0; i < cities; i++) {
				if (!vis1[i]) {
					if (dis1[i] < minDis) {
						minDis = dis1[i];
						minIndex = i;
					}
				}
			}
			
			if (minDis == Integer.MAX_VALUE) {
				break;
			}
			
			vis1[minIndex] = true;
			
			for (int i = 0; i < cities; i++) {
				if (adj[minIndex].get(i)[1] != 0 && dis1[i] > minDis + adj[minIndex].get(i)[1]) {
					dis1[i] = minDis + adj[minIndex].get(i)[1];
				}
			}
		}
		
		int[] dis2 = new int[cities];
		Arrays.fill(dis2, Integer.MAX_VALUE);
		boolean[] vis2 = new boolean[cities];
		dis2[cities-1] = 0;
		
		while (true) {
			int minDis = Integer.MAX_VALUE;
			int minIndex = -1;
			
			for (int i = 0; i < cities; i++) {
				if (!vis2[i]) {
					if (dis2[i] < minDis) {
						minDis = dis2[i];
						minIndex = i;
					}
				}
			}
			
			if (minDis == Integer.MAX_VALUE) {
				break;
			}
			
			vis2[minIndex] = true;
			
			for (int i = 0; i < cities; i++) {
				if (adj[minIndex].get(i)[1] != 0 && dis2[i] > minDis + adj[minIndex].get(i)[1]) {
					dis2[i] = minDis + adj[minIndex].get(i)[1];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cities; i++) {
			max = Math.max(dis1[i] + dis2[i], max);
		}
		
		System.out.println(max);
	}
}