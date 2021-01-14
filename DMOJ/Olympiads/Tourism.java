import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Tourism {
    public static void main(String[] args) throws IOException {
        
        //first 3 points: only two days; use prefix max array and suffix max array, try all possible cuts to find max
        //other 17: dp state: dp[current position (i)] = max score for first i attractions
        //how do you represent your answer based on something you already have?
        //dp[i] = max(dp[yesterday's last attraction (j)] + RMQ(j+1, i)) --> i - j <= k, therefore j >= i - k
        // j is also <= (ceiling(i/k) - 1)*k --> use this range of j, iterate to find max
        //still not fast enough: calculating RMQ is to slow. RMQ is basically the max suffix of j+1 to p (the last one of yesterday), and the prefix of p+i to i
        //dp[j] + RMQ(j+1, i) --> max(dp[j] + smax(j+1), dp[j] + pmax(i))
        //as you're iterating from j+1 to p, only the j increases by 1, while the i doesn't (because it's a condition)
        //dp[j] + smax(j+1) --> dp[j+1] + smax[j+2] --> dp[j+2] + smax[j+3] --> ... --> dp[p] + smax[p+1]; use another two smax to keep track of dp and smax
        //for dp[j] + pmax[i], only the j changes, meaning that you only need to keep track of dp


        //create and maintain prefix max and suffix max for every day

    }
}