import java.util.Scanner;
import java.util.ArrayList;

public class ChancesOfWinning {
	static int team;
	static int count = 0;
	public static void main(String[] args) { //recursive brute force
		
		Scanner scanner = new Scanner(System.in);
		team = scanner.nextInt();
		int n = scanner.nextInt();
		ArrayList<int[]> games = new ArrayList<int[]>();
		int[] pts = new int[5];
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int sa = scanner.nextInt();
			int sb = scanner.nextInt();
			
			if (sa > sb) pts[a] += 3;
			else if (sa < sb) pts[b] += 3;
			else {pts[a]++; pts[b]++;}
			
			int[] temp = {a, b};
			games.add(temp);
		}
		
		solve(games, pts);
		System.out.println(count);
		
	}
	public static void solve(ArrayList<int[]> games, int[] pts) {
		if (games.size() == 6) {
			boolean yes = true;
			for (int i = 1; i <= 4; i++) {
				if (i != team && pts[i] >= pts[team]) {
					yes = false;
					break;
				}
			}
			
			if (yes) {
				count++;
			}
		} else {
			ArrayList<int[]> next = new ArrayList<int[]>();
			for (int i = 0; i < games.size(); i++) {
				next.add(games.get(i));
			}
			int[] p = new int[5];
			for (int i = 1; i <= 4; i++) {
				p[i] = pts[i];
			}
			
			boolean done = false;
			for (int i = 1; i <= 3; i++) {
				for (int j = i+1; j <= 4; j++) {
					int[] curGame = {i, j};
					if (!has(games, curGame) && !done) {
						next.add(curGame);
						
						p[i] += 3; solve(next, p);
						p[i] -= 3;
						
						p[j] += 3; solve(next, p);
						p[j] -= 3;
						
						p[i]++; p[j]++; solve(next, p);
						p[i]--; p[j]--;
						done = true;
					}
				}
			}
		}
	}
	public static boolean has (ArrayList<int[]> a, int[] b) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i)[0] == b[0] && a.get(i)[1] == b[1]) return true;
		}
		
		return false;
	}
}