import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PiDay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pieces = Integer.parseInt(br.readLine());
        int people = Integer.parseInt(br.readLine());

        int[][] dp = new int[people+1][pieces+1];

        for (int i = 1; i <= people; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i <= pieces; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= people; i++) {
            for (int j = 1; j <= pieces; j++) {
                int ans = 0;
                for (int k = 1; k <= j-i; k++) { //k is number of pieces given to first person
                    ans += dp[i-1][j-k];
                }
                dp[i][j] = ans;
            }
        }

        System.out.println(dp[people][pieces]);
    }
}