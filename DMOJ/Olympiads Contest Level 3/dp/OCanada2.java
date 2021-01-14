import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class OCanada2 {
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int maps = Integer.parseInt(br.readLine());
		
		String[] edges = new String[maps];
		
		for(int i = 0; i < maps; i++) {
			map = new boolean[size][size];
			for (int j = 0; j < size; j++) {
				String input = br.readLine();
				for (int k = 0; k < size; k++) {
					if (input.charAt(k) == 'R') { //R = true, W = false
						map[j][k] = true;
					}
				}
			}
			
			boolean changed = true;
			while (changed) {
				changed = false;
				
				for (int j = 0; j < size-1; j++) {
					for (int k = 0; k < size-1; k++) {
						if (map[j][k]) {
							changed = true;
							change(j, k);
						}
					}
				}
			}
			
			edges[i] = "";
			for (int j = 0; j < size; j++) {
				if (map[size-1][j]) {
					edges[i] += "1";
				} else {
					edges[i] += "0";
				}
			}
			for (int j = 1; j < size; j++) {
				if (map[size-1-j][size-1]) {
					edges[i] += "1";
				} else {
					edges[i] += "0";
				}
			}
		}
		
		Arrays.sort(edges);
		int count = 1;
		int sol = 0;
		for (int i = 1; i < maps; i++) {
			if (edges[i].equals(edges[i-1])) {
				count++;
			} else if (count > 1) {
				sol += count*(count-1)/2;
				count = 1;
			}
		}
		
		if (count > 1) {
			sol += count*(count-1)/2;
		}
		
		System.out.println(sol);
	}
	public static void change(int i, int j) {
		map[i][j] = false;
		
		if (map[i+1][j]) {
			map[i+1][j] = false;
		} else if (!map[i+1][j]) {
			map[i+1][j] = true;
		}
		
		if (map[i][j+1]) {
			map[i][j+1] = false;
		} else if (!map[i][j+1]) {
			map[i][j+1] = true;
		}
		
		if (map[i+1][j+1]) {
			map[i+1][j+1] = false;
		} else if (!map[i+1][j+1]) {
			map[i+1][j+1] = true;
		}
	}
}