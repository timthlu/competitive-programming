import java.util.Scanner;
import java.util.Arrays;

public class CamelCase {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] dic = new String[n];
		scanner.nextLine();
		
		for (int i = 0; i < n; i++) {
			dic[i] = scanner.nextLine();
		}
		
		//find minimum number of words in string
		for (int i = 0; i < 10; i++) {
			String input = scanner.nextLine();
			int[] dp = new int[input.length()+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[input.length()] = 0;
			
			for (int j = input.length()-1; j >= 0; j--) {
				for (int k = j; k < input.length(); k++) {
					if (ifWord(dic, input.substring(j, k+1))) {
						dp[j] = Math.min(dp[k+1] + 1, dp[j]);
					}
				}
			}
			
			System.out.println(dp[0]-1);
		}
	}
	public static boolean ifWord(String[] dic, String s) {
		for (int i = 0; i < dic.length; i++) {
			if (dic[i].equals(s)) return true;
		}
		return false;
	}
}	
/*
i = currentindex from end, j = index that works
dp[i] = min {dp[j] + if substring(i, j-1) is a word}
*/