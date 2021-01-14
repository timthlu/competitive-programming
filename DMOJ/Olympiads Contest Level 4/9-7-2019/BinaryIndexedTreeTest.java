import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BinaryIndexedTreeTest {
    static long[] bit;
    static int[] array;
    static long[] freq = new long[100001];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        array = new int[n+1];
        bit = new long[n+1];
        String[] input2 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(input2[i-1]);
            array[i] = val;
            update(bit, i, val);
            update(freq, val, 1);
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("C")) {
                update(freq, array[Integer.parseInt(input[1])], -1);
                update(freq, Integer.parseInt(input[2]), 1);
                update(bit, Integer.parseInt(input[1]), Integer.parseInt(input[2]) - array[Integer.parseInt(input[1])]);
                array[Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
            } else if (input[0].equals("S")) {
                System.out.println(sumBit(Integer.parseInt(input[1])-1, Integer.parseInt(input[2])));
            } else {
                System.out.println(sumFreq(Integer.parseInt(input[1])));
            }
        }
    }

    public static void update(long[] a, int index, int value) {
        while (index <= a.length) {
            a[index] += value;
            index += (index & -index);
        }
    }

    public static long sumBit(int first, int second) {
        long sum1 = 0;
        while (first > 0) {
            sum1 += bit[first];
            first -= (first & -first);
        }

        long sum2 = 0;
        while (second > 0) {
            sum2 += bit[second];
            second -= (second & -second);
        }

        return (sum2 - sum1);
    }

    public static long sumFreq(int lastIndex) {
        long sum = 0;
        while (lastIndex > 0) {
            sum += freq[lastIndex];
            lastIndex -= (lastIndex & -lastIndex);
        }

        return sum;
    }
}