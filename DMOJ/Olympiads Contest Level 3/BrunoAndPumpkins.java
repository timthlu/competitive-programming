import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class BrunoAndPumpkins {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> neg = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			if (num >= 0) pos.add(num);
			else neg.add(-1*num);
		}
		
		int[] sortedPos = new int[pos.size()];
		int[] sortedNeg = new int[neg.size()];
		for (int i = 0; i < pos.size(); i++) {
			sortedPos[i] = pos.get(i);
		}
		for (int i = 0; i < neg.size(); i++) {
			sortedNeg[i] = neg.get(i);
		}
		
		Arrays.sort(sortedPos);
		Arrays.sort(sortedNeg);
		
		int minPath = Integer.MAX_VALUE;
		for (int i = 0; i < t; i++) {
			if (i + 1 + sortedNeg.length < t) {
				continue;
			} else if (sortedPos[i] < sortedNeg[t-i-2]) {
				int result = sortedPos[i]*2 + sortedNeg[t-i-2];
				System.out.println("result 1: pos = " + sortedPos[i] + ", neg = " + sortedNeg[t-i-2]);
				System.out.println("result = " + result);
				minPath = Math.min(minPath, result);
			} else if (sortedPos[i] > sortedNeg[t-i-2]) {
				int result = sortedPos[i] + sortedNeg[t-i-2]*2;
				minPath = Math.min(minPath, result);
				System.out.println("result 2: pos = " + sortedPos[i] + ", neg = " + sortedNeg[t-i-2]);
				System.out.println("result = " + result);
			} else if (sortedPos[i] == sortedNeg[t-i-2]) {
				int result = Math.min(sortedPos[i]*2 + sortedNeg[t-i-2], sortedPos[i] + sortedNeg[t-i-2]*2);
				minPath = Math.min(minPath, result);
				System.out.println("result 3: pos = " + sortedPos[i] + ", neg = " + sortedNeg[t-i-2]);
				System.out.println("result = " + result);
			}
		}
		
		if (sortedPos.length >= t) {
			minPath = Math.min(minPath, sortedPos[t-1]);
		}
		
		if (sortedNeg.length >= t) {
			minPath = Math.min(minPath, sortedNeg[t-1]);
		}
		
		System.out.println(minPath);
	}
}