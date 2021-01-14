import java.util.Scanner;
import java.util.Arrays;

public class HighTideLowTide {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] recordings = new int[num];
		for (int i = 0; i < num; i++) {
			recordings[i] = scanner.nextInt();
		}
		
		Arrays.sort(recordings);
		int[] newOrder = new int[num];
		
		int countRecordings = 0;
		if (num%2 == 0) {
			for (int i = 1; i <= num/2; i++) {
				newOrder[num-i*2] = recordings[countRecordings];
				countRecordings++;
			}
			for (int i = 1; i <= num/2; i++) {
				newOrder[i*2-1] = recordings[countRecordings];
				countRecordings++;
			}
		} else {
			for (int i = 0; i <= num/2; i++) {
				newOrder[num-i*2-1] = recordings[countRecordings];
				countRecordings++;
			}
			for (int i = 0; i < num/2; i++) {
				newOrder[i*2+1] = recordings[countRecordings];
				countRecordings++;
			}
		}
		
		for (int i = 0; i < num; i++) {
			System.out.print(newOrder[i] + " ");
		}
		
	}
}