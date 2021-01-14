import java.util.Scanner;

public class Avalon {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		double prob = 1;
		for (int i = 0; i < testCases; i++) {
			int evil = scanner.nextInt();
			int totalNum = scanner.nextInt();
			
			prob = prob * (totalNum - evil) / totalNum;
		}
		
		System.out.println(prob);
	}
}