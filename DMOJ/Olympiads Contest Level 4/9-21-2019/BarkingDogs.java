import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarkingDogs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        int[] w = new int[D+1];
        List<Integer>[] adj = new ArrayList[D+1];
        for (int i = 1; i <= D; i++) {
            w[i] = Integer.parseInt(br.readLine());
            adj[i] = new ArrayList();
        }

        int F = Integer.parseInt(br.readLine());
        for (int i = 1; i <= F; i++) {
            String[] input = br.readLine().split(" ");
            adj[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
        }
        int T = Integer.parseInt(br.readLine());
        int[] cnt = new int[D+1];
        int[] t = new int[D+1];
        Arrays.fill(t, -1);
        t[1] = 0;
        for (int time = 0; time <= T; time++) {
            for (int i = 1; i <= D; i++) {
                if (t[i] < time || t[i] > time) continue;
                if (t[i] == time) {
                    cnt[i]++;
                    for (int d: adj[i]) {
                        if (time > t[d]) t[d] = time + w[d];
                    }
                }
            }
        }
        for (int i = 1; i <= D; i++) {
            System.out.println(cnt[i]);
        }
    }
}