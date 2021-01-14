import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobsMathHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int count = 1;
        for (int i = 2; i <= Math.sqrt(n*2); i++) {
            if (i % 2 == 0) {
                if (n % i == i/2) {
                    count++;
                }
            } else {
                if (n % i == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}