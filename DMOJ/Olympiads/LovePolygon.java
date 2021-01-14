import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class LovePolygon {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n % 2 == 1) {
			System.out.println(-1);
			System.exit(0);
		}
		
		int[] in = new int[n+1];
		int ans = 0;
		int cnt = 1;
		int[] next = new int[n+1];
		boolean[] done = new boolean[n+1];
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		Queue<Integer> q = new LinkedList();
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			if (!mp.containsKey(input[0])) {
				mp.put(input[0], cnt);
				cnt++;
			}
			
			if (!mp.containsKey(input[1])) {
				mp.put(input[1], cnt);
				cnt++;
			}
			
			next[mp.get(input[0])] = mp.get(input[1]);
		}
		
		for (int i = 1; i <= n; i++) {
			if (!done[i] && next[next[i]] == i && next[i] != i) {
				done[i] = true;
				done[next[i]] = true;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (!done[i] && next[i] != i) {
				in[next[i]]++;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (!done[i] && in[i] == 0 && next[i] != i) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int u = q.remove();
			done[u] = true;
			ans++;
			
			if (!done[next[u]]) {
				done[next[u]] = true;
				
				int v = next[next[u]];
				in[v]--;
				
				if (!done[v] && in[v] == 0) {
					q.add(v);
				}
			}
			
		}
		
		for (int i = 1; i <= n; i++) {
			if (!done[i]) {
				int tot = 0;
				for (int j = i; !done[j]; j = next[j]) {
					done[j] = true;
					tot++;
				}
				ans += (tot+1)/2;
			}
		}
		
		System.out.println(ans);
	}
}