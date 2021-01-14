import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SomeName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        System.out.println("ask " + 1 + " " + n);
        System.out.flush();
        int sum1 = Integer.parseInt(br.readLine());
        System.out.println("ask " + 1 + " " + 2);
        System.out.flush();
        int sum2 = Integer.parseInt(br.readLine());
        System.out.println("ask " + 2 + " " + n);
        System.out.flush();
        int sum3 = Integer.parseInt(br.readLine());

        array[2] = sum2 + sum3 - sum1;
        array[1] = sum2 - array[2];

        int sum = 0;
        int sumPrev = sum2;
        for (int i = 3; i <= n-1; i++) {
            System.out.println("ask " + 1 + " " + i);
            System.out.flush();
            sum = Integer.parseInt(br.readLine());
            array[i] = sum - sumPrev;
            sumPrev = sum;
        }

        array[n] = sum1 - sumPrev;

        String ans = "guess ";
        for (int i = 1; i <= n; i++) {
            ans += array[i] + " ";
        }
        ans.trim();
        System.out.println(ans);
        System.out.flush();
    }
}