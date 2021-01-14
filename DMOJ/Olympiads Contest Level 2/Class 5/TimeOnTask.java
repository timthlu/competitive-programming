import java.util.Scanner;
import java.util.Arrays;

public class TimeOnTask {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int minutes = scanner.nextInt();
		int possibleChores = scanner.nextInt();
		
		int[] choresLength = new int[possibleChores];
		
		for (int i = 0; i < possibleChores; i++) {
			choresLength[i] = scanner.nextInt();
		}
		
		Arrays.sort(choresLength);
		
		int count = 0;
		for (int i = 0; i < possibleChores; i++) {
			minutes = minutes - choresLength[i];
			
			if (minutes < 0) {
				break;
			} else {
				count++;
			}
		}
		
		System.out.println(count);
	}
}