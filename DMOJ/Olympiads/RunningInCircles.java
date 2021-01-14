import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class RunningInCircles {
	static boolean[][] adj = new boolean[101][101];
	static int[] length = new int[101];
	static int cycleLength = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) {
			for (int j = 1; j <= 100; j++) {
				Arrays.fill(adj[j], 1, 100, false);
			}
			Arrays.fill(length, 1, 100, 0);
			cycleLength = 0;

			int n = Integer.parseInt(br.readLine());
            
			for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");

                int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				
				adj[a][b] = true;
			}
			
            length[1] = 1;
			dfs(1);
			System.out.println(cycleLength);
		}
	}
	public static void dfs(int cur) {
		for (int i = 1; i <= 100; i++) {
			if (adj[cur][i] && length[i] != 0) {
				cycleLength = Math.max(cycleLength, length[cur] - length[i] + 1);
			} else if (adj[cur][i] && length[i] == 0) {
				length[i] = length[cur] + 1;
				dfs(i);
			}
		}
	}
}