import java.io.BufferedReader;
import java.io.InputStreamReader;

import sun.util.logging.resources.logging_de;

import java.io.IOException;

public class Knapsack1 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int objects = Integer.parseInt(input[0]);
        int weight = Integer.parseInt(input[1]);

        long[] dp = new long[weight+1];
        
        int[] w = new int[objects];
        long[] v = new long[objects];

        for (int i = 0; i < objects; i++) {
            input = br.readLine().split(" ");
            w[i] = Integer.parseInt(input[0]);
            v[i] = Long.parseLong(input[1]);
        }

        for (int i = 0; i < objects; i++) {
            for (int j = weight; j >= 0; j--) {
                if (w[i] <= j) {
                    dp[j] = Math.max(dp[j-w[i]] + v[i], dp[j]);
                }
            }
        }

        System.out.println(dp[weight]);
    }
}