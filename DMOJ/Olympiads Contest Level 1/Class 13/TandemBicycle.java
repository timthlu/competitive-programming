import java.util.Scanner;
import java.util.Arrays;

public class TandemBicycle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int question = scanner.nextInt();
		int N = scanner.nextInt();
		int[] dSpeeds = new int[N];
		int[] pSpeeds = new int[N];
		for (int i = 0; i < N; i++) {
			dSpeeds[i] = scanner.nextInt();
		}
		for (int i = 0; i < N; i++) {
			pSpeeds[i] = scanner.nextInt();
		}
		
		Arrays.sort(dSpeeds);
		Arrays.sort(pSpeeds);
		
		int speed = 0;
		if (question == 1) {
			for (int i = 0; i < N; i++) {
				speed = speed + max(dSpeeds[i], pSpeeds[i]);
			}
		} else {
			for (int i = 0; i < N/2; i++) {
				int temp = pSpeeds[i];
				pSpeeds[i] = pSpeeds[N-i-1];
				pSpeeds[N-i-1] = temp;
			}
			
			for (int i = 0; i < N; i++) {
				speed = speed + max(dSpeeds[i], pSpeeds[i]);
			}
		}
		
		System.out.println(speed);
	}
	public static int max(int one, int two) {
		if (one > two) return one;
		else return two;
	}
}