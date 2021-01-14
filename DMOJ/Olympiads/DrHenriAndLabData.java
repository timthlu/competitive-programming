import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class DrHenriAndLabData {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);
		
		int[] a = new int[n+1];
		
		input = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(input[i-1]);
		}
		
		long[] psa = new long[n+1];
		psa[1] = a[1];
		for (int i = 2; i <= n; i++) {
			psa[i] = a[i] + psa[i-1];
		}
		
		Query[] sorted = new Query[q];
		Query[] ori = new Query[q];
		
		for (int i = 0; i < q; i++) {
			input = br.readLine().split(" ");
			
			ori[i] = new Query(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			sorted[i] = ori[i];
		}
		
		//sort all queries by k
		Arrays.sort(sorted);
		
		int prevK = 0;
		
		long[] smallerPsa = new long[n+1];
		
		for (int i = 0; i < q; i++) {
			Query cur = sorted[i];
			
			if (cur.k != prevK) {
				int goingSum = 0;
				
				for (int j = 1; j <= n; j++) {
					if (a[j] < cur.k && a[j] >= prevK) {
						goingSum += a[j];
					}
					
					smallerPsa[j] += goingSum;
				}
				
				prevK = cur.k;
			}
			
			sorted[i].ans = psa[cur.r] - psa[cur.l-1] - 2*(smallerPsa[cur.r] - smallerPsa[cur.l-1]);
		}
		
		for (int i = 0; i < q; i++) {
			System.out.println(ori[i].ans);
		}
		
	}
	static class Query implements Comparable<Query> {
		int l;
		int r;
		int k;
		long ans;
		
		public Query(int l, int r, int k) {
			this.l = l;
			this.r = r;
			this.k = k;
		}
		
		public int compareTo(Query q) {
			return k - q.k;
		}
	}
}