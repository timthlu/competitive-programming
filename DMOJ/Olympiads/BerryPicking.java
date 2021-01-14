import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BerryPicking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] trees = new int[n];
        input = br.readLine().split(" ");

        int lmt = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(input[i]);
            lmt = Math.max(lmt, trees[i]);
        }

        int count;
        int ans = -1;
        for (int i = 1; i <= lmt; i++) { //number of berries per basket
            count = 0;
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = trees[j];
            }

            for (int j = 0; j < n; j++) {
                count += temp[j]/i;
                temp[j] = temp[j]%i;
            }

            if (count >= k) {
                ans = Math.max(ans, i*k/2);
            } else {
                if (count < k/2) {
                    break;
                } else { //k/2 to k
                    Arrays.sort(temp);
                    int sum = (count - k/2)*i;
                    for (int j = 1; j <= k-count; j++) {
                        if (n-j >= 0) {
                            sum += temp[n-j];
                        }
                    }

                    ans = Math.max(ans, sum);
                }
            }
        }

        System.out.println(ans);
    }
}