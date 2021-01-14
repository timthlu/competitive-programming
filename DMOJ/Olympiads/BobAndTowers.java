import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class BobAndTowers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input[2]);
		int m = Integer.parseInt(input[3]);
		
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = h;
		}
		
		ArrayList<Pair> p = new ArrayList<Pair>();
		HashSet<Pair> hs = new HashSet<Pair>();
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int j = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			
			int temp = hs.size();
			hs.add(new Pair(j, k));
			if (hs.size() != temp) {
				p.add(new Pair(j, k));
			}
		}
		
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < m; i++) {
				int j = p.get(i).j;
				int k = p.get(i).k;
				
				if (j < k) {
					for (int l = j+1; l < k; l++) {
						int temp = a[l];
						a[l] = Math.min(a[l], a[j]-1);
						
						if (temp != a[l]) {
							changed = true;
						}
					}
				} else {
					for (int l = k+1; l < j; l++) {
						int temp = a[l];
						a[l] = Math.min(a[l], a[j]-1);
						
						if (temp != a[l]) {
							changed = true;
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.println(a[i]);
		}
	}
	static class Pair {
		int j;
		int k;
		
		Pair(int j, int k) {
			this.j = j;
			this.k = k;
		}
	}
}