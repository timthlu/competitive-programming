import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class AFK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input1 = br.readLine().split(" ");
            int w = Integer.parseInt(input1[0]);
            int l = Integer.parseInt(input1[1]);

            String[][] map = new String[l][w];
            Pos start = new Pos(-1, -1);
            Pos end = new Pos(-1, -1);
            for (int j = 0; j < l; j++) {
                String input2 = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = input2.substring(k, k+1);
                    if (map[j][k].equals("C")) {
                        start = new Pos(j, k);
                    } else if (map[j][k].equals("W")) {
                        end = new Pos (j, k);
                    }
                }
            }

            Queue<Pos> q = new LinkedList();
            int[][] dis = new int[l][w];
            dis[start.row][start.col] = 1; //remember to subtract 1 from answer
            q.add(start);
            boolean ansFound = false;
            while (!q.isEmpty()) {
                Pos curPos = q.remove();
                int curRow = curPos.row;
                int curCol = curPos.col;

                if (curRow == end.row && curCol == end.col) {
                    ansFound = true;
                    if (dis[curRow][curCol] - 1 < 60) {
                        System.out.println(dis[curRow][curCol] - 1);
                    } else {
                        System.out.println("#notworth");
                    }
                    break;
                }

                //north
                if (curRow != 0 && !map[curRow-1][curCol].equals("X") && dis[curRow-1][curCol] == 0) {
                    dis[curRow-1][curCol] = dis[curRow][curCol] + 1;
                    q.add(new Pos(curRow-1, curCol));
                }

                //south
                if (curRow != l-1 && !map[curRow+1][curCol].equals("X") && dis[curRow+1][curCol] == 0) {
                    dis[curRow+1][curCol] = dis[curRow][curCol] + 1;
                    q.add(new Pos(curRow+1, curCol));
                }

                //west
                if (curCol != 0 && !map[curRow][curCol-1].equals("X") && dis[curRow][curCol-1] == 0) {
                    dis[curRow][curCol-1] = dis[curRow][curCol] + 1;
                    q.add(new Pos(curRow, curCol-1));
                }

                //east
                if (curCol != w-1 && !map[curRow][curCol+1].equals("X") && dis[curRow][curCol+1] == 0) {
                    dis[curRow][curCol+1] = dis[curRow][curCol] + 1;
                    q.add(new Pos(curRow, curCol+1));
                }
            }
            if (!ansFound) {
                System.out.println("#notworth");
            }
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