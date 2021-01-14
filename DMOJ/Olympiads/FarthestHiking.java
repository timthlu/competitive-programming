import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FarthestHiking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int u = Integer.parseInt(input[2]);
        int f = Integer.parseInt(input[3]);
        int d = Integer.parseInt(input[4]);
        String path = br.readLine();

        int time = 0;
        int paths = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'u' || path.charAt(i) == 'd') {
                time += u + d;
            } else {
                time += 2*f;
            }

            if (time < m) {
                paths++;
            } else if (time >= m) {
                System.out.println(paths);
                System.exit(0);
            }
        }
        System.out.println(paths);
    }
}