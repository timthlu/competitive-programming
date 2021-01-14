import java.util.Scanner;
import java.util.Arrays;
//done
public class FraudNotifications {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int[] spendingList = new int[n];
		for (int i = 0; i < n; i++) {
			spendingList[i] = scanner.nextInt();
		}
		
		int notifications = 0;
		for (int i = d; i < n; i++) {
			int[] medianList = new int[d];
			int indexCounter = 0;
			for (int j = i-1; j > i-6; j--) {
				medianList[indexCounter] = spendingList[j];
				indexCounter++;
			}
			Arrays.sort(medianList);
			
			int median;
			if (d%2 == 1) {
				median = medianList[d/2];
			} else {
				median = (medianList[d/2] + medianList[d/2 - 1])/2;
			}
			
			if (median*2 <= spendingList[i]) {
				notifications++;
			}
		}
		
		System.out.println(notifications);
	}
}