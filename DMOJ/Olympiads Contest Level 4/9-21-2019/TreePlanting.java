//diagonal binary indexed trees

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreePlanting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[2002][2002];
        List<Integer>[] bit1 = new ArrayList[]


    }
    public static void update(int index, int value, int[] bit) {
        while (index <= bit.length) {
            bit[index] += value;
            index += (index & -index);
        }
    }
    public static int sum(int index, int[] bit) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }
}