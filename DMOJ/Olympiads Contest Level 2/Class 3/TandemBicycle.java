import java.util.Scanner;
import java.util.Arrays;

public class TandemBicycle {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int question = scanner.nextInt();
		int size = scanner.nextInt();
		int[] dmoj = new int[size];
		int[] peg = new int[size];
		for (int i = 0; i < size; i++) {
			dmoj[i] = scanner.nextInt();
		}
		for (int i = 0; i < size; i++) {
			peg[i] = scanner.nextInt();
		}
		
		Arrays.sort(dmoj);
		Arrays.sort(peg);
		
		int totalSpeed = 0;
		if (question == 1) {
			for (int i = 0; i < size; i++) {
				totalSpeed += Math.max(dmoj[i], peg[i]);
			}
		} else {
			for (int i = 0; i < size; i++) {
				totalSpeed += Math.max(dmoj[i], peg[size-1-i]);
			}
		}
		
		System.out.println(totalSpeed);
	}
}