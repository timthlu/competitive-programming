import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AlicesShoppingTrip {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int t = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		int curT = 0;
		int curPos = 0;
		
		int indexClosest = 0;
		for (int i = 1; i < a.length; i++) {
			if (Math.abs(a[indexClosest]) > Math.abs(a[i])) {
				indexClosest = i;
			}
		}
		
		while (Math.abs(a[indexClosest]-curPos) <= t - curT) {	
			ans++;
			curT += Math.abs(a[indexClosest]-curPos);
			curPos = a[indexClosest];
			
			a[indexClosest] = Integer.MAX_VALUE;
			indexClosest = 0;
			for (int i = 1; i < a.length; i++) {
				if (Math.abs(a[indexClosest]) > Math.abs(a[i])) {
					indexClosest = i;
				}
			}
		}
		
		System.out.println(ans);
	}
}