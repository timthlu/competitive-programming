import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class KeepOnTruckin {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long min = scanner.nextLong();
		long max = scanner.nextLong();
		ArrayList<Integer> motels = new ArrayList<Integer>();
		
		motels.add(0);
		motels.add(990);
		motels.add(1010);
		motels.add(1970);
		motels.add(2030);
		motels.add(2940);
		motels.add(3060);
		motels.add(3930);
		motels.add(4060);
		motels.add(4970);
		motels.add(5030);
		motels.add(5990);
		motels.add(6010);
		motels.add(7000);
		
		int addedMotels = scanner.nextInt();
		for (int i = 0; i < addedMotels; i++) {
			motels.add(scanner.nextInt());
		}
		
		int[] m = new int[motels.size()];
		for (int i = 0; i < motels.size(); i++) {
			m[i] = motels.get(i);
		}
		
		Arrays.sort(m);
		
		long[] ways = new long[m.length];
		ways[0] = 1;
		
		for (int i = 0; i < m.length-1; i++) {
			for (int j = i+1; j < m.length; j++) {
				if (ways[i] == 0) {
					continue;
				}
				
				if (m[i] + max >= m[j] && m[i] + min <= m[j]) {
					ways[j] += ways[i];
				}
			}
		}
		
		if (ways[m.length-1] == 0) {
			System.out.println(0);
		} else {
			System.out.println(ways[m.length-1]);
		}
	}
}