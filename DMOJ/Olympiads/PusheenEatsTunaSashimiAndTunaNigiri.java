import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class PusheenEatsTunaSashimiAndTunaNigiri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int[][] map = new int[x+1][y+1];
        int[][] time = new int[x+1][y+1];
        int n = Integer.parseInt(input[2]);
        input = br.readLine().split(" ");
        Pos start = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        input = br.readLine().split(" ");
        Pos end = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
        }
        
        Queue<Pos> q = new LinkedList();
        q.add(start);
        time[start.row][start.col] = 1;
        boolean ansFound = false;
        while (!q.isEmpty()) {
            Pos curPos = q.remove();
            int curRow = curPos.row;
            int curCol = curPos.col;
            
            if (curRow == end.row && curCol == end.col) {
                ansFound = true;
                System.out.println(time[curRow][curCol]);
                System.exit(0);
            }

            //north
            for (int i = 1; i <= 100; i++) {
                if (curRow-i >= 0 && time[curRow-i][curCol] == 0 && map[curRow-i][curCol] != 1) {
                    time[curRow-i][curCol] = time[curRow][curCol] + 1;
                    q.add(new Pos(curRow-i, curCol));
                } else if (curRow-i < 0 || map[curRow-i][curCol] == 1) {
                    break;
                }
            }

            //south
            for (int i = 1; i <= 100; i++) {
                if (curRow+i <= x && time[curRow+i][curCol] == 0 && map[curRow+i][curCol] != 1) {
                    time[curRow+i][curCol] = time[curRow][curCol] + 1;
                    q.add(new Pos(curRow+i, curCol));
                } else if (curRow+i > x || map[curRow+i][curCol] == 1) {
                    break;
                }
            }

            //west
            for (int i = 1; i <= 100; i++) {
                if (curCol-i >= 0 && time[curRow][curCol-i] == 0 && map[curRow][curCol-i] != 1) {
                    time[curRow][curCol-i] = time[curRow][curCol] + 1;
                    q.add(new Pos(curRow, curCol-i));
                } else if (curCol-i < 0 || map[curRow][curCol-i] == 1) {
                    break;
                }
            }

            //east
            for (int i = 1; i <= 100; i++) {
                if (curCol+i <= y && time[curRow][curCol+i] == 0 && map[curRow][curCol+i] != 1) {
                    time[curRow][curCol+i] = time[curRow][curCol] + 1;
                    q.add(new Pos(curRow, curCol+i));
                } else if (curCol+i > y || map[curRow][curCol+i] == 1) {
                    break;
                }
            }
        }

        if (!ansFound) {
            System.out.println(-1);
        }
    }
}
class Pos {
    int row;
    int col;

    Pos (int row, int col) {
        this.row = row;
        this.col = col;
    }
}