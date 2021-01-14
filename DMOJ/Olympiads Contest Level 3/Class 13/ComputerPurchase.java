import java.util.Scanner;

public class ComputerPurchase {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int computers = scanner.nextInt();
		scanner.nextLine();
		
		String[] names = new String[computers];
		int[] ratings = new int[computers];
		
		for (int i = 0; i < computers; i++) {
			names[i] = scanner.next();
			ratings[i] = 2*scanner.nextInt() + 3*scanner.nextInt() + scanner.nextInt();
		}
		
		int maxIndex = 0;
		int secondMaxIndex = 1;
		
		for (int i = 0; i < computers; i++) {
			if (ratings[i] > ratings[maxIndex]) {
				maxIndex = i;
			}
		}
		
		for (int i = 0; i < computers; i++) {
			if (maxIndex != i && ratings[i] > ratings[secondMaxIndex]) {
				secondMaxIndex = i;
			}
		}
		
		if (computers == 0) {
			System.exit(0);
		} else if (computers == 1) {
			System.out.println(names[maxIndex]);
		} else if (ratings[maxIndex] != ratings[secondMaxIndex]) {
			System.out.println(names[maxIndex]);
			System.out.println(names[secondMaxIndex]);
		} else {
			if (names[maxIndex].compareTo(names[secondMaxIndex]) <= 0) {
				System.out.println(names[maxIndex]);
				System.out.println(names[secondMaxIndex]);
			} else {
				System.out.println(names[secondMaxIndex]);
				System.out.println(names[maxIndex]);
			}
		}
	}
}