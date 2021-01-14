import java.util.Scanner;

public class Parking {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		boolean[] truck1 = new boolean[101];
		boolean[] truck2 = new boolean[101];
		boolean[] truck3 = new boolean[101];
		
		for (int i = 0; i < 3; i++) {
			int startTime = scanner.nextInt();
			int endTime = scanner.nextInt();
			
			if (i == 0) {
				for (int j = startTime; j < endTime; j++) {
					truck1[j] = true;
				}
			} else if (i == 1) {
				for (int j = startTime; j < endTime; j++) {
					truck2[j] = true;
				}
			} else {
				for (int j = startTime; j < endTime; j++) {
					truck3[j] = true;
				}
			}
		}
		
		int cost = 0;
		for (int i = 1; i < 101; i++) {
			int count = 0;
			
			if (truck1[i]) {
				count++;
			}
			if (truck2[i]) {
				count++;
			}
			if (truck3[i]) {
				count++;
			}
			
			if (count == 1) {
				cost = cost + a;
			} else if (count == 2) {
				cost = cost + b*2;
			} else if (count == 3) {
				cost = cost + c*3;
			}
		}
		
		System.out.println(cost);
	}
}