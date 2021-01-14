import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class FloorPlan {
    static int r, c;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        r = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        map = new String[r][c];

        Pos one = new Pos(-1, -1);
        Pos two = new Pos(-1, -1);
        Pos three = new Pos(-1, -1);
        Pos four = new Pos(-1, -1);
        Pos five = new Pos(-1, -1);
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.substring(j, j+1);
                if (map[i][j].equals("1")) {
                    one = new Pos(i, j);
                } else if (map[i][j].equals("2")) {
                    two = new Pos(i, j);
                } else if (map[i][j].equals("3")) {
                    three = new Pos(i, j);
                } else if (map[i][j].equals("4")) {
                    four = new Pos(i, j);
                } else if (map[i][j].equals("5")) {
                    five = new Pos(i, j);
                }
            }
        }

        System.out.println(calculateArea(one));
        System.out.println(calculateArea(two));
        System.out.println(calculateArea(three));
        System.out.println(calculateArea(four));
        System.out.println(calculateArea(five));
    }
    public static int calculateArea(Pos start) {
        Queue<Pos> q = new LinkedList();
        boolean[][] vis = new boolean[r][c];
        int sum = 1;
        q.add(start);
        vis[start.row][start.col] = true;

        while (!q.isEmpty()) {
            Pos curPos = q.remove();
            int curRow = curPos.row;
            int curCol = curPos.col;

            //north
            if (curRow != 0 && !map[curRow-1][curCol].equals("#") && !vis[curRow-1][curCol]) {
                sum++;
                vis[curRow-1][curCol] = true;
                q.add(new Pos(curRow-1, curCol));
            }

            //south
            if (curRow != r-1 && !map[curRow+1][curCol].equals("#") && !vis[curRow+1][curCol]) {
                sum++;
                vis[curRow+1][curCol] = true;
                q.add(new Pos(curRow+1, curCol));
            }

            //west
            if (curCol != 0 && !map[curRow][curCol-1].equals("#") && !vis[curRow][curCol-1]) {
                sum++;
                vis[curRow][curCol-1] = true;
                q.add(new Pos(curRow, curCol-1));
            }

            //east
            if (curCol != c-1 && !map[curRow][curCol+1].equals("#") && !vis[curRow][curCol+1]) {
                sum++;
                vis[curRow][curCol+1] = true;
                q.add(new Pos(curRow, curCol+1));
            }
        }

        return sum;
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