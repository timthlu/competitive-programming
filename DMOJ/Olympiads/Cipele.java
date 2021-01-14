import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Cipele {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] left = new int[n];
        int[] right = new int[m];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            right[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int lo = 0;
        int hi = (int)1e9;
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (check(mid, left, right)) {
                ans = mid;
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static boolean check(int num, int[] left, int[] right) {
        int count = 0;
        for (int i = 0, j = 0; i < left.length && j < right.length;) {
            if (Math.abs(left[i]-right[j]) <= num) {
                i++;
                j++;
                count++;
            } else if (left[i] < right[j]) {
                i++;
            } else if (left[i] > right[j]) {
                j++;
            }
        }

        if (count == Math.min(left.length, right.length)) {
            return true;
        } else {
            return false;
        }
    }
}