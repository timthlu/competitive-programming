import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Oversleep {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		scanner.nextLine();
		String[][] map = new String[rows][cols];
		
		int[] start = new int[2];
		
		boolean startFound = false;
		
		for (int i = 0; i < rows; i++) {
			String input = scanner.nextLine();
			for (int j = 0; j < cols; j++) {
				map[i][j] = input.substring(j, j+1);
				
				if (!startFound && input.substring(j, j+1).equals("s")) {
					startFound = true;
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] vis = new boolean[rows][cols];
		int[][] dis = new int[rows][cols];
		vis[start[0]][start[1]] = true;
		dis[start[0]][start[1]] = 0;
		q.add(start);
		
		int[] rMove = {-1, 0, 1, 0};
		int[] cMove = {0, 1, 0, -1};
		
		while (!q.isEmpty()) {
			int[] pos = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int[] next = {pos[0] + rMove[i], pos[1] + cMove[i]};
				
				if (next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < cols && !vis[next[0]][next[1]]) {
					if (map[next[0]][next[1]].equals("e")) {
						System.out.println(dis[pos[0]][pos[1]]);
						System.exit(0);
					} else if (map[next[0]][next[1]].equals(".")) {
						q.add(next);
						dis[next[0]][next[1]] = dis[pos[0]][pos[1]] + 1;
						vis[next[0]][next[1]] = true;
					}
				}
			}
			
		}
		
		System.out.println(-1);
		
	}
}