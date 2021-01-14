import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PatternGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            System.out.println("The bit patterns are");
            solve("", b, a);
            System.out.println();
        }

    }
    public static void solve(String curString, int onesLeft, int lengthLeft) {
        if (onesLeft == 0 && lengthLeft > 0) {
            solve(curString + "0", onesLeft, lengthLeft-1);
        } else if (onesLeft == 0 && lengthLeft == 0) {
            System.out.println(curString);
        } else if (onesLeft == lengthLeft) {
            solve(curString + "1", onesLeft-1, lengthLeft-1);
        } else {
            solve(curString + "1", onesLeft-1,lengthLeft-1);
            solve(curString + "0", onesLeft,lengthLeft-1);
        }
    }
}