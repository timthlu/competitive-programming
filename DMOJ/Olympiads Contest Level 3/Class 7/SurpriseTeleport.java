import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class SurpriseTeleport {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		
		int[] start = {scanner.nextInt(), scanner.nextInt()};
		int[] office = {scanner.nextInt(), scanner.nextInt()};
		
		scanner.nextLine();
		
		String[][] map = new String[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			String input = scanner.nextLine();
			
			for (int j = 0; j < cols; j++) {
				map[i][j] = input.substring(j, j+1);
			}
		}
		
		int devices = scanner.nextInt();
		int[][] tele = new int[devices][2];
		for (int i = 0; i < devices; i++) {
			tele[i][0] = scanner.nextInt();
			tele[i][1] = scanner.nextInt();
		}
		
		int disToOffice = -1;
		int disToTele = -1;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] vis = new boolean[rows][cols];
		int[][] dis = new int[rows][cols];
		dis[start[0]][start[1]] = 0;
		q.add(start);
		vis[start[0]][start[1]] = true;
		
		int[] rMove = {1, 0, -1, 0};
		int[] cMove = {0, 1, 0, -1};
		
		boolean teleFound = false;
		boolean officeFound = false;
		
		if (devices == 0) {
			teleFound = true;
		}
		
		while (!q.isEmpty()) {
			int[] currentPos = q.remove();
			
			if (!teleFound) {
				for (int i = 0; i < devices; i++) {
					if (currentPos[0] == tele[i][0] && currentPos[1] == tele[i][1]) {
						disToTele = dis[currentPos[0]][currentPos[1]];
						teleFound = true;
					}
				}
			}
			
			if (!officeFound && currentPos[0] == office[0] && currentPos[1] == office[1]) {
				disToOffice = dis[currentPos[0]][currentPos[1]];
				officeFound = true;
			}
			
			for (int i = 0; i < 4; i++) {
				int[] next = {currentPos[0]+rMove[i], currentPos[1]+cMove[i]};
				
				if (next[0] < rows && next[0] >= 0 && next[1] < cols && next[1] >= 0 && !vis[next[0]][next[1]] && map[next[0]][next[1]].equals("O")) {
					q.add(next);
					vis[next[0]][next[1]] = true;
					dis[next[0]][next[1]] = dis[currentPos[0]][currentPos[1]] + 1;
				}
			}
			
			if (teleFound && officeFound) {
				if (disToTele >= disToOffice) {
					System.out.println(0);
				} else {
					System.out.println(disToOffice - disToTele);
				}
				
				System.exit(0);
			}
		}
	}
}