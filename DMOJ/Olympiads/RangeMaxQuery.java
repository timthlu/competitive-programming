import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RangeMaxQuery {
    static int[][] st = new int[17][(int)1e5 + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            st[0][i] = Integer.parseInt(input[i-1]);
        }

        for (int i = 1; i < 17; i++) {
            for (int j = 1; j + (1<<i) - 1 <= n; j++) {
                st[i][j] = Math.max(st[i-1][j], st[i-1][j + (1<<(i-1))]);
            }
        }

        for (int i = 1; i <= q; i++) {
            input = br.readLine().split(" ");
            System.out.println(RMQ(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
    }
    public static int RMQ(int x, int y) {
        int lvl = (int)(Math.log(y - x + 1) / Math.log(2));
        return Math.max(st[lvl][x], st[lvl][y-(1<<lvl)+1]);
    }
}