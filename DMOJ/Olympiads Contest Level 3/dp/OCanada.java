import java.util.Scanner;

public class OCanada {
	static boolean[][] map;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int maps = scanner.nextInt();
		scanner.nextLine();
		
		String[] edges = new String[maps];
		
		for(int i = 0; i < maps; i++) {
			map = new boolean[size][size];
			for (int j = 0; j < size; j++) {
				String input = scanner.nextLine();
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
		
		int count = 0;
		for (int i = 0; i < maps-1; i++) {
			for (int j = i+1; j < maps; j++) {
				if (edges[i].equals(edges[j])) {
					count++;
				}
			}
		}
		
		System.out.println(count);
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