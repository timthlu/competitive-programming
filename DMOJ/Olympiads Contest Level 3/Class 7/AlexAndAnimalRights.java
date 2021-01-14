import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class AlexAndAnimalRights {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int rows = Integer.parseInt(input1[0]);
		int cols = Integer.parseInt(input1[1]);
		
		String[][] array = new String[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			String input2 = br.readLine();
			
			for (int j = 0; j < cols; j++) {
				array[i][j] = input2.substring(j, j+1);
			}
		}
		
		int[] rMove = {1, 0, -1, 0};
		int[] cMove = {0, 1, 0, -1};
		
		boolean[][] vis = new boolean[rows][cols];
		int count = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!array[i][j].equals("#") && !vis[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					int[] start = {i, j};
					q.add(start);
					vis[i][j] = true;
					
					boolean added = false;
					
					while (!q.isEmpty()) {
						int[] currentNode = q.remove();
						
						if (!added && array[currentNode[0]][currentNode[1]].equals("M")) {
							count++;
							added = true;
						}
						
						for (int k = 0; k < 4; k++) {
							int[] nextNode = {currentNode[0]+rMove[k], currentNode[1]+cMove[k]};
							
							if (!vis[nextNode[0]][nextNode[1]] && !array[nextNode[0]][nextNode[1]].equals("#")) {
								q.add(nextNode);
								vis[nextNode[0]][nextNode[1]] = true;
							}
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
}