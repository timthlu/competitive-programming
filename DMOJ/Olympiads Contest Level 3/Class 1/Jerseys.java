import java.util.Scanner;

public class Jerseys {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int jerseys = scanner.nextInt();
		int[] sizes = new int[jerseys];
		boolean[] taken = new boolean[jerseys];
		int athletes = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < jerseys; i++) {
			String size = scanner.nextLine();
			if (size.equals("S")) {
				sizes[i] = 1;
			} else if (size.equals("M")) {
				sizes[i] = 2;
			} else {
				sizes[i] = 3;
			}
			
			taken[i] = false;
		}
		
		int satisfied = 0;
		for (int i = 0; i < athletes; i++) {
			String requestedSize = scanner.next();
			int numSize;
			int num = scanner.nextInt();
			scanner.nextLine();
			
			if (requestedSize.equals("S")) {
				numSize = 1;
			} else if (requestedSize.equals("M")) {
				numSize = 2;
			} else {
				numSize = 3;
			}
			
			if (!taken[num-1] && numSize <= sizes[num-1]) {
				satisfied++;
				taken[num-1] = true;
			}
		}
		
		System.out.println(satisfied);
	}
}