import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class FreedomAppears {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] gundam = {Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> slopes = new ArrayList<int[]>;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int[] pos = {Integer.parseInt(input[0]) - gundam[0], Integer.parseInt(input[1]) - gundam[1], Integer.parseInt(input[2]) - gundam[2]};
            if (i == 0) {
                slopes.add(pos);
            } else {
                boolean found = false;
                for (int j = 0; j < slopes.size(); j++) {
                    if (pos[0] == 0 && gundam[0] == 0 && ) {
                        
                    }
                }
            }
        }
    }
}