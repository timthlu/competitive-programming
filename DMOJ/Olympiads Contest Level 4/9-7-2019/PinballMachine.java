import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class PinballMachine {
    static int[] bit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bit = new int[n+1];
        int[] rankings = new int[n+1];
        int[] realNum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            //read and compress
            
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            update(rankings.get(i)+1, 1);
            sum += sum(rankings.get(i)+1) + 1;
        }

        System.out.println(sum/n);
    }
    public static void update(int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += (index & -index);
        }
    }
    public static int sum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }

        return sum;
    }
}