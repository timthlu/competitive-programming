import java.util.Scanner;

public class OccupyParking {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		scanner.nextLine();
		String yesterday = scanner.nextLine();
		String today = scanner.nextLine();
		
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (yesterday.charAt(i) == today.charAt(i) && yesterday.charAt(i) == 'C') {
				count++;
			}
		}
		
		System.out.println(count);
	}
}