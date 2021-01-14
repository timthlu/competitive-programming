import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AthenaOnZanzibarIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int x = 0;
        int y = 1;
        int val = Math.abs(a[x] + a[y]);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (Math.abs(a[i] + a[j]) < val) {
                    x = i;
                    y = j;
                    val = Math.abs(a[i] + a[j]);
                }
            }
        }

        x++;
        y++;
        System.out.println(val);
        System.out.println(x + " " + y);
    }
}