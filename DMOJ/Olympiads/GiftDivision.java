import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class GiftDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            int x = a[n-i-1];
            int new1 = sum1 + x;
            int new2 = sum2 + x;
            int new3 = sum3 + x;
            
            if (new1 <= new2 && new1 <= new3) {
                sum1 = new1;
            } else if (new2 <= new1 && new2 <= new3) {
                sum2 = new2;
            } else if (new3 <= new1 && new3 <= new2) {
                sum3 = new3;
            }

            System.out.println("sum1 : " + sum1);
            System.out.println("sum2 : " + sum2);
            System.out.println("sum3 : " + sum3);
        }

        System.out.println(Math.max(sum1, Math.max(sum2, sum3)));
    }
}