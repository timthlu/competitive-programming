import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

public class CarnivalPhantasm2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //number of stalls
		int s = Integer.parseInt(input[1]); //number of stalls selling candy apples
		Stall[] stalls = new Stall[n];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			stalls[i] = new Stall(Integer.parseInt(input[i]), i);
		}
		
		SortedSet<Stall>[] db = new TreeSet[101];
		
		for (int i = 0; i < 101; i++) {
			db[i] = new TreeSet<Stall>();
		}
		
		for (int i = 0; i < s; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			
			db[a].add(stalls[x-1]);
		}
		
		int q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++) {
			input = br.readLine().split(" ");
			
			if (input[0].equals("A")) {
				int x = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);
				
				db[k].add(stalls[x-1]);
			} else if (input[0].equals("S")) {
				int x = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);
				
				db[k].remove(stalls[x-1]);
			} else if (input[0].equals("E")) {
				int x = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);
				
				for (int j = 0; j < 101; j++) {
					db[j].remove(stalls[x-1]);
				}
				
				stalls[x-1] = new Stall(k, x-1);
			} else {
				int k = Integer.parseInt(input[1]);
				
				if (db[k].isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(db[k].first().index + 1);
				}
			}
		}
		
	}
	static class Stall implements Comparable<Stall> {
		int dis;
		int index;
		
		public Stall (int dis, int index) {
			this.dis = dis;
			this.index = index;
		}
		
		public int compareTo(Stall s) {
			if (dis == s.dis) {
				return index - s.index;
			} else {
				return dis - s.dis;
			}
		}
	}
}