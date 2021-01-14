import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SimonAndMarcy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] numP = new int[c];
        int[] songs = new int[c];
        int[][] dp = new int[2][m+1];

        for (int i = 0; i < c; i++) {
            input = br.readLine().split(" ");
            numP[i] = Integer.parseInt(input[0]);
            songs[i] = Integer.parseInt(input[1]); 
        }

        for (int i = 0; i <= m; i++) {
            if (songs[0] <= i) {
                dp[0][i] = numP[0];
            }
        }

        for (int i = 1; i < c; i++) {
            if (i%2 == 1) {
                for (int j = 0; j <= m; j++) {
                    if (songs[i] > j) {
                        dp[1][j] = dp[0][j];
                    } else {
                        dp[1][j] = Math.max(dp[0][j], numP[i] + dp[0][j-songs[i]]);
                    }
                }
            } else {
                for (int j = 0; j <= m; j++) {
                    if (songs[i] > j) {
                        dp[0][j] = dp[1][j];
                    } else {
                        dp[0][j] = Math.max(dp[1][j], numP[i] + dp[1][j-songs[i]]);
                    }
                }
            }
        }
        
        if (c%2 == 0) {
            System.out.println(dp[1][m]);
        } else {
            System.out.println(dp[0][m]);
        }
    }
}