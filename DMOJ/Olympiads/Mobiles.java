import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Mobiles {
	static int minDepth = Integer.MAX_VALUE;
	static int maxDepth = Integer.MIN_VALUE;
	static int[] dep;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Rod[] tree = new Rod[n+1];
		dep = new int[n+1]; //use rod numbers as nodes, don't care about leaf nodes
		
		for (int i = 1; i <= n; i++) {
			String input[] = br.readLine().split(" ");
			tree[i] = new Rod(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		getDep(1, 0);
		if (maxDepth - minDepth > 1) {
			System.out.println(-1);
		} else if (maxDepth == minDepth) {
			System.out.println(0);
		} else {
			dfs(1);
			System.out.println(ans);
		}
	}
	static class Rod {
		int left;
		int right;
		int leftSubtreeDepth;
		int rightSubtreeDepth;
		
		public Rod(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	public static void getDep(int u, int d) {
		if (u == -1) {
			minDepth = Math.min(minDepth, d);
			maxDepth = Math.max(maxDepth, d);
		} else {
			dep[u] = d;
			u.leftSubtreeDepth = getDep(tree[u.left], d+1);
			u.rightSubtreeDepth = getDep(tree[u.right], d+1);
		}
	}
	public static void dfs(int u) {
		//check all three cases to ans++
		if (u != -1) {
			boolean leftMixed = false;
			boolean rightMixed = false;
			boolean leftMin = false;
			boolean rightMin = false;
			boolean leftMax = false;
			boolean rightMax = false;
			
			if (u.left.leftSubtreeDepth == u.left.rightSubtreeDepth && u.left.leftSubtreeDepth == minDepth) {
				leftMin = true;
			} else if (u.left.leftSubtreeDepth == u.left.rightSubtreeDepth && u.left.leftSubtreeDepth == maxDepth) {
				leftMax = true;
			} else {
				leftMixed = true;
			}
			
			if (u.right.leftSubtreeDepth == u.right.rightSubtreeDepth && u.right.leftSubtreeDepth == minDepth) {
				rightMin = true;
			} else if (u.right.leftSubtreeDepth == u.right.rightSubtreeDepth && u.right.leftSubtreeDepth == maxDepth) {
				rightMax = true;
			} else {
				rightMixed = true;
			}
			
			if (leftMin && rightMixed || rightMax && leftMixed || leftMin && rightMax) {
				ans++;
			}
			
			dfs(u.left);
			dfs(u.right);
		}
	}
}