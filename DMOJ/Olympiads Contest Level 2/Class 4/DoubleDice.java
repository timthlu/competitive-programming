import java.util.Scanner;

public class DoubleDice {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numRounds = scanner.nextInt();
		
		int scoreA = 100;
		int scoreD = 100;
		
		for (int i = 0; i < numRounds; i++) {
			int valueA = scanner.nextInt();
			int valueD = scanner.nextInt();
			
			if (valueA > valueD) {
				scoreD = scoreD - valueA;
			} else if (valueD > valueA) {
				scoreA = scoreA - valueD;
			}
		}
		
		System.out.println(scoreA);
		System.out.println(scoreD);
	}
}