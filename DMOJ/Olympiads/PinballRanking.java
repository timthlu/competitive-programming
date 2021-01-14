import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class PinballRanking {
    static int[] bit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] org = new Pair[n];

        for(int i = 0; i < n; i++) {
            org[i] = new Pair(i+1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(org);

        int[] compressed = new int[n+1];
        for(int i = 0; i < n; i++) {
            compressed[org[i].order] = i+1;
        }

        bit = new int[n+1];
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            update(compressed[i], 1);
            long ans = query(compressed[i]);
            sum += ans;
        }
        System.out.println(Math.round((double)sum/n*100)/100.0);
    }

    public static void update(int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += (index & -index);
        }
    }

    public static long query(int index) {
        long sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }

    static class Pair implements Comparable<Pair> {
        int order;
        int score;

        public Pair(int a, int b) {
            order = a;
            score = b;
        }

        public int compareTo(Pair o) {
            return o.score - this.score; //greatest to least
        }
    }
}