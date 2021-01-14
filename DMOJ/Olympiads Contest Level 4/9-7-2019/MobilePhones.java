import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MobilePhones {
    static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        while (Integer.parseInt(input[0]) != 3) {
            if (Integer.parseInt(input[0]) == 0) {
                a = new int[Integer.parseInt(input[1])+1][Integer.parseInt(input[1])+1];
            } else if (Integer.parseInt(input[0]) == 1) {
                update(Integer.parseInt(input[1])+1, Integer.parseInt(input[2])+1, Integer.parseInt(input[3]));
            } else {
                System.out.println(sum(Integer.parseInt(input[1])+1, Integer.parseInt(input[2])+1, Integer.parseInt(input[3])+1, Integer.parseInt(input[4])+1));
            }

            input = br.readLine().split(" ");
        }
    }
    public static void update(int row, int col, int value) {
        while (col <= a[row].length) {
            a[row][col] += value;
            col += (col & -col);
        }
    }
    public static int sum(int firstRow, int firstCol, int lastRow, int lastCol) {
        firstCol--;
        int tempFirstCol = firstCol;
        int tempLastCol = lastCol;
        
        int sum = 0;
        for (int i = firstRow; i <= lastRow; i++) {
            int sum1 = 0;
            while (firstCol > 0) {
                sum1 += a[i][firstCol];
                firstCol -= (firstCol & -firstCol);
            }

            int sum2 = 0;
            while (lastCol > 0) {
                sum2 += a[i][lastCol];
                lastCol -= (lastCol & -lastCol);
            }

            sum += sum2 - sum1;
            firstCol = tempFirstCol;
            lastCol = tempLastCol;
        }

        return sum;
    }
}