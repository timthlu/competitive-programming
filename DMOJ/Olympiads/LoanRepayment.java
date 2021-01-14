import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LoanRepayment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long k = Long.parseLong(input[1]);
        long m = Long.parseLong(input[2]);
        
        long ans = -1;
        long lo = 1;
        long hi = n;
        while (hi >= lo) {
            long mid = (lo + hi)/2;
            if (function(mid, n, k, m) >= n) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
    public static long function(long x, long n, long k, long m) {
        long daysSpent = 0;
        long givenAlready = 0;

        while (daysSpent < k && givenAlready < n) {
            long y = (n-givenAlready)/x;
            if (y <= m) {
                return (givenAlready + (k-daysSpent)*m);
            }
            
            long days = Math.min(k - daysSpent, ((n-givenAlready) - y*x)/y + 1);
            givenAlready += days*y;
            daysSpent += days;
            y--;
        }
        
        return givenAlready;
    }
}