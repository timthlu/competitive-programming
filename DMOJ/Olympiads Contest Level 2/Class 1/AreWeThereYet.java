import java.util.Scanner;

public class AreWeThereYet {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] distances = new int[4];
		for (int i = 0; i < 4; i++) {
			distances[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j) {
					System.out.print(0);
				} else if (i < j) {
					int sum = 0;
					for (int k = i; k < j; k++) {
						sum = sum + distances[k];
					}
					System.out.print(sum);
				} else {
					int sum = 0;
					for (int k = j; k < i; k++) {
						sum = sum + distances[k];
					}
					System.out.print(sum);
				}
				
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}