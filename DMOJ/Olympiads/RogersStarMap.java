import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RogersStarMap {
    static int[] bit = new int[32002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lvl = new int[n+1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            x++;
            int val = query(x);
            lvl[val]++; 
            update(x, 1);
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(lvl[i]);
        }
    }
    public static void update(int pos, int val) {
        for (int i = pos; i < bit.length; i += (i & -i)) {
            bit[i] += val;
        }
    }
    public static int query(int pos) {
        int ret = 0;
        for (int i = pos; i > 0; i -= (i & -i)) {
            ret += bit[i];
        }
        return ret;
    }
}