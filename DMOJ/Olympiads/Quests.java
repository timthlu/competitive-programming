import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Quests {

    //do 0-1 knapsack assuming that you must visit first, then check with unlimited
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int quests = Integer.parseInt(input[0]);
        int hours = Integer.parseInt(input[1]);
        
        long[][] dp = new long[2][5002];
        
        int pre = 0;
        int cur = 1;

        for (int i = 1; i <= quests; i++) {
            input = br.readLine().split(" ");
            long g = Long.parseLong(input[0]);
            int h = Integer.parseInt(input[1]);
            long q = Long.parseLong(input[2]);
            int t = Integer.parseInt(input[3]);

            for (int j = h; j <= hours; j++) {
                dp[cur][j] = dp[pre][j-h] + g; //must choose it
            }

            for (int j = h+t; j <= hours; j++) {
                dp[cur][j] = Math.max(dp[cur][j], dp[cur][j-t] + q);
            }

            for (int j = 1; j <= hours; j++) {
                dp[cur][j] = Math.max(dp[cur][j], dp[pre][j]);
            }

            int temp = pre;
            pre = cur;
            cur = temp;
        }

        if (quests%2 == 0) {
            System.out.println(dp[0][hours]);
        } else {
            System.out.println(dp[1][hours]);
        }
    }
}