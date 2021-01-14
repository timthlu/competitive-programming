import java.util.Scanner;

public class VoteCount {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numVotes = scanner.nextInt();
		scanner.nextLine();
		String votes = scanner.nextLine();
		
		int countA = 0;
		int countB = 0;
		for (int i = 0; i < numVotes; i++) {
			if (votes.charAt(i) == 'A') {
				countA++;
			} else {
				countB++;
			}
		}
		
		if (countA > countB) {
			System.out.println("A");
		} else if (countB > countA) {
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
	}
}