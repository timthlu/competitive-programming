import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class RoboThieves {
	static String[][] map;
	static boolean[][] vis;
	static int[][] steps;
	static boolean[][] camerasView;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		map = new String[rows][cols];
		int[] start = new int[2];
		ArrayList<int[]> cameras = new ArrayList<int[]>();
		camerasView = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			String input1 = br.readLine();
			for (int j = 0; j < cols; j++) {
				map[i][j] = input1.substring(j, j+1);
				if (map[i][j].equals("S")) {
					start[0] = i;
					start[1] = j;
				} else if (map[i][j].equals("C")) {
					int[] camera = new int[2];
					camera[0] = i; camera[1] = j;
					cameras.add(camera);
				}
			}
		}
		
		for (int i = 0; i < cameras.size(); i++) {
			int[] camera = {cameras.get(i)[0], cameras.get(i)[1]};
			camerasView[camera[0]][camera[1]] = true;
			
			int[] pos = {camera[0], camera[1]};
			pos[0]--;
			while (pos[0] >= 0 && !map[pos[0]][pos[1]].equals("W")) {
				if (map[pos[0]][pos[1]].equals(".") || map[pos[0]][pos[1]].equals("S")) {
					camerasView[pos[0]][pos[1]] = true;
				}
				pos[0]--;
			}
			
			pos[0] = camera[0]+1;
			while (pos[0] < rows && !map[pos[0]][pos[1]].equals("W")) {
				if (map[pos[0]][pos[1]].equals(".") || map[pos[0]][pos[1]].equals("S")) {
					camerasView[pos[0]][pos[1]] = true;
				}
				pos[0]++;
			}
			
			pos[0] = camera[0]; pos[1]--;
			while (pos[1] >= 0 && !map[pos[0]][pos[1]].equals("W")) {
				if (map[pos[0]][pos[1]].equals(".") || map[pos[0]][pos[1]].equals("S")) {
					camerasView[pos[0]][pos[1]] = true;
				}
				pos[1]--;
			}
			
			pos[1] = camera[1]+1;
			while (pos[1] < cols && !map[pos[0]][pos[1]].equals("W")) {
				if (map[pos[0]][pos[1]].equals(".") || map[pos[0]][pos[1]].equals("S")) {
					camerasView[pos[0]][pos[1]] = true;
				}
				pos[1]++;
			}
		}
		/*
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (camerasView[i][j]) System.out.print("T");
				else System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();*/
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);
		vis = new boolean[rows][cols];
		steps = new int[rows][cols];
		vis[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int[] curPos = q.remove();
			int prevSteps = steps[curPos[0]][curPos[1]];
			
			if (!camerasView[curPos[0]][curPos[1]]) {
				if (!map[curPos[0]-1][curPos[1]].equals("W") && !vis[curPos[0]-1][curPos[1]] && !camerasView[curPos[0]-1][curPos[1]]) { //move up if no w
					int[] newPos = {curPos[0]-1, curPos[1]};
					steps[newPos[0]][newPos[1]] = prevSteps + 1;
					vis[newPos[0]][newPos[1]] = true;
					int[] nextPos = con(newPos);
					if (nextPos != null) q.add(nextPos);
				}
				
				if (!map[curPos[0]+1][curPos[1]].equals("W") && !vis[curPos[0]+1][curPos[1]] && !camerasView[curPos[0]+1][curPos[1]]) { //move down if no wall
					int[] newPos = {curPos[0]+1, curPos[1]};
					steps[newPos[0]][newPos[1]] = prevSteps + 1;
					vis[newPos[0]][newPos[1]] = true;
					int[] nextPos = con(newPos);
					if (nextPos != null) q.add(nextPos);
				}
				
				if (!map[curPos[0]][curPos[1]-1].equals("W") && !vis[curPos[0]][curPos[1]-1] && !camerasView[curPos[0]][curPos[1]-1]) { //move left if no wall
					int[] newPos = {curPos[0], curPos[1]-1};
					steps[newPos[0]][newPos[1]] = prevSteps + 1;
					vis[newPos[0]][newPos[1]] = true;
					int[] nextPos = con(newPos);
					if (nextPos != null) q.add(nextPos);
				}
				
				if (!map[curPos[0]][curPos[1]+1].equals("W") && !vis[curPos[0]][curPos[1]+1] && !camerasView[curPos[0]][curPos[1]+1]) { //move right if no wall
					int[] newPos = {curPos[0], curPos[1]+1};
					steps[newPos[0]][newPos[1]] = prevSteps + 1;
					vis[newPos[0]][newPos[1]] = true;
					int[] nextPos = con(newPos);
					if (nextPos != null) q.add(nextPos);
				}
			}
		}
		/*
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(steps[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j].equals(".")) {
					if (steps[i][j] == 0) System.out.println(-1);
					else System.out.println(steps[i][j]);
				}
			}
		}
		
	}
	public static int[] con (int[] curPos) {
		boolean c = true;
		int s = steps[curPos[0]][curPos[1]];
		
		while (c) {
			c = false;
			
			if (map[curPos[0]][curPos[1]].equals("U") && !vis[curPos[0]-1][curPos[1]] && !map[curPos[0]-1][curPos[1]].equals("W")) { //conveyor up
				c = true;
				vis[curPos[0]-1][curPos[1]] = true;
				curPos[0] = curPos[0]-1; curPos[1] = curPos[1];
			} else if (map[curPos[0]][curPos[1]].equals("D") && !vis[curPos[0]+1][curPos[1]] && !map[curPos[0]+1][curPos[1]].equals("W")) { //conveyor down
				c = true;
				vis[curPos[0]+1][curPos[1]] = true;
				curPos[0] = curPos[0]+1; curPos[1] = curPos[1];
			} else if (map[curPos[0]][curPos[1]].equals("L") && !vis[curPos[0]][curPos[1]-1] && !map[curPos[0]][curPos[1]-1].equals("W")) { // conveyor left
				c = true;
				vis[curPos[0]][curPos[1]-1] = true;
				curPos[0] = curPos[0]; curPos[1] = curPos[1]-1;
			} else if (map[curPos[0]][curPos[1]].equals("R") && !vis[curPos[0]][curPos[1]+1] && !map[curPos[0]][curPos[1]+1].equals("W")) { //conveyor right
				c = true;
				vis[curPos[0]][curPos[1]+1] = true;
				curPos[0] = curPos[0]; curPos[1] = curPos[1]+1;
			}
		}
		
		if (map[curPos[0]][curPos[1]].equals(".") && !camerasView[curPos[0]][curPos[1]]) {
			steps[curPos[0]][curPos[1]] = s;
			return curPos;
		}
		
		return null;
	}
}