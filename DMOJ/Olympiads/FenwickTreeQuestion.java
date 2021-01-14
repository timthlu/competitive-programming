import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FenwickTreeQuestion {
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

        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            if (Integer.parseInt(input[0]) == 1) {
                array[Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
            } else if (Integer.parseInt(input[0]) == 2) {
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);
                
                int sum = 0;
                for (int j = a; j <= b-1; j++) {
                    for (int k = j+1; k <= b; k++) {
                        sum += array[j] | array[k];
                    }
                }
                System.out.println(sum);
            } else if (Integer.parseInt(input[0]) == 3) {
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);
                
                int sum = 0;
                for (int j = a; j <= b-1; j++) {
                    for (int k = j+1; k <= b; k++) {
                        sum += array[j] & array[k];
                    }
                }
                System.out.println(sum);
            } else {
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);
                
                int sum = 0;
                for (int j = a; j <= b-1; j++) {
                    for (int k = j+1; k <= b; k++) {
                        sum += array[j] ^ array[k];
                    }
                }
                System.out.println(sum);
            }
        }
    }
}