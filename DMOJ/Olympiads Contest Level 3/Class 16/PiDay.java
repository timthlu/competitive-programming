import java.util.Scanner;

public class PiDay {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int pieces = scanner.nextInt();
		int people = scanner.nextInt();
		
		if (pieces < people) {
			System.out.println(0);
		} else {
			int[] dp = new int[people+1];
			dp[1] = 1;
			for (int i = 2; i <= people; i++) {
				dp[i] = dp[i-1] + 
			}
			
			System.out.println(dp[people-1]);
		}
		
	}
}