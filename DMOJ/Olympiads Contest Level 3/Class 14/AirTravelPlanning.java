import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class AirTravelPlanning {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			int data = scanner.nextInt();
			scanner.nextLine();
			
			ArrayList<String> names = new ArrayList<String>();
			int[][] adj = new int[data*2][data*2];
			
			for (int j = 0; j < data; j++) {
				String u = scanner.next();
				String v = scanner.next();
				int w = scanner.nextInt();
				scanner.nextLine();
				
				if (names.indexOf(u) == -1) {
					names.add(u);
				}
				if (names.indexOf(v) == -1) {
					names.add(v);
				}
				
				adj[names.indexOf(u)][names.indexOf(v)] = w;
			}
			
			int[] dis = new int[names.size()];
			Arrays.fill(dis, Integer.MAX_VALUE);
			boolean[] vis = new boolean[data*2];
			dis[names.indexOf("YYZ")] = 0;
			
			while (true) {
				int minDis = Integer.MAX_VALUE;
				int minIndex = -1;
				
				for (int j = 0; j < names.size(); j++) {
					if (!vis[j]) {
						if (dis[j] < minDis) {
							minDis = dis[j];
							minIndex = j;
						}
					}
				}
				
				if (minDis == Integer.MAX_VALUE) {
					break;
				}
				
				vis[minIndex] = true;
				
				for (int j = 0; j < names.size(); j++) {
					if (adj[minIndex][j] != 0 && dis[j] > minDis + adj[minIndex][j]) {
						dis[j] = minDis + adj[minIndex][j];
					}
				}
			}
			
			System.out.println(dis[names.indexOf("SEA")]);
			
		}
	}
}