import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class FakeJudges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        long[] indexCount = new long[n+2];
        long[] scores = new long[n+1];

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(input[i-1]);
        }

        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            indexCount[a]++;
            indexCount[b+1]--;
        }

        long[] psa = new long[n+1];
        psa[1] = indexCount[1];
        for (int i = 2; i <= n; i++) {
            psa[i] += psa[i-1] + indexCount[i];
        }

        Arrays.sort(scores);
        Arrays.sort(psa);

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += psa[n-i+1]*scores[i];
        }
        System.out.println(ans);
    }
}