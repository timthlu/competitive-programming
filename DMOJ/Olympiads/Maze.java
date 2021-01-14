import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Maze {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int r = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            String[][] map = new String[r][c];
            int[][] dis = new int[r][c];
            for (int j = 0; j < r; j++) {
                String input = br.readLine();
                for (int k = 0; k < c; k++) {
                    map[j][k] = input.substring(k, k+1);
                }
            }
            
            Queue<Pos> q = new LinkedList();
            q.add(new Pos(0, 0));
            dis[0][0] = 1;

            boolean ansFound = false;
            while (!q.isEmpty()) {
                Pos curPos = q.remove();
                int curRow = curPos.row;
                int curCol = curPos.col;

                if (curRow == r-1 && curCol == c-1) {
                    ansFound = true;
                    System.out.println(dis[curRow][curCol]);
                    break;
                }

                boolean ns = false;
                boolean we = false;
                if (map[curRow][curCol].equals("+")) {
                    ns = true;
                    we = true;
                } else if (map[curRow][curCol].equals("-")) {
                    we = true;
                } else if (map[curRow][curCol].equals("|")) {
                    ns = true;
                }

                if (ns) {
                    if (curRow != 0 && !map[curRow-1][curCol].equals("*") && dis[curRow-1][curCol] == 0) {
                        dis[curRow-1][curCol] = dis[curRow][curCol] + 1;
                        q.add(new Pos(curRow-1, curCol));
                    }
                    if (curRow != r-1 && !map[curRow+1][curCol].equals("*") && dis[curRow+1][curCol] == 0) {
                        dis[curRow+1][curCol] = dis[curRow][curCol] + 1;
                        q.add(new Pos(curRow+1, curCol));
                    }
                }
                if (we) {
                    if (curCol != 0 && !map[curRow][curCol-1].equals("*") && dis[curRow][curCol-1] == 0) {
                        dis[curRow][curCol-1] = dis[curRow][curCol] + 1;
                        q.add(new Pos(curRow, curCol-1));
                    }
                    if (curCol != c-1 && !map[curRow][curCol+1].equals("*") && dis[curRow][curCol+1] == 0) {
                        dis[curRow][curCol+1] = dis[curRow][curCol] + 1;
                        q.add(new Pos(curRow, curCol+1));
                    }
                }
            }

            if (!ansFound) {
                System.out.println(-1);
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