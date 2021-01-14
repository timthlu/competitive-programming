import java.util.Scanner;

public class PiDay {

	static int dp[][] = new int[251][251];
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(), k = scanner.nextInt();
		System.out.println(solve(n-k, k));
	}
	static int solve (int pie, int people) {
		if (pie < 0) return 0;
		if (pie == 0 || people == 1) return 1;
		if (dp[pie][people] > 0) return dp[pie][people];
		return dp[pie][people] = solve(pie, people-1) + solve(pie-people, people);
	}
}

/*
Dp state = code
dp[pie][people]: # of ways

dp[n][k] = dp[n][k-1] + dp[n-k][k] (either you don't give pie or you give to everyone left)

code:
 - you don't give to a person
 - you give the person 1 to max. possible amount of pie
 - base case: run out of pie or number of people is 1
*/