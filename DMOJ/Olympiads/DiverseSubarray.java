import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DiverseSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        int[] array = new int[n+1];
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(input[i-1]);
        }

        
    }
}