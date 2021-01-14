import java.util.Scanner;
import java.util.Arrays;

public class KeepOnTruckin {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long[] oriMotels = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000}, dp, motels, addedMotels;
		long min = scanner.nextLong(); long max = scanner.nextLong(); long n = scanner.nextLong();
		addedMotels = new long[(int)n];
		for (int i = 0; i < n; i++) addedMotels[i] = scanner.nextLong();
		motels = new long[oriMotels.length + (int)n];
		for (int i = 0; i < oriMotels.length; i++) motels[i] = oriMotels[i];
		for (int i = 0; i < addedMotels.length; i++) motels[oriMotels.length+i] = addedMotels[i];
		Arrays.sort(motels);
		dp = new long[motels.length];
		for (int i = 0; i < motels.length; i++) dp[i] = 0;
		dp[0] = 1;
		for (int i = 0; i < motels.length-1; i++) {
			if (motels[i+1] >= motels[i] + min && motels[i+1] <= motels[i] + max) {
				dp[i+1] += dp[i];
			}
		}
		System.out.println(dp[motels.length-1]);
	}
}

/*
dp state:
d[pos] : # of ways from startpoint to pos

d[pos] = d[pos-1] + d[pos-2] + d[pos-3] ... 
as long as pos is reachable from pos-1, pos-2, pos-3, etc.

sol: iterate through motels array to update reachable pos in dp
*/